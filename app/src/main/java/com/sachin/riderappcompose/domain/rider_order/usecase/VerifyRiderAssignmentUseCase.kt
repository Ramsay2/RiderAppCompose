package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCaseV2
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.request.sale.verify_rider_assignment.VerifyRiderAssignmentRequestV2
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.apnamart.apnarider.data.http.response.verify_rider_assignment.VerifyRiderAssignmentResponseV2
import com.apnamart.apnarider.domain.rider_order.entity.verify_rider_assignment.VerifyRiderAssignmentDomainV2
import com.apnamart.apnarider.domain.rider_order.mapper.toVerifyRiderAssignmentDomainV2
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class VerifyRiderAssignmentUseCase(
    private val dataHelper: DataHelper,
    dispatcherProvider: DispatcherProvider
) : SimpleUseCaseV2<VerifyRiderAssignmentRequestV2, VerifyRiderAssignmentDomainV2, VerifyRiderAssignmentResponseV2>(dispatcherProvider) {

    override suspend fun buildUseCase(input: VerifyRiderAssignmentRequestV2): Response<GenericResponseV2<VerifyRiderAssignmentResponseV2>> {
        return dataHelper.apiHelper.verifyRiderAssignment(input)
    }

    override suspend fun onComplete(data: GenericResponseV2<VerifyRiderAssignmentResponseV2>): State<VerifyRiderAssignmentDomainV2> {
       return State.success(data.data?.toVerifyRiderAssignmentDomainV2())
    }

}