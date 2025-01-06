package com.apnamart.apnarider.domain.payment.entity

data class PaymentQrDomain(
    val amount: Double,
    val expiryTime: Double,
    val orderNumber: String,
    val qrStr: String,
    val refId: String,
    val status: String,
    val paymentReceiverName : String
)
