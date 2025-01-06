package com.apnamart.apnarider.data.mqtt

//import com.apnamart.apnarider.ApnaRider
import com.apnamart.apnarider.core_app_framework.ioc.scope.ApplicationScope
import com.apnamart.apnarider.core_app_framework.logger.AppLogger
import com.apnamart.apnarider.core_app_framework.logger.event.EventKey
import com.apnamart.apnarider.core_app_framework.logger.event.EventName
import com.apnamart.apnarider.core_app_framework.serializer.ObjectSerializer
import com.apnamart.apnarider.core_app_framework.utility.datetime.getCurrentTimeStamp
import com.apnamart.apnarider.data.mqtt.entity.SubscribeMessage
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import org.eclipse.paho.client.mqttv3.IMqttActionListener
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.IMqttToken
import org.eclipse.paho.client.mqttv3.MqttAsyncClient
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttException
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.eclipse.paho.client.mqttv3.internal.ClientComms
import java.lang.reflect.Field
import javax.inject.Inject


class MqttHelperImpl @Inject
constructor(
    private val mqttClient: MqttAsyncClient,
    private val mqttConnectOptions: MqttConnectOptions,
    override val serializer: ObjectSerializer
) : MqttHelper {

    override fun connect() {
        if (mqttClient.isConnected || isMqttClientConnecting(mqttClient)) {
            return
        }
        try {
            mqttClient.connect(mqttConnectOptions, null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken) {
                   /* ApnaRider.eventHub.trackEvent(
                        EventName.MQTT_CONNECTED,
                        hashMapOf(
                            EventKey.CONNECTION_STATUS to "Connected",
                            EventKey.TIME_STAMP to getCurrentTimeStamp()
                        )
                    )*/
                    AppLogger.debug("Connected successfully")
                }

                override fun onFailure(asyncActionToken: IMqttToken, exception: Throwable) {
                 /*   ApnaRider.eventHub.trackEvent(
                        EventName.MQTT_CONNECTION_FAILED,
                        hashMapOf(
                            EventKey.CONNECTION_STATUS to "Connection Failed",
                            EventKey.TIME_STAMP to getCurrentTimeStamp(),
                            EventKey.ERROR_MESSAGE to (exception.toString())
                        )
                    )
                    ApnaRider.eventHub.recordError(exception)*/
                    AppLogger.debug("Connection failed")
                }
            }).waitForCompletion()
        } catch (e: MqttException) {
           /* ApnaRider.eventHub.trackEvent(
                EventName.MQTT_CONNECTION_FAILED,
                hashMapOf(
                    EventKey.CONNECTION_STATUS to "Connect Exception",
                    EventKey.TIME_STAMP to getCurrentTimeStamp(),
                    EventKey.ERROR_MESSAGE to (e.toString())
                )
            )
            ApnaRider.eventHub.recordError(e)*/
            AppLogger.error(e, "Connect Exception")
        }
    }

    override fun subscribe(topic: String, qos: Int): Flow<SubscribeMessage> = callbackFlow {
        startSubscription(topic, qos)

        awaitClose {
            try {
                mqttClient.unsubscribe(topic)
            } catch (e: MqttException) {
                AppLogger.error(e, "Close Exception")
            }
        }
    }

    override fun connectAndSubscribe(topic: String, qos: Int): Flow<SubscribeMessage> =
        callbackFlow {
            mqttClient.setCallback(object : MqttCallbackExtended {
                override fun connectionLost(cause: Throwable) {
                  /*  ApnaRider.eventHub.trackEvent(
                        EventName.MQTT_CONNECTION_FAILED,
                        hashMapOf(
                            EventKey.CONNECTION_STATUS to "Connection Lost",
                            EventKey.TIME_STAMP to getCurrentTimeStamp(),
                            EventKey.ERROR_MESSAGE to (cause.toString())
                        )
                    )
                    ApnaRider.eventHub.recordError(cause)*/
                    AppLogger.error("Connection lost")
                }

                override fun messageArrived(topic: String, message: MqttMessage) {
                    AppLogger.debug("Message received from $topic")
                    trySend(SubscribeMessage(topic, message))
                }

                override fun deliveryComplete(token: IMqttDeliveryToken) {
                    // Handle delivery complete
                }

                override fun connectComplete(reconnect: Boolean, serverURI: String?) {
                    startSubscription(topic, qos)
                }
            })
            connect()

            awaitClose {
                try {
                    mqttClient.unsubscribe(topic)
                } catch (e: MqttException) {
//                    ApnaRider.eventHub.recordError(e)
                    AppLogger.error(e, "Close Exception")
                }
            }
        }

    private fun startSubscription(topic: String, qos: Int) {
        try {
            mqttClient.subscribe(topic, qos, null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken) {
                    asyncActionToken.topics.forEach {
                      /*  ApnaRider.eventHub.trackEvent(
                            EventName.MQTT_SUBSCRIBED,
                            hashMapOf(
                                EventKey.TOPIC to it,
                                EventKey.TIME_STAMP to getCurrentTimeStamp()
                            )
                        )*/
                        AppLogger.debug("Subscribed to $it")
                    }
                }

                override fun onFailure(asyncActionToken: IMqttToken, exception: Throwable) {
                   /* ApnaRider.eventHub.trackEvent(
                        EventName.MQTT_SUBSCRIPTION_FAILED,
                        hashMapOf(
                            EventKey.SUBSCRIPTION_STATUS to "Subscription Failed",
                            EventKey.ERROR_MESSAGE to (exception.toString()),
                            EventKey.TIME_STAMP to getCurrentTimeStamp()
                        )
                    )
                    ApnaRider.eventHub.recordError(exception)*/
                    AppLogger.error("Subscribe failure")
                }
            })
        } catch (e: MqttException) {
           /* ApnaRider.eventHub.trackEvent(
                EventName.MQTT_SUBSCRIPTION_FAILED,
                hashMapOf(
                    EventKey.SUBSCRIPTION_STATUS to "Subscription Exception",
                    EventKey.ERROR_MESSAGE to (e.toString()),
                    EventKey.TIME_STAMP to getCurrentTimeStamp()
                )
            )
            ApnaRider.eventHub.recordError(e)*/
            AppLogger.error(e, "Subscribe Exception")
        }
    }


    override fun disconnect() {
        if (mqttClient.isConnected) {
            mqttClient.disconnect().waitForCompletion()
        }
    }

    override fun unsubscribe(topic: List<String>) {
        try {
            if (mqttClient.isConnected) {
                mqttClient.unsubscribe(topic.toTypedArray()).waitForCompletion()
            }
        } catch (e: MqttException) {
//            ApnaRider.eventHub.recordError(e)
            AppLogger.error(e, "Unsubscribe Exception")
        }
    }

    override fun publish(topic: String, message: String, qos: Int) {
        try {
            val mqttMessage = MqttMessage().apply {
                payload = message.toByteArray()
                this.qos = qos
            }
            mqttClient.publish(topic, mqttMessage, null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken) {
                    // Handle successful publish
                }

                override fun onFailure(asyncActionToken: IMqttToken, exception: Throwable) {
                    // Handle publish failure
                }
            })
        } catch (e: MqttException) {
//            ApnaRider.eventHub.recordError(e)
            AppLogger.error(e, "Publish Exception")
        }
    }

    override fun setCallback(callback: MqttCallbackExtended) {
        mqttClient.setCallback(callback)
    }


}

fun isMqttClientConnecting(mqttClient: MqttAsyncClient): Boolean {
    try {
        // Access the 'comms' field using reflection
        val commsField: Field = mqttClient.javaClass.getDeclaredField("comms")
        commsField.isAccessible = true // Make the protected field accessible
        // Get the 'comms' object from the mqttClient
        val comms = commsField.get(mqttClient) as ClientComms
        // Call the 'isConnecting' method on the comms object
        return comms.isConnecting
    } catch (e: Exception) {
//        ApnaRider.eventHub.recordError(e)
        return false
    }
}