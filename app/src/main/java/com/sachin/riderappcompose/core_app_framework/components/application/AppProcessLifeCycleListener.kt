package com.apnamart.apnarider.core_app_framework.components.application

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.apnamart.apnarider.core_app_framework.logger.AppLogger

class AppProcessLifeCycleListener : DefaultLifecycleObserver {
    override fun onStop(owner: LifecycleOwner) {
        AppLogger.error("App is in background")
    }

    override fun onStart(owner: LifecycleOwner) {
        AppLogger.error("App is in foreground")
    }
}