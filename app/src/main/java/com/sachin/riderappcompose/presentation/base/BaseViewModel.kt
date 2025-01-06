package com.sachin.riderappcompose.presentation.base

import androidx.lifecycle.ViewModel
import com.apnamart.apnarider.core_app_framework.retrofit.RetrofitException
import com.apnamart.apnarider.domain.DomainHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import org.json.JSONObject
import retrofit2.Response


@HiltViewModel
abstract class BaseViewModel(
    val domainHelper: DomainHelper
) : ViewModel() {

    fun onCreate() {

    }

    fun showErrorMessage(message: String) {

    }

    fun showSuccessMessage(message: String) {

    }

    fun showMessage(message: String) {

    }

    fun showHighlightMessage(message: String) {

    }

    fun showInfo(info: String) {

    }

    fun openActivityOnTokenExpire() {

    }

    fun navigateToUrl(url: String) {

    }

    fun processApiError(error: Exception?, errorBody: Response<*>?) {
        if (errorBody != null) {
            val errorObj =
                JSONObject(errorBody.errorBody()!!.charStream().readText()).getString("error")
            showErrorMessage(errorObj)
            return
        }

        if (error != null) {
            if (error is RetrofitException)
                when (error.kind) {
                    RetrofitException.NETWORK_ERROR -> showErrorMessage("")
                    RetrofitException.HTTP_ERROR -> {}// processHttpError(error)
                    RetrofitException.UNEXPECTED_ERROR -> {} //navigator?.showErrorMessage(getString(R.string.error_unexpected_contact_support))
                }
            else
            //   navigator?.showErrorMessage(getString(R.string.error_unexpected_contact_support))
                return
        }
    }


}