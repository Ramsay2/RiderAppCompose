package com.apnamart.apnarider.domain.rider_transaction.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleVoidUseCaseV2
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.apnamart.apnarider.data.http.response.rider_cash_collection.RiderInHandCashDetailsResponse
import com.apnamart.apnarider.domain.rider_transaction.entity.RiderInHandCashDetailsDomain
import com.apnamart.apnarider.domain.rider_transaction.mapper.toRiderInHandCashDetailsDomain
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class RiderInHandCashDetailsUseCase(
    val dataHelper: DataHelper,
    dispatcherProvider: DispatcherProvider
) : SimpleVoidUseCaseV2<RiderInHandCashDetailsDomain , RiderInHandCashDetailsResponse>(dispatcherProvider) {
    override suspend fun buildUseCase(input: Unit): Response<GenericResponseV2<RiderInHandCashDetailsResponse>> {
        return dataHelper.apiHelper.getRiderInHandCashDetails(
            dataHelper.cacheHelper.userId
        )
    }

    override suspend fun onComplete(data: GenericResponseV2<RiderInHandCashDetailsResponse>): State<RiderInHandCashDetailsDomain> {
        return State.success(data.data?.toRiderInHandCashDetailsDomain())
    }
}