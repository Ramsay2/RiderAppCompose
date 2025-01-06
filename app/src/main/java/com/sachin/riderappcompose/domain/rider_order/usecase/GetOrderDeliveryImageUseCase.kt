package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCaseV2
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.GetOrderDeliveryImageListResponse
import com.apnamart.apnarider.domain.rider_order.entity.order_detail.GetOrderDeliveryImageListDomain
import com.apnamart.apnarider.domain.rider_order.mapper.toGetOrderDeliveryImageListDomain
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class GetOrderDeliveryImageUseCase(val dataHelper: DataHelper, dispatcherProvider: DispatcherProvider) :
    SimpleUseCaseV2<Pair<Int, String>, GetOrderDeliveryImageListDomain, GetOrderDeliveryImageListResponse>(
        dispatcherProvider
    ) {
    override suspend fun buildUseCase(input: Pair<Int, String>): Response<GenericResponseV2<GetOrderDeliveryImageListResponse>> {
        val orderId = input.first
        val imageType = input.second

        return dataHelper.apiHelper.getOrderDeliveryImage(orderId, imageType)
    }

    override suspend fun onComplete(data: GenericResponseV2<GetOrderDeliveryImageListResponse>): State<GetOrderDeliveryImageListDomain> {
        return State.success(data.data?.toGetOrderDeliveryImageListDomain())
    }
}