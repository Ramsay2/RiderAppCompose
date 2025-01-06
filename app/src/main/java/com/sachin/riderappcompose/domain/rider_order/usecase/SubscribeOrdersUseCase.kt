package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.mqtt.ORDER_DETAILS_SUB
import com.apnamart.apnarider.data.mqtt.response.PendingOrderResponse
import com.apnamart.apnarider.domain.rider_order.entity.mqtt.PendingOrderDomain
import com.apnamart.apnarider.domain.rider_order.mapper.toPendingOrderDomain
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SubscribeOrdersUseCase(
    private val dataHelperTez: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) {

    fun execute(input: Int): Flow<Pair<String, List<PendingOrderDomain>>> {
        val type = object : TypeToken<List<PendingOrderResponse>>() {}.type
        val topic = String.format(ORDER_DETAILS_SUB, input)
        return dataHelperTez.mqttHelper.connectAndSubscribe(
            topic, 1).map {
            dataHelperTez.mqttHelper.serializer.deserializeCollection<PendingOrderResponse>(
                String(it.payload), type).map { ord -> ord.toPendingOrderDomain() }
        }.map { Pair(topic, it) }
    }
}