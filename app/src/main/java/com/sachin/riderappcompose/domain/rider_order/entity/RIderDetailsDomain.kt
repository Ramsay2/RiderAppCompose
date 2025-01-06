package com.apnamart.apnarider.domain.rider_order.entity
data class RiderDetailsDomain(
    val riderData: RiderDataDomain?,
    val storeData: StoreDataDomain?,
    val isStoreAllocated: Boolean
)

data class StoreDataDomain(
    val pendingOrderCount: Int ,
    val storeLatitude: Double ,
    val storeLongitude: Double 
)

data class RiderDataDomain(
    val deliveryRadius: Double ,
    val markInRadius: Double ,
    val markedIn: Boolean ,
    val pickUpRadius: Double ,
    val reachedStore: Boolean ,
    val status: String ,
    val username: String ,
    val workingHours: Int 
)