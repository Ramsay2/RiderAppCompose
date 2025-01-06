package com.apnamart.apnarider.domain.user_location.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCaseV2
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.request.validate_rider_at_store.ValidateRiderAtStoreRequest
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.apnamart.apnarider.data.http.response.validate_rider_at_store.ValidateRiderAtStoreResponse
import com.apnamart.apnarider.domain.user_location.entity.validate_rider_at_store.ValidateRiderAtStoreDomain
import com.apnamart.apnarider.domain.user_location.mapper.toValidateRiderAtStoreDomain
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class ValidateRiderAtStoreUseCase(
    val dataHelper: DataHelper,
    dispatcherProvider: DispatcherProvider
) : SimpleUseCaseV2<ValidateRiderAtStoreRequest, ValidateRiderAtStoreDomain, ValidateRiderAtStoreResponse>(dispatcherProvider) {

    override suspend fun buildUseCase(input: ValidateRiderAtStoreRequest): Response<GenericResponseV2<ValidateRiderAtStoreResponse>> {
        return dataHelper.apiHelper.validateRiderAtStore(input)
    }

    override suspend fun onComplete(data: GenericResponseV2<ValidateRiderAtStoreResponse>): State<ValidateRiderAtStoreDomain> {
        return State.success(data.data?.toValidateRiderAtStoreDomain())
    }
}