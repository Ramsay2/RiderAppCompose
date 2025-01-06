package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCaseV2
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.apnamart.apnarider.data.http.response.rider_orders.order_list_v2.OrdersListResponseV2
import com.apnamart.apnarider.domain.rider_order.entity.order_list_v2.OrderListDomainV2
import com.apnamart.apnarider.domain.rider_order.mapper.toOrderListDomainV2
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class OrderListUseCaseV2(
    private val dataHelper: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) : SimpleUseCaseV2<String, OrderListDomainV2, OrdersListResponseV2>(dispatcherProvider){

    override suspend fun buildUseCase(input: String): Response<GenericResponseV2<OrdersListResponseV2>> {
        return dataHelper.apiHelper.getListRiderOrderV2(input)
    }

    override suspend fun onComplete(data: GenericResponseV2<OrdersListResponseV2>): State<OrderListDomainV2> {
        return State.success(data.data?.toOrderListDomainV2())
    }
}