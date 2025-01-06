package com.apnamart.apnarider.domain._base.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import retrofit2.Response

abstract class BasePagingDataSourceV2<API_RESPONSE : GenericResponseV2<Any>, RESPONSE_DOMAIN : Any> :
    PagingSource<Int, RESPONSE_DOMAIN>() {

    abstract fun toLoadResult(
        data: API_RESPONSE?,
        prevKey: Int?,
        nextKey: Int?
    ): LoadResult<Int, RESPONSE_DOMAIN>

    abstract suspend fun callApi(currentPage: Int): Response<API_RESPONSE>

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RESPONSE_DOMAIN> {
        val currentLoadingPageKey: Int = params.key ?: 1
        val prevKey =
            if (currentLoadingPageKey > 1) currentLoadingPageKey - 1 else null

        return try {
            val result = callApi(currentLoadingPageKey)
            if (result.isSuccessful) {
                result.body()?.let {
                    val nextPage = getNextPage(it)
                    toLoadResult(it, prevKey, nextPage)
                } ?: kotlin.run {
                    LoadResult.Error(Throwable("Something went wrong."))
                }
            } else {
                toLoadResult(null, 0, 0)
                LoadResult.Error(Throwable(result.errorBody()?.string()))
            }
        } catch (e: java.lang.Exception) {
            toLoadResult(null, 1, 1)
            LoadResult.Error(e as Throwable)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, RESPONSE_DOMAIN>): Int? {
        val key = state.anchorPosition?.let { anchorPosition ->
            (state.closestPageToPosition(anchorPosition)?.prevKey
                ?: (state.closestPageToPosition(anchorPosition)?.prevKey) ?: 1)
        }
        return key
    }

    private fun getNextPage(data: API_RESPONSE): Int? {
        return if (data.paginationData?.hasNext == true) {
            return data.paginationData.currentPage.plus(1)
        } else {
            null
        }
    }
}