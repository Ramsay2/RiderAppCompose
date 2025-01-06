package com.apnamart.apnarider.data.http.request.consumer_auth

import com.apnamart.apnarider.core_app_framework.identifiers.ApiRequest
import com.google.gson.annotations.SerializedName

@ApiRequest
data class UpdateProfileRequest(
    @SerializedName("full_name")
    var name: String? = null,
    @SerializedName("nick_name")
    var nickName: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("gender")
    var gender: String? = null,
    @SerializedName("dob")
    var dob: String? = null,
    @SerializedName("client_app")
    val clientApp: String = "rider"
)