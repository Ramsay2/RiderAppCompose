package com.apnamart.apnarider.data.http.response

import com.apnamart.apnarider.core_app_framework.identifiers.ApiResponse
import com.google.gson.annotations.SerializedName

@ApiResponse
data class ApiError(
    @SerializedName("error")
    val error: String?
)