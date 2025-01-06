package com.apnamart.apnarider.core_app_framework.validations

import java.util.regex.Pattern

/**
 *
 */

val mobileNumberRegex = Regex("^[6789]\\d{9}\$")

fun String?.isMobileNumberValid(): Boolean {
    return this != null && mobileNumberRegex.matches(this)
}

fun String?.isPasswordValid(): Boolean {
    return this != null && this.isNotEmpty() && this.length > 7
}

fun String?.isOtpValid(): Boolean {
    return this != null && this.isNotEmpty() && this.length == 6
}

fun String?.isPinCodeValid(): Boolean {
    return this != null && this.isNotEmpty() && this.length == 6
}

fun String.isEmailValid(): Boolean {
    val pattern: Pattern = Pattern.compile(
            "[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.+[a-z]+")
    val matcher = pattern.matcher(this)

    return this.isNotEmpty() && matcher.matches()
}

