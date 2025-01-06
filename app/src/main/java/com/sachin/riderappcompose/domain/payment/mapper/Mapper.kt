package com.apnamart.apnarider.domain.payment.mapper

import com.apnamart.apnarider.data.http.response.payment.PaymentModeResponse
import com.apnamart.apnarider.data.http.response.payment.PaymentQrResponse
import com.apnamart.apnarider.domain.payment.entity.ModeOfPaymentDomain
import com.apnamart.apnarider.domain.payment.entity.PaymentQrDomain

fun PaymentQrResponse.toPaymentQrDomain(): PaymentQrDomain {
    return PaymentQrDomain(
        amount = amount ?: 0.0,
        expiryTime = expiry ?: 0.0,
        orderNumber = orderNumber ?: "",
        qrStr = qrStr ?: "",
        refId = refId ?: "",
        status = status ?: "",
        paymentReceiverName = receiverName ?: ""

    )
}

fun Iterable<PaymentModeResponse>.toModeOfPaymentList(): List<ModeOfPaymentDomain> {
    return this.filter { it.active }.map { it.toModeOfPayment() }
}

fun PaymentModeResponse.toModeOfPayment(): ModeOfPaymentDomain {
    return ModeOfPaymentDomain(id, priority, tagName, displayName, helpText, logo, razorPayKey, paytmMid)
}