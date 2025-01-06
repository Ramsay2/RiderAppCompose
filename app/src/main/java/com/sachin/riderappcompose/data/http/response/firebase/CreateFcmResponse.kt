package com.apnamart.apnarider.data.http.response.firebase

import com.apnamart.apnarider.core_app_framework.identifiers.ApiResponse
import com.google.gson.annotations.SerializedName

@ApiResponse
data class CreateFcmResponse(
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("device_id")
    val deviceId: Int
)
