package com.apnamart.apnarider.domain.payment

import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.domain._base.BaseHelperImplNew
import com.apnamart.apnarider.domain.payment.useCase.CancelPaymentQrUseCase
import com.apnamart.apnarider.domain.payment.useCase.CreatePaymentQrUseCase
import com.apnamart.apnarider.domain.payment.useCase.GetPaymentModesUseCase
import com.apnamart.apnarider.domain.payment.useCase.GetPaymentStatusUseCase
import javax.inject.Inject

class PaymentHelperImpl @Inject
constructor(dataHelper: DataHelper, dispatcherProvider: DispatcherProvider) :
    BaseHelperImplNew(dataHelper, dispatcherProvider) , PaymentHelper{
    override val cancelPaymentQrUseCase: CancelPaymentQrUseCase
        get() = CancelPaymentQrUseCase(dataHelper, dispatcherProvider)
    override val getPaymentStatusUseCase: GetPaymentStatusUseCase
        get() = GetPaymentStatusUseCase(dataHelper, dispatcherProvider)
    override val createPaymentQrUseCase: CreatePaymentQrUseCase
        get() = CreatePaymentQrUseCase(dataHelper, dispatcherProvider)

    override val getPaymentModesUseCase: GetPaymentModesUseCase
        get() = GetPaymentModesUseCase(dataHelper, dispatcherProvider)
}