package com.apnamart.apnarider.domain.user_location.usecase

import android.app.PendingIntent
import com.apnamart.apnarider.core_app_framework.interactor.usecase.CompletableUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.sachin.riderappcompose.core_app_framework.interactor.State

class RemoveGeofenceUseCase(
    private val dataHelperTez: DataHelper,
    private val dispatcherProvider: DispatcherProvider
): CompletableUseCase<PendingIntent, Unit>(dispatcherProvider) {

    override suspend fun execute(input: PendingIntent): State<Unit> {
        return State.success(Unit)
    }
}