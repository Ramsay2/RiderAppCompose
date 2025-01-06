package com.sachin.riderappcompose.data.cache.entities

data class CurrentStoreCache(
    val storeId : Int,
    val name : String,
    val address : String,
    val riderAutoAssignment : Boolean,
    val latitude : Double,
    val longitude : Double,
    val radius: Float,
    val markOutThreshold: Float,
    val geofenceMarkOutEnabled: Boolean
)
