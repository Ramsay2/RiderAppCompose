package com.apnamart.apnarider.data.mqtt.entity

import org.eclipse.paho.client.mqttv3.MqttMessage
import java.util.Date

class SubscribeMessage(val topic: String?, val message: MqttMessage?) : MqttMessage() {

    init {
        message?.let {
            this.id = message.id
            this.isDuplicate = message.isDuplicate
            this.isRetained = message.isRetained
            this.payload = message.payload
            this.qos = message.qos
            this.setMutable(true)
        }
    }

    val timestamp: Date = Date()
}