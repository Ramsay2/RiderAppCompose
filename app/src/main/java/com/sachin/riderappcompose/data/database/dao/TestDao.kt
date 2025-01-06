package com.apnamart.apnarider.data.database.dao

import androidx.room.Dao
import com.apnamart.apnarider.core_app_framework.storage.database.BaseDao
import com.apnamart.apnarider.data.database.entity.TestEntity

@Dao
interface TestDao : BaseDao<TestEntity>