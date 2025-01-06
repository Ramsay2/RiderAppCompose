package com.apnamart.apnarider.domain.user_location.usecase

import android.content.Context
import com.apnamart.apnarider.core_app_framework.interactor.usecase.CompletableUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.sachin.riderappcompose.core_app_framework.interactor.State

class CheckLocationUseCase(
    private val dataHelperTez: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) : CompletableUseCase<Context, Boolean>(dispatcherProvider) {

    override suspend fun execute(input: Context): State<Boolean> {
      /*  val fineLocation = checkFineLocation(input)
        val coarseLocation = checkCoarseLocation(input)
        val backgroundLocation =
            (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && checkBackgroundLocationPermission(input))
        ApnaRider.eventHub.trackEvent(
            EventName.LOCATION_PERMISSION,
            hashMapOf(
                EventKey.TIME_STAMP to getCurrentTimeStamp(),
                EventKey.FINE_LOCATION_PERMISSION to fineLocation,
                EventKey.COARSE_LOCATION_PERMISSION to coarseLocation,
                EventKey.BACKGROUND_LOCATION_PERMISSION to backgroundLocation
            )
        )
        var hasLocationPermission = false
        if (!fineLocation || !coarseLocation) {
            hasLocationPermission =  false
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && !backgroundLocation) {
            hasLocationPermission = false
        } else {
            hasLocationPermission = true
        }*/
        return State.success(true)
    }
}