package com.apnamart.apnarider.data.http.request.consumer_auth

import com.google.gson.annotations.SerializedName

data class LogoutRequest(
    @SerializedName("client_app")
    val clientApp: String = "rider",
    @SerializedName("device_id")
    val deviceId: Int
)
