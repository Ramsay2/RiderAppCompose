package com.apnamart.apnarider.domain.consumer_auth.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.sachin.riderappcompose.data.cache.entities.UserCacheData
import com.apnamart.apnarider.data.http.request.consumer_auth.VerifyOtpRequest
import com.apnamart.apnarider.data.http.response.consumer_auth.AuthResponse
import com.apnamart.apnarider.domain.consumer_auth.mapper.toUserCacheData
import com.sachin.riderappcompose.core_app_framework.interactor.State
import com.sachin.riderappcompose.data.cache.entities.LoginMode
import retrofit2.Response

typealias VerifyOtpInput = Triple<String , String , Int>

class VerifyOtpUseCase(
    private val dataHelper: DataHelper,
    dispatcherProvider: DispatcherProvider
) : SimpleUseCase<VerifyOtpInput, UserCacheData, AuthResponse>(dispatcherProvider) {

    override suspend fun buildUseCase(input: VerifyOtpInput): Response<AuthResponse> {
        val verifyOtpRequest = VerifyOtpRequest(
            phone = input.first,
            otp = input.second,
            accountId = input.third,
            uniqueDeviceId = dataHelper.cacheHelper.deviceUniqueId
        )

        return dataHelper.apiHelper.verifyOtp(verifyOtpRequest)
    }

    override suspend fun onComplete(data: AuthResponse): State<UserCacheData> {
        dataHelper.cacheHelper.loginMode = LoginMode.USERNAME.value
        dataHelper.cacheHelper.userToken = data.token
        dataHelper.cacheHelper.userId = data.userData.userId
        dataHelper.cacheHelper.loggedInUser = data.userData.toUserCacheData()
        dataHelper.updateUserData(data.userData.toUserCacheData(), null)
        return State.success(data.userData.toUserCacheData())
    }
}