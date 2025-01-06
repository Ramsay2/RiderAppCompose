package com.apnamart.apnarider.domain.rider_order.entity.order_detail

import com.apnamart.apnarider.domain.rider_order.entity.order_list.OrderTimingsDomain


data class RiderOrderDetailDomain(
    val deliveredIn : Long,
    var id: Int,
    var orderId: String? = null,
    var orderNumber: String? = null,
    var profile: Int? = null,
    var customerPhone: String? = null,
    var customerName: String? = null,
    var statusTag: String? = null,
    var delTag: String? = null,
    var status: String? = null,
    var delStatus: String? = null,
    var deliveryAddressDetails: DeliveryAddressDetailsDomain? = null,
    var paymentDetails: PaymentDetailsDomain? = null,
    var pickupAddressDetails: PickupAddressDetailsDomain? = null,
    var orderTimings: OrderTimingsDomain? = null,
    var instructions: InstructionsDomain? = null,
    var deliveryDetails: DeliveryDetailsDomain? = null
)