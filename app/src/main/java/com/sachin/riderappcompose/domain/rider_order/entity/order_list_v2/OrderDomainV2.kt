package com.apnamart.apnarider.domain.rider_order.entity.order_list_v2

import com.apnamart.apnarider.domain.rider_order.entity.order_list.DeliveryStatus

data class OrderListDomainV2(
    val orderListV2 : List<OrderDomainV2>
)

data class OrderDomainV2(
    val orderId : Int,
    val  customerName: String,
    val customerAddress : String,
    val noOfItems : Int,
    val billId: Int,
    val billNo : String,
    val heading : String,
    val subHeading : String,
    val deliveryModeString : String,
    val deliveryStatus : String,
    val orderStatusTag : String,
    val orderStatus : String,
    val isRush : Boolean,
    val deliveryStatusTag: DeliveryStatus,
    val showCustomerAddress : Boolean
)
