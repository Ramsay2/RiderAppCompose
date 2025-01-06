package com.apnamart.apnarider.core_app_framework.logger.event

import com.apnamart.apnarider.core_app_framework.logger.event.interfaces.Provider

class EventHub(
    private vararg var providers: Provider
) {

    /**
     * It sends events to [Provider]'s which track all the events
     */
    fun trackEvent(event: String, eventData: HashMap<String, Any>) {
        providers.forEach {
            if (it.trackAllEvents) {
                it.trackEvent(event, eventData)
                //AppLogger.debug("EventProvider_${it.providerName}\n EventName_$event --> EventData_${eventData.toString()}")

            }
        }
    }

    /**
     * it sends event to [Provider]'s which track all the events
     * and will also push to [additionalTracker]'s
     */
    fun trackEvent(
        event: String,
        eventData: HashMap<String, Any>,
        additionalTracker: List<Provider.ProviderName>
    ) {
        trackEvent(event, eventData)
        providers.forEach { it ->
            if (!it.trackAllEvents && additionalTracker.contains(it.providerName)) {
                it.trackEvent(event, eventData)
                //AppLogger.debug("EventProvider_${it.providerName}\n EventName_$event --> EventData_${eventData.toString()}")
            }
        }
    }

    fun recordError(error: Throwable) {
        providers.forEach { it.recordError(error) }
    }

    fun setUserId(userId: String) {
        providers.forEach { it.setUserId(userId) }
    }

    fun setUserProperty(userProperty: String, propertyData: String) {
        providers.forEach { it.setUserProperty(userProperty, propertyData) }
    }

    fun setUserProperties(properties: HashMap<String, Any>) {
        providers.forEach { it.setUserProperties(properties) }
    }

    fun setDefaultEventParam(userProperty: String, propertyData: String) {
        providers.forEach { it.setDefaultEventParam(userProperty, propertyData) }
    }

    fun setDefaultEventParams(properties: HashMap<String, Any>) {
        providers.forEach { it.setDefaultEventParams(properties) }
    }

    fun onUserLogin(properties: HashMap<String, Any>) {
        providers.forEach { it.onUserLogin(properties) }
    }

    fun setNotificationId(fcmToken: String) {
        providers.forEach { it.setNotificationId(fcmToken) }
    }

    fun onUserLogout(){
        providers.forEach {
            it.onUserLogOut()
        }
    }

}