package com.sachin.riderappcompose.presentation.navigation.nav

import kotlinx.serialization.Serializable

sealed interface Destination {
    @Serializable
    data object AuthScreen : Destination
}