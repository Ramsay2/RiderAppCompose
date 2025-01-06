package com.sachin.riderappcompose.presentation.auth_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apnamart.apnarider.core_app_framework.logger.AppLogger
import com.apnamart.apnarider.domain.DomainHelper
import com.sachin.riderappcompose.core_app_framework.interactor.Status
import com.sachin.riderappcompose.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    domainHelper: DomainHelper
) : BaseViewModel(domainHelper) {

    private val _authUiState = MutableStateFlow(AuthUiState())
    val authUiState = _authUiState.asStateFlow()

    private val _authActions = MutableStateFlow(AuthActions(
        onOtpValueChange = {
            onOtpValueChange(it)
        },
        onPhoneNumberChanged = {
            onPhoneNumberChanged(it)
        },
        sendOtpContinueClicked = {
            sendOtpContinueClicked()
        }
    ))

    val authActions = _authActions.asStateFlow()

    fun getData() {
        viewModelScope.launch {
            val result = domainHelper.appInfoHelper.checkAppUpdateUseCase.execute("2.17.0.0")
            when (result.status) {
                Status.SUCCESS -> {
                    AppLogger.error("result_data_ ${result.data}")
                }

                Status.ERROR -> {

                }
            }
        }
    }

    private fun sendOtpContinueClicked() {

        _authUiState.value = _authUiState.value.copy(
            isLoading = true
        )

        viewModelScope.launch {
            delay(3000)
            _authUiState.value = _authUiState.value.copy(
                isLoading = false,
                showPhoneNumberLayout = false
            )

//            isLoading.value = false
//            val result = domainHelper.consumerAuthHelper.sendOtpUseCase.execute(
//                enteredNo.value
//            )
//            when (result.status) {
//                Status.SUCCESS -> {
//                    isLoading.value = false
//                    isOtpSent.value = true
//                }
//
//                Status.ERROR -> {
//                    isLoading.value = false
//                }
//            }
        }
    }

    private fun onOtpValueChange(otp: String) {
        _authUiState.value = _authUiState.value.copy(
            otpValue = otp
        )
    }

    private fun onPhoneNumberChanged(s: String) {
        _authUiState.value = _authUiState.value.copy(
            sendEnabled = s.length == 10,
            enteredNo = s
        )
    }
}