package com.sachin.riderappcompose.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.sachin.riderappcompose.R

// Define custom colors and font family
val InterMedium = FontFamily(Font(R.font.inter_medium))
val InterSemiBold = FontFamily(Font(R.font.inter_semibold))
val InterBold = FontFamily(Font(R.font.inter_bold))
val InterRegular = FontFamily(Font(R.font.inter))

// Define custom typography
val MyTypography = Typography(
    // Title styles
    titleLarge = TextStyle(
        fontFamily = InterMedium,
        fontSize = 24.sp,
        color = AppColor.ColorTextAndIconsHighEmphasis,
        letterSpacing = (-0.01).sp
    ),

    titleMedium = TextStyle(
        fontFamily = InterSemiBold,
        fontSize = 14.sp,
        color = AppColor.ColorTextAndIconsHighEmphasis
    ),

    // Headings styles
    headlineLarge = TextStyle(
        fontFamily = InterSemiBold,
        fontSize = 20.sp,
        color = AppColor.ColorTextAndIconsHighEmphasis,
        letterSpacing = (-0.01).sp
    ),

    headlineMedium = TextStyle(
        fontFamily = InterSemiBold,
        fontSize = 18.sp,
        color = AppColor.ColorTextAndIconsHighEmphasis,
        letterSpacing = (-0.01).sp
    ),

    headlineSmall = TextStyle(
        fontFamily = InterMedium,
        fontSize = 16.sp,
        color = AppColor.ColorTextAndIconsHighEmphasis,
        letterSpacing = (-0.01).sp
    ),

    // Body styles
    bodyLarge = TextStyle(
        fontFamily = InterRegular,
        fontSize = 16.sp,
        color = AppColor.ColorTextAndIconsHighEmphasis,
        letterSpacing = (-0.01).sp
    ),

    bodyMedium = TextStyle(
        fontFamily = InterRegular,
        fontSize = 14.sp,
        color = AppColor.ColorTextAndIconsHighEmphasis
    ),

    bodySmall = TextStyle(
        fontFamily = InterRegular,
        fontSize = 12.sp,
        color = AppColor.ColorTextAndIconsHighEmphasis
    ),

    labelSmall = TextStyle(
        fontFamily = InterMedium,
        fontSize = 12.sp,
        color = AppColor.ColorTextAndIconsHighEmphasis
    ),

    labelMedium = TextStyle(
        fontFamily = InterRegular,
        fontSize = 10.sp,
        color = AppColor.ColorTextAndIconsHighEmphasis
    ),

    // Button text styles
    labelLarge = TextStyle(
        fontFamily = InterSemiBold,
        fontSize = 16.sp,
        letterSpacing = 0.sp,
        color = AppColor.ColorTextAndIconsHighEmphasis
    ),

    // Number text styles
    displayLarge = TextStyle(
        fontFamily = InterSemiBold,
        fontSize = 24.sp,
        color = AppColor.ColorTextAndIconsHighEmphasis,
        letterSpacing = (-0.04).sp
    ),

    displayMedium = TextStyle(
        fontFamily = InterBold,
        fontSize = 18.sp,
        color = AppColor.ColorTextAndIconsHighEmphasis,
        letterSpacing = (-0.03).sp
    ),

    displaySmall = TextStyle(
        fontFamily = InterMedium,
        fontSize = 18.sp,
        color = AppColor.ColorTextAndIconsHighEmphasis,
        letterSpacing = (-0.03).sp
    )
)

val ButtonLarge = TextStyle(
    fontFamily = InterSemiBold,
    fontSize = 16.sp,
    letterSpacing = 0.sp,
    color = AppColor.ColorTextAndIconsHighEmphasis
)

val ButtonMedium = TextStyle(
    fontFamily = InterSemiBold,
    fontSize = 14.sp,
    letterSpacing = 0.sp,
    color = AppColor.ColorTextAndIconsHighEmphasis
)

val ButtonSmall = TextStyle(
    fontFamily = InterSemiBold,
    fontSize = 12.sp,
    letterSpacing = 0.sp,
    color = AppColor.ColorTextAndIconsHighEmphasis
)
