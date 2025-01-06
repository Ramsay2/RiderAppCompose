package com.apnamart.apnarider.data.http.response.rider_orders.order_list

import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.ProductResponse
import com.google.gson.annotations.SerializedName

data class RiderOrderListResponse(
    @SerializedName("allocated_orders") var allocatedOrders: List<AllocatedOrdersResponse>? = listOf()
)


data class AllocatedOrdersResponse(
    @SerializedName("order_details") var orderDetails: OrderDetailsResponse? = null,
    @SerializedName("customer_details") var customerDetails: CustomerDetailsResponse? = null,
    @SerializedName("store_details") var storeDetails: StoreDetailsResponse? = null,
    @SerializedName("product_details") var productDetails: List<ProductResponse>? = null,
)

data class OrderDetailsResponse(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("bill_id") var billId: Int? = null,
    @SerializedName("order_number") var orderNumber: String? = null,
    @SerializedName("new_model_eta") var eta: String? = null,
    @SerializedName("delivery_status") var deliveryStatus: String? = null,
    @SerializedName("status_tag") var statusTag: String? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("bill_no") var billNo: String? = null,
    @SerializedName("verification_code") val otp : String? = null,
    @SerializedName("amount") var amount: Double? = null,
    @SerializedName("payment_method") var paymentMethod: String? = null,
    @SerializedName("payment_tag") var paymentTag: String? = null,
    @SerializedName("ordered_at") var orderAt: String? = null,
    @SerializedName("city") var city: String? = null,
    @SerializedName("is_v3_enabled") var isV3ModelEnabled: Boolean,
    @SerializedName("payment_status_tag") var paymentStatusTag: String? = null,
    @SerializedName("txn_id") var txnId: String? = null,
    @SerializedName("reached_destination_radius") var reachedDestinationRadius: Double? = null,
    @SerializedName("take_photo_on_delivery") var takePhotoOnDelivery: Boolean? = false,
)

data class CustomerDetailsResponse(
    @SerializedName("name") var name: String? = null,
    @SerializedName("address") var address: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("latitude") var latitude: Double? = null,
    @SerializedName("longitude") var longitude: Double? = null,
    @SerializedName("city") var customerCity: String? = null,

)

data class StoreDetailsResponse(
    @SerializedName("name") var name: String? = null,
    @SerializedName("id") var id: Int? = null,
    @SerializedName("address") var address: String? = null,
    @SerializedName("latitude") var latitude: Double? = null,
    @SerializedName("longitude") var longitude: Double? = null,
    @SerializedName("rider_cash_collection") var riderCashCollection: Boolean = false,
)

data class OrderTimingResponse(
    @SerializedName("eta") val eta: String? = null,
    @SerializedName("order_at") val orderAt: String? = null,
    @SerializedName("updated_at") val updatedAt: String? = null,
    @SerializedName("delivered_at") val deliveredAt: String? = null,
    @SerializedName("packed_at") val packedAt: String? = null
)