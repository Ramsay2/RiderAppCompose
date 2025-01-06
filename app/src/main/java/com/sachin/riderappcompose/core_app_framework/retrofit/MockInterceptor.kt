package com.apnamart.apnarider.core_app_framework.retrofit

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody

class MockInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (false) {

            val uri = chain.request().url.toUri()
            val responseString = when (uri.path.toString()) {
                else -> ""
            }

            return if (responseString.isNotEmpty()) {
                chain.proceed(chain.request())
                    .newBuilder()
                    .code(200)
                    .protocol(Protocol.HTTP_2)
                    .message(responseString)
                    .body(
                        ResponseBody.create(
                            "application/json".toMediaTypeOrNull(),
                            responseString.toByteArray()
                        )
                    )
                    .addHeader("content-type", "application/json")
                    .build()
            } else {
                chain.proceed(chain.request())
            }
        } else {
            throw IllegalAccessError(
                "MockInterceptor is only meant for Testing Purposes and " +
                        "bound to be used only with DEBUG mode"
            )
        }
    }
}

