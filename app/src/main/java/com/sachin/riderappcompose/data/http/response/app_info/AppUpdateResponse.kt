package com.apnamart.apnarider.data.http.response.app_info

import com.apnamart.apnarider.core_app_framework.identifiers.ApiResponse
import com.google.gson.annotations.SerializedName

@ApiResponse
data class AppUpdateResponse(

    @SerializedName("major")
    var major: Boolean = false,
    @SerializedName("required")
    var required: Boolean = false,
)
