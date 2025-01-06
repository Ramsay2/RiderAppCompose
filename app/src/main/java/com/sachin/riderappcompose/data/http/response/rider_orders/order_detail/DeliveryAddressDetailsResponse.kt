package com.apnamart.apnarider.data.http.response.rider_orders.order_detail

import com.google.gson.annotations.SerializedName


data class DeliveryAddressDetailsResponse(

    @SerializedName("address_name") val addressName: String? = null,
    @SerializedName("state") val state: String? = null,
    @SerializedName("city") val city: String? = null,
    @SerializedName("phone") val phone: String? = null,
    @SerializedName("pin_code") val pinCode: String? = null,
    @SerializedName("latitude") val latitude: String? = null,
    @SerializedName("longitude") val longitude: String? = null,
    @SerializedName("landmark") val landmark: String? = null,
    @SerializedName("user_address") val userAddress: String? = null,
    @SerializedName("full_address") val fullAddress: String? = null,
    @SerializedName("other_address_details") val otherAddressDetails: String? = null,
    @SerializedName("contact_person") val contactPerson: String? = null,
    @SerializedName("country") val country: String? = null,
    @SerializedName("country_code") val countryCode: String? = null

)