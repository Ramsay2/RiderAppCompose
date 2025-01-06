package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.rider_orders.order_list.AllocatedOrdersResponse
import com.apnamart.apnarider.domain.rider_order.entity.order_list.AllocatedOrdersDomain
import com.apnamart.apnarider.domain.rider_order.mapper.toAllocatedOrdersDomain
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

typealias UPDATE_RIDER_INPUT = Pair<Pair<Int, String>, Pair<Double, Double>>

class UpdateRiderStatusUseCase(val dataHelper: DataHelper, dispatcherProvider: DispatcherProvider) :
    SimpleUseCase<UPDATE_RIDER_INPUT, AllocatedOrdersDomain, AllocatedOrdersResponse>(
        dispatcherProvider
    ) {

    override suspend fun buildUseCase(input: UPDATE_RIDER_INPUT): Response<AllocatedOrdersResponse> {
        return dataHelper.apiHelper.updateRiderStatus(
            input.first.first, input.first.second, input.second.first,
            input.second.second
        )
    }

    override suspend fun onComplete(data: AllocatedOrdersResponse): State<AllocatedOrdersDomain> {
        return State.success(data.toAllocatedOrdersDomain())
    }
}