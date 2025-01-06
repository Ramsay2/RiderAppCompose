package com.sachin.riderappcompose.data.cache

import com.sachin.riderappcompose.data.cache.entities.CurrentStoreCache
import com.sachin.riderappcompose.data.cache.entities.OnboardingDetailsCache
import com.sachin.riderappcompose.data.cache.entities.PendingOrderCache
import com.sachin.riderappcompose.data.cache.entities.UserCacheData

interface CacheHelper {

    // User Specific Data
    var userToken: String?
    var loginMode : Int
    var lastUserDataUpdateTime: Long
    var userId: Int
    var deviceId: Int
    var loggedInUser: UserCacheData?
    var userMarkedIn: Boolean

    var markInRadius: Double
    var deliveryRadius: Double
    var pickupRadius: Double
    var pendingOrders : Int
    var deviceUniqueId : String?

    // FCM Data
    var fcmToken: String?

    // API specific Data
    var userAgent: String

    var selectedStore: CurrentStoreCache?

    var pendingOrderList: List<PendingOrderCache>

    var onboardingDetails: OnboardingDetailsCache?

    var isOutForDelivery: Boolean
}
