package com.apnamart.apnarider.core_app_framework.components.application

import androidx.multidex.MultiDexApplication

import javax.inject.Inject

abstract class BaseApplication : MultiDexApplication() {



    override fun onCreate() {
        super.onCreate()
        initializeDependencyInjection()
        attachDataBindingComponent()
        setUpApplication()
    }


    abstract fun attachDataBindingComponent()

    abstract fun initializeDependencyInjection()

    abstract fun setUpApplication()
}