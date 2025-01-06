package com.apnamart.apnarider.data.http.request.sale

import okhttp3.MultipartBody

data class UpdateOrderStatusRequest(
    val orderId: Int,
    val cashAmount: Int,
    val onlineAmount: Int,
    val dQRAmount: Double?,
    val status: String,
    val remarks: String?,
    val oType: String? = "rider",
    val latitude: Double,
    val longitude: Double,
    val image : MultipartBody.Part?
    )