package com.apnamart.apnastore.presentation_di.ioc.module

import androidx.work.WorkerFactory
import com.apnamart.apnarider.core_app_framework.ioc.scope.ApplicationScope
import com.apnamart.apnastore.presentation_di.ioc.factory.WorkerProviderFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class WorkManagerModule {

    @Provides
    
    fun bindsWorkerFactory(factory: WorkerProviderFactory): WorkerFactory {
        return factory
    }

}