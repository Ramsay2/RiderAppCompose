package com.apnamart.apnarider.domain.payment.useCase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.payment.PaymentModeResponse
import com.apnamart.apnarider.domain.payment.entity.ModeOfPaymentDomain
import com.apnamart.apnarider.domain.payment.mapper.toModeOfPaymentList
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class GetPaymentModesUseCase(
    private val dataHelper: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) : SimpleUseCase<Int, List<ModeOfPaymentDomain>, List<PaymentModeResponse>>(dispatcherProvider) {

    override suspend fun buildUseCase(input: Int): Response<List<PaymentModeResponse>> {
        return dataHelper.apiHelper.getPaymentMethods(input, true)
    }

    override suspend fun onComplete(data: List<PaymentModeResponse>): State<List<ModeOfPaymentDomain>> {
        return State.success(data.toModeOfPaymentList())
    }
}