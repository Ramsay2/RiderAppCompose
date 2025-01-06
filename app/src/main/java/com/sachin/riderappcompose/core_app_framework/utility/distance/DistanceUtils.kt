package com.apnamart.apnarider.core_app_framework.utility.distance

import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.log10
import kotlin.math.sin

/**
 *
 */

fun distance(lat1: Double, lon1: Double, lat2: Double, lon2: Double, unit: Char): Double {
    val theta = lon1 - lon2
    var dist = sin(deg2rad(lat1)) * sin(deg2rad(lat2)) + cos(deg2rad(lat1)) * cos(deg2rad(lat2)) * cos(
        deg2rad(theta)
    )
    dist = acos(dist)
    dist = rad2deg(dist)
    dist *= 60 * 1.1515
    when (unit) {
        'M' -> dist *= 1609.344
        'K' -> dist *= 1.609344
        'N' -> dist *= 0.8684
    }
    return (dist)
}

fun deg2rad(deg: Double): Double {
    return (deg * Math.PI / 180.0)
}

fun rad2deg(rad: Double): Double {
    return (rad * 180.0 / Math.PI)
}

private fun getLength(number: Double): Int {
    return (log10(number.toInt().toDouble()) + 1).toInt()
}

fun Double.toFormattedDistance(): String {
    return when {
        getLength(this) <= 3 -> String.format("%.2f", this) + " mtr"
        getLength(this) in 4..6 -> String.format("%.2f", this / 1000) + " Km"
        else -> "Unknown"
    }
}
