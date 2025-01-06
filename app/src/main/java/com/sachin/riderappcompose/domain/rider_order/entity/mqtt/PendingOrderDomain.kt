package com.apnamart.apnarider.domain.rider_order.entity.mqtt

import java.util.Date

data class PendingOrderDomain (
    var id: Int,
    var orderId: String,
    var statusTag: String,
    var delStatusTag: String? = null,
    var deliveryAgent: Int,
    var delMode: String,
    var storeOpenTime: String,
    var closeTime: String,
    var orderAt: Date? = null,
    var eta: Date? = null
)