package com.apnamart.apnarider.domain.rider_transaction.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCaseV2
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.apnamart.apnarider.data.http.response.payout_details.PayoutTotalDetailsResponse
import com.apnamart.apnarider.domain.rider_transaction.entity.PayoutTotalDetailsModal
import com.apnamart.apnarider.domain.rider_transaction.mapper.toPayoutTotalDetailsModal
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response


class GetRiderPayoutTotalDetailsUseCase(
    val dataHelper: DataHelper,
    dispatcherProvider: DispatcherProvider
) : SimpleUseCaseV2<Pair<String, String>, PayoutTotalDetailsModal, PayoutTotalDetailsResponse>(dispatcherProvider) {

    override suspend fun buildUseCase(input: Pair<String, String>): Response<GenericResponseV2<PayoutTotalDetailsResponse>> {
        val userId = dataHelper.cacheHelper.userId
        return dataHelper.apiHelper.getRiderPayoutTotal(userId, input.first, input.second)
    }

    override suspend fun onComplete(data: GenericResponseV2<PayoutTotalDetailsResponse>): State<PayoutTotalDetailsModal> {
        return State.success(data.data?.toPayoutTotalDetailsModal())
    }
}