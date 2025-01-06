package com.apnamart.apnarider.domain.rider_order.usecase


import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper

class UnsubscribeOrdersUseCase(
    private val dataHelperTez: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) {

    fun execute(input: List<String>) {
        dataHelperTez.mqttHelper.connect()
        dataHelperTez.mqttHelper.unsubscribe(input)
    }
}