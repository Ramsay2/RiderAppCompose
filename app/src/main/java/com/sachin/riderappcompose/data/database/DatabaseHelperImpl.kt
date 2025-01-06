package com.apnamart.apnarider.data.database

import com.apnamart.apnarider.core_app_framework.ioc.scope.ApplicationScope
import javax.inject.Inject



class DatabaseHelperImpl @Inject constructor(private val appDatabase: AppDatabase) : DatabaseHelper