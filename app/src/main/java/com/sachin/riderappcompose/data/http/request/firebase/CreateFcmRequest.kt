package com.apnamart.apnarider.data.http.request.firebase

import com.apnamart.apnarider.core_app_framework.identifiers.ApiRequest
import com.google.gson.annotations.SerializedName

@ApiRequest
data class CreateFcmRequest(
        @SerializedName("device_type")
        var deviceType: String = "rider",
        @SerializedName("fcm_token")
        var fcmToken: String = "",
        @SerializedName("device_id")
        var deviceId: Int
)