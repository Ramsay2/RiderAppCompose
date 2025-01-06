package com.apnamart.apnarider.data.http.response.verify_rider_assignment

import com.google.gson.annotations.SerializedName

data class VerifyRiderAssignmentResponseV2(

    @SerializedName("check_needed")
    val checkNeeded : Boolean? = null
)
