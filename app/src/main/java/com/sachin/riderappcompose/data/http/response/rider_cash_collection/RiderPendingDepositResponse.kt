package com.apnamart.apnarider.data.http.response.rider_cash_collection

import com.google.gson.annotations.SerializedName

data class RiderPendingDepositResponse(
    @SerializedName("month")
    val month: String? = null,
    @SerializedName("order_id")
    val orderId: String? = null,
    @SerializedName("store_name")
    val storeName: String? = null,
    @SerializedName("delivered_at")
    val deliveredAt: String? = null,
    @SerializedName("cash_amount")
    val cash: Double? = null,
    @SerializedName("order_number")
    val orderNumber: String? = null,

)
