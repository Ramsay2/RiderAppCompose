package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleVoidUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.rider_orders.RiderDetailsResponse
import com.apnamart.apnarider.domain.rider_order.entity.RiderDetailsDomain
import com.apnamart.apnarider.domain.rider_order.mapper.toRiderDetailsDomain
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class GetRiderDataUseCase(
    private val dataHelper: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) : SimpleVoidUseCase<RiderDetailsDomain, RiderDetailsResponse>(dispatcherProvider) {
    override suspend fun buildUseCase(input: Unit): Response<RiderDetailsResponse> {
        return dataHelper.apiHelper.getRiderData()
    }

    override suspend fun onComplete(data: RiderDetailsResponse): State<RiderDetailsDomain> {
        val riderData = data.data?.toRiderDetailsDomain()
        val onboardingDetails = dataHelper.cacheHelper.onboardingDetails
        dataHelper.cacheHelper.onboardingDetails = onboardingDetails?.apply {
            storeAllocated = riderData?.isStoreAllocated == true
        }
        return State.success(riderData)
    }
}