package com.apnamart.apnarider.domain.onboarding

import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.domain._base.BaseHelperImplNew
import com.apnamart.apnarider.domain.onboarding.usecase.CreateUpdateOnboardingDataUseCase
import com.apnamart.apnarider.domain.onboarding.usecase.GetCitiesUseCase
import com.apnamart.apnarider.domain.onboarding.usecase.GetKycDetailsUseCase
import javax.inject.Inject

class OnboardingHelperImpl @Inject
constructor(dataHelper: DataHelper, dispatcherProvider: DispatcherProvider) :
    BaseHelperImplNew(dataHelper, dispatcherProvider), OnboardingHelper {
    override val getCitiesUseCase: GetCitiesUseCase
        get() = GetCitiesUseCase(dataHelper, dispatcherProvider)
    override val createUpdateOnboardingDataUseCase: CreateUpdateOnboardingDataUseCase
        get() = CreateUpdateOnboardingDataUseCase(dataHelper, dispatcherProvider)
    override val getKycDetailsUseCase: GetKycDetailsUseCase
        get() = GetKycDetailsUseCase(dataHelper, dispatcherProvider)
}