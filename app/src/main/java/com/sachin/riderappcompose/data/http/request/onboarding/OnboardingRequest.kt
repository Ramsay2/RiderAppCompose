package com.apnamart.apnarider.data.http.request.onboarding

import com.google.gson.annotations.SerializedName

data class OnboardingRequest(
    @SerializedName("trxn_id") val transactionId: String? = null,
    @SerializedName("vehicle_type") val vehicleType: String? = null,
    @SerializedName("pref_city_code") val cityCode: String? = null,
    @SerializedName("terms_accepted") val termsAndConditionsAccepted: Boolean? = null,
)