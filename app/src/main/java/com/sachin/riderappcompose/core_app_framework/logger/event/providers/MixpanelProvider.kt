package com.apnamart.apnarider.core_app_framework.logger.event.providers

import android.content.Context

class MixpanelProvider(private val context: Context){}

 /*   : Provider {

    override val providerName: Provider.ProviderName
        get() = Provider.ProviderName.MIXPANEL

    override val trackAllEvents: Boolean
        get() = true

    private val mixpanelAPI: MixpanelAPI = MixpanelAPI.getInstance(context, context.getString(R.string.mixpanel_project_id), true)

    override fun trackEvent(eventName: String, eventData: HashMap<String, Any>) {
        mixpanelAPI.trackMap(eventName, eventData)
    }

    override fun setUserId(userId: String) {
        mixpanelAPI.identify(userId)
    }

    override fun setUserProperty(userProperty: String, propertyData: String) {
        val hashmap = HashMap<String, Any>()
        hashmap[userProperty] = propertyData
        mixpanelAPI.people.setMap(hashmap)
    }

    override fun setUserProperties(properties: HashMap<String, Any>) {
        mixpanelAPI.people.setMap(properties)
    }

    override fun setDefaultEventParam(userProperty: String, propertyData: String) {
        val hashmap = HashMap<String, Any>()
        hashmap[userProperty] = propertyData
        mixpanelAPI.registerSuperPropertiesMap(hashmap)
    }

    override fun setDefaultEventParams(properties: HashMap<String, Any>) {
        mixpanelAPI.registerSuperPropertiesOnceMap(properties)
    }

    override fun onUserLogin(propertyData: HashMap<String, Any>) {
        mixpanelAPI.people.setMap(propertyData)
    }

    override fun onUserLogOut() {
        mixpanelAPI.reset()
    }
}*/