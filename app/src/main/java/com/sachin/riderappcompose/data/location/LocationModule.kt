package com.apnamart.apnarider.data.location

import android.app.Application
import android.location.Geocoder
import com.apnamart.apnarider.core_app_framework.ioc.scope.ApplicationScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.SettingsClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.Locale

@Module
@InstallIn(SingletonComponent::class)
class LocationModule {

    @Provides
    fun contributeClientDataHelper(clientDataHelper: LocationHelperImpl): LocationHelper {
        return clientDataHelper
    }

    @Provides
    internal fun contributeFusedLocationProvider(application: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(application)
    }

    @Provides
    internal fun contributeGeocoder(application: Application): Geocoder {
        return Geocoder(application, Locale.getDefault())
    }

    @Provides
    internal fun contributeSettingsClient(application: Application): SettingsClient {
        return LocationServices.getSettingsClient(application)
    }

    @Provides
    internal fun contributeLocationSettingsRequest(): LocationSettingsRequest.Builder {
        val locationRequest = LocationRequest.create().apply {
            interval = 10000
            fastestInterval = 5000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
        return LocationSettingsRequest.Builder().addLocationRequest(locationRequest)
    }

}