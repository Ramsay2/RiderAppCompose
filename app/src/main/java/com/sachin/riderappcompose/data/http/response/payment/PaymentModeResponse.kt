package com.apnamart.apnarider.data.http.response.payment

import com.google.gson.annotations.SerializedName

data class PaymentModeResponse(
    @SerializedName("id") var id: Int,
    @SerializedName("priority") var priority: Int,
    @SerializedName("active") var active: Boolean,
    @SerializedName("tag_name") var tagName: String,
    @SerializedName("name") var name: String?,
    @SerializedName("display_name") var displayName: String?,
    @SerializedName("help_text") var helpText: String?,
    @SerializedName("applicable_list") var applicableList: List<String>?,
    @SerializedName("logo") var logo: String?,
    @SerializedName("razorpay_key") var razorPayKey: String?,
    @SerializedName("paytm_mid") var paytmMid: String?
)