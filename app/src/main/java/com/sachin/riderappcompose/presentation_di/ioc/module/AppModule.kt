package com.apnamart.apnastore.presentation_di.ioc.module

import android.app.Application
import android.content.Context
import androidx.work.WorkManager
import com.apnamart.apnarider.core_app_framework.ioc.scope.ApplicationScope
import com.apnamart.apnarider.data.DataModule
import com.sachin.riderappcompose.domain.DomainModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module(
    includes = [
        DataModule::class,
        DomainModule::class,
        WorkManagerModule::class
    ]
)
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun contributeContext(application: Application): Context {
        return application
    }

    @Provides
    fun contributeWorkManager(application: Application): WorkManager {
        return WorkManager.getInstance(application)
    }

}
