package com.apnamart.apnarider.data.http.response.rider_cash_collection

import com.google.gson.annotations.SerializedName

data class RiderInHandCashDetailsResponse(
    @SerializedName("cash_collection_limit_data")
    val cashCollectionLimitData: CashCollectionLimitDataResponse?,
    @SerializedName("cash_collection_limit_flag")
    val cashCollectionLimitFlag: Boolean?
)

data class CashCollectionLimitDataResponse(
    @SerializedName("has_reached_limit")
    val hasReachedLimit: Boolean?,
    @SerializedName("max_cash_limit")
    val maxCashLimit: Double?,
    @SerializedName("pending_cash")
    val pendingCash: Double?,
    @SerializedName("remaining_limit")
    val remainingLimit: Double?
)
