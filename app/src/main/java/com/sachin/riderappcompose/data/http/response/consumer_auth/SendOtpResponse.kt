package com.apnamart.apnarider.data.http.response.consumer_auth

import com.apnamart.apnarider.core_app_framework.identifiers.ApiResponse
import com.google.gson.annotations.SerializedName

@ApiResponse
data class SendOtpResponse(
    @SerializedName("token")
    val token: String,
    @SerializedName("account_id")
    val accountId: Int,
    @SerializedName("forgot_pwd")
    val forgotPassword: Boolean
)