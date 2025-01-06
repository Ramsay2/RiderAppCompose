package com.apnamart.apnarider.data.http.response.rider_orders.order_detail

import com.google.gson.annotations.SerializedName


data class InstructionsResponse(

    @SerializedName("delivery_instructions") val deliveryInstructions: String? = null,
    @SerializedName("remarks") val remarks: String? = null

)