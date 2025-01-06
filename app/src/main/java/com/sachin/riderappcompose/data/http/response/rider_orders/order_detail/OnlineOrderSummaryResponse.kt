package com.apnamart.apnarider.data.http.response.rider_orders.order_detail


import com.google.gson.annotations.SerializedName

data class OnlineOrderSummaryResponse(
    @SerializedName("data")
    val data: OrderSummaryResponse? = null
)

data class OrderSummaryResponse(
    @SerializedName("handover_breached")
    val handoverBreached: List<String>?,
    @SerializedName("order_count")
    val orderCount: OrderCountResponse? = null,
    @SerializedName("picking_breached")
    val pickingBreached: List<String>?,
    @SerializedName("delivery_breached")
    val deliveryBreached: List<String>?
)

data class OrderCountResponse(
    @SerializedName("confirmed_count")
    val confirmedCount: Int = 0,
    @SerializedName("packed_count")
    val packedCount: Int = 0,
    @SerializedName("placed_count")
    val placedCount: Int = 0
)

