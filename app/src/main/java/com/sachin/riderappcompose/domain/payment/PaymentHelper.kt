package com.apnamart.apnarider.domain.payment

import com.apnamart.apnarider.domain.payment.useCase.CancelPaymentQrUseCase
import com.apnamart.apnarider.domain.payment.useCase.CreatePaymentQrUseCase
import com.apnamart.apnarider.domain.payment.useCase.GetPaymentModesUseCase
import com.apnamart.apnarider.domain.payment.useCase.GetPaymentStatusUseCase

interface PaymentHelper {
    val cancelPaymentQrUseCase : CancelPaymentQrUseCase
    val getPaymentStatusUseCase : GetPaymentStatusUseCase
    val createPaymentQrUseCase : CreatePaymentQrUseCase
    val getPaymentModesUseCase : GetPaymentModesUseCase
}