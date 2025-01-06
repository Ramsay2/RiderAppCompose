package com.apnamart.apnarider.data

//import com.apnamart.apnarider.ApnaRider
import com.apnamart.apnarider.core_app_framework.ioc.scope.ApplicationScope
import com.apnamart.apnarider.core_app_framework.logger.event.LoggingConstants
import com.sachin.riderappcompose.data.cache.CacheHelper
import com.sachin.riderappcompose.data.cache.entities.LoginMode
import com.sachin.riderappcompose.data.cache.entities.UserCacheData
import com.apnamart.apnarider.data.database.DatabaseHelper
import com.apnamart.apnarider.data.files.FileHelper
//import com.apnamart.apnarider.data.geofencing.GeofencingHelper
import com.apnamart.apnarider.data.http.ApiHelper
import com.apnamart.apnarider.data.location.LocationHelper
import com.apnamart.apnarider.data.mqtt.MqttHelper
import javax.inject.Inject
//import com.apnamart.apnarider.data.remote_config.RemoteConfigHelper


internal class DataHelperImpl @Inject
constructor(
    override val cacheHelper: CacheHelper,
    override val fileHelper: FileHelper,
    override val apiHelper: ApiHelper,
    override val locationHelper: LocationHelper,
    override val databaseHelper: DatabaseHelper,
//    override val remoteConfigHelper: RemoteConfigHelper,
    override val mqttHelper: MqttHelper,
//    override val geofencingHelper: GeofencingHelper
) : DataHelper {

    override fun clearUserData() {
        cacheHelper.userId = -1
        cacheHelper.loggedInUser = null
        cacheHelper.userToken = null
        cacheHelper.loginMode = LoginMode.LOGGED_OUT.value
        cacheHelper.fcmToken = null
        cacheHelper.onboardingDetails = null
    }

    override suspend fun updateUserData(user: UserCacheData, token: String?) {
        cacheHelper.loggedInUser = user
        cacheHelper.userId = user.userId
        if (!token.isNullOrBlank()) {
            cacheHelper.userToken = token
        }
   /*     ApnaRider.eventHub.setUserId(user.userId.toString())
        ApnaRider.eventHub.setUserProperty(LoggingConstants.PHONE, user.phone.toString())
        ApnaRider.eventHub.setUserProperty(LoggingConstants.EMAIL, user.email.toString())
        ApnaRider.eventHub.setDefaultEventParam(
            LoggingConstants.PHONE, user.phone.toString()
        )*/

    }


}