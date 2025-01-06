package com.apnamart.apnarider.data.database

import android.content.Context
import androidx.room.Room
import com.apnamart.apnarider.core_app_framework.ioc.qualifier.DatabaseInfo
import com.apnamart.apnarider.core_app_framework.ioc.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @DatabaseInfo("NAME")
    fun contributeDatabaseName(): String {
        return "app_database"
    }

    @Provides
    @DatabaseInfo("PASSWORD")
    fun contributeDatabaseKey(): String {
        return "app_password"
    }

    @Provides
    fun contributeAppDatabase(
            @DatabaseInfo("NAME") dbName: String,
            context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName)
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    fun contributeDatabaseHelper(databaseHelper: DatabaseHelperImpl): DatabaseHelper {
        return databaseHelper
    }
}