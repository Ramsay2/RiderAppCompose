package com.apnamart.apnarider.domain.attendance.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.request.attendance.RiderStatusRequest
import com.apnamart.apnarider.data.http.response.attendance.RiderStatusResponse
import com.sachin.riderappcompose.core_app_framework.interactor.State
import retrofit2.Response

class MarkOutRiderUseCase(
    private val dataHelper: DataHelper,
    dispatcherProvider: DispatcherProvider
) : SimpleUseCase<Pair<Double, Double>, Pair<Boolean, String>, RiderStatusResponse>(
    dispatcherProvider
) {

    override suspend fun buildUseCase(input: Pair<Double, Double>): Response<RiderStatusResponse> {
        val request = RiderStatusRequest(latitude = input.first, longitude = input.second)
        return dataHelper.apiHelper.markOutRider(request)
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