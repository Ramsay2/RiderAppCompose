package com.apnamart.apnarider.domain.onboarding.entity

data class CityEntity(
    val id: Int? = null,
    val name: String? = null,
    val code: String? = null,
    var isSelected: Boolean = false
)