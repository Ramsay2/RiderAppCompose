package com.apnamart.apnarider.data.http.services

import com.apnamart.apnarider.data.http.CANCEL_DQR
import com.apnamart.apnarider.data.http.CREATE_PAYMENT_DQR
import com.apnamart.apnarider.data.http.GET_PAYMENT_MODE
import com.apnamart.apnarider.data.http.GET_PAYMENT_STATUS
import com.apnamart.apnarider.data.http.request.payment.PaymentRequest
import com.apnamart.apnarider.data.http.response.GenericResponse
import com.apnamart.apnarider.data.http.response.payment.CreatePaymentQrResponse
import com.apnamart.apnarider.data.http.response.payment.PaymentModeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PaymentApiService {

@POST(CREATE_PAYMENT_DQR)
suspend fun createPaymentQR(@Body request: PaymentRequest): Response<CreatePaymentQrResponse>

@POST(GET_PAYMENT_STATUS)
suspend fun getPaymentStatus(@Body request: PaymentRequest): Response<CreatePaymentQrResponse>

@POST(CANCEL_DQR)
suspend fun cancelPayment(@Body request: PaymentRequest): Response<GenericResponse>

    @GET(GET_PAYMENT_MODE)
    suspend fun getPaymentMethods(
        @Path("storeId") storeId: Int,
        @Query("qr") qrEnabled: Boolean,
    ): Response<List<PaymentModeResponse>>

}