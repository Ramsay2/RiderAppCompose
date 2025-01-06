package com.apnamart.apnarider.core_app_framework.retrofit.logger

import android.text.TextUtils
import com.apnamart.apnarider.core_app_framework.logger.AppLogger
import okhttp3.Request
import okio.Buffer
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

internal open class LogPrinter {

    private var requestBuilder: StringBuilder = StringBuilder()
    private var responseBuilder: StringBuilder = StringBuilder()



    private fun isEmpty(line: String): Boolean {
        return TextUtils.isEmpty(line) || NEXT_LINE == line || TAB_SEPARATOR == line || TextUtils.isEmpty(line.trim { it <= ' ' })
    }

    fun printJsonRequest(builder: LoggingInterceptor.Builder, request: Request) {
        val requestBody = LINE_SEPARATOR + BODY_TAG + LINE_SEPARATOR + bodyToString(request)
        val tag = builder.getTag(true)
        requestBuilder.append(REQUEST_UP_LINE +"\n")
        logRequestLines(builder.type, tag, arrayOf(URL_TAG + request.url), false)
        logRequestLines(builder.type, tag, getRequest(request, builder.level), true)
        if (builder.level == Level.BASIC || builder.level == Level.BODY) {
            logRequestLines(builder.type, tag, requestBody.split(LINE_SEPARATOR.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray(), true)
        }
        requestBuilder.append(END_LINE +"\n")
    }

    fun printJsonResponse(builder: LoggingInterceptor.Builder, chainMs: Long, isSuccessful: Boolean,
                          code: Int, headers: String, bodyString: String, segments: List<String>, message: String, responseUrl: String) {

        val responseBody = LINE_SEPARATOR + BODY_TAG + LINE_SEPARATOR + getJsonString(bodyString)
        val tag = builder.getTag(false)
        val urlLine = arrayOf(URL_TAG + responseUrl, NEXT_LINE)
        val response = getResponse(headers, chainMs, code, isSuccessful,
                builder.level, segments, message)

        responseBuilder.append(RESPONSE_UP_LINE +"\n")

        logResponseLines(builder.type, tag, urlLine, true)
        logResponseLines(builder.type, tag, response, true)

        if (builder.level == Level.BASIC || builder.level == Level.BODY) {
            logResponseLines(builder.type, tag, responseBody.split(LINE_SEPARATOR.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray(), true)
        }
        responseBuilder.append(END_LINE +"\n")
    }

    fun printFileRequest(builder: LoggingInterceptor.Builder, request: Request) {
        val tag = builder.getTag(true)
        requestBuilder.append(REQUEST_UP_LINE +"\n")
        logRequestLines(builder.type, tag, arrayOf(URL_TAG + request.url), false)
        logRequestLines(builder.type, tag, getRequest(request, builder.level), true)
        if (builder.level == Level.BASIC || builder.level == Level.BODY) {
            logRequestLines(builder.type, tag, OMITTED_REQUEST, true)
        }
        requestBuilder.append(END_LINE +"\n")
    }

    fun printFileResponse(builder: LoggingInterceptor.Builder, chainMs: Long, isSuccessful: Boolean,
                          code: Int, headers: String, segments: List<String>, message: String) {
        val tag = builder.getTag(false)
        responseBuilder.append(RESPONSE_UP_LINE +"\n")
        logResponseLines(builder.type, tag, getResponse(headers, chainMs, code, isSuccessful,
                builder.level, segments, message), true)
        logResponseLines(builder.type, tag, OMITTED_RESPONSE, true)
        responseBuilder.append(END_LINE +"\n")
    }

    private fun getRequest(request: Request, level: Level): Array<String> {
        val log: String
        val header = request.headers.toString()
        val loggableHeader = level == Level.HEADERS || level == Level.BASIC
        log = METHOD_TAG + request.method + DOUBLE_SEPARATOR +
                if (isEmpty(header)) "" else if (loggableHeader) HEADERS_TAG + LINE_SEPARATOR + dotHeaders(header) else ""
        return log.split(LINE_SEPARATOR.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    }

    private fun getResponse(header: String, tookMs: Long, code: Int, isSuccessful: Boolean,
                            level: Level, segments: List<String>, message: String): Array<String> {
        val log: String
        val loggableHeader = level == Level.HEADERS || level == Level.BASIC
        val segmentString = slashSegments(segments)
        log = ((if (!TextUtils.isEmpty(segmentString)) "$segmentString - " else "") + "is success : "
                + isSuccessful + " - " + RECEIVED_TAG + tookMs + "ms" + DOUBLE_SEPARATOR + STATUS_CODE_TAG +
                code + " / " + message + DOUBLE_SEPARATOR + when {
            isEmpty(header) -> ""
            loggableHeader -> HEADERS_TAG + LINE_SEPARATOR +
                    dotHeaders(header)
            else -> ""
        })
        return log.split(LINE_SEPARATOR.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    }

    private fun slashSegments(segments: List<String>): String {
        val segmentString = StringBuilder()
        for (segment in segments) {
            segmentString.append("/").append(segment)
        }
        return segmentString.toString()
    }

    /* Print DotHeaders*/
    private fun dotHeaders(header: String): String {
        val headers = header.split(LINE_SEPARATOR.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val builder = StringBuilder()
        var tag = "─ "
        if (headers.size > 1) {
            for (i in headers.indices) {
                tag = when (i) {
                    0 -> CORNER_UP
                    headers.size - 1 -> CORNER_BOTTOM
                    else -> CENTER_LINE
                }
                builder.append(tag).append(headers[i]).append("\n")
            }
        } else {
            for (item in headers) {
                builder.append(tag).append(item).append("\n")
            }
        }
        return builder.toString()
    }

    private fun logRequestLines(type: Int, tag: String, lines: Array<String>, withLineSize: Boolean) {
        for (line in lines) {
            val lineLength = line.length
            val maxLongSize = if (withLineSize) 110 else lineLength
            for (i in 0..lineLength / maxLongSize) {
                val start = i * maxLongSize
                var end = (i + 1) * maxLongSize
                end = if (end > line.length) line.length else end
                requestBuilder.append(line.substring(start, end)+"\n")
            }
        }
    }

    private fun logResponseLines(type: Int, tag: String, lines: Array<String>, withLineSize: Boolean) {
        for (line in lines) {
            val lineLength = line.length
            val maxLongSize = if (withLineSize) 110 else lineLength
            for (i in 0..lineLength / maxLongSize) {
                val start = i * maxLongSize
                var end = (i + 1) * maxLongSize
                end = if (end > line.length) line.length else end
                responseBuilder.append(line.substring(start, end)+"\n")
            }
        }
    }

    private fun bodyToString(request: Request): String {
        try {
            val copy = request.newBuilder().build()
            val buffer = Buffer()
            if (copy.body == null)
                return ""
            copy.body!!.writeTo(buffer)
            return getJsonString(buffer.readUtf8())
        } catch (e: IOException) {
            return "{\"err\": \"" + e.message + "\"}"
        }

    }

    fun getJsonString(msg: String): String {
        val message: String
        message = try {
            when {
                msg.startsWith("{") -> {
                    val jsonObject = JSONObject(msg)
                    jsonObject.toString(JSON_INDENT)
                }
                msg.startsWith("[") -> {
                    val jsonArray = JSONArray(msg)
                    jsonArray.toString(JSON_INDENT)
                }
                else -> msg
            }
        } catch (e: JSONException) {
            msg
        }

        return message
    }

    fun printApiLog() {
        AppLogger.apiLog("$requestBuilder$responseBuilder")
    }

    companion object {
        const val JSON_INDENT = 3

        val LINE_SEPARATOR = System.getProperty("line.separator") ?: "\n"
        val DOUBLE_SEPARATOR = LINE_SEPARATOR + LINE_SEPARATOR

        val OMITTED_RESPONSE = arrayOf(LINE_SEPARATOR, "Omitted response body")
        val OMITTED_REQUEST = arrayOf(LINE_SEPARATOR, "Omitted request body")

        const val NEXT_LINE = "\n"
        const val TAB_SEPARATOR = "\t"
        const val REQUEST_UP_LINE = "---------- Request ----------"
        const val END_LINE =        "-----------------------------"
        const val RESPONSE_UP_LINE = "---------- Response ----------"
        const val BODY_TAG = "Body:"
        const val URL_TAG = "BASE_URL: "
        const val METHOD_TAG = "Method: @"
        const val HEADERS_TAG = "Headers:"
        const val STATUS_CODE_TAG = "Status Code: "
        const val RECEIVED_TAG = "Received in: "
        const val CORNER_UP = "┌ "
        const val CORNER_BOTTOM = "└ "
        const val CENTER_LINE = "├ "
        const val DEFAULT_LINE = "│ "
    }
}
