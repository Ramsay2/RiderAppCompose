package com.apnamart.apnarider.domain.onboarding.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleVoidUseCaseV2
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.apnamart.apnarider.data.http.response.onboarding.CityListResponse
import com.apnamart.apnarider.domain.onboarding.entity.CityDomain
import com.apnamart.apnarider.domain.onboarding.mapper.toCityDomain
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class GetCitiesUseCase(
    private val dataHelper: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) : SimpleVoidUseCaseV2<List<CityDomain>, CityListResponse>(dispatcherProvider) {

    override suspend fun buildUseCase(input: Unit): Response<GenericResponseV2<CityListResponse>> {
        return dataHelper.apiHelper.getCities()
    }

    override suspend fun onComplete(data: GenericResponseV2<CityListResponse>): State<List<CityDomain>> {
        return State.success(data.data?.cities?.map { it.toCityDomain() })
    }
}