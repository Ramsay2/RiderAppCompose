package com.apnamart.apnarider.data.http.response
import com.google.gson.annotations.SerializedName



data class CustomerSupportDetailResponse(
    @SerializedName("customer_support_phone")
    val customerSupportPhone: String?,
    @SerializedName("whatsapp_link")
    val whatsappLink: String?
)