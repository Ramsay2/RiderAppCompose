package com.apnamart.apnarider.data.http.services

import com.apnamart.apnarider.data.http.CHECK_APP_UPDATE
import com.apnamart.apnarider.data.http.response.app_info.AppUpdateResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AppInfoApiService {
    @GET(CHECK_APP_UPDATE)
    suspend fun checkAppUpdate(
        @Query("name") name: String, @Query("code") code:String): Response<AppUpdateResponse>
}