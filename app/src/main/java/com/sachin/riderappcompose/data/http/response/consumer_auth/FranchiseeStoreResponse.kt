package com.apnamart.apnarider.data.http.response.consumer_auth

import com.apnamart.apnarider.core_app_framework.identifiers.ApiResponse
import com.google.gson.annotations.SerializedName

@ApiResponse
data class FranchiseeStoreResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String? = null,
    @SerializedName("tag_name") val tagName: String? = null,
    @SerializedName("store_open") val storeOpen: Boolean,
    @SerializedName("latitude") val latitude: String? = null,
    @SerializedName("longitude") val longitude: String? = null,
    @SerializedName("address") val address: String? = null,
    @SerializedName("landmark") val landmark: String? = null,
    @SerializedName("pin_code") val pinCode: String? = null,
    @SerializedName("city") val city: String? = null,
    @SerializedName("state") val state: String? = null

)