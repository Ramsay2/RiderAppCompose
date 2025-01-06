package com.apnamart.apnarider.domain.rider_order.entity.store_details

data class GetCurrentStoreDetailsDomain(
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
