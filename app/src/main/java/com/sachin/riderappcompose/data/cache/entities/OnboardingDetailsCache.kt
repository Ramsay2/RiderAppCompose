package com.sachin.riderappcompose.data.cache.entities

data class OnboardingDetailsCache(
    var storeAllocated : Boolean = false,
    var kycStatus: Int = KycStatus.PENDING,
    var kycVerificationNeeded: Boolean = false,
    var termsAndConditionsAccepted: Boolean = false
)

object KycStatus {
    const val PENDING = 0
    const val IN_REVIEW = 1
    const val APPROVED = 2
    const val REJECTED = 3
}