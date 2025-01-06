package com.apnamart.apnarider.data.http.request.payment

import com.google.gson.annotations.SerializedName


data class PaymentRequest(
    @SerializedName("order_id") val orderId: String?,
    @SerializedName("store_id") val storeId: Int?,
    @SerializedName("txn_id") val refId: String?,
    @SerializedName("pay_mode") val payMode: String = "DQR"
)
