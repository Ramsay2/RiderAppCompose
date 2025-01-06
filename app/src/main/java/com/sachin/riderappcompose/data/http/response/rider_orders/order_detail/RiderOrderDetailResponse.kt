package com.apnamart.apnarider.data.http.response.rider_orders.order_detail

import com.apnamart.apnarider.data.http.response.rider_orders.order_list.OrderTimingResponse
import com.google.gson.annotations.SerializedName


data class RiderOrderDetailResponse(

    @SerializedName("id") val id: Int,
    @SerializedName("delivered_in") val deliveredIn: Long,
    @SerializedName("order_id") val orderId: String,
    @SerializedName("order_number") val orderNumber: String? = null,
    @SerializedName("profile") val profile: Int,
    @SerializedName("customer_phone") val customerPhone: String? = null,
    @SerializedName("customer_name") val customerName: String? = null,
    @SerializedName("status_tag") val statusTag: String? = null,
    @SerializedName("del_tag") val delTag: String? = null,
    @SerializedName("status") val status: String? = null,
    @SerializedName("del_status") val delStatus: String? = null,
    @SerializedName("offer_code") val offerCode: String? = null,
    @SerializedName("delivery_address_details") val deliveryAddressDetails: DeliveryAddressDetailsResponse? = null,
    @SerializedName("payment_details") val paymentDetails: PaymentDetailsResponse? = null,
    @SerializedName("pickup_address_details") val pickupAddressDetails: PickupAddressDetailsResponse? = null,
    @SerializedName("order_timings") val orderTimings: OrderTimingResponse? = null,
    @SerializedName("instructions") val instructions: InstructionsResponse? = null,
    @SerializedName("delivery_details") val deliveryDetails: DeliveryDetailsResponse? = null,
)