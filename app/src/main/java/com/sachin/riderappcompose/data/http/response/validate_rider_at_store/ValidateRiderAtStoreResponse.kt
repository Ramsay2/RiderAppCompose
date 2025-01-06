package com.apnamart.apnarider.data.http.response.validate_rider_at_store

import com.google.gson.annotations.SerializedName

data class ValidateRiderAtStoreResponse(

   @SerializedName("rider_distance")
    val riderDistance : Float,

    @SerializedName("verification")
    val verification : Boolean
)
