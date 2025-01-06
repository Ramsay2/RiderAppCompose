package com.sachin.riderappcompose.presentation.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch


@Composable
fun <VM : BaseViewModel> BaseCompose(
    viewModel: VM,
    content: @Composable (VM) -> Unit
) {

    SideEffect {
        viewModel.onCreate()
    }

    content(viewModel)

}

@Composable
fun BaseSnackBarHandler(
    message: String?
) {
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LaunchedEffect(message) {
                if (message != null) {
                    coroutineScope.launch {
                        snackBarHostState.showSnackbar(message)
                    }
                }
            }
        }
    }
}

