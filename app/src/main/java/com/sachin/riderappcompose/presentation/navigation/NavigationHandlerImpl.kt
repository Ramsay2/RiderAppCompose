package com.example.navigationmodule.presentation.navigation

import androidx.navigation.NavHostController


class NavigationHandlerImpl(
    override val navController: NavHostController
) : NavigationHandler {

    override fun navigateToScreen(screen: Screens) {
        navController.navigate(screen)
    }

    override fun popBackStack() {
        navController.popBackStack()
    }
}
