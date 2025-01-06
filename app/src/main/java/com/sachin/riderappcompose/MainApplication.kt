package com.sachin.riderappcompose

import android.app.Application
import com.apnamart.apnarider.core_app_framework.logger.AppLogger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppLogger.initialize(this)
        AppLogger.enableLogcat(true)
        AppLogger.enableFileLogging(true)
    }
}