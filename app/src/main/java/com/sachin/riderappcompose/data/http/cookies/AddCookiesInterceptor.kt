package com.sachin.riderappcompose.data.http.cookies

import android.content.Context
import com.apnamart.apnarider.data.cache.USER_AGENT
import com.apnamart.apnarider.data.cache.USER_TOKEN
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * This interceptor put all the Cookies in Preferences in the Request.
 */
class AddCookiesInterceptor(private val context: Context) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        val pref = context.getSharedPreferences("BuildConfig.PREF_NAME", Context.MODE_PRIVATE)
        builder.addHeader("Content-Type", "application/json")
        builder.addHeader("Cache-Control", "no-cache")
        builder.addHeader("VERSION", "BuildConfig.VERSION_NAME")
        val token = pref.getString(USER_TOKEN, "")
        if (!token.isNullOrBlank()) {
            builder.addHeader("AUTHORIZATION", "token $token")
        }
        val userAgent = pref.getString(USER_AGENT, null) ?: System.getProperty("http.agent") ?: ""
        builder.addHeader("User-Agent",  userAgent)
        return chain.proceed(builder.build())
    }
}