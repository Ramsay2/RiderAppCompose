package com.apnamart.apnarider.domain.consumer_auth.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleVoidUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.consumer_auth.FranchiseeStoreResponse
import com.apnamart.apnarider.domain.consumer_auth.entity.FranchiseeStoreDomain
import com.apnamart.apnarider.domain.consumer_auth.mapper.toFranchiseeStoreDomain
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class GetOperatedStoresUseCase(
    private val dataHelper: DataHelper,
    val dispatcherProvider: DispatcherProvider
) : SimpleVoidUseCase<List<FranchiseeStoreDomain>, List<FranchiseeStoreResponse>>(dispatcherProvider = dispatcherProvider) {

    override suspend fun buildUseCase(input: Unit): Response<List<FranchiseeStoreResponse>> {
        return dataHelper.apiHelper.getOperatedStores(1)
    }

    override suspend fun onComplete(data: List<FranchiseeStoreResponse>): State<List<FranchiseeStoreDomain>> {
        return State.success(data.map { it.toFranchiseeStoreDomain() })
    }
}