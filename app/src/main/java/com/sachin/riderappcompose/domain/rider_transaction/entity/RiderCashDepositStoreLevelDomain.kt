package com.apnamart.apnarider.domain.rider_transaction.entity


data class RiderCashDepositStoreLevelDomain(
    val storePendingCash: List<StorePendingCashDomain>,
    val totalPendingCash: Double
)

data class StorePendingCashDomain(
    val totalCashAmount: Double,
    val storeId: Int,
    val storeName: String,
    val hour : String,
    val approvedBy : List<String>
)
