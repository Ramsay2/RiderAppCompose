package com.apnamart.apnarider.domain.attendance.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.SimpleUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.attendance.RiderStatusResponse
import com.sachin.riderappcompose.core_app_framework.interactor.State
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response


class MarkInRiderUseCase(
    private val dataHelper: DataHelper,
    dispatcherProvider: DispatcherProvider
) : SimpleUseCase<Triple< MultipartBody.Part? ,Double, Double>, Pair<Boolean, String>, RiderStatusResponse>(
    dispatcherProvider = dispatcherProvider
) {

    override suspend fun buildUseCase(input: Triple< MultipartBody.Part? ,Double, Double>): Response<RiderStatusResponse> {
        val lat = input.second.toString().toRequestBody("text/plain".toMediaTypeOrNull())
        val lon = input.third.toString().toRequestBody("text/plain".toMediaTypeOrNull())
        return dataHelper.apiHelper.markInRider(lat, lon, input.first)
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