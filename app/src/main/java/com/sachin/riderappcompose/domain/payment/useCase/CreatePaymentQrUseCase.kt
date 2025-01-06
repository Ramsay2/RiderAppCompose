package com.apnamart.apnarider.domain.payment.useCase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.request.payment.PaymentRequest
import com.apnamart.apnarider.data.http.response.payment.CreatePaymentQrResponse
import com.apnamart.apnarider.domain.payment.entity.PaymentQrDomain
import com.apnamart.apnarider.domain.payment.mapper.toPaymentQrDomain
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class CreatePaymentQrUseCase(
    private val dataHelper: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) : SimpleUseCase<PaymentRequest ,  PaymentQrDomain, CreatePaymentQrResponse>(dispatcherProvider) {
    override suspend fun buildUseCase(input: PaymentRequest): Response<CreatePaymentQrResponse> {
        return dataHelper.apiHelper.createPaymentQR(input)
    }

    override suspend fun onComplete(data: CreatePaymentQrResponse): State<PaymentQrDomain> {
       return State.success(data.data.toPaymentQrDomain())
    }
}