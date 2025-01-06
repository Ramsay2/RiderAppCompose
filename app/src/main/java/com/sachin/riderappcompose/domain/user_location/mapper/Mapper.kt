package com.apnamart.apnarider.domain.user_location.mapper

import com.apnamart.apnarider.data.http.response.validate_rider_at_store.ValidateRiderAtStoreResponse
import com.apnamart.apnarider.domain.user_location.entity.geofencing.GeoFenceData
import com.apnamart.apnarider.domain.user_location.entity.validate_rider_at_store.ValidateRiderAtStoreDomain
import com.google.android.gms.location.Geofence

fun GeoFenceData.toGeofence() : Geofence? {
    return try {
        val geofence = Geofence.Builder()
            .setRequestId(requestId)
            .setCircularRegion(
                latitude, longitude,
                radius
            )
            .setTransitionTypes(transactionType)
        delay?.let {
            geofence.setLoiteringDelay(it)
        }
        geofence.build()
    } catch (e: Exception) {
    /*    ApnaRider.eventHub.trackEvent(
            EventName.GEOFENCE_INCORRECT_DATA,
            hashMapOf(
                EventKey.CONNECTION_STATUS to "Geofence Data Incorrect",
                EventKey.GEOFENCE_OBJECT to toString(),
                EventKey.TIME_STAMP to Calendar.getInstance().time,
                EventKey.ERROR_MESSAGE to (e)
            )
        )*/
        null
    }
}

fun ValidateRiderAtStoreResponse.toValidateRiderAtStoreDomain() : ValidateRiderAtStoreDomain {
    return ValidateRiderAtStoreDomain(
        riderDistance = riderDistance,
        verification = verification
    )
}
