package com.apnamart.apnarider.data.http.response.rider_orders.order_list_v2

import com.google.gson.annotations.SerializedName

data class PickingTimerConfigResponse(

    @SerializedName("enable")
    val enable : Boolean? = null,

    @SerializedName("picking_time")
    val pickingTime : Int? = null,

    @SerializedName("card_color_background")
    val cardColorBackground : String? = null,

    @SerializedName("card_text_color")
    val cardTextColor : String? = null

)
