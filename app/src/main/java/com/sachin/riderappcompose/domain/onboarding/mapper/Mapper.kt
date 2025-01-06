package com.apnamart.apnarider.domain.onboarding.mapper

import com.apnamart.apnarider.data.http.response.onboarding.CityResponse
import com.apnamart.apnarider.data.http.response.onboarding.RiderKycDetailsResponse
import com.apnamart.apnarider.domain.onboarding.entity.CityDomain
import com.apnamart.apnarider.domain.onboarding.entity.CityEntity
import com.apnamart.apnarider.domain.onboarding.entity.RiderKycDetailsDomain
import com.sachin.riderappcompose.data.cache.entities.KycStatus

fun CityResponse.toCityDomain(): CityDomain {
    return CityDomain(
        id, name, code
    )
}

fun CityDomain.toCityEntity(): CityEntity {
    return CityEntity(
        id, name, code, false
    )
}

fun RiderKycDetailsResponse.toRiderKycDetailsDomain(): RiderKycDetailsDomain {
    return RiderKycDetailsDomain(
        kycStatus = kycStatus ?: KycStatus.PENDING,
        kycVerificationNeeded = kycVerificationNeeded ?: true,
        termsAndConditionsAccepted = termsAndConditionsAccepted ?: false
    )
}