package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleVoidUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.rider_orders.order_list.RiderOrderListResponse
import com.apnamart.apnarider.domain.rider_order.entity.order_list.AllocatedOrdersDomain
import com.apnamart.apnarider.domain.rider_order.mapper.toAllocatedOrdersDomain
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class GetRiderOrdersUseCase(val dataHelper: DataHelper, dispatcherProvider: DispatcherProvider) :
    SimpleVoidUseCase< List<AllocatedOrdersDomain>, RiderOrderListResponse>(
        dispatcherProvider
    ) {

    override suspend fun buildUseCase(input : Unit): Response<RiderOrderListResponse> {
        return dataHelper.apiHelper.getRiderOrderList("rider_pending")
    }

    override suspend fun onComplete(data: RiderOrderListResponse): State<List<AllocatedOrdersDomain>> {
        dataHelper.cacheHelper.pendingOrders = data.allocatedOrders?.size ?: 0
        return State.success(data.allocatedOrders?.map { it.toAllocatedOrdersDomain() })
    }
}