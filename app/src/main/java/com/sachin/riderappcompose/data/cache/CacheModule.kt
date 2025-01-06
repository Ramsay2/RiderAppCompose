package com.apnamart.apnarider.data.cache

import android.content.Context
import android.content.SharedPreferences
import com.apnamart.apnarider.core_app_framework.ioc.qualifier.CacheInfo
import com.sachin.riderappcompose.data.cache.CacheHelper
import com.sachin.riderappcompose.data.cache.CacheHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CacheModule {

    @Provides
    @CacheInfo("NAME")
    fun providePreferenceName(): String {
        return "app_preferences"
    }

    @Provides
    fun contributeSharedPreferences(context: Context, @CacheInfo("NAME") name: String): SharedPreferences {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    @Provides
    fun contributeCacheHelper(cacheHelper: CacheHelperImpl): CacheHelper {
        return cacheHelper
    }
}