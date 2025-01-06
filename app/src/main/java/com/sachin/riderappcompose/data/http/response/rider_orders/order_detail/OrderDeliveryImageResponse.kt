package com.apnamart.apnarider.data.http.response.rider_orders.order_detail

import com.google.gson.annotations.SerializedName

data class UploadOrderDeliveryImageResponse(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("url") val url: String? = null
)

data class GetOrderDeliveryImageListResponse(
    @SerializedName("img_list") val imageList: List<UploadOrderDeliveryImageResponse>? = null
)