package com.apnamart.apnarider.data.http

/*import android.content.Context
import com.apnamart.apnarider.R
import com.apnamart.apnarider.core_app_framework.retrofit.RetrofitException
import com.apnamart.apnarider.data.http.response.ApiError
import com.apnamart.apnarider.presentation._base.BaseViewModel*/

/*
fun Exception.getErrorString(application: Context): Pair<String, Boolean> {
    var logout = false
    val errorMsg = if (this is RetrofitException)
        when (this.kind) {
            RetrofitException.NETWORK_ERROR -> application.getString(R.string.error_connection)
            RetrofitException.HTTP_ERROR -> {
                when (this.response?.code()) {
                    BaseViewModel.INTERNAL_SERVER_ERROR -> application.getString(R.string.error_500)
                    BaseViewModel.NOT_FOUND -> application.getString(R.string.generic_error)
                    BaseViewModel.BAD_REQUEST, BaseViewModel.NOT_ACCEPTABLE -> try {
                        val response = this.getErrorBodyAs(ApiError::class.java)
                        response?.error ?: application.getString(R.string.error_bad_request)
                    } catch (e: Exception) {
                        application.getString(R.string.error_bad_request)
                    }
                    BaseViewModel.UNAUTHORIZED-> {
                        logout = true
                        "Session Expired. Please login again to start buying your favourite products."
                    }
                    BaseViewModel.FORBIDDEN -> {
                        application.getString(R.string.forbidden_error)
                    }
                    else -> application.getString(R.string.error_unexpected_contact_support)
                }
            }
            RetrofitException.UNEXPECTED_ERROR -> application.getString(R.string.error_unexpected_contact_support)
            else -> application.getString(R.string.error_unexpected_contact_support)
        }
    else
        application.getString(R.string.error_unexpected_contact_support)
    return Pair(errorMsg, logout)
}*/
