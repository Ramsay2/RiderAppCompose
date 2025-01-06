package com.apnamart.apnarider.domain.user_location

import com.apnamart.apnarider.domain.user_location.usecase.AddGeofenceUseCase
import com.apnamart.apnarider.domain.user_location.usecase.CheckLocationUseCase
import com.apnamart.apnarider.domain.user_location.usecase.GetLastLocationUseCase
import com.apnamart.apnarider.domain.user_location.usecase.RemoveGeofenceUseCase
import com.apnamart.apnarider.domain.user_location.usecase.ValidateRiderAtStoreUseCase

interface UserLocationHelper {
    val addGeofenceUseCase : AddGeofenceUseCase
    val checkLocationUseCase : CheckLocationUseCase
    val removeGeofenceUseCase : RemoveGeofenceUseCase
    val validateRiderAtStoreUseCase : ValidateRiderAtStoreUseCase
    val getLastLocationUseCase: GetLastLocationUseCase
}