package com.sachin.riderappcompose.presentation.common_component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.apnamart.apnarider.core_app_framework.logger.AppLogger
import com.sachin.riderappcompose.presentation.theme.ButtonMedium
import com.sachin.riderappcompose.presentation.theme.AppColor.ColorAccentRed500
import com.sachin.riderappcompose.presentation.theme.AppColor.ColorPrimary500
import com.sachin.riderappcompose.presentation.theme.AppColor.ColorTextAndIconsWhite

@Composable
fun GenericButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    textStyle: TextStyle = ButtonMedium,
    containerColor: Color = ColorPrimary500,
    contentColor: Color = ColorTextAndIconsWhite,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    textColor: Color = ColorTextAndIconsWhite,
    border: BorderStroke? = BorderStroke(1.dp, containerColor.copy(alpha = 0.5f)),
    isLoading: Boolean = false,
    loaderColor: Color = ColorPrimary500,
    icon: ImageVector? = null,
    iconSpacing: Dp = 8.dp,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled && !isLoading,
        colors = ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor.copy(alpha = 0.5f),
            disabledContentColor = contentColor.copy(alpha = 0.5f)
        ),
        contentPadding = contentPadding,
        border = border,

        ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = loaderColor,
                modifier = Modifier.size(20.dp),
                strokeWidth = 2.dp
            )
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                if (icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "button icon",
                        modifier = Modifier.size(20.dp),
                        tint = contentColor
                    )
                }

                if (text.isNotEmpty()) {
                    Spacer(modifier = Modifier.width(iconSpacing)) // Spacing between icon and text
                    Text(
                        text = text,
                        style = textStyle,
                        color = textColor
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun ButtonPreview() {
    GenericButton(
        text = "Continue",
        enabled = true,
        containerColor = ColorAccentRed500,
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            AppLogger.error("button_clicked")
        }
    )
}