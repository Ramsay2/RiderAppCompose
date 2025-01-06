package com.apnamart.apnarider.domain.rider_transaction.entity


data class RiderInHandCashDetailsDomain(
    val hasReachedLimit: Boolean,
    val maxCashLimit: Double,
    val pendingCash: Double,
    val remainingLimit: Double,
    val cashCollectionLimitFlag: Boolean
)