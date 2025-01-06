package com.apnamart.apnarider.core_app_framework.multithread

import com.apnamart.apnarider.core_app_framework.ioc.scope.ApplicationScope
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MultiThreadModule {

    
    @Provides
    internal fun contributeDispatcherProvider(dispatcherProvider: DispatcherProviderImpl): DispatcherProvider {
        return dispatcherProvider
    }
}
