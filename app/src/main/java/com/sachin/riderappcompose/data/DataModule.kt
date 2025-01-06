package com.apnamart.apnarider.data

import com.apnamart.apnarider.data.cache.CacheModule
import com.apnamart.apnarider.data.database.DatabaseModule
import com.apnamart.apnarider.data.files.FileModule
import com.apnamart.apnarider.data.http.ApiModule
import com.apnamart.apnarider.data.location.LocationModule
import com.apnamart.apnarider.data.mqtt.MqttModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [
    CacheModule::class,
    FileModule::class,
    DatabaseModule::class,
    ApiModule::class,
    LocationModule::class,
    MqttModule::class,
//    RemoteConfigModule::class,
//    GeofencingModule::class,
//    NetworkChangeListenerServiceModule::class
])
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    internal fun contributeDataManager(dataManager: DataHelperImpl): DataHelper {
        return dataManager
    }
}