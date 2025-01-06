package com.apnamart.apnarider.domain.consumer_auth.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleVoidUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.sachin.riderappcompose.data.cache.entities.UserCacheData
import com.apnamart.apnarider.data.http.response.consumer_auth.UserData
import com.apnamart.apnarider.domain.consumer_auth.mapper.toUserCacheData
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class GetUserDataUseCase(
    private val dataHelper: DataHelper,
    dispatcherProvider: DispatcherProvider
) : SimpleVoidUseCase<UserCacheData, UserData>(dispatcherProvider) {

    override suspend fun buildUseCase(input: Unit): Response<UserData> {
        return dataHelper.apiHelper.getUserData("rider")
    }

    override suspend fun onComplete(data: UserData): State<UserCacheData> {
        dataHelper.cacheHelper.loggedInUser = data.toUserCacheData()
        return State.success(data.toUserCacheData())
    }
}