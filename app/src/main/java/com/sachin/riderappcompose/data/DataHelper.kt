package com.apnamart.apnarider.data

import com.sachin.riderappcompose.data.cache.CacheHelper
import com.sachin.riderappcompose.data.cache.entities.UserCacheData
import com.apnamart.apnarider.data.database.DatabaseHelper
import com.apnamart.apnarider.data.files.FileHelper
//import com.apnamart.apnarider.data.geofencing.GeofencingHelper
import com.apnamart.apnarider.data.http.ApiHelper
import com.apnamart.apnarider.data.location.LocationHelper
import com.apnamart.apnarider.data.mqtt.MqttHelper
//import com.apnamart.apnarider.data.remote_config.RemoteConfigHelper

interface DataHelper {
    // Shared Preferences Helper
    val cacheHelper: CacheHelper
    // Database Helper
    val databaseHelper: DatabaseHelper
    // File Helper
    val fileHelper: FileHelper
    // Network calls
    val apiHelper: ApiHelper

    val mqttHelper: MqttHelper

    // Location services
    val locationHelper: LocationHelper

//    val remoteConfigHelper: RemoteConfigHelper

//    val geofencingHelper : GeofencingHelper
    // Clear user data
    fun clearUserData()
    suspend fun updateUserData(user: UserCacheData, token: String?)
}