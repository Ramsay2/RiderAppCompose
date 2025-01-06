package com.apnamart.apnarider.data.http.response.consumer_auth

import com.apnamart.apnarider.core_app_framework.identifiers.ApiResponse
import com.google.gson.annotations.SerializedName

@ApiResponse
data class UserData(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("nick_name")
    var nickName: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("gender")
    var gender: String? = null,
    @SerializedName("phone")
    var phone: String? = null,
    @SerializedName("country_code")
    var countryCode: String? = null,
    @SerializedName("blocked")
    var blocked: Boolean,
    @SerializedName("user_id")
    var userId: Int,
    @SerializedName("user_image")
    var userImage: String? = null,
    @SerializedName("whatsapp")
    var whatsapp: String? = null,
    @SerializedName("dob")
    var dob: String? = null,
    @SerializedName("added_on")
    var addedOn: String? = null,
    @SerializedName("is_superuser")
    var isSuperuser: Boolean = false,
    @SerializedName("groups")
    var groups: List<String>? = null,
    @SerializedName("rider_data")
    val riderData: RiderData? = null,
    @SerializedName("username")
    val username : String? = null,
)

data class RiderData(
    @SerializedName("is_v3_enabled")
    val isV3Enabled : Boolean
)