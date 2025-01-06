package com.apnamart.apnarider.domain.consumer_auth.usecase

import com.apnamart.apnarider.core_app_framework.getDeviceUniqueId
import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.request.consumer_auth.SendOtpRequest
import com.apnamart.apnarider.data.http.response.consumer_auth.SendOtpResponse
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class SendOtpUseCase(
    private val dataHelper: DataHelper,
    dispatcherProvider: DispatcherProvider
) : SimpleUseCase<String, Int, SendOtpResponse>(dispatcherProvider) {

    override suspend fun buildUseCase(input: String): Response<SendOtpResponse> {
        val otpRequest = SendOtpRequest(
            phone = input,
            uniqueDeviceId = getDeviceUniqueId(true)
        )
        return dataHelper.apiHelper.sendOtp(otpRequest)
    }

    override suspend fun onComplete(data: SendOtpResponse): State<Int> {
        return State.success(data.accountId)
    }
}