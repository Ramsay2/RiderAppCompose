package com.apnamart.apnarider.domain.rider_order.entity.order_detail


data class PaymentDetailsDomain(

    var orderAmount: Double,
    var totalAmount: Double,
    var billedAmount: Double,
    var deliveryCharges: Double,
    var savings: Double,
    var name: String? = null,
    var tagName: String? = null

)