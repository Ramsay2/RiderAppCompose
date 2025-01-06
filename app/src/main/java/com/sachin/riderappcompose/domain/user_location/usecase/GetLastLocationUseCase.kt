package com.apnamart.apnarider.domain.user_location.usecase

import android.annotation.SuppressLint
import android.location.Location
import android.os.Looper
import com.apnamart.apnarider.data.DataHelper
import com.sachin.riderappcompose.core_app_framework.interactor.State
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.Priority
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class GetLastLocationUseCase(
    private val dataHelper: DataHelper,
) {
    @SuppressLint("MissingPermission")
    suspend fun execute(
        scope: CoroutineScope, isRepeat: Boolean
    ): Flow<State<Location>> = callbackFlow() {

        val locationRequest: LocationRequest =
            LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 10000)
                .setMaxUpdates(if (isRepeat) MAX_UPDATE else 1)
                .setMinUpdateIntervalMillis(5000)
                .build()


        val listener = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)
                if (!scope.isActive) {
                    close()
                }
                locationResult.locations.lastOrNull()?.let { location ->
                    trySend(State.success(location))
                }
            }
        }

        dataHelper.locationHelper.client.checkLocationSettings(dataHelper.locationHelper.locationSettingsRequest.build())
            .addOnSuccessListener {
                try {
                    dataHelper.locationHelper.fusedLocationClient.requestLocationUpdates(
                        locationRequest,
                        listener,
                        Looper.getMainLooper()
                    ).addOnFailureListener {
                        close(it)
                        scope.launch {
                            trySend(State.error(it))
                        }
                    }.addOnCompleteListener { task ->
                        if (!task.isSuccessful || task.exception != null) {
                            trySend(
                                State.error(
                                    task.exception
                                        ?: IllegalStateException("Can't get location from FusedLocationProviderClient")
                                )
                            )
                        }
                    }
                } catch (e: Exception) {
                    scope.launch {
                        trySend(State.error(e))
                    }
                }
            }.addOnFailureListener {
                scope.launch {
                    trySend(State.error(it))
                }
            }
        awaitClose {
            dataHelper.locationHelper.fusedLocationClient.removeLocationUpdates(listener)
        }
    }

    private val MAX_UPDATE = 5
}
