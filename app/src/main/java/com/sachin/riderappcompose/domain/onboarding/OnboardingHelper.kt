package com.apnamart.apnarider.domain.onboarding

import com.apnamart.apnarider.domain.onboarding.usecase.CreateUpdateOnboardingDataUseCase
import com.apnamart.apnarider.domain.onboarding.usecase.GetCitiesUseCase
import com.apnamart.apnarider.domain.onboarding.usecase.GetKycDetailsUseCase

interface OnboardingHelper {
    val getCitiesUseCase: GetCitiesUseCase
    val createUpdateOnboardingDataUseCase: CreateUpdateOnboardingDataUseCase
    val getKycDetailsUseCase: GetKycDetailsUseCase
}