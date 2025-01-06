package com.apnamart.apnarider.data.http.response.rider_orders.order_detail

import com.google.gson.annotations.SerializedName

data class PickupAddressDetailsResponse(

    @SerializedName("store_id") val storeId: Int? = null,
    @SerializedName("store_name") val storeName: String? = null,
    @SerializedName("store_tag") val storeTag: String? = null,
    @SerializedName("latitude") val latitude: String? = null,
    @SerializedName("longitude") val longitude: String? = null,
    @SerializedName("address") val address: String? = null,
    @SerializedName("city") val city: String? = null,
    @SerializedName("pin_code") val pinCode: String? = null

)