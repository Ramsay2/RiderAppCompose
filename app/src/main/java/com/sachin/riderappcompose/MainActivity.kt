package com.sachin.riderappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.navigationmodule.presentation.navigation.SetUpNavGraph
import com.sachin.riderappcompose.presentation.theme.RiderAppComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RiderAppComposeTheme {
                val navController = rememberNavController()
                SetUpNavGraph(
                    navController = navController
                )
            }
        }
    }
}
