package com.apnamart.apnarider.data.http.response.rider_orders


import com.google.gson.annotations.SerializedName

data class RiderDetailsResponse(
    @SerializedName("data")
    val data: DataResponse? = null,
    @SerializedName("message")
    val message: String? = null
)

data class DataResponse(
    @SerializedName("rider_data")
    val riderData: RiderDataResponse ? = null,
    @SerializedName("store_data")
    val storeData: StoreDataResponse? = null,
    @SerializedName("is_store_allocated")
    val isStoreAllocated: Boolean? = false,
)

data class StoreDataResponse(
    @SerializedName("pending_order_count")
    val pendingOrderCount: Int ? = null,
    @SerializedName("store_latitude")
    val storeLatitude: String ? = null,
    @SerializedName("store_longitude")
    val storeLongitude: String ? = null
)

data class RiderDataResponse(
    @SerializedName("delivery_radius")
    val deliveryRadius: Double ? = null,
    @SerializedName("mark_in_radius")
    val markInRadius: Double ? = null,
    @SerializedName("marked_in")
    val markedIn: Boolean ? = null,
    @SerializedName("pick_up_radius")
    val pickUpRadius: Double ? = null,
    @SerializedName("reached_store")
    val reachedStore: Boolean ? = null,
    @SerializedName("status")
    val status: String ? = null,
    @SerializedName("username")
    val username: String ? = null,
    @SerializedName("working_hours")
    val workingHours: Int ? = null
)