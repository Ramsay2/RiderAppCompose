package com.apnamart.apnarider.domain.attendance.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleVoidUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.attendance.RiderStatusResponse
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class GetRiderAttendanceStatusUseCase(
    private val dataHelper: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) : SimpleVoidUseCase<Pair<Boolean, String>, RiderStatusResponse>(dispatcherProvider = dispatcherProvider) {

    override suspend fun buildUseCase(input: Unit): Response<RiderStatusResponse> {
        return dataHelper.apiHelper.getRiderMarkInStatus()
    }

    override suspend fun onComplete(data: RiderStatusResponse): State<Pair<Boolean, String>> {
        dataHelper.cacheHelper.markInRadius = data.markInRadius
        dataHelper.cacheHelper.deliveryRadius = data.deliveryRadius
        dataHelper.cacheHelper.pickupRadius = data.pickupRadius
        dataHelper.cacheHelper.userMarkedIn = data.markedIn
        val timingTxt = if (data.markedIn) "${data.workingMinutes / 60}:${data.workingMinutes % 60} Hrs on duty today" else "Timings 9AM - 8PM"
        return State.success(Pair(data.markedIn, timingTxt))
    }
}