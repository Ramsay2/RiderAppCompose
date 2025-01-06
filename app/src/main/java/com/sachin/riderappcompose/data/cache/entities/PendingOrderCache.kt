package com.sachin.riderappcompose.data.cache.entities


import java.util.Date


data class PendingOrderCache (
    var id: Int,
    var orderId: String,
    var statusTag: String,
    var delStatusTag: String? = null,
    var deliveryAgent: Int,
    var delMode: String,
    var storeOpenTime: String? = null,
    var closeTime: String? = null,
    var orderAt: Date? = null,
    var eta: Date? = null
)
