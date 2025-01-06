package com.sachin.riderappcompose.presentation.auth_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mukeshsolanki.OTP_VIEW_TYPE_BORDER
import com.mukeshsolanki.OtpView
import com.sachin.riderappcompose.R
import com.sachin.riderappcompose.presentation.base.BaseCompose
import com.sachin.riderappcompose.presentation.common_component.AppSpacer
import com.sachin.riderappcompose.presentation.common_component.GenericButton
import com.sachin.riderappcompose.presentation.theme.AppColor
import com.sachin.riderappcompose.presentation.theme.MyTypography


@Composable
fun AuthScreen() {
    BaseCompose( viewModel = hiltViewModel<AuthViewModel>()) { viewModel ->

        SideEffect {
            viewModel.getData()
        }

        val uiState by viewModel.authUiState.collectAsStateWithLifecycle()
        val authAction by viewModel.authActions.collectAsStateWithLifecycle()

        AuthScreenUi(uiState, authAction)

    }
}

@Composable
fun AuthScreenUi(authState: AuthUiState, authActions: AuthActions) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_rider_icon_name),
            contentDescription = null,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
        )

        if (authState.showPhoneNumberLayout) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Text(
                    text = "Enter your phone number to get started",
                    style = MyTypography.headlineMedium,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                AppSpacer(modifier = Modifier.padding(top = 8.dp))

                OutlinedTextField(
                    value = authState.enteredNo,
                    onValueChange = {
                        if (it.length <= 10)
                            authActions.onPhoneNumberChanged(it)
                    },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    maxLines = 1,
                )

                AppSpacer(modifier = Modifier.padding(top = 8.dp))

                GenericButton(
                    text = "Continue",
                    enabled = authState.sendEnabled,
                    onClick = {
                        authActions.sendOtpContinueClicked()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp),
                    isLoading = authState.isLoading,
                    icon = Icons.Default.Send,
                    border = null
                )
            }
        } else {
            Column {
                AppSpacer(modifier = Modifier.padding(top = 8.dp))

                Text(
                    text = "Enter your code",
                    style = MyTypography.headlineMedium,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                AppSpacer(modifier = Modifier.padding(top = 8.dp))

                OtpView(
                    otpText = authState.otpValue,
                    onOtpTextChange = {
                        authActions.onOtpValueChange(it)
                    },
                    type = OTP_VIEW_TYPE_BORDER,
                    containerSize = 48.dp,
                    charColor = AppColor.ColorTextAndIconsHighEmphasis,
                    otpCount = 6,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )

            }
        }
    }
}
