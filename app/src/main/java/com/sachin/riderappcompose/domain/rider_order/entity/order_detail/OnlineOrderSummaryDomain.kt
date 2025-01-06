package com.apnamart.apnarider.domain.rider_order.entity.order_detail

data class OnlineOrderSummaryDomain(
    val handoverBreached: List<String>?,
    val orderCount: OrderCountDomain?,
    val pickingBreached: List<String>?,
    val deliveryBreached: List<String>?
)

data class OrderCountDomain(
    val confirmedCount: Int,
    val packedCount: Int,
    val placedCount: Int
)