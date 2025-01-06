package com.apnamart.apnarider.core_app_framework.logger.event.interfaces

interface Provider {
    val providerName : ProviderName
    val trackAllEvents : Boolean
    fun trackEvent(eventName: String, eventData: HashMap<String, Any>)

    fun recordError(error: Throwable) {

    }

    fun onUserLogin(propertyData: HashMap<String, Any>) {}


    fun setUserId(userId: String) {}
    fun setUserProperty(userProperty: String, propertyData: String) {}
    fun setUserProperties(properties: HashMap<String, Any>) {}
    fun setDefaultEventParam(userProperty: String, propertyData: String) {}
    fun setDefaultEventParams(properties: HashMap<String, Any>) {}
    fun setNotificationId(fcmToken: String) {}
    fun onUserLogOut(){}

    enum class ProviderName{
         MIXPANEL,FIREBASE
    }
}