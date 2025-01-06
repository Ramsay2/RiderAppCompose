package com.apnamart.apnarider.core_app_framework.storage.cache

import android.annotation.TargetApi
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import com.apnamart.apnarider.core_app_framework.ioc.qualifier.CacheInfo
import com.apnamart.apnarider.core_app_framework.ioc.scope.ApplicationScope
import javax.inject.Inject


class Preferences {

    private val settings: SharedPreferences
    private var intDefaultVal = 0
    private var longDefaultVal: Long = 0L
    private var floatDefaultVal = 0f
    private var isBoolDefaultVal = false
    private var stringDefaultVal = ""
    private var stringSetDefaultVal: Set<String>? = null

    val all: Map<String, *>
        get() = settings.all

    @Inject
    constructor(context: Context, @CacheInfo("NAME") preferenceFileName: String) : this(
            context, preferenceFileName, Context.MODE_PRIVATE)

    private constructor(context: Context, preferenceFileName: String, mode: Int) {
        settings = context.getSharedPreferences(preferenceFileName, mode)
    }

    fun putInt(key: String, value: Int) {
        settings.edit().putInt(key, value).apply()
    }

    fun putString(key: String, value: String) {
        settings.edit().putString(key, value).apply()
    }

    fun putBoolean(key: String, value: Boolean) {
        settings.edit().putBoolean(key, value).apply()
    }

    fun putFloat(key: String, value: Float) {
        settings.edit().putFloat(key, value).apply()
    }

    fun putLong(key: String, value: Long) {
        settings.edit().putLong(key, value).apply()
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun putStringSet(key: String, value: Set<String>) {
        settings.edit().putStringSet(key, value).apply()
    }

    fun getInt(key: String, defaultValue: Int): Int {
        return settings.getInt(key, defaultValue)
    }

    fun getInt(key: String): Int {
        return settings.getInt(key, intDefaultVal)
    }

    fun getString(key: String, defaultValue: String): String? {
        return settings.getString(key, defaultValue)
    }

    fun getString(key: String): String? {
        return settings.getString(key, stringDefaultVal)
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return settings.getBoolean(key, defaultValue)
    }

    fun getBoolean(key: String): Boolean {
        return settings.getBoolean(key, isBoolDefaultVal)
    }

    fun getFloat(key: String, defaultValue: Float): Float {
        return settings.getFloat(key, defaultValue)
    }

    fun getFloat(key: String): Float {
        return settings.getFloat(key, floatDefaultVal)
    }

    fun getLong(key: String, defaultValue: Long): Long {
        return settings.getLong(key, defaultValue)
    }

    fun getLong(key: String): Long {
        return settings.getLong(key, longDefaultVal)
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun getStringSet(key: String, defaultValue: Set<String>): Set<String>? {
        return settings.getStringSet(key, defaultValue)
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun getStringSet(key: String): Set<String>? {
        return settings.getStringSet(key, stringSetDefaultVal)
    }

}