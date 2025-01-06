package com.apnamart.apnarider.domain.user_location.entity.geofencing

data class GeoFenceData(
    val requestId: String,
    val radius: Float,
    val latitude: Double,
    val longitude: Double,
    val delay: Int? = null,
    val transactionType: Int,
)
