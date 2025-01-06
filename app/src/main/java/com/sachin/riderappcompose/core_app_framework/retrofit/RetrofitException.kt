package com.apnamart.apnarider.core_app_framework.retrofit

import com.apnamart.apnarider.data.http.response.GenericResponseV2
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException

// This is RetrofitError converted to Retrofit 2
class RetrofitException internal constructor(
    message: String? = null,
    /** The request BASE_URL which produced the isProgressVisible.  */
    val url: String? = null,
    /** Response object containing status code, headers, body, etc.  */
    val response: Response<*>? = null,
    /** The event kind which triggered this isProgressVisible.  */
    val kind: String,
    exception: Throwable?,
    /** The Retrofit this request was executed on  */
    private val retrofit: Retrofit? = null,

    val genericResponse: GenericResponseV2<*>? = null,
) : RuntimeException(message, exception) {

    /**
     * HTTP response body converted to specified `type`. `null` if there is no
     * response.
     *
     * @throws IOException if unable to convert the body to the specified `type`.
     */
    @Throws(IOException::class)
    fun <T> getErrorBodyAs(type: Class<T>): T? {
        return null
    }

    fun getApiErrorString(): String {
        return if (!genericResponse?.error.isNullOrEmpty()) {
            genericResponse?.error ?: ""
        } else {
            genericResponse?.errorList?.joinToString(separator = "\n") { it.errorMessage } ?: ""
        }
    }

    companion object {

        const val NETWORK_ERROR = "network_error"
        const val HTTP_ERROR = "http_error"
        const val UNEXPECTED_ERROR = "unexpected_error"
        fun httpError(url: String, response: Response<*>, retrofit: Retrofit): RetrofitException {
            val message = response.code().toString() + " " + response.message()
            return RetrofitException(message, url, response, HTTP_ERROR, Throwable(), retrofit)
        }

        fun networkError(exception: IOException): RetrofitException {
            return RetrofitException(exception.message, null, null, NETWORK_ERROR, exception, null)
        }

        fun unexpectedError(exception: Throwable): RetrofitException {
            return RetrofitException(
                exception.message,
                null,
                null,
                UNEXPECTED_ERROR,
                exception,
                null
            )
        }
    }
}