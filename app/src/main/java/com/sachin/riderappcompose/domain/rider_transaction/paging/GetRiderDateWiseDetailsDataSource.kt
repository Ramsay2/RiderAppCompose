package com.apnamart.apnarider.domain.rider_transaction.paging

import com.apnamart.apnarider.data.http.ApiHelper
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.apnamart.apnarider.data.http.response.payout_details.DateWiseDataResponse
import com.apnamart.apnarider.domain._base.paging.BasePagingDataSourceV2
import com.apnamart.apnarider.domain.rider_transaction.entity.DateWisePayoutDetailsDomain
import com.apnamart.apnarider.domain.rider_transaction.mapper.toDateWiseDataModal
import retrofit2.Response

class GetRiderDateWiseDetailsDataSource(
    val apiHelper: ApiHelper,
    val userId : Int,
    private val queryParams: Pair<String, String>
) : BasePagingDataSourceV2<GenericResponseV2<List<DateWiseDataResponse>>, DateWisePayoutDetailsDomain>() {

    override fun toLoadResult(
        data: GenericResponseV2<List<DateWiseDataResponse>>?,
        prevKey: Int?,
        nextKey: Int?
    ): LoadResult<Int, DateWisePayoutDetailsDomain> {
        return LoadResult.Page(
            data?.data?.map { it.toDateWiseDataModal() } ?: listOf(),
            prevKey = prevKey,
            nextKey = nextKey
        )
    }

    override suspend fun callApi(currentPage: Int): Response<GenericResponseV2<List<DateWiseDataResponse>>> {
        val data = apiHelper.getRiderPayoutDetails(
            riderId = userId,
            startDate = queryParams.first,
            endDate = queryParams.second,
            pageNo = currentPage,
            limit = 20
        )
        return data
    }
}