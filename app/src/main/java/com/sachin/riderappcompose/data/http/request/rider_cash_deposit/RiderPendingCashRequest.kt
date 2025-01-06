package com.apnamart.apnarider.data.http.request.rider_cash_deposit


import com.google.gson.annotations.SerializedName

data class RiderPendingCashRequest(
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("date_from")
    val dateFrom: String? = null,
    @SerializedName("date_to")
    val dateTo: String? = null,
    @SerializedName("group_by")
    val groupBy: String? = null,
    @SerializedName("limit")
    val limit: Int? = null,
    @SerializedName("page_no")
    val pageNo: Int? = null,
    @SerializedName("store_id")
    val storeId: Int? = null
)