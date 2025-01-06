package com.apnamart.apnarider.domain.rider_order.entity.order_list_v2

data class PickingTimerConfigDomain(
    val enable : Boolean,
    val pickingTime : Int,
    val cardColorBackground : String,
    val cardTextColor : String
)
