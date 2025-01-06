package com.apnamart.apnarider.data.http.request.attendance

import com.apnamart.apnarider.core_app_framework.identifiers.ApiRequest
import com.google.gson.annotations.SerializedName

@ApiRequest
data class RiderStatusRequest(
    @SerializedName("latitude")
    val latitude: Double = 0.0,
    @SerializedName("longitude")
    val longitude: Double = 0.0,
)
