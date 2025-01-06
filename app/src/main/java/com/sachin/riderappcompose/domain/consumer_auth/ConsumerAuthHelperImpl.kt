package com.apnamart.apnarider.domain.consumer_auth

import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.domain._base.BaseHelperImplNew
import com.apnamart.apnarider.domain.consumer_auth.usecase.CleanUserDataUseCase
import com.apnamart.apnarider.domain.consumer_auth.usecase.GetOperatedStoresUseCase
import com.apnamart.apnarider.domain.consumer_auth.usecase.GetUserDataUseCase
import com.apnamart.apnarider.domain.consumer_auth.usecase.LogoutUseCase
import com.apnamart.apnarider.domain.consumer_auth.usecase.SendOtpUseCase
import com.apnamart.apnarider.domain.consumer_auth.usecase.UpdateProfileUseCase
import com.apnamart.apnarider.domain.consumer_auth.usecase.VerifyOtpUseCase
import javax.inject.Inject

class ConsumerAuthHelperImpl @Inject constructor(
    dataHelper: DataHelper,
    dispatcherProvider: DispatcherProvider
) : BaseHelperImplNew(dataHelper, dispatcherProvider), ConsumerAuthHelper {
    override val cleanUserDataUseCase: CleanUserDataUseCase
        get() = CleanUserDataUseCase(dataHelper = dataHelper, dispatcherProvider)
    override val getUserDataUseCase: GetUserDataUseCase
        get() = GetUserDataUseCase(dataHelper = dataHelper, dispatcherProvider)
    override val logoutUseCase: LogoutUseCase
        get() = LogoutUseCase(dataHelper = dataHelper, dispatcherProvider)
    override val getOperatedStoresUseCase: GetOperatedStoresUseCase
        get() = GetOperatedStoresUseCase(dataHelper = dataHelper, dispatcherProvider)
    override val sendOtpUseCase: SendOtpUseCase
        get() = SendOtpUseCase(dataHelper = dataHelper, dispatcherProvider)
    override val verifyOtpUseCase: VerifyOtpUseCase
        get() = VerifyOtpUseCase(dataHelper = dataHelper, dispatcherProvider)
    override val updateProfileUseCase: UpdateProfileUseCase
        get() = UpdateProfileUseCase(dataHelper = dataHelper, dispatcherProvider = dispatcherProvider)
}