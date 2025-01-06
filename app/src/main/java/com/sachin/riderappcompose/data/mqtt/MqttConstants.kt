package com.apnamart.apnarider.data.mqtt

//import com.apnamart.apnarider.BuildConfig


const val BROKER_USERNAME = "BuildConfig.MQTT_USERNAME"
const val BROKER_PASSWORD = "BuildConfig.MQTT_PASSWORD"
const val CONNECTION_TIMEOUT = 30
const val IS_AUTOMATIC_RECONNECT = true
const val KEEP_ALIVE_INTERVAL = 60
const val IS_CLEAN_SESSION = true
const val MAX_IN_FLIGHT = 30
const val env = "BuildConfig.MQTT_ENV"

const val BROKER_URI = "ssl://mqtt-devuat.apnamart.in:8883"

const val ORDER_DETAILS_SUB = "pub/$env/store/%d/order/online/pending_dispatch"
