package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.GenericResponse
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class VerifyOnlineOrderReturn(
    val dataHelper: DataHelper,
    val dispatcher: DispatcherProvider
) : SimpleUseCase<Pair<Int, String>, GenericResponse, GenericResponse>(dispatcher) {
    override suspend fun buildUseCase(input: Pair<Int, String>): Response<GenericResponse> {
        return dataHelper.apiHelper.verifyReturn("return", input.first, input.second)
    }

    override suspend fun onComplete(data: GenericResponse): State<GenericResponse> {
        return State.success(data)
    }

}