package com.mc.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider




@Composable
fun MonkeyTheme(
    colors: MonkeyColors = DefaultColorPalette,
    size: MonkeySize = rememberDsSize(),
    typography: MonkeyTypoGraphy = rememberMonkeyTypography(size),
    content: @Composable () -> Unit
)   {

    CompositionLocalProvider(
        LocalSimpleMonkeyColors provides colors,
        LocalMonkeyTypography provides typography,
        LocalMonkeySize provides size
    ){
        content()
    }
}

object AppTheme {
    val colors: MonkeyColors
        @Composable
        get() = LocalSimpleMonkeyColors.current

    val typography
        @Composable
        get() = LocalMonkeyTypography.current


    val size
        @Composable
        get() = LocalMonkeySize.current

}