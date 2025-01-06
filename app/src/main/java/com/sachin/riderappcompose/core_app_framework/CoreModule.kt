package com.apnamart.apnarider.core_app_framework

import com.apnamart.apnarider.core_app_framework.multithread.MultiThreadModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/***
 * Core App Framework requires following:
 * 0. Android X
 * 3. Android Lifecycle Components
 * 4. Gson
 * 5. Room
 * 6. Firebase Analytics
 * 7. Firebase Crashlytics
 * 8. Retrofit
 */
@InstallIn(SingletonComponent::class)
@Module(includes = [
    MultiThreadModule::class])
class CoreModule