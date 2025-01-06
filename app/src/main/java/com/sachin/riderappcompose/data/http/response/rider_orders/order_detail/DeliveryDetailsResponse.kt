package com.apnamart.apnarider.data.http.response.rider_orders.order_detail

import com.google.gson.annotations.SerializedName


data class DeliveryDetailsResponse(

    @SerializedName("mode") val mode: String? = null,
    @SerializedName("pick_up") val pickUp: Boolean? = null,
    @SerializedName("home_delivery") val homeDelivery: Boolean? = null,
    @SerializedName("slug_name") val slugName: String? = null,
    @SerializedName("id") val id: Int? = null,

)