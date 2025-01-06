package com.apnamart.apnarider.data.location

import android.location.Geocoder
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.SettingsClient
import javax.inject.Inject

class LocationHelperImpl @Inject constructor(
        override val fusedLocationClient: FusedLocationProviderClient,
        override val geocoder: Geocoder,
        override val client: SettingsClient,
        override val locationSettingsRequest: LocationSettingsRequest.Builder
) : LocationHelper