package com.apnamart.apnarider.domain.rider_order.entity.order_detail


data class ProductDomain(
    val productId: Int,
    val mainImage: String,
    val displayName: String,
    val isHighValueItem: Boolean,
)