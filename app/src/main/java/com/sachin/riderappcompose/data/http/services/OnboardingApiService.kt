package com.apnamart.apnarider.data.http.services

import com.apnamart.apnarider.data.http.CREATE_UPDATE_ONBOARDING_DATA
import com.apnamart.apnarider.data.http.GET_CITIES
import com.apnamart.apnarider.data.http.GET_KYC_DETAILS
import com.apnamart.apnarider.data.http.request.onboarding.OnboardingRequest
import com.apnamart.apnarider.data.http.response.GenericResponse
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.apnamart.apnarider.data.http.response.onboarding.CityListResponse
import com.apnamart.apnarider.data.http.response.onboarding.RiderKycResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface OnboardingApiService {
    @GET(GET_CITIES)
    suspend fun getCities(): Response<GenericResponseV2<CityListResponse>>

    @POST(CREATE_UPDATE_ONBOARDING_DATA)
    suspend fun createUpdateOnboardingData(@Body onboardingRequest: OnboardingRequest): Response<GenericResponseV2<GenericResponse>>

    @GET(GET_KYC_DETAILS)
    suspend fun getKycDetails(): Response<GenericResponseV2<RiderKycResponse>>
}