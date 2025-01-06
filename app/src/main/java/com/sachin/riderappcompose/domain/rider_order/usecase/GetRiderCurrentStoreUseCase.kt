package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleVoidUseCaseV2
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.apnamart.apnarider.data.http.response.store_details.GetStoreDetailsResponse
import com.apnamart.apnarider.domain.rider_order.entity.store_details.GetCurrentStoreDetailsDomain
import com.apnamart.apnarider.domain.rider_order.mapper.getCurrentStoreDetailsDomain
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class GetRiderCurrentStoreUseCase(
    private val dataHelper: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) :  SimpleVoidUseCaseV2<GetCurrentStoreDetailsDomain, GetStoreDetailsResponse>(dispatcherProvider){

    override suspend fun buildUseCase(input: Unit): Response<GenericResponseV2<GetStoreDetailsResponse>> {
            return dataHelper.apiHelper.getCurrentRiderStoreDetails()
    }

    override suspend fun onComplete(data: GenericResponseV2<GetStoreDetailsResponse>): State<GetCurrentStoreDetailsDomain> {
        return State.success(data.data?.currentStoreDetailsResponse?.getCurrentStoreDetailsDomain())
    }
}