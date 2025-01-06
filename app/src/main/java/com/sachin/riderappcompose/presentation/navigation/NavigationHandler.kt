package com.example.navigationmodule.presentation.navigation

import androidx.navigation.NavController

interface NavigationHandler {
    val navController: NavController
    fun navigateToScreen(screen: Screens)
    fun popBackStack()
}
