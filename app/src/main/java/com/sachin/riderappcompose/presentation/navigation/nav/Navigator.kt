package com.sachin.riderappcompose.presentation.navigation.nav

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.flow.Flow


interface Navigator {
    val startDestination: Destination
    val navigationActions: Flow<NavigationAction>

    suspend fun navigate(
        destination: Destination,
        navOptions: NavOptionsBuilder.() -> Unit = {}
    )

    suspend fun navigateUp()
}


