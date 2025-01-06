package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCaseV2
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.request.sale.upload_order_delivery_image.UploadOrderDeliveryImageRequest
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.UploadOrderDeliveryImageResponse
import com.apnamart.apnarider.domain.rider_order.entity.order_detail.OrderDeliveryImageDomain
import com.apnamart.apnarider.domain.rider_order.mapper.toUploadDeliveryImageDomain
import com.sachin.riderappcompose.core_app_framework.interactor.State
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response

class UploadOrderDeliveryImageUseCase(val dataHelper: DataHelper, dispatcherProvider: DispatcherProvider) :
    SimpleUseCaseV2<UploadOrderDeliveryImageRequest, OrderDeliveryImageDomain, UploadOrderDeliveryImageResponse>(
        dispatcherProvider
    ) {
    override suspend fun buildUseCase(input: UploadOrderDeliveryImageRequest): Response<GenericResponseV2<UploadOrderDeliveryImageResponse>> {
        val orderId = input.orderId
        val image = input.image
        val imageType = input.imageType.toRequestBody("text/plain".toMediaTypeOrNull())

        return dataHelper.apiHelper.uploadOrderDeliveryImage(orderId, image, imageType)
    }

    override suspend fun onComplete(data: GenericResponseV2<UploadOrderDeliveryImageResponse>): State<OrderDeliveryImageDomain> {
        return State.success(data.data?.toUploadDeliveryImageDomain())
    }
}