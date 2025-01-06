package com.apnamart.apnarider.domain.rider_transaction.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.domain.rider_transaction.entity.DateWisePayoutDetailsDomain
import com.apnamart.apnarider.domain.rider_transaction.paging.GetRiderDateWiseDetailsDataSource
import com.sachin.riderappcompose.presentation.AppConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow


class GetRiderPayoutDateWiseDetailsUseCase(
    val dataHelper: DataHelper,
    ){

    fun execute(input: Pair<Pair<String, String>, CoroutineScope>):
            Flow<PagingData<DateWisePayoutDetailsDomain>> {
        val userId = dataHelper.cacheHelper.userId
        return Pager(
            config = PagingConfig(
                pageSize = AppConstants.DEFAULT_PAGING_PAGE_SIZE
            ), pagingSourceFactory = {
                GetRiderDateWiseDetailsDataSource(
                    apiHelper = dataHelper.apiHelper,
                        userId,
                        input.first
                    )
            }
        ).flow.cachedIn(input.second)
    }
}