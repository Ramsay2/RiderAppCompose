package com.apnamart.apnarider.domain.rider_transaction.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.request.rider_cash_deposit.RiderPendingCashRequest
import com.apnamart.apnarider.domain.rider_transaction.entity.RiderPendingDepositDomain
import com.apnamart.apnarider.domain.rider_transaction.paging.RiderPendingCashDataSource
import com.sachin.riderappcompose.presentation.AppConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class RiderPendingCashUseCase(private val dataHelper: DataHelper) {
    fun execute(input: Pair<RiderPendingCashRequest, CoroutineScope>):
            Flow<PagingData<RiderPendingDepositDomain>> {

        return Pager(
            config = PagingConfig(
                pageSize = AppConstants.DEFAULT_PAGING_PAGE_SIZE
            ), pagingSourceFactory = {
                RiderPendingCashDataSource(
                    apiHelper = dataHelper.apiHelper,
                    input.first
                )
            }
        ).flow.cachedIn(input.second)
    }
}