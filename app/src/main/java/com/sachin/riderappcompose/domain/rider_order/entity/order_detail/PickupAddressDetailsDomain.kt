package com.apnamart.apnarider.domain.rider_order.entity.order_detail

data class PickupAddressDetailsDomain(

    var storeId: Int,
    var storeName: String? = null,
    var storeTag: String? = null,
    var latitude: Double,
    var longitude: Double,
    var address: String? = null,
    var city: String? = null,
    var pinCode: String? = null

)