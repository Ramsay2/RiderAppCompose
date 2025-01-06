package com.apnamart.apnarider.core_app_framework.retrofit.logger

import android.text.TextUtils
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.internal.platform.Platform
import java.io.IOException
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

class LoggingInterceptor private constructor(private val builder: Builder) : Interceptor {

    private val isDebug: Boolean

    init {
        this.isDebug = builder.isDebug
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val printer = LogPrinter()

        var request = chain.request()
        val headerMap = builder.headers
        if (headerMap.size > 0) {
            val requestBuilder = request.newBuilder()
            for (key in headerMap.keys) {
                val value = headerMap[key]
                requestBuilder.addHeader(key, value.toString())
            }
            request = requestBuilder.build()
        }

        val queryMap = builder.httpUrl
        if (queryMap.size > 0) {
            val httpUrlBuilder = request.url.newBuilder(request.url.toString())
            for (key in queryMap.keys) {
                val value = queryMap[key]
                httpUrlBuilder!!.addQueryParameter(key, value)
            }
            request = request.newBuilder().url(httpUrlBuilder!!.build()).build()
        }

        if (!isDebug || builder.getLevel() == Level.NONE) {
            return chain.proceed(request)
        }

        val requestBody = request.body

        var rSubtype: String? = null
        if (requestBody?.contentType() != null) {
            rSubtype = requestBody.contentType()!!.subtype
        }

        val executor = builder.executor

        if (isNotFileRequest(rSubtype)) {
            printer.printJsonRequest(builder, request)
        } else {
            printer.printFileRequest(builder, request)
        }

        val st = System.nanoTime()

        val response = chain.proceed(request)
        val chainMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - st)

        val segmentList = request.url.encodedPathSegments
        val header = response.headers.toString()
        val code = response.code
        val isSuccessful = response.isSuccessful
        val message = response.message
        val responseBody = response.body
        val contentType = responseBody!!.contentType()

        var subtype: String? = null
        val body: ResponseBody

        if (contentType != null) {
            subtype = contentType.subtype
        }

        if (isNotFileRequest(subtype)) {
            val bodyString = printer.getJsonString(responseBody.string())
            val url = response.request.url.toString()

            printer.printJsonResponse(
                    builder, chainMs, isSuccessful, code, header, bodyString, segmentList, message, url)
            body = bodyString.toResponseBody(contentType)
        } else {
            printer.printFileResponse(
                    builder, chainMs, isSuccessful, code, header, segmentList, message)

            printer.printApiLog()
            return response
        }
        printer.printApiLog()
        return response.newBuilder().body(body).build()
    }

    private fun isNotFileRequest(subtype: String?): Boolean {
        return subtype != null && (subtype.contains("json")
                || subtype.contains("xml")
                || subtype.contains("plain")
                || subtype.contains("html"))
    }

    class Builder {
        internal val headers: HashMap<String, String> = HashMap()
        internal val httpUrl: HashMap<String, String> = HashMap()
        internal var isDebug: Boolean = false
        internal var type = Platform.INFO
            private set
        private var requestTag: String? = null
        private var responseTag: String? = null
        var level = Level.BASIC
        internal var executor: Executor? = null
            private set

        internal fun getLevel(): Level {
            return level
        }

        /**
         * @param level set log level
         * @return Builder
         * @see Level
         */
        fun setLevel(level: Level): Builder {
            this.level = level
            return this
        }

        internal fun getTag(isRequest: Boolean): String {
            return if (isRequest) {
                if (TextUtils.isEmpty(requestTag)) TAG else requestTag.toString()
            } else {
                if (TextUtils.isEmpty(responseTag)) TAG else responseTag.toString()
            }
        }

        /**
         * @param name Filed
         * @param value Value
         * @return Builder Add a field with the specified value
         */
        fun addHeader(name: String, value: String): Builder {
            headers[name] = value
            return this
        }

        /**
         * @param name Filed
         * @param value Value
         * @return Builder Add a field with the specified value
         */
        fun addQueryParam(name: String, value: String): Builder {
            httpUrl[name] = value
            return this
        }

        /**
         * Set request and response each log tag
         *
         * @param tag general log tag
         * @return Builder
         */
        fun tag(tag: String): Builder {
            TAG = tag
            return this
        }

        /**
         * Set request log tag
         *
         * @param tag request log tag
         * @return Builder
         */
        fun request(tag: String): Builder {
            this.requestTag = tag
            return this
        }

        /**
         * Set response log tag
         *
         * @param tag response log tag
         * @return Builder
         */
        fun response(tag: String): Builder {
            this.responseTag = tag
            return this
        }

        /**
         * @param isDebug set can sending log output
         * @return Builder
         */
        fun loggable(isDebug: Boolean): Builder {
            this.isDebug = isDebug
            return this
        }

        /**
         * @param type set sending log output type
         * @return Builder
         * @see Platform
         */
        fun log(type: Int): Builder {
            this.type = type
            return this
        }

        /**
         * @param executor manual executor for printing
         * @return Builder
         * @see
         */
        fun executor(executor: Executor): Builder {
            this.executor = executor
            return this
        }

        fun build(): LoggingInterceptor {
            return LoggingInterceptor(this)
        }

        companion object {

            private var TAG = "LoggingI"
        }
    }
}
