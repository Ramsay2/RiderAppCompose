package com.apnamart.apnarider.data.http.response.consumer_auth

import com.apnamart.apnarider.core_app_framework.identifiers.ApiResponse
import com.google.gson.annotations.SerializedName

@ApiResponse
data class AuthResponse(
    @SerializedName("is_active")
    var isActive: Boolean = false,
    @SerializedName("token")
    var token: String? = null,
    @SerializedName("user_data")
    var userData: UserData
)