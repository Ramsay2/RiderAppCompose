package com.apnamart.apnarider.data.http

import com.apnamart.apnarider.core_app_framework.ioc.scope.ApplicationScope
import com.sachin.riderappcompose.data.http.provider.ApiServicesProvider
import com.apnamart.apnarider.data.http.request.attendance.RiderStatusRequest
import com.apnamart.apnarider.data.http.request.consumer_auth.LogoutRequest
import com.apnamart.apnarider.data.http.request.consumer_auth.SendOtpRequest
import com.apnamart.apnarider.data.http.request.consumer_auth.UpdateProfileRequest
import com.apnamart.apnarider.data.http.request.consumer_auth.VerifyOtpRequest
import com.apnamart.apnarider.data.http.request.firebase.CreateFcmRequest
import com.apnamart.apnarider.data.http.request.onboarding.OnboardingRequest
import com.apnamart.apnarider.data.http.request.payment.PaymentRequest
import com.apnamart.apnarider.data.http.request.rider_cash_deposit.RiderPendingCashRequest
import com.apnamart.apnarider.data.http.request.sale.verify_rider_assignment.VerifyRiderAssignmentRequestV2
import com.apnamart.apnarider.data.http.request.validate_rider_at_store.ValidateRiderAtStoreRequest
import com.apnamart.apnarider.data.http.response.GenericResponse
import com.apnamart.apnarider.data.http.response.GenericResponseV2
import com.apnamart.apnarider.data.http.response.app_info.AppUpdateResponse
import com.apnamart.apnarider.data.http.response.attendance.RiderStatusResponse
import com.apnamart.apnarider.data.http.response.consumer_auth.AuthResponse
import com.apnamart.apnarider.data.http.response.consumer_auth.FranchiseeStoreResponse
import com.apnamart.apnarider.data.http.response.consumer_auth.SendOtpResponse
import com.apnamart.apnarider.data.http.response.consumer_auth.UserData
import com.apnamart.apnarider.data.http.response.firebase.CreateFcmResponse
import com.apnamart.apnarider.data.http.response.onboarding.CityListResponse
import com.apnamart.apnarider.data.http.response.onboarding.RiderKycResponse
import com.apnamart.apnarider.data.http.response.payment.CreatePaymentQrResponse
import com.apnamart.apnarider.data.http.response.payment.PaymentModeResponse
import com.apnamart.apnarider.data.http.response.payout_details.DateWiseDataResponse
import com.apnamart.apnarider.data.http.response.payout_details.PayoutTotalDetailsResponse
import com.apnamart.apnarider.data.http.response.rider_cash_collection.RiderCashDepositStoreLevelResponse
import com.apnamart.apnarider.data.http.response.rider_cash_collection.RiderInHandCashDetailsResponse
import com.apnamart.apnarider.data.http.response.rider_cash_collection.RiderPendingDepositResponse
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
import com.apnamart.apnarider.data.http.services.AppInfoApiService
import com.apnamart.apnarider.data.http.services.AttendanceApiService
import com.sachin.riderappcompose.data.http.services.ConsumerAuthApiService
import com.apnamart.apnarider.data.http.services.FirebaseApiService
import com.apnamart.apnarider.data.http.services.OnboardingApiService
import com.apnamart.apnarider.data.http.services.PaymentApiService
import com.apnamart.apnarider.data.http.services.RiderCashCollectionApiService
import com.apnamart.apnarider.data.http.services.SaleApiService
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import javax.inject.Inject


class ApiHelperImpl @Inject
constructor(
    override val consumerAuthApiService: ConsumerAuthApiService,
    override val firebaseApiService: FirebaseApiService,
    override val appInfoApiService: AppInfoApiService,
    override val saleApiService: SaleApiService,
    override val attendanceApiService: AttendanceApiService,
    override val paymentApiService: PaymentApiService,
    override val riderCashCollectionApiService: RiderCashCollectionApiService,
    override val onboardingApiService: OnboardingApiService
) : ApiServicesProvider, ApiHelper {

    override suspend fun getUserData(clientApp: String): Response<UserData> {
        return consumerAuthApiService.getUserData(clientApp)
    }

    override suspend fun logout(logoutRequest: LogoutRequest): Response<GenericResponse> {
        return consumerAuthApiService.logout(logoutRequest)
    }
    override suspend fun registerFCM(fcmRequest: CreateFcmRequest): Response<CreateFcmResponse> {
        return firebaseApiService.registerFCM(fcmRequest)
    }

    override suspend fun checkAppUpdate(name: String, code: String): Response<AppUpdateResponse> {
        return appInfoApiService.checkAppUpdate(name, code)
    }

    override suspend fun getRiderOrderList(
        oType: String
    ): Response<RiderOrderListResponse> {
        return saleApiService.getRiderOrderList(oType)
    }

    override suspend fun getRiderMarkInStatus(): Response<RiderStatusResponse> {
        return attendanceApiService.getRiderMarkInStatus()
    }

    override suspend fun updateRiderStatus(
        orderId: Int,
        delStatus: String,
        lat: Double,
        lng: Double
    ): Response<AllocatedOrdersResponse> {
        return saleApiService.updateRiderStatus(orderId, delStatus, lat, lng)
    }

    override suspend fun verifyReturn(
        stage: String,
        orderId: Int,
        code: String
    ): Response<GenericResponse> {
        return saleApiService.verifyReturn(stage, orderId, code)
    }

    override suspend fun manuallyAssignRider(
        orderId: String,
        riderId: Int,
        lat: Double,
        lng: Double
    ): Response<GenericResponse> {
        return saleApiService.manuallyAssignRider(orderId, riderId, lat, lng)
    }

    override suspend fun getRiderOrderDetails(orderId: Int): Response<AllocatedOrdersResponse> {
        return saleApiService.getRiderOrderDetails(orderId)
    }

    override suspend fun getRiderData(): Response<RiderDetailsResponse> {
        return saleApiService.getRiderData()
    }

    override suspend fun getOnlineOrderSummary(riderId: Int): Response<OnlineOrderSummaryResponse> {
        return saleApiService.getOnlineOrderSummary(riderId)
    }

    override suspend fun updateOrderStatus(
        orderId: RequestBody,
        cashAmount: RequestBody,
        onlineAmount: RequestBody,
        dQRAmount: RequestBody,
        status: RequestBody,
        image: MultipartBody.Part?,
        remarks: RequestBody?,
        oType: RequestBody?,
        latitude: RequestBody,
        longitude: RequestBody
    ): Response<RiderOrderDetailResponse> {
        return saleApiService.updateOrderStatus(
            orderId,
            cashAmount,
            onlineAmount,
            dQRAmount,
            status,
            image,
            remarks,
            oType,
            latitude,
            longitude
        )
    }

    override suspend fun markRiderAtStore(riderStatusRequest: RiderStatusRequest): Response<GenericResponse> {
        return saleApiService.markRiderAtStore(riderStatusRequest)
    }

    override suspend fun getCurrentRiderStoreDetails(): Response<GenericResponseV2<GetStoreDetailsResponse>> {
        return saleApiService.getCurrentRiderStoreDetails()
    }

    override suspend fun getRiderOrdersCount(): Response<GenericResponseV2<RiderOrdersCountResponse>> {
        return saleApiService.getRiderOrdersCount()
    }

    override suspend fun getListRiderOrderV2(status: String): Response<GenericResponseV2<OrdersListResponseV2>> {
        return saleApiService.getListRiderOrderV2(status)
    }

    override suspend fun verifyRiderAssignment(verifyRiderAssignmentRequestV2: VerifyRiderAssignmentRequestV2): Response<GenericResponseV2<VerifyRiderAssignmentResponseV2>> {
        return saleApiService.verifyRiderAssignment(verifyRiderAssignmentRequestV2)
    }

    override suspend fun validateRiderAtStore(validateRiderAtStoreRequest: ValidateRiderAtStoreRequest): Response<GenericResponseV2<ValidateRiderAtStoreResponse>> {
        return saleApiService.validateRiderAtStore(validateRiderAtStoreRequest)
    }

    override suspend fun markInRider(
        latitude: RequestBody,
        longitude: RequestBody,
        image: MultipartBody.Part?
    ): Response<RiderStatusResponse> {
        return attendanceApiService.markInRider(latitude, longitude, image)
    }

    override suspend fun markOutRider(riderStatusRequest: RiderStatusRequest): Response<RiderStatusResponse> {
        return attendanceApiService.markOutRider(riderStatusRequest)
    }

    override suspend fun createPaymentQR(request: PaymentRequest): Response<CreatePaymentQrResponse> {
        return paymentApiService.createPaymentQR(request)
    }

    override suspend fun getPaymentStatus(request: PaymentRequest): Response<CreatePaymentQrResponse> {
        return paymentApiService.getPaymentStatus(request)
    }

    override suspend fun cancelPayment(request: PaymentRequest): Response<GenericResponse> {
        return paymentApiService.cancelPayment(request)
    }

    override suspend fun getPaymentMethods(
        storeId: Int,
        qrEnabled: Boolean
    ): Response<List<PaymentModeResponse>> {
        return paymentApiService.getPaymentMethods(storeId, qrEnabled)
    }

    override suspend fun getRiderPendingCashStoreLevel(requestBody: RiderPendingCashRequest): Response<GenericResponseV2<RiderCashDepositStoreLevelResponse>> {
        return riderCashCollectionApiService.getRiderPendingCashStoreLevel(requestBody)
    }

    override suspend fun getPaginatedRiderPendingCash(requestBody: RiderPendingCashRequest): Response<GenericResponseV2<List<RiderPendingDepositResponse>>> {
        return riderCashCollectionApiService.getPaginatedRiderPendingCash(requestBody)
    }

    override suspend fun getRiderPayoutTotal(
        riderId: Int,
        startDate: String,
        endDate: String
    ): Response<GenericResponseV2<PayoutTotalDetailsResponse>> {
        return riderCashCollectionApiService.getRiderPayoutTotal(
            riderId = riderId,
            startDate = startDate,
            endDate = endDate
        )
    }

    override suspend fun getRiderPayoutDetails(
        riderId: Int,
        startDate: String,
        endDate: String,
        pageNo: Int,
        limit: Int
    ): Response<GenericResponseV2<List<DateWiseDataResponse>>> {
        return riderCashCollectionApiService.getRiderPayoutDetails(
            riderId = riderId,
            startDate = startDate,
            endDate = endDate,
            pageNo = pageNo,
            limit = limit
        )
    }

    override suspend fun getRiderInHandCashDetails(riderId: Int): Response<GenericResponseV2<RiderInHandCashDetailsResponse>> {
        return riderCashCollectionApiService.getRiderInHandCashDetails(riderId)
    }

    override suspend fun getOperatedStores(active: Int): Response<List<FranchiseeStoreResponse>> {
        return consumerAuthApiService.getOperatedStores(active)
    }

    override suspend fun uploadOrderDeliveryImage(
        orderId: Int,
        image: MultipartBody.Part?,
        imageType: RequestBody
    ): Response<GenericResponseV2<UploadOrderDeliveryImageResponse>> {
        return saleApiService.uploadOrderDeliveryImage(orderId, image, imageType)
    }

    override suspend fun deleteOrderDeliveryImage(
        imageId: Int
    ): Response<GenericResponseV2<GenericResponse>> {
        return saleApiService.deleteOrderDeliveryImage(imageId)
    }

    override suspend fun getOrderDeliveryImage(
        orderId: Int,
        imageType: String
    ): Response<GenericResponseV2<GetOrderDeliveryImageListResponse>> {
        return saleApiService.getOrderDeliveryImage(orderId, imageType)
    }

    override suspend fun sendOtp(sendOtpRequest: SendOtpRequest): Response<SendOtpResponse> {
        return consumerAuthApiService.sendOtp(sendOtpRequest)
    }

    override suspend fun verifyOtp(verifyOtpRequest: VerifyOtpRequest): Response<AuthResponse> {
        return consumerAuthApiService.verifyOtp(verifyOtpRequest)
    }

    override suspend fun getCities(): Response<GenericResponseV2<CityListResponse>> {
        return onboardingApiService.getCities()
    }

    override suspend fun createUpdateOnboardingData(onboardingRequest: OnboardingRequest): Response<GenericResponseV2<GenericResponse>> {
        return onboardingApiService.createUpdateOnboardingData(onboardingRequest)
    }

    override suspend fun getKycDetails(): Response<GenericResponseV2<RiderKycResponse>> {
        return onboardingApiService.getKycDetails()
    }

    override suspend fun updateProfile(
        userId: Int,
        updateProfileRequest: UpdateProfileRequest
    ): Response<UserData> {
        return consumerAuthApiService.updateProfile(userId, updateProfileRequest)
    }

}
