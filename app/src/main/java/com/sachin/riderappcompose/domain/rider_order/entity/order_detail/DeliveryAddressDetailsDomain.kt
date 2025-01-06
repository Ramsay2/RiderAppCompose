package com.apnamart.apnarider.domain.rider_order.entity.order_detail


data class DeliveryAddressDetailsDomain(

    var addressName: String? = null,
    var state: String? = null,
    var city: String? = null,
    var phone: String? = null,
    var pinCode: String? = null,
    var latitude: Double,
    var longitude: Double,
    var landmark: String? = null,
    var userAddress: String? = null,
    var fullAddress: String? = null,
    var otherAddressDetails: String? = null,
    var contactPerson: String? = null,
    var country: String? = null,
    var countryCode: String? = null

)