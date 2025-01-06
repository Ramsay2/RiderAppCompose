package com.apnamart.apnarider.domain.rider_transaction.entity


data class RiderPendingDepositDomain(
    val month: String,
    val storeName: String,
    val deliveredAt: String,
    val cash: Double,
    val orderNumber: String
)
