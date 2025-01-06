package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.GenericResponse
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class ManuallyAssignRiderUseCase(
    private val dataHelper: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) : SimpleUseCase<Triple<String, Double, Double>, GenericResponse, GenericResponse>(
    dispatcherProvider
) {
    override suspend fun buildUseCase(input: Triple<String, Double, Double>): Response<GenericResponse> {
        return dataHelper.apiHelper.manuallyAssignRider(
            input.first, dataHelper.cacheHelper.userId,
            input.second, input.third
        )
    }

    override suspend fun onComplete(data: GenericResponse): State<GenericResponse> {
        return State.success(data)
    }
}