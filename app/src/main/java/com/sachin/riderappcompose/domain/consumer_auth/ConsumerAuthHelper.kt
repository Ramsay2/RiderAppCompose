package com.apnamart.apnarider.domain.consumer_auth

import com.apnamart.apnarider.domain.consumer_auth.usecase.CleanUserDataUseCase
import com.apnamart.apnarider.domain.consumer_auth.usecase.GetOperatedStoresUseCase
import com.apnamart.apnarider.domain.consumer_auth.usecase.GetUserDataUseCase
import com.apnamart.apnarider.domain.consumer_auth.usecase.LogoutUseCase
import com.apnamart.apnarider.domain.consumer_auth.usecase.SendOtpUseCase
import com.apnamart.apnarider.domain.consumer_auth.usecase.UpdateProfileUseCase
import com.apnamart.apnarider.domain.consumer_auth.usecase.VerifyOtpUseCase

interface ConsumerAuthHelper {
    val cleanUserDataUseCase: CleanUserDataUseCase
    val getUserDataUseCase: GetUserDataUseCase
    val logoutUseCase: LogoutUseCase
    val getOperatedStoresUseCase: GetOperatedStoresUseCase
    val sendOtpUseCase: SendOtpUseCase
    val verifyOtpUseCase: VerifyOtpUseCase
    val updateProfileUseCase : UpdateProfileUseCase
}