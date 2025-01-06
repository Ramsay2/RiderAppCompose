package com.apnamart.apnarider.domain.rider_transaction.paging

import com.apnamart.apnarider.data.http.ApiHelper
import com.apnamart.apnarider.data.http.request.rider_cash_deposit.RiderPendingCashRequest
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.apnamart.apnarider.data.http.response.rider_cash_collection.RiderPendingDepositResponse
import com.apnamart.apnarider.domain._base.paging.BasePagingDataSourceV2
import com.apnamart.apnarider.domain.rider_transaction.entity.RiderPendingDepositDomain
import com.apnamart.apnarider.domain.rider_transaction.mapper.toRiderPendingDepositDomain
import com.sachin.riderappcompose.presentation.AppConstants
import retrofit2.Response

class RiderPendingCashDataSource(
    val apiHelper: ApiHelper,
    private val requestBody: RiderPendingCashRequest
) : BasePagingDataSourceV2<GenericResponseV2<List<RiderPendingDepositResponse>>, RiderPendingDepositDomain>() {

    override fun toLoadResult(
        data: GenericResponseV2<List<RiderPendingDepositResponse>>?,
        prevKey: Int?,
        nextKey: Int?
    ): LoadResult<Int, RiderPendingDepositDomain> {
        return LoadResult.Page(
            data?.paginatedData?.map { it.toRiderPendingDepositDomain() } ?: listOf(),
            prevKey = prevKey,
            nextKey = nextKey
        )
    }

    override suspend fun callApi(currentPage: Int): Response<GenericResponseV2<List<RiderPendingDepositResponse>>> {
        val data = apiHelper.getPaginatedRiderPendingCash(
            requestBody.copy(pageNo = currentPage, limit = AppConstants.DEFAULT_PAGING_PAGE_SIZE)
        )
        return data
    }
}