package com.apnamart.apnarider.domain.app_info.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.app_info.AppUpdateResponse
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class CheckAppUpdateUseCase(
    private val dataHelper: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) : SimpleUseCase<String, Pair<Boolean, Boolean>, AppUpdateResponse>(dispatcherProvider) {


    override suspend fun buildUseCase(input: String): Response<AppUpdateResponse> {
        return dataHelper.apiHelper.checkAppUpdate("SCR", input)
    }

    override suspend fun onComplete(data: AppUpdateResponse): State<Pair<Boolean, Boolean>> {
        return State.success(Pair(data.required, data.major))
    }


}