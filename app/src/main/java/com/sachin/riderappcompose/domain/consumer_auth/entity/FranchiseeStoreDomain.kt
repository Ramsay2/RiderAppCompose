package com.apnamart.apnarider.domain.consumer_auth.entity


data class FranchiseeStoreDomain(
    var id: Int,
    var name: String? = null,
    var tagName: String? = null,
    var storeOpen: Boolean = false,
    var latitude: Double,
    var longitude: Double,
    var address: String? = null,
    var landmark: String? = null,
    var pinCode: String? = null,
    var city: String? = null,
    var state: String? = null
)
