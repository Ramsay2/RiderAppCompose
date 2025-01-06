package com.apnamart.apnarider.domain.rider_order.entity.order_detail

data class OrderDeliveryImageDomain(
    val id: Int,
    val url: String
)

data class GetOrderDeliveryImageListDomain(
    val imageList: List<OrderDeliveryImageDomain>?
)

object DeliveryImageType {
    const val BAG = "bag"
    const val PRODUCT = "product"
}