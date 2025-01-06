package com.apnamart.apnarider.domain.onboarding.entity

import com.sachin.riderappcompose.R

data class VehicleEntity(
    val name: String,
    val code: String,
    val licenseRequired: Boolean,
    val icon: Int,
    var isSelected: Boolean = false
)

val vehicleList = mutableListOf(
    VehicleEntity(
        name = "Motorcycle",
        code = "Motorcycle",
        licenseRequired = true,
        icon = R.drawable.ic_launcher_background
    ),
    VehicleEntity(
        name = "Electric Scooter",
        code = "E-Scooter",
        licenseRequired = true,
        icon = R.drawable.ic_launcher_background
    ),
    VehicleEntity(
        name = "Bicycle",
        code = "Bicycle",
        licenseRequired = false,
        icon = R.drawable.ic_launcher_background
    )
)