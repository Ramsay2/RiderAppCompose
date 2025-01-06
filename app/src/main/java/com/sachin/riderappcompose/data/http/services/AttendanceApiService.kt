package com.apnamart.apnarider.data.http.services

import com.apnamart.apnarider.data.http.GET_RIDER_MARK_IN_STATUS
import com.apnamart.apnarider.data.http.MARK_IN_RIDER
import com.apnamart.apnarider.data.http.MARK_OUT_RIDER
import com.apnamart.apnarider.data.http.request.attendance.RiderStatusRequest
import com.apnamart.apnarider.data.http.response.attendance.RiderStatusResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface AttendanceApiService {

    @GET(GET_RIDER_MARK_IN_STATUS)
    suspend fun getRiderMarkInStatus(): Response<RiderStatusResponse>

    @Multipart
    @POST(MARK_IN_RIDER)
    suspend fun markInRider(
        @Part("latitude") latitude: RequestBody,
        @Part("longitude") longitude: RequestBody,
        @Part image: MultipartBody.Part?
    ): Response<RiderStatusResponse>

    @POST(MARK_OUT_RIDER)
    suspend fun markOutRider(
        @Body riderStatusRequest: RiderStatusRequest
    ): Response<RiderStatusResponse>

}