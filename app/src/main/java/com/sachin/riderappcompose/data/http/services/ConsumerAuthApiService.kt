package com.sachin.riderappcompose.data.http.services

import com.apnamart.apnarider.data.http.GET_OPERATED_STORES
import com.apnamart.apnarider.data.http.GET_USER_DATA
import com.apnamart.apnarider.data.http.LOGOUT
import com.apnamart.apnarider.data.http.SEND_OTP
import com.apnamart.apnarider.data.http.UPDATE_PROFILE
import com.apnamart.apnarider.data.http.VERIFY_OTP
import com.apnamart.apnarider.data.http.request.consumer_auth.LogoutRequest
import com.apnamart.apnarider.data.http.request.consumer_auth.SendOtpRequest
import com.apnamart.apnarider.data.http.request.consumer_auth.UpdateProfileRequest
import com.apnamart.apnarider.data.http.request.consumer_auth.VerifyOtpRequest
import com.apnamart.apnarider.data.http.response.GenericResponse
import com.apnamart.apnarider.data.http.response.consumer_auth.AuthResponse
import com.apnamart.apnarider.data.http.response.consumer_auth.FranchiseeStoreResponse
import com.apnamart.apnarider.data.http.response.consumer_auth.SendOtpResponse
import com.apnamart.apnarider.data.http.response.consumer_auth.UserData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ConsumerAuthApiService {

    @GET(GET_USER_DATA)
    suspend fun getUserData(@Query("client_app") clientApp: String): Response<UserData>

    @PUT(LOGOUT)
    suspend fun logout(@Body logoutRequest: LogoutRequest): Response<GenericResponse>

    @GET(GET_OPERATED_STORES)
    suspend fun getOperatedStores(@Query("active") active: Int): Response<List<FranchiseeStoreResponse>>

    @POST(SEND_OTP)
    suspend fun sendOtp(@Body sendOtpRequest: SendOtpRequest): Response<SendOtpResponse>

    @POST(VERIFY_OTP)
    suspend fun verifyOtp(@Body verifyOtpRequest: VerifyOtpRequest): Response<AuthResponse>

    @PUT(UPDATE_PROFILE)
    suspend fun updateProfile(
        @Path("userId") userId: Int,
        @Body updateProfileRequest: UpdateProfileRequest
    ): Response<UserData>
}