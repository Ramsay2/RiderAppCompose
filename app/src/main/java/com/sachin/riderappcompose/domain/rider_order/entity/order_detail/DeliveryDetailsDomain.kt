package com.apnamart.apnarider.domain.rider_order.entity.order_detail


data class DeliveryDetailsDomain(

    var mode: String? = null,
    var pickUp: Boolean? = null,
    var homeDelivery: Boolean? = null,
    var slugName: String? = null,
    var id: Int? = null,

)