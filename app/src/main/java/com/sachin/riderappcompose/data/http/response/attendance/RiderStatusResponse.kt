package com.apnamart.apnarider.data.http.response.attendance

import com.apnamart.apnarider.core_app_framework.identifiers.ApiResponse
import com.google.gson.annotations.SerializedName

@ApiResponse
data class RiderStatusResponse(

    @SerializedName("rider_id")
    val riderId: Int,
    @SerializedName("mark_in_radius")
    val markInRadius: Double = 100.0,
    @SerializedName("delivery_radius")
    val deliveryRadius: Double = 500.0,
    @SerializedName("pick_up_radius")
    val pickupRadius: Double = 500.0,
    @SerializedName("marked_in")
    val markedIn: Boolean = false,
    @SerializedName("working_minutes")
    val workingMinutes : Int
)
