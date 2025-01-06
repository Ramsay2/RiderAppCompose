package com.apnamart.apnarider.data.http.request.consumer_auth

import com.apnamart.apnarider.core_app_framework.identifiers.ApiRequest
import com.google.gson.annotations.SerializedName

@ApiRequest
data class VerifyOtpRequest(
    @SerializedName("phone")
    val phone: String,
    @SerializedName("country_code")
    val countryCode: String = "+91",
    @SerializedName("client_app")
    val clientApp: String = "rider",
    @SerializedName("otp")
    val otp: String,
    @SerializedName("token")
    val token: String = "",
    @SerializedName("account_id")
    val accountId: Int,
    @SerializedName("device_identifier")
    val uniqueDeviceId: String? = null
)