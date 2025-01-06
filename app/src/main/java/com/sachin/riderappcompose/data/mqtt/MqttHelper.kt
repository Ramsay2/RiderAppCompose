package com.apnamart.apnarider.data.mqtt

import com.apnamart.apnarider.core_app_framework.serializer.ObjectSerializer
import com.apnamart.apnarider.data.mqtt.entity.SubscribeMessage
import kotlinx.coroutines.flow.Flow
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended

interface MqttHelper {
    val serializer: ObjectSerializer
    fun connect()
    fun disconnect()
    fun subscribe(topic: String, qos: Int): Flow<SubscribeMessage>
    fun unsubscribe(topic: List<String>)
    fun publish(topic: String, message: String, qos: Int)
    fun setCallback(callback: MqttCallbackExtended)
    fun connectAndSubscribe(topic: String, qos: Int): Flow<SubscribeMessage>
}