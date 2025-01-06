package com.apnamart.apnarider.core_app_framework.logger.event.providers

import android.os.Bundle
import androidx.core.os.bundleOf
import com.apnamart.apnarider.core_app_framework.logger.event.interfaces.Provider
import com.apnamart.apnarider.core_app_framework.toBundle
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.crashlytics.ktx.setCustomKeys
import com.google.firebase.ktx.Firebase

class FirebaseProvider: Provider {

    override val providerName: Provider.ProviderName
        get() = Provider.ProviderName.FIREBASE

    override val trackAllEvents: Boolean
        get() = true

    private val firebaseAnalytics = Firebase.analytics.apply {
        setAnalyticsCollectionEnabled(true)
        setSessionTimeoutDuration(15 * 60 * 1000)
    }

    private val firebaseCrashlytics = Firebase.crashlytics.apply {
        setCrashlyticsCollectionEnabled(true)
    }

    override fun trackEvent(eventName: String, eventData: HashMap<String, Any>) {
        firebaseAnalytics.logEvent(eventName, eventData.toBundle())
    }

    override fun recordError(error: Throwable) {
        firebaseCrashlytics.recordException(error)
    }

    override fun setUserId(userId: String) {
        firebaseAnalytics.setUserId(userId)
        firebaseCrashlytics.setUserId(userId)
    }

    override fun setUserProperty(userProperty: String, propertyData: String) {
        firebaseAnalytics.setUserProperty(userProperty, propertyData)
        firebaseCrashlytics.setCustomKeys {
            key(userProperty, propertyData)
        }
    }

    override fun setUserProperties(properties: HashMap<String, Any>) {
        for (each in properties) {
            firebaseCrashlytics.setCustomKeys {
                if(each.value is Double)
                    key(each.key, each.value as Double)
                if(each.value is String)
                    key(each.key, each.value as String)
                if (each.value is Long)
                    key(each.key, each.value as Long)
                if (each.value is Int)
                    key(each.key, each.value as Int)
                if (each.value is Float)
                    key(each.key, each.value as Float)
                if (each.value is Boolean)
                    key(each.key, each.value as Boolean)

            }
            if(each.value is String)
                firebaseAnalytics.setUserProperty(each.key, each.value as String)
        }
    }

    override fun setDefaultEventParam(userProperty: String, propertyData: String) {
        firebaseAnalytics.setDefaultEventParameters(Bundle().apply {
            putString(userProperty, propertyData)
        })
    }

    override fun setDefaultEventParams(properties: HashMap<String, Any>) {
        val bundle = bundleOf(*properties.toList().toTypedArray())
        firebaseAnalytics.setDefaultEventParameters(bundle)
    }
}