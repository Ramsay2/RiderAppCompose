package com.sachin.riderappcompose.data.cache

import com.apnamart.apnarider.core_app_framework.serializer.ObjectSerializer
import com.apnamart.apnarider.core_app_framework.utility.datetime.getCurrentTimeLong
import com.apnamart.apnarider.data.cache.DELIVERY_RADIUS
import com.apnamart.apnarider.data.cache.DEVICE_ID
import com.apnamart.apnarider.data.cache.DEVICE_UNIQUE_ID
import com.apnamart.apnarider.data.cache.FCM_TOKEN
import com.apnamart.apnarider.data.cache.IS_OUT_FOR_DELIVERY
import com.apnamart.apnarider.data.cache.LOGGED_USER
import com.apnamart.apnarider.data.cache.LOGGED_USER_ID
import com.apnamart.apnarider.data.cache.LOGGED_USER_UPDATE_TIME
import com.apnamart.apnarider.data.cache.LOGIN_MODE
import com.apnamart.apnarider.data.cache.MARK_IN_RADIUS
import com.apnamart.apnarider.data.cache.ONBOARDING_DETAILS
import com.apnamart.apnarider.data.cache.ORDERS
import com.apnamart.apnarider.data.cache.PENDING_ORDERS
import com.apnamart.apnarider.data.cache.PICK_UP_RADIUS
import com.apnamart.apnarider.data.cache.SELECTED_STORE
import com.apnamart.apnarider.data.cache.USER_AGENT
import com.apnamart.apnarider.data.cache.USER_MARKED_IN
import com.apnamart.apnarider.data.cache.USER_TOKEN
import com.sachin.riderappcompose.data.cache.entities.CurrentStoreCache
import com.sachin.riderappcompose.data.cache.entities.OnboardingDetailsCache
import com.sachin.riderappcompose.data.cache.entities.PendingOrderCache
import com.sachin.riderappcompose.data.cache.entities.UserCacheData
import com.google.gson.reflect.TypeToken
import javax.inject.Inject


class CacheHelperImpl @Inject
constructor(private val preferences: com.apnamart.apnarider.core_app_framework.storage.cache.Preferences, private var serializer: ObjectSerializer) :
    CacheHelper {

    override var userAgent: String
        get() = preferences.getString(USER_AGENT, "") ?: ""
        set(value) {
            preferences.putString(USER_AGENT, value)
        }
    override var selectedStore: CurrentStoreCache?
        get() = serializer.deserialize(
            preferences.getString(SELECTED_STORE, "") ?: "", CurrentStoreCache::class.java
        )
        set(value) {
            if (value == null)
                preferences.putString(SELECTED_STORE, "")
            else
                preferences.putString(
                    SELECTED_STORE,
                    serializer.serialize(value, CurrentStoreCache::class.java)
                )

        }

    override var userToken: String?
        get() = preferences.getString(USER_TOKEN)
        set(value) {
            preferences.putString(USER_TOKEN, value ?: "")
        }

    override var loginMode: Int
        get() = preferences.getInt(LOGIN_MODE, -1)
        set(value) {
            preferences.putInt(LOGIN_MODE, value)
        }

    override var lastUserDataUpdateTime: Long
        get() = preferences.getLong(LOGGED_USER_UPDATE_TIME, 0L)
        set(value) {
            preferences.putLong(LOGGED_USER_UPDATE_TIME, value)
        }

    override var userId: Int
        get() = preferences.getInt(LOGGED_USER_ID, -1)
        set(value) {
            preferences.putInt(LOGGED_USER_ID, value)
        }

    override var deviceId: Int
        get() = preferences.getInt(DEVICE_ID, -1)
        set(value) {
            preferences.putInt(DEVICE_ID, value)
        }

    override var loggedInUser: UserCacheData?
        get() = serializer.deserialize(
            preferences.getString(LOGGED_USER, "") ?: "", UserCacheData::class.java
        )
        set(value) {
            lastUserDataUpdateTime = getCurrentTimeLong()
            if (value == null)
                preferences.putString(LOGGED_USER, "")
            else
                preferences.putString(
                    LOGGED_USER,
                    serializer.serialize(value, UserCacheData::class.java)
                )
        }

    override var userMarkedIn: Boolean
        get() = preferences.getBoolean(USER_MARKED_IN, false)
        set(value) {
            preferences.putBoolean(USER_MARKED_IN, value)
        }


    override var markInRadius: Double
        get() = preferences.getFloat(MARK_IN_RADIUS, 1000F).toDouble()
        set(value) {
            preferences.putFloat(MARK_IN_RADIUS, value.toFloat())
        }

    override var deliveryRadius: Double
        get() = preferences.getFloat(DELIVERY_RADIUS, 500F).toDouble()
        set(value) {
            preferences.putFloat(DELIVERY_RADIUS, value.toFloat())
        }

    override var pickupRadius: Double
        get() = preferences.getFloat(PICK_UP_RADIUS, 500F).toDouble()
        set(value) {
            preferences.putFloat(PICK_UP_RADIUS, value.toFloat())
        }
    override var pendingOrders: Int
        get() = preferences.getInt(PENDING_ORDERS, 0)
        set(value) {
            preferences.putInt(PENDING_ORDERS, value)
        }

    override var fcmToken: String?
        get() = preferences.getString(FCM_TOKEN)
        set(value) {
            preferences.putString(FCM_TOKEN, value ?: "")
        }

    override var deviceUniqueId: String?
        get() = preferences.getString(DEVICE_UNIQUE_ID)
        set(value) {
            preferences.putString(DEVICE_UNIQUE_ID, value ?: "")
        }

    override var pendingOrderList: List<PendingOrderCache>
        get() =
            serializer.deserializeCollection(
                (preferences.getString(ORDERS, "") ?: ""),
                (object : TypeToken<List<PendingOrderCache>>() {}.type)
            )
        set(value) {
            preferences.putString(
                ORDERS,
                serializer.serializeCollection(
                    value,
                    (object : TypeToken<List<PendingOrderCache>>() {}.type)
                )
            )
        }

    override var onboardingDetails: OnboardingDetailsCache?
        get() {
            val json = preferences.getString(ONBOARDING_DETAILS, "") ?: ""
            return if (json.isNotEmpty()) {
                serializer.deserialize(json, OnboardingDetailsCache::class.java)
                    ?: OnboardingDetailsCache()
            } else {
                OnboardingDetailsCache()
            }
        }
        set(value) {
            if (value == null)
                preferences.putString(ONBOARDING_DETAILS, "")
            else
                preferences.putString(
                    ONBOARDING_DETAILS,
                    serializer.serialize(value, OnboardingDetailsCache::class.java)
                )
        }

    override var isOutForDelivery: Boolean
        get() = preferences.getBoolean(IS_OUT_FOR_DELIVERY, false)
        set(value) {
            preferences.putBoolean(IS_OUT_FOR_DELIVERY, value)
        }
}
