package com.apnamart.apnarider.data.http.request.sale.upload_order_delivery_image

import okhttp3.MultipartBody

data class UploadOrderDeliveryImageRequest(
    val orderId: Int,
    val image: MultipartBody.Part?,
    val imageType: String
)