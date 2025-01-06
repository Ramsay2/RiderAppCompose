package com.apnamart.apnarider.core_app_framework.serializer

import com.apnamart.apnarider.core_app_framework.utility.datetime.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Json ObjectSerializer/Deserializer.
 */
@Singleton
class ObjectSerializer @Inject
internal constructor() {

    val gson = GsonBuilder().setDateFormat(DATE_FORMAT_YYYY_MM_DD_HH_MM_SS).create()
    /**
     * Serialize an object to Json.
     * @param any to serialize.
     */
    fun serialize(any: Any, clazz: Class<*>): String {
        return gson.toJson(any, clazz)
    }

    /**
     * Deserialize a json representation of an object.
     * @param string A json string to deserialize.
     */
    fun <T> deserialize(string: String, clazz: Class<T>): T? {
        try {
            return gson.fromJson(string, clazz)
        } catch (err: Exception) {
            return null
        }
    }

    fun <T> deserialize(string: String, type: Type): T {
        return gson.fromJson(string, type)
    }

    /**
     * Serialize a collection of object to Json.
     */
    fun <T> serializeCollection(list: List<T>): String {
        val type = object : TypeToken<List<T>>() {}.type
        return gson.toJson(list, type)
    }

    fun <T> serializeCollection(list: List<T>, type: Type): String {
        return gson.toJson(list, type)
    }

    /**
     * Deserialize a json representation of an object collection.
     */
    fun <T> deserializeCollection(data: String, clazz: Class<T>): List<T> {
        val type = object : TypeToken<List<T>>() {}.type
        return gson.fromJson<List<T>>(data, type).toList()
    }

    fun <T> deserializeCollection(data: String, type: Type): List<T> {
        if (data.isEmpty()) {
            return listOf()
        }
        return gson.fromJson(data, type)
    }
}



