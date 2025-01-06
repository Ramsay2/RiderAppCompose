package com.example.navigationmodule.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sachin.riderappcompose.presentation.auth_screen.AuthScreen

@Composable
fun SetUpNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.AuthScreen
    ) {

        composable<Screens.AuthScreen> {
            AuthScreen()

        }

    }
}