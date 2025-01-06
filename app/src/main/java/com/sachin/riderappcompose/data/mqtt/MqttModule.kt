package com.apnamart.apnarider.data.mqtt

import com.apnamart.apnarider.core_app_framework.ioc.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.eclipse.paho.client.mqttv3.MqttAsyncClient
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence

@Module
@InstallIn(SingletonComponent::class)
class MqttModule {

    @Provides
    fun contributeMqttHelper(mqttHelperImpl: MqttHelperImpl): MqttHelper {
        return mqttHelperImpl
    }

    @Provides
    fun contributeMqttConnectOptions(): MqttConnectOptions {
        val mqttConnectOptions = MqttConnectOptions()
        mqttConnectOptions.connectionTimeout = CONNECTION_TIMEOUT
        mqttConnectOptions.isAutomaticReconnect = IS_AUTOMATIC_RECONNECT
        mqttConnectOptions.keepAliveInterval = KEEP_ALIVE_INTERVAL
        mqttConnectOptions.isCleanSession = IS_CLEAN_SESSION
        mqttConnectOptions.maxInflight = MAX_IN_FLIGHT
        mqttConnectOptions.mqttVersion = MqttConnectOptions.MQTT_VERSION_3_1_1
        mqttConnectOptions.userName = BROKER_USERNAME
        mqttConnectOptions.password = BROKER_PASSWORD.toCharArray()
        return mqttConnectOptions
    }

    @Provides
    fun contributeMqttClient(): MqttAsyncClient {
        return MqttAsyncClient(
            BROKER_URI, MqttAsyncClient.generateClientId(), MemoryPersistence()
        )
    }

}