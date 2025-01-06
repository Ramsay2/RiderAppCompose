package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCaseV2
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.GenericResponse
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class DeleteOrderDeliveryImageUseCase(val dataHelper: DataHelper, dispatcherProvider: DispatcherProvider) :
    SimpleUseCaseV2<Int, GenericResponse, GenericResponse>(
        dispatcherProvider
    ) {
    override suspend fun buildUseCase(input: Int): Response<GenericResponseV2<GenericResponse>> {
        return dataHelper.apiHelper.deleteOrderDeliveryImage(input)
    }

    override suspend fun onComplete(data: GenericResponseV2<GenericResponse>): State<GenericResponse> {
        return State.success(data.data)
    }
}