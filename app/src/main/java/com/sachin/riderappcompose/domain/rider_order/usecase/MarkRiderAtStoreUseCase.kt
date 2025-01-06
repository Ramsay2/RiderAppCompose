package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.request.attendance.RiderStatusRequest
import com.apnamart.apnarider.data.http.response.GenericResponse
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class MarkRiderAtStoreUseCase(val dataHelper: DataHelper, dispatcherProvider: DispatcherProvider) :
    SimpleUseCase<Pair<Double, Double>, GenericResponse, GenericResponse>(
        dispatcherProvider
    ) {
    override suspend fun buildUseCase(input: Pair<Double, Double>): Response<GenericResponse> {
        return dataHelper.apiHelper.markRiderAtStore(
            RiderStatusRequest(input.first, input.second)
        )
    }

    override suspend fun onComplete(data: GenericResponse): State<GenericResponse> {
        dataHelper.cacheHelper.isOutForDelivery = false
        return State.success(data)
    }
}