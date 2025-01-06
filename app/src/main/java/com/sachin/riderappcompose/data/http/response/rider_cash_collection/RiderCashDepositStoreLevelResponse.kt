package com.apnamart.apnarider.data.http.response.rider_cash_collection

import com.google.gson.annotations.SerializedName

data class RiderCashDepositStoreLevelResponse(
    @SerializedName("store_cash_collection")
    val storeCashCollection: List<StoreCashCollectionResponse>? = null,
    @SerializedName("total_cash")
    val totalCash: Double? = null
)

data class StoreCashCollectionResponse(
    @SerializedName("store_id")
    val storeId: Int? = null,
    @SerializedName("store_name")
    val storeName: String? = null,
    @SerializedName("total_cash_amount")
    val totalCashAmount: Double? = null,
    @SerializedName("hour")
    val hour: String? = null,
    @SerializedName("approved_by")
    val approvedBy: List<String>? = null,
)
