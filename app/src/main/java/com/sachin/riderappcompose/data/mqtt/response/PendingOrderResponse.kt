package com.apnamart.apnarider.data.mqtt.response

import com.google.gson.annotations.SerializedName


data class PendingOrderResponse(
    @SerializedName("id") var id: Int,
    @SerializedName("order_id") var orderId: String,
    @SerializedName("status_tag") var statusTag: String,
    @SerializedName("del_status_tag") var delStatusTag: String? = null,
    @SerializedName("delivery_agent") var deliveryAgent: Int,
    @SerializedName("del_mode") var delMode: String? = null,
    @SerializedName("store_open_time") var storeOpenTime: String? = null,
    @SerializedName("close_time") var closeTime: String? = null,
    @SerializedName("order_at") var orderAt: String? = null,
    @SerializedName("eta") var eta: String? = null
)