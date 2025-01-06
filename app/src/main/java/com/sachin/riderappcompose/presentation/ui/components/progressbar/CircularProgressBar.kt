package com.example.navigationmodule.presentation.ui.components.progressbar

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import com.example.navigationmodule.presentation.ui.theme.colorPrimary500

@Composable
fun CircularProgressBar(
    modifier: Modifier = Modifier,
    color: Color = colorPrimary500,
) {

    CircularProgressIndicator(
        modifier = modifier,
        color = color,
        strokeCap = StrokeCap.Round,
    )

}