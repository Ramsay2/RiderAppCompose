package com.apnamart.apnarider.data.http.services

import com.apnamart.apnarider.data.http.CREATE_FCM
import com.apnamart.apnarider.data.http.request.firebase.CreateFcmRequest
import com.apnamart.apnarider.data.http.response.firebase.CreateFcmResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PUT

interface FirebaseApiService {

    @PUT(CREATE_FCM)
    suspend fun registerFCM(@Body fcmRequest: CreateFcmRequest): Response<CreateFcmResponse>

}