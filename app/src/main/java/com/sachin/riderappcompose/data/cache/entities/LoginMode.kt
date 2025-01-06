package com.sachin.riderappcompose.data.cache.entities

enum class LoginMode(val value: Int) {
    FIREBASE(1),
    MOBILE(2),
    USERNAME(3),
    LOGGED_OUT(-1)

}

