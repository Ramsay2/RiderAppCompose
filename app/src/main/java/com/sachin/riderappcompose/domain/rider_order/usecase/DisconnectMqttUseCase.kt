package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.CompletableVoidUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.sachin.riderappcompose.core_app_framework.interactor.State


class DisconnectMqttUseCase(
    private val dataHelperTez: DataHelper,
    private val dispatcherProvider: DispatcherProvider
): CompletableVoidUseCase<Unit>(dispatcherProvider) {

    override suspend fun execute(): State<Unit> {
        return State.success(dataHelperTez.mqttHelper.disconnect())
    }
}