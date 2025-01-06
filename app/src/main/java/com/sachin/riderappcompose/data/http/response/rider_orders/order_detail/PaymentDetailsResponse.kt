package com.apnamart.apnarider.data.http.response.rider_orders.order_detail

import com.google.gson.annotations.SerializedName


data class PaymentDetailsResponse(

    @SerializedName("order_amount") val orderAmount: Double  = 0.0,
    @SerializedName("total_amount") val totalAmount: Double = 0.0,
    @SerializedName("billed_amount"    ) val billedAmount    : Double? = null,
    @SerializedName("delivery_charges") val deliveryCharges: Double = 0.0,
    @SerializedName("savings") val savings: Double = 0.0,
    @SerializedName("name") val name: String? = null,
    @SerializedName("tag_name") val tagName: String? = null

)