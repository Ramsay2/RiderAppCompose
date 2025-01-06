package com.sachin.riderappcompose.presentation.auth_screen

data class AuthUiState(
    val showPhoneNumberLayout: Boolean = true,
    val resendVisibility: Boolean = false,
    val resendTimer: String = "",
    val phoneNumberError: String = "",
    val sendEnabled: Boolean = false,
    val resendEnabled: Boolean = false,
    val codeSentTo: String = "",
    val enteredNo: String = "",
    val otpValue: String = "",
    val isLoading: Boolean = false,
    val isOtpSent: Boolean = false
)

data class AuthActions(
    val onPhoneNumberChanged: (String) -> Unit = {},
    val sendOtpContinueClicked: () -> Unit = {},
    val onOtpValueChange: (String) -> Unit = {}
)

