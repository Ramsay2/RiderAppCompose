package com.apnamart.apnarider.data.http.services

import com.apnamart.apnarider.data.http.GET_PAGINATED_RIDER_PENDING_CASH
import com.apnamart.apnarider.data.http.GET_RIDER_IN_HAND_CASH_DETAILS
import com.apnamart.apnarider.data.http.GET_RIDER_PAYOUT_DETAILS
import com.apnamart.apnarider.data.http.GET_RIDER_PAYOUT_TOTAL
import com.apnamart.apnarider.data.http.GET_RIDER_STORE_COLLECTION
import com.apnamart.apnarider.data.http.request.rider_cash_deposit.RiderPendingCashRequest
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.apnamart.apnarider.data.http.response.payout_details.DateWiseDataResponse
import com.apnamart.apnarider.data.http.response.payout_details.PayoutTotalDetailsResponse
import com.apnamart.apnarider.data.http.response.rider_cash_collection.RiderCashDepositStoreLevelResponse
import com.apnamart.apnarider.data.http.response.rider_cash_collection.RiderInHandCashDetailsResponse
import com.apnamart.apnarider.data.http.response.rider_cash_collection.RiderPendingDepositResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RiderCashCollectionApiService {

    @POST(GET_RIDER_STORE_COLLECTION)
    suspend fun getRiderPendingCashStoreLevel(
        @Body requestBody: RiderPendingCashRequest
    ): Response<GenericResponseV2<RiderCashDepositStoreLevelResponse>>

    @POST(GET_PAGINATED_RIDER_PENDING_CASH)
    suspend fun getPaginatedRiderPendingCash(
        @Body requestBody: RiderPendingCashRequest
    ): Response<GenericResponseV2<List<RiderPendingDepositResponse>>>

    @GET(GET_RIDER_PAYOUT_TOTAL)
    suspend fun getRiderPayoutTotal(
        @Query("rider_id") riderId: Int,
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String
    ): Response<GenericResponseV2<PayoutTotalDetailsResponse>>

    @GET(GET_RIDER_PAYOUT_DETAILS)
    suspend fun getRiderPayoutDetails(
        @Query("rider_id") riderId: Int,
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("page_no") pageNo: Int,
        @Query("limit") limit: Int
    ): Response<GenericResponseV2<List<DateWiseDataResponse>>>

    @GET(GET_RIDER_IN_HAND_CASH_DETAILS)
    suspend fun getRiderInHandCashDetails(
        @Query("rider_id") riderId: Int
    ): Response<GenericResponseV2<RiderInHandCashDetailsResponse>>

}