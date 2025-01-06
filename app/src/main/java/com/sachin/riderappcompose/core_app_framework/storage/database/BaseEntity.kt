package com.apnamart.apnarider.core_app_framework.storage.database

import androidx.room.PrimaryKey
import java.util.Date


open class BaseEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
    var createdAt: Long = Date().time
    var updatedAt: Long = Date().time
}