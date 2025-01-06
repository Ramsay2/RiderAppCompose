package com.apnamart.apnarider.core_app_framework.logger.event

/**
 *  AppUserProperty is related to User Logged in. Like favourite things of User, Other User Related Details
 *  OnlineStatus Inheritance to make this clear AppEventParams are like FirebaseAnalytics.UserProperty(). Same Keys Added forcefully.
 */
object LoggingConstants {

    const val SIGN_UP_METHOD = "sign_up_method"
    const val PHONE = "user_phone"
    const val EMAIL = "user_email"
    const val DEVICE_ID = "device_id"
}
