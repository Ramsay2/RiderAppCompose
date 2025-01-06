package com.apnamart.apnarider.domain.onboarding.entity


data class RiderKycDetailsDomain(
    val kycStatus : Int,
    val kycVerificationNeeded : Boolean,
    val termsAndConditionsAccepted : Boolean,
)