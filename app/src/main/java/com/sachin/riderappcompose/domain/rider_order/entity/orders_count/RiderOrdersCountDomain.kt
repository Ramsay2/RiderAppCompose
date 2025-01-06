package com.apnamart.apnarider.domain.rider_order.entity.orders_count

data class RiderOrdersCountDomain(
    val confirmOrderCount : Int,
    val pendingOrderCount : Int,
    val pendingReturnOrderCount : Int

)
