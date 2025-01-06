package com.apnamart.apnarider.domain.rider_order.entity.order_detail


data class RiderOrderProductDomain(

    var productId: Int,
    var name: String? = null,
    var mrp: Double,
    var itemCode: Int,
    var barCodes: List<String> = listOf(),
    var sellingPrice: Double,
    var orderQty: Int,
    var imageUrl: String? = null

)