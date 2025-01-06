package com.example.navigationmodule.presentation.ui.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.navigationmodule.presentation.ui.theme.colorPrimary500

@Composable
fun RoundedCornersButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    textStyle: TextStyle,
    onClick: () -> Unit,
    enabled: Boolean = true,
    cornerSize: Dp = 12.dp,
    contentPadding: PaddingValues = PaddingValues(all = 12.dp),
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    borderStroke: BorderStroke? = null,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    iconSize: Dp? = null
) {

    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(cornerSize),
        contentPadding = contentPadding,
        colors = colors,
        border = borderStroke,
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            if (leadingIcon != null && iconSize != null) {
                Icon(
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .size(iconSize),
                    imageVector = leadingIcon,
                    contentDescription = null,
                )
            }
            if (text != null) {
                Text(text, style = textStyle)
            }
            if (trailingIcon != null && iconSize != null) {
                Icon(
                    modifier = Modifier
                        .padding(start = 6.dp)
                        .size(iconSize),
                    imageVector = trailingIcon,
                    contentDescription = null,
                )
            }

        }

    }

}

@Preview
@Composable
private fun RoundedCornerButtonPreview() {
    RoundedCornersButton(
        modifier = Modifier.fillMaxWidth(),
        text = "Share Link",
        textStyle = MaterialTheme.typography.bodyMedium,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = colorPrimary500
        ),
        onClick = {},
        enabled = true,
        cornerSize = 12.dp,
        contentPadding = PaddingValues(16.dp),
        leadingIcon = Icons.Default.KeyboardArrowRight,
        trailingIcon = Icons.Default.KeyboardArrowRight,
        iconSize = 20.dp
    )
}