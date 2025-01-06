package com.apnamart.apnarider.domain.firebase.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleVoidUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.request.firebase.CreateFcmRequest
import com.apnamart.apnarider.data.http.response.firebase.CreateFcmResponse
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class CreateFcmUseCase(private val dataHelper: DataHelper, dispatcherProvider: DispatcherProvider) :
    SimpleVoidUseCase<Pair<String?, Int>, CreateFcmResponse>(dispatcherProvider) {

    override suspend fun buildUseCase(input: Unit): Response<CreateFcmResponse> {
        return dataHelper.apiHelper.registerFCM(
            CreateFcmRequest(
                fcmToken = dataHelper.cacheHelper.fcmToken ?: "",
                deviceId = dataHelper.cacheHelper.deviceId
            )
        )
    }

    override suspend fun onComplete(data: CreateFcmResponse): State<Pair<String?, Int>> {
        dataHelper.cacheHelper.deviceId = data.deviceId
        return State.success(Pair(data.message, data.deviceId))
    }
}