package com.apnamart.apnarider.data.remote_config

import android.app.Application
import com.apnamart.apnarider.core_app_framework.ioc.scope.ApplicationScope
import com.apnamart.apnarider.core_app_framework.logger.AppLogger
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
//
//@Module
//@InstallIn(SingletonComponent::class)
//class RemoteConfigModule {
//
//    @Provides
//    fun contribute(clientDataHelper: RemoteConfigHelperImpl): RemoteConfigHelper {
//        return clientDataHelper
//    }
//
//    @Provides
//    internal fun contributeFireBaseConfig(application: Application): FirebaseRemoteConfig {
//        return FirebaseRemoteConfig.getInstance()
//    }
//
//    @Provides
//    internal fun contributeConfigSettingsClient(application: Application): FirebaseRemoteConfigSettings {
//        val duration  = 3600L
//        AppLogger.info(duration.toString())
//        return FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(duration).build()
//    }
//
//}