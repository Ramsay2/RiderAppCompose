package com.apnamart.apnarider.data.http.response.payment

import com.google.gson.annotations.SerializedName


data class CreatePaymentQrResponse(
    @SerializedName("data")
    val data: PaymentQrResponse
)

data class PaymentQrResponse(
    @SerializedName("amount")
    val amount: Double? = null,
    @SerializedName("expiry")
    val expiry: Double? = null,
    @SerializedName("order_number")
    val orderNumber: String? = null,
    @SerializedName("qr_string")
    val qrStr: String? = null,
    @SerializedName("txn_id")
    val refId: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("qr_name")
    val receiverName: String? = null
)