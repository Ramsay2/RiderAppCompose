package com.apnamart.apnarider.data.http.services

import com.apnamart.apnarider.data.http.DELETE_ORDER_DELIVERY_IMAGE
import com.apnamart.apnarider.data.http.GET_CURRENT_RIDER_STORE
import com.apnamart.apnarider.data.http.GET_ONLINE_ORDER_SUMMARY
import com.apnamart.apnarider.data.http.GET_ORDER_DELIVERY_IMAGE
import com.apnamart.apnarider.data.http.GET_RIDER_DATA
import com.apnamart.apnarider.data.http.GET_RIDER_ORDERS_COUNT
import com.apnamart.apnarider.data.http.GET_RIDER_ORDER_DETAILS
import com.apnamart.apnarider.data.http.GET_RIDER_ORDER_LIST
import com.apnamart.apnarider.data.http.LIST_RIDER_ORDERS_V2
import com.apnamart.apnarider.data.http.MARK_RIDER_AT_STORE
import com.apnamart.apnarider.data.http.SCAN_ORDER
import com.apnamart.apnarider.data.http.UPDATE_ORDER_RIDER_STATUS
import com.apnamart.apnarider.data.http.UPDATE_ORDER_STATUS
import com.apnamart.apnarider.data.http.UPLOAD_ORDER_DELIVERY_IMAGE
import com.apnamart.apnarider.data.http.VALIDATE_RIDER_AT_STORE
import com.apnamart.apnarider.data.http.VERIFY_RETURN
import com.apnamart.apnarider.data.http.VERIFY_RIDER_ASSIGNMENT
import com.apnamart.apnarider.data.http.request.attendance.RiderStatusRequest
import com.apnamart.apnarider.data.http.request.sale.verify_rider_assignment.VerifyRiderAssignmentRequestV2
import com.apnamart.apnarider.data.http.request.validate_rider_at_store.ValidateRiderAtStoreRequest
import com.apnamart.apnarider.data.http.response.GenericResponse
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.apnamart.apnarider.data.http.response.rider_orders.RiderDetailsResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.GetOrderDeliveryImageListResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.OnlineOrderSummaryResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.RiderOrderDetailResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.UploadOrderDeliveryImageResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_list.AllocatedOrdersResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_list.RiderOrderListResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_list_v2.OrdersListResponseV2
import com.apnamart.apnarider.data.http.response.rider_orders.orders_count.RiderOrdersCountResponse
import com.apnamart.apnarider.data.http.response.store_details.GetStoreDetailsResponse
import com.apnamart.apnarider.data.http.response.validate_rider_at_store.ValidateRiderAtStoreResponse
import com.apnamart.apnarider.data.http.response.verify_rider_assignment.VerifyRiderAssignmentResponseV2
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface SaleApiService {
    @GET(GET_RIDER_ORDER_LIST)
    suspend fun getRiderOrderList(
        @Query("o_type") oType: String
    ): Response<RiderOrderListResponse>

    @GET(GET_RIDER_ORDER_DETAILS)
    suspend fun getRiderOrderDetails(@Path("order_id") orderId: Int): Response<AllocatedOrdersResponse>

    @GET(GET_ONLINE_ORDER_SUMMARY)
    suspend fun getOnlineOrderSummary(@Query("rider_id") riderId: Int): Response<OnlineOrderSummaryResponse>

    @Multipart
    @POST(UPDATE_ORDER_STATUS)
    suspend fun updateOrderStatus(
        @Part("id") orderId: RequestBody,
        @Part("cash_amount") cashAmount: RequestBody,
        @Part("online_amount") onlineAmount: RequestBody,
        @Part("dqr_amount") dQRAmount : RequestBody,
        @Part("status") status: RequestBody,
        @Part image: MultipartBody.Part?,
        @Part("remarks") remarks: RequestBody?,
        @Part("o_type") oType: RequestBody?,
        @Part("latitude") latitude: RequestBody,
        @Part("longitude") longitude: RequestBody,
    ): Response<RiderOrderDetailResponse>

    @POST(UPDATE_ORDER_RIDER_STATUS)
    suspend fun updateRiderStatus(
        @Path("order_id") orderId: Int,
        @Query("del_status") delStatus: String,
        @Query("latitude") lat: Double,
        @Query("longitude") lng: Double,
        ): Response<AllocatedOrdersResponse>

    @PUT(VERIFY_RETURN)
    suspend fun verifyReturn(
        @Query("stage") stage: String,
        @Query("order_id") orderId: Int,
        @Query("verification_code") code: String
    ): Response<GenericResponse>

    @PUT(SCAN_ORDER)
    suspend fun manuallyAssignRider(
        @Query("order_id") orderId: String,
        @Query("rider_id") riderId: Int,
        @Query("latitude") lat : Double,
        @Query("longitude") lng : Double
    ): Response<GenericResponse>

    @GET(GET_RIDER_DATA)
    suspend fun getRiderData(): Response<RiderDetailsResponse>

    @POST(MARK_RIDER_AT_STORE)
    suspend fun markRiderAtStore(
        @Body riderStatusRequest: RiderStatusRequest
    ): Response<GenericResponse>

    @GET(GET_CURRENT_RIDER_STORE)
    suspend fun getCurrentRiderStoreDetails(): Response<GenericResponseV2<GetStoreDetailsResponse>>

    @GET(GET_RIDER_ORDERS_COUNT)
    suspend fun getRiderOrdersCount(): Response<GenericResponseV2<RiderOrdersCountResponse>>

    @GET(LIST_RIDER_ORDERS_V2)
    suspend fun getListRiderOrderV2(
        @Query("status") status : String) : Response<GenericResponseV2<OrdersListResponseV2>>

    @PUT(VERIFY_RIDER_ASSIGNMENT)
    suspend fun verifyRiderAssignment(
       @Body verifyRiderAssignmentRequestV2: VerifyRiderAssignmentRequestV2
    ): Response<GenericResponseV2<VerifyRiderAssignmentResponseV2>>

    @Multipart
    @POST(UPLOAD_ORDER_DELIVERY_IMAGE)
    suspend fun uploadOrderDeliveryImage(
        @Path("order_id") orderId: Int,
        @Part image: MultipartBody.Part?,
        @Part("image_type") imageType: RequestBody,
    ): Response<GenericResponseV2<UploadOrderDeliveryImageResponse>>

    @DELETE(DELETE_ORDER_DELIVERY_IMAGE)
    suspend fun deleteOrderDeliveryImage(
        @Path("image_id") imageId: Int,
    ): Response<GenericResponseV2<GenericResponse>>

    @GET(GET_ORDER_DELIVERY_IMAGE)
    suspend fun getOrderDeliveryImage(
        @Path("order_id") orderId: Int,
        @Query("image_type") imageType : String
    ) : Response<GenericResponseV2<GetOrderDeliveryImageListResponse>>

    @POST(VALIDATE_RIDER_AT_STORE)
    suspend fun validateRiderAtStore(
        @Body validateRiderAtStoreRequest: ValidateRiderAtStoreRequest
    ): Response<GenericResponseV2<ValidateRiderAtStoreResponse>>
}