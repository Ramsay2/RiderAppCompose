package com.apnamart.apnarider.domain.rider_transaction.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.request.rider_cash_deposit.RiderPendingCashRequest
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.apnamart.apnarider.data.http.response.rider_cash_collection.RiderCashDepositStoreLevelResponse
import com.apnamart.apnarider.domain.rider_transaction.entity.RiderCashDepositStoreLevelDomain
import com.apnamart.apnarider.domain.rider_transaction.mapper.toRiderCashDepositStoreLevelDomain
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class GetCashDepositStoreLevelUseCase(
    private val dataHelper: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) : SimpleUseCase<RiderPendingCashRequest, RiderCashDepositStoreLevelDomain, GenericResponseV2<RiderCashDepositStoreLevelResponse>>(
    dispatcherProvider
) {

    override suspend fun buildUseCase(input: RiderPendingCashRequest): Response<GenericResponseV2<RiderCashDepositStoreLevelResponse>> {
        return dataHelper.apiHelper.getRiderPendingCashStoreLevel(input)
    }

    override suspend fun onComplete(data: GenericResponseV2<RiderCashDepositStoreLevelResponse>):
            State<RiderCashDepositStoreLevelDomain> {
        return State.success(data.data?.toRiderCashDepositStoreLevelDomain())
    }
}