package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.core_app_framework.logger.AppLogger
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.domain.rider_order.entity.order_detail.OnlineOrderSummaryDomain
import com.apnamart.apnarider.domain.rider_order.mapper.toOnlineOrderSummaryDomain
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

class GetRiderOrdersSummaryUseCase(
    private val dataHelper: DataHelper,
    private val dispatcherProvider: DispatcherProvider
) {

    suspend fun execute(): Flow<OnlineOrderSummaryDomain> {
        return channelFlow {
            while (!isClosedForSend) {
                delay(DELAY)
                val response = dataHelper.apiHelper.getOnlineOrderSummary(
                    dataHelper.cacheHelper.userId
                )
                if (response.isSuccessful) {
                    response.body()?.data?.let {
                        send(it.toOnlineOrderSummaryDomain())
                    } ?: kotlin.run { }
                } else {
                    flowOf(response.errorBody())
                }
            }
        }.catch {
            it.message?.let { message -> AppLogger.error(message) }
        }.flowOn(dispatcherProvider.io())
    }

    private val DELAY: Long =  1000 * 60 * 5
}