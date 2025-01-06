package com.apnamart.apnarider.data.http.response.rider_orders.order_detail

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("product_id") val productId: Int,
    @SerializedName("main_image") val mainImage: String,
    @SerializedName("display_name") val displayName: String,
    @SerializedName("is_high_value_item") val isHighValueItem: Boolean
)
