package com.apnamart.apnarider.domain.payment.useCase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.request.payment.PaymentRequest
import com.apnamart.apnarider.data.http.response.GenericResponse
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class CancelPaymentQrUseCase(
    private val dataHelper: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) : SimpleUseCase<PaymentRequest, GenericResponse, GenericResponse>(dispatcherProvider) {
    override suspend fun buildUseCase(input: PaymentRequest): Response<GenericResponse> {
        return dataHelper.apiHelper.cancelPayment(input)
    }

    override suspend fun onComplete(data: GenericResponse): State<GenericResponse> {
        return State.success(data)
    }
}