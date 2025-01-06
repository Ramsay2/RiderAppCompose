package com.apnamart.apnarider.data.http.request.sale.verify_rider_assignment

import com.google.gson.annotations.SerializedName

data class VerifyRiderAssignmentRequestV2(
    @SerializedName("order_id") val orderId : Int
)
