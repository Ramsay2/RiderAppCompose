package com.apnamart.apnarider.data.http.response.rider_orders.orders_count

import com.google.gson.annotations.SerializedName

data class RiderOrdersCountResponse(

    @SerializedName("CNF")
    val confirmOrderCount : Int? = null,

    @SerializedName("PDG")
    val pendingOrderCount : Int? = null,

    @SerializedName("PDG_RTN")
    val pendingReturnOrderCount : Int? = null
)
