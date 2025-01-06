package com.apnamart.apnarider.data.http.response.payout_details

import com.google.gson.annotations.SerializedName


data class DateWiseDataResponse(
    @SerializedName("earnings")
    val earnings : Double? = null,
    @SerializedName("order_count")
    val orderCount : Int? = null,
    @SerializedName("login_hours")
    val loginHours : String? = null,
    @SerializedName("date")
    val date : String? = null,
    @SerializedName("payout_breakdown")
    val payoutBreakup : List<PayoutBreakdownResponse>? = null

)

data class PayoutBreakdownResponse(
    @SerializedName("icon")
    val iconUrl: String? = null,
    @SerializedName("payout_type_id")
    val payoutTypeId: Int? = null,
    @SerializedName("payout_type_name")
    val payoutTypeName: String? = null,
    @SerializedName("amount")
    val value: Double? = null
)

