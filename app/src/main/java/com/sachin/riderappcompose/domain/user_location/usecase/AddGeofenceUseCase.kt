package com.apnamart.apnarider.domain.user_location.usecase

import android.app.PendingIntent
import com.apnamart.apnarider.core_app_framework.interactor.usecase.CompletableUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.domain.user_location.entity.geofencing.GeoFenceData
import com.apnamart.apnarider.domain.user_location.mapper.toGeofence
import com.sachin.riderappcompose.core_app_framework.interactor.State

class AddGeofenceUseCase(
    private val dataHelperTez: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) : CompletableUseCase<Pair<List<GeoFenceData>, PendingIntent>, Unit>(dispatcherProvider) {

    override suspend fun execute(input: Pair<List<GeoFenceData>, PendingIntent>): State<Unit> {
        val list = input.first.mapNotNull { it.toGeofence() }
        return State.success(
            Unit
        )
    }
}