package com.apnamart.apnarider.data.remote_config

import android.net.Uri
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import javax.inject.Inject
//
//class RemoteConfigHelperImpl @Inject constructor(
//    override val firebaseRemoteConfig: FirebaseRemoteConfig,
//    override val firebaseRemoteConfigSettings: FirebaseRemoteConfigSettings): RemoteConfigHelper {
//
//    init {
//        firebaseRemoteConfig.setConfigSettingsAsync(firebaseRemoteConfigSettings)
////        firebaseRemoteConfig.setDefaultsAsync(R.xml.remote_config_defaults).addOnCompleteListener {
////            defaultsLoaded = true
////        }
//        firebaseRemoteConfig.fetchAndActivate()
//    }
//
//    override var defaultsLoaded: Boolean = false
//
//    override fun refresh() {
//        firebaseRemoteConfig.fetchAndActivate()
//    }
//
//    override fun getLong(key: String): Long {
//        return firebaseRemoteConfig.getLong(key)
//    }
//
//    override fun getString(key: String): String {
//        return firebaseRemoteConfig.getString(key)
//    }
//
//    override fun getDouble(key: String): Double {
//        return firebaseRemoteConfig.getDouble(key)
//    }
//
//    override fun getBoolean(key: String): Boolean {
//        return firebaseRemoteConfig.getBoolean(key)
//    }
//
//    override fun getUri(key: String): Uri {
//        return Uri.parse(firebaseRemoteConfig.getString(key))
//    }
//
//
//}