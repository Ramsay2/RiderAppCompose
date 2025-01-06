package com.apnamart.apnarider.data.http.response.onboarding

import com.google.gson.annotations.SerializedName

data class RiderKycResponse(
    @SerializedName("kyc_details")
    val kycDetails : RiderKycDetailsResponse?,
)

data class RiderKycDetailsResponse(
    @SerializedName("kyc_status")
    val kycStatus : Int?,
    @SerializedName("kyc_verification_needed")
    val kycVerificationNeeded : Boolean?,
    @SerializedName("terms_accepted")
    val termsAndConditionsAccepted : Boolean?,
)