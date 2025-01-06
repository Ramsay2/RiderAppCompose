package com.apnamart.apnarider.data.http.response.rider_orders.order_list_v2

import com.google.gson.annotations.SerializedName

data class OrdersListResponseV2(

    @SerializedName("orders")
    val orders : List<OrderResponseV2>? = null
)
data class OrderResponseV2(

    @SerializedName("order_id")
    val orderId : Int? = null,

    @SerializedName("customer_name")
    val  customerName: String? = null,

    @SerializedName("customer_address")
    val customerAddress : String? = null,

    @SerializedName("no_of_items")
    val noOfItems : Int? = null,

    @SerializedName("bill_id")
    val billId: Int? = null,

    @SerializedName("bill_no")
    val billNo : String? = null,

    @SerializedName("heading")
    val heading : String? = null,

    @SerializedName("sub_heading")
    val subHeading : String? = null,

    @SerializedName("delivery_mode_string")
    val deliveryModeString : String? = null,

    @SerializedName("delivery_status_tag")
    val deliveryStatusTag : String? = null,

    @SerializedName("delivery_status")
    val deliveryStatus : String? = null,

    @SerializedName("is_rush")
    val isRush : Boolean? = null,

    @SerializedName("show_customer_address")
    val showCustomerAddress : Boolean? = null,

    @SerializedName("order_status_tag")
    val orderStatusTag : String? = null,

    @SerializedName("order_status")
    val orderStatus : String? = null,

)
