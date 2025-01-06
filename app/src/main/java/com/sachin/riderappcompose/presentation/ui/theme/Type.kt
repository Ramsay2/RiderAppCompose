package com.example.navigationmodule.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sachin.riderappcompose.R

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = interFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.35.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = interFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
)

val Typography.headingLg: TextStyle
    get() = TextStyle(
        fontFamily = interFontFamily(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 17.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.41).sp
    )

val Typography.heading2Xs: TextStyle
    get() = TextStyle(
        fontFamily = interFontFamily(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 9.sp,
        lineHeight = 11.sp,
        letterSpacing = 0.07.sp
    )

val Typography.headingSm: TextStyle
    get() = TextStyle(
        fontFamily = interFontFamily(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        lineHeight = 17.sp,
        letterSpacing = (-0.24).sp
    )

fun interFontFamily() = FontFamily(
    Font(R.font.inter, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold)
)