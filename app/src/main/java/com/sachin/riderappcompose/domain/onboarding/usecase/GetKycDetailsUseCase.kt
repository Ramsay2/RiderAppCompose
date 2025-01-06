package com.apnamart.apnarider.domain.onboarding.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleVoidUseCaseV2
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.apnamart.apnarider.data.http.response.onboarding.RiderKycResponse
import com.apnamart.apnarider.domain.onboarding.entity.RiderKycDetailsDomain
import com.apnamart.apnarider.domain.onboarding.mapper.toRiderKycDetailsDomain
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class GetKycDetailsUseCase(
    private val dataHelper: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) : SimpleVoidUseCaseV2<RiderKycDetailsDomain, RiderKycResponse>(dispatcherProvider) {

    override suspend fun buildUseCase(input: Unit): Response<GenericResponseV2<RiderKycResponse>> {
        return dataHelper.apiHelper.getKycDetails()
    }

    override suspend fun onComplete(data: GenericResponseV2<RiderKycResponse>): State<RiderKycDetailsDomain> {
        val kycDetails = data.data?.kycDetails?.toRiderKycDetailsDomain()
        kycDetails?.let {
            val onboardingDetails = dataHelper.cacheHelper.onboardingDetails
            dataHelper.cacheHelper.onboardingDetails = onboardingDetails?.apply {
                kycStatus = it.kycStatus
                kycVerificationNeeded = it.kycVerificationNeeded
                termsAndConditionsAccepted = it.termsAndConditionsAccepted
            }
        }
        return State.success(kycDetails)
    }
}