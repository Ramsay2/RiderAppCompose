package com.apnamart.apnarider.domain.rider_transaction.entity

data class DateWisePayoutDetailsDomain(
    val earnings : Double,
    val orderCount : Int,
    val loginHours : String,
    val date : String,
    val payoutBreakup : List<PayoutBreakdownDomain>
    
)

data class PayoutBreakdownDomain(
    val iconUrl: String,
    val payoutTypeId: Int,
    val payoutTypeName: String,
    val value: Double
)

