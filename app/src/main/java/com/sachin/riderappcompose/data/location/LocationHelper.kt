package com.apnamart.apnarider.data.location

import android.location.Geocoder
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.SettingsClient

interface LocationHelper {
    val fusedLocationClient: FusedLocationProviderClient
    val geocoder: Geocoder

    val client: SettingsClient
    val locationSettingsRequest: LocationSettingsRequest.Builder
}