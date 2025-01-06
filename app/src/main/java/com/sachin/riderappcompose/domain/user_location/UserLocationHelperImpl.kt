package com.apnamart.apnarider.domain.user_location

import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.domain._base.BaseHelperImplNew
import com.apnamart.apnarider.domain.user_location.usecase.AddGeofenceUseCase
import com.apnamart.apnarider.domain.user_location.usecase.CheckLocationUseCase
import com.apnamart.apnarider.domain.user_location.usecase.GetLastLocationUseCase
import com.apnamart.apnarider.domain.user_location.usecase.RemoveGeofenceUseCase
import com.apnamart.apnarider.domain.user_location.usecase.ValidateRiderAtStoreUseCase
import javax.inject.Inject


class UserLocationHelperImpl @Inject
constructor(dataHelper: DataHelper, dispatcherProvider: DispatcherProvider) :
    BaseHelperImplNew(dataHelper, dispatcherProvider), UserLocationHelper {
    override val addGeofenceUseCase: AddGeofenceUseCase
        get() = AddGeofenceUseCase(dataHelper, dispatcherProvider)
    override val checkLocationUseCase: CheckLocationUseCase
        get() = CheckLocationUseCase(dataHelper, dispatcherProvider)
    override val removeGeofenceUseCase: RemoveGeofenceUseCase
        get() = RemoveGeofenceUseCase(dataHelper, dispatcherProvider)
    override val validateRiderAtStoreUseCase: ValidateRiderAtStoreUseCase
        get() = ValidateRiderAtStoreUseCase(dataHelper, dispatcherProvider)
    override val getLastLocationUseCase: GetLastLocationUseCase
        get() = GetLastLocationUseCase(dataHelper)
}