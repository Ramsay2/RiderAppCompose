package com.example.navigationmodule.presentation.ui.components.avatars

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Avatar(
    @DrawableRes
    res: Int,
    size: Dp,
    iconColor: Color,
    backgroundColor: Color,
    onClick: () -> Unit
) {

    Icon(
        modifier = Modifier
            .clip(CircleShape)
            .size(size)
            .background(color = backgroundColor)
            .padding(all = 12.dp)
            .clickable {
                onClick()
            },
        painter = painterResource(res),
        contentDescription = null,
        tint = iconColor
    )

}