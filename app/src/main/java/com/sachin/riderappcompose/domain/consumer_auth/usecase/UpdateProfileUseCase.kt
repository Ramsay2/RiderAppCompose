package com.apnamart.apnarider.domain.consumer_auth.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.sachin.riderappcompose.data.cache.entities.UserCacheData
import com.apnamart.apnarider.data.http.request.consumer_auth.UpdateProfileRequest
import com.apnamart.apnarider.data.http.response.consumer_auth.UserData
import com.apnamart.apnarider.domain.consumer_auth.mapper.toUserCacheData
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class UpdateProfileUseCase(
    private val dataHelper: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) : SimpleUseCase<UpdateProfileRequest, UserCacheData, UserData>(dispatcherProvider = dispatcherProvider) {

    override suspend fun buildUseCase(input: UpdateProfileRequest): Response<UserData> {
        return dataHelper.apiHelper.updateProfile(dataHelper.cacheHelper.userId, input)
    }

    override suspend fun onComplete(data: UserData): State<UserCacheData> {
        dataHelper.cacheHelper.loggedInUser = data.toUserCacheData()
        return State.success(data.toUserCacheData())
    }
}