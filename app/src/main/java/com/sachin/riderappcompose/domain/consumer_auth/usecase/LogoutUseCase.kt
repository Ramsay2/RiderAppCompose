package com.apnamart.apnarider.domain.consumer_auth.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleVoidUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.request.consumer_auth.LogoutRequest
import com.apnamart.apnarider.data.http.response.GenericResponse
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class LogoutUseCase(private val dataHelper: DataHelper, dispatcherProvider: DispatcherProvider) :
    SimpleVoidUseCase<GenericResponse, GenericResponse>(dispatcherProvider = dispatcherProvider) {

    override suspend fun buildUseCase(input: Unit): Response<GenericResponse> {
        return dataHelper.apiHelper.logout(LogoutRequest(deviceId = dataHelper.cacheHelper.deviceId))
    }

    override suspend fun onComplete(data: GenericResponse): State<GenericResponse> {
        dataHelper.clearUserData()
        return State.success(data)
    }
}