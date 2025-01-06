package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.core_app_framework.logger.AppLogger
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.domain.rider_order.entity.order_list.AllocatedOrdersDomain
import com.apnamart.apnarider.domain.rider_order.mapper.toAllocatedOrdersDomain
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

class GetOrderSummaryUseCase(
    val dataHelper: DataHelper,
    val dispatcherProvider: DispatcherProvider
) {

    suspend fun execute(): Flow<List<AllocatedOrdersDomain>> {
        return channelFlow {
            while (!isClosedForSend) {
                delay(DELAY)
                val response = dataHelper.apiHelper.getRiderOrderList("rider_pending")
                if (response.isSuccessful) {
                    response.body()?.allocatedOrders?.let {
                        send(it.map { item -> item.toAllocatedOrdersDomain() })
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