package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleVoidUseCaseV2
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.apnamart.apnarider.data.http.response.rider_orders.orders_count.RiderOrdersCountResponse
import com.apnamart.apnarider.domain.rider_order.entity.orders_count.RiderOrdersCountDomain
import com.apnamart.apnarider.domain.rider_order.mapper.toRiderOrdersCount
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class GetRiderOrdersCountUseCase(
    private val dataHelper: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) : SimpleVoidUseCaseV2<RiderOrdersCountDomain, RiderOrdersCountResponse>(dispatcherProvider){

    override suspend fun buildUseCase(input: Unit): Response<GenericResponseV2<RiderOrdersCountResponse>> {
        return dataHelper.apiHelper.getRiderOrdersCount()
    }

    override suspend fun onComplete(data: GenericResponseV2<RiderOrdersCountResponse>): State<RiderOrdersCountDomain> {
        dataHelper.cacheHelper.pendingOrders =
            (data.data?.pendingOrderCount ?: 0) + (data.data?.confirmOrderCount ?: 0)
        return State.success(data.data?.toRiderOrdersCount())
    }

}