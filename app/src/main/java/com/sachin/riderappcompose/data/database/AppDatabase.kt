package com.apnamart.apnarider.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.apnamart.apnarider.data.database.entity.TestEntity

@Database(
    entities = [TestEntity::class],
    version = 3, exportSchema = false
)
abstract class AppDatabase : RoomDatabase()