package com.apnamart.apnarider.data.http.response.payout_details

import com.google.gson.annotations.SerializedName

data class PayoutTotalDetailsResponse(
    @SerializedName("total_earnings")
    val totalEarnings : Float? = null,
    @SerializedName("total_order_count")
    val totalOrderCount : Int? = null,
    @SerializedName("total_login_hours")
    val totalLoginHours : String? = null,
)
