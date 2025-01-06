package com.apnamart.apnarider.domain.payment.entity

data class ModeOfPaymentDomain (
        var id: Int,
        var priority: Int,
        var tagName: String,
        var displayName: String?,
        var helpText: String?,
        var logo: String?,
        var razorPayKey: String?,
        var paytmMid: String?
)