package com.apnamart.apnarider.data.http.response.store_details

import com.google.gson.annotations.SerializedName

data class GetStoreDetailsResponse(

    @SerializedName("store_details")
    val currentStoreDetailsResponse: CurrentStoreDetailsResponse
)

data class CurrentStoreDetailsResponse(

    @SerializedName("store_id")
    val storeId : Int? = null,

    @SerializedName("name")
    val name : String? = null,

    @SerializedName("address")
    val address : String? = null,

    @SerializedName("rider_auto_assignment")
    val riderAutoAssignment : Boolean? = null,

    @SerializedName("latitude")
    val latitude : Double? = null,

    @SerializedName("longitude")
    val longitude : Double? = null,

    @SerializedName("rider_reach_store_radius")
    val radius: Float? = null,

    @SerializedName("mark_out_threshold")
    val markOutThreshold: Float? = null,

    @SerializedName("geofence_markout_enabled")
    val geofenceMarkOutEnabled: Boolean? = null

)
