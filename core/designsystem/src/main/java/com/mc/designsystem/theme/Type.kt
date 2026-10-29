package com.mc.designsystem.theme


import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight



data class MonkeyTypoGraphy(
    val display: TextStyle,
    val header: TextStyle,
    val title: TextStyle,
    val subTitle: TextStyle,
    val body: TextStyle,
    val label: TextStyle,
    val caption: TextStyle,
    val buttonLarge: TextStyle,
    val buttonMedium: TextStyle,
    val buttonSmall: TextStyle,
)

val DefaultTypography = MonkeyTypoGraphy(
    display = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),

    header = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),

    title = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),

    subTitle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),

    body = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),

    label = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),

    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),

    buttonLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),

    buttonMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),

    buttonSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),


    )

val LocalSimpleMonkeyTypography = staticCompositionLocalOf {
    DefaultTypography
}

@Composable
fun rememberMonkeyTypography(ds: MonkeySize): MonkeyTypoGraphy {
    val density = LocalDensity.current
    return remember(ds, density) {
        with(density) {
            MonkeyTypoGraphy(
                display = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = ds.fontDisplay.toSp()
                ),
                header = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = ds.fontHeader.toSp()
                ),
                title = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = ds.fontTitle.toSp()
                ),
                subTitle = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    fontSize = ds.fontSubTitle.toSp(),
                    lineHeight = (ds.fontSubTitle * 1.4f).toSp()
                ),
                body = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    fontSize = ds.fontBody.toSp(),
                    lineHeight = (ds.fontBody * 1.4f).toSp()
                ),
                label = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    fontSize = ds.fontLabel.toSp()
                ),
                caption = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    fontSize = ds.fontCaption.toSp()
                ),
                buttonLarge = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium,
                    fontSize = ds.fontButtonLarge.toSp()
                ),
                buttonMedium = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium,
                    fontSize = ds.fontButtonMedium.toSp()
                ),
                buttonSmall = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium,
                    fontSize = ds.fontButtonSmall.toSp()
                ),
            )
        }
    }
}

val LocalMonkeyTypography = staticCompositionLocalOf<MonkeyTypoGraphy> {
    error("MonkeyTypography not provided")
}