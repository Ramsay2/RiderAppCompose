package com.apnamart.apnarider.data.http.response.onboarding

import com.google.gson.annotations.SerializedName

data class CityResponse(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("code")
    val code: String? = null
)

data class CityListResponse(
    @SerializedName("cities")
    val cities: List<CityResponse>
)