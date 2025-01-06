package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.request.sale.UpdateOrderStatusRequest
import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.RiderOrderDetailResponse
import com.apnamart.apnarider.domain.rider_order.entity.order_detail.RiderOrderDetailDomain
import com.apnamart.apnarider.domain.rider_order.mapper.toRiderOrderDetailDomain
import com.sachin.riderappcompose.core_app_framework.interactor.State
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response

class UpdateOrderStatusUseCase(val dataHelper: DataHelper, dispatcherProvider: DispatcherProvider) :
    SimpleUseCase<UpdateOrderStatusRequest, RiderOrderDetailDomain, RiderOrderDetailResponse>(
        dispatcherProvider
    ) {
    override suspend fun buildUseCase(input: UpdateOrderStatusRequest): Response<RiderOrderDetailResponse> {
        val orderId = input.orderId.toString().toRequestBody("text/plain".toMediaTypeOrNull())
        val cashAmount = input.cashAmount.toString().toRequestBody("text/plain".toMediaTypeOrNull())
        val dQRAmount = input.dQRAmount.toString().toRequestBody("text/plain".toMediaTypeOrNull())
        val status = input.status.toRequestBody("text/plain".toMediaTypeOrNull())
        val onlineAmount =
            input.onlineAmount.toString().toRequestBody("text/plain".toMediaTypeOrNull())
        val image = input.image
        val remarks = input.remarks.toString().toRequestBody("text/plain".toMediaTypeOrNull())
        val oType = input.oType.toString().toRequestBody("text/plain".toMediaTypeOrNull())
        val lat = input.latitude.toString().toRequestBody("text/plain".toMediaTypeOrNull())
        val long = input.longitude.toString().toRequestBody("text/plain".toMediaTypeOrNull())

        return dataHelper.apiHelper.updateOrderStatus(
            orderId, cashAmount, onlineAmount,dQRAmount, status, image, remarks, oType, lat, long
        )
    }

    override suspend fun onComplete(data: RiderOrderDetailResponse): State<RiderOrderDetailDomain> {
        return State.success(data.toRiderOrderDetailDomain())
    }
}