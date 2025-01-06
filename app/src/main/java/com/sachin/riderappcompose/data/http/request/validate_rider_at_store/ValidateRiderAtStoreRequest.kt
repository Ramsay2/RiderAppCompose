package com.apnamart.apnarider.data.http.request.validate_rider_at_store

import com.google.gson.annotations.SerializedName

data class ValidateRiderAtStoreRequest(
    @SerializedName("latitude")
    val latitude : Double,
    @SerializedName("longitude")
    val longitude : Double,
    @SerializedName("check_action")
    val checkAction : String
)
