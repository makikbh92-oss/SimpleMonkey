package com.mc.designsystem.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.*
//
//private const val DESIGN_WIDTH = 960f
//private const val DESIGN_HEIGHT = 600f

enum class PaddingReduceType { Left, Right, Both }

private const val DESIGN_WIDTH = 960f
private const val DESIGN_HEIGHT = 600f

private const val BASE_MIN = 0.9f   // 이보다 작아지지 않게
private const val BASE_MAX = 1.5f   // 이보다 커지지 않게
//private const val TABLET_BREAKPOINT = 600f
@Immutable
class MonkeySize(
    val widthCommon: Dp,
    val heightCommon: Dp,
    ratio: Float = widthCommon.value / heightCommon.value,
) {
    val base: Float = minOf(
        widthCommon.value / DESIGN_WIDTH,
        heightCommon.value / DESIGN_HEIGHT
    ).coerceIn(BASE_MIN, BASE_MAX)
//private val origin: Float =
//    if (widthCommon.value < TABLET_BREAKPOINT) widthCommon.value
//    else heightCommon.value * DESIGN_WIDTH / DESIGN_HEIGHT
//
//    // Flutter의 px1 (origin * 0.0022728 ≈ origin / 440)
//    val base: Float = origin / DESIGN_WIDTH
//
    val unit: Float = base * 4

    private fun b(v: Float) = (base * v).dp     // base 기준
    private fun u(v: Float) = (unit * v).dp     // unit 기준

    val ratioHalf: Float = ratio / 2

    val extendsGap = b(0.001f)
    val border = b(1.3f)

    // 폰트 (dp 기준 → 사용 시 dsSp() 또는 toSp 변환)
    val fontDisplay = b(27f)
    val fontHeader = b(21f)
    val fontTitle = b(19f)
    val fontSubTitle = b(18f)
    val fontBody = b(16f)
    val fontLabel = b(14f)
    val fontCaption = b(12f)
    val fontButtonLarge = b(17f)
    val fontButtonMedium = b(15f)
    val fontButtonSmall = b(13f)

    val spacing1 = b(1f)
    val spacing2 = b(2f)
    val spacing4 = u(1f)
    val spacing8 = u(2f)
    val spacing12 = u(3f)
    val spacing16 = u(4f)
    val spacing24 = u(6f)
    val spacing32 = u(8f)
    val spacing40 = u(10f)
    val spacing48 = u(12f)
    val spacing56 = u(14f)
    val spacing64 = u(16f)

    val tapSide = b(3f)

    val contentPadding17 = b(17f)
    val contentPadding15 = b(15f)

    val gapHorizontal = b(13f)
    val gapVertical = b(5f)
    val gap = b(11f)
    val gapAppbarTitle = b(5f)

    val icon = b(22f)
    val iconForm = u(5f)
    val radius = b(10f)
    val stethoscope = u(17f)

    val iconButtonArea = u(11f)
    val iconFormButtonArea = u(10f)
    val iconProfileButtonArea = u(9f)
    val iconFormText = u(7f)

    val primaryButtonNav = u(15f)
    val primaryButtonNormal = u(13f)
    val primaryButtonDialog = u(12f)

    val widgetLoading = u(7f)

    val thumbnailSmall = u(10f)
    val thumbnailMedium = u(16f)
    val thumbnailLarge = u(26f)

    val navbar = u(17f)

    val paddingDefault = PaddingValues(horizontal = u(6f), vertical = u(4f))
    val paddingScroll = PaddingValues(end = u(1f), bottom = u(12f))

    // Flutter의 paddingDefault.horizontal/2 에 해당 (한쪽 값)
    private val paddingDefaultHalf = u(6f)

    fun paddingWithButton(type: PaddingReduceType): PaddingValues = when (type) {
        PaddingReduceType.Both -> PaddingValues(
            horizontal = gapHorizontal,
            vertical = gapVertical
        )
        PaddingReduceType.Left -> PaddingValues(
            start = gapHorizontal,
            end = paddingDefaultHalf,
            top = gapVertical,
            bottom = gapVertical
        )
        PaddingReduceType.Right -> PaddingValues(
            start = paddingDefaultHalf,
            end = gapHorizontal,
            top = gapVertical,
            bottom = gapVertical
        )
    }
}

@Composable
fun rememberDsSize(): MonkeySize {
    val config = LocalConfiguration.current
    return remember (config.screenWidthDp, config.screenHeightDp) {
        MonkeySize(config.screenWidthDp.dp, config.screenHeightDp.dp)
    }
}


val LocalMonkeySize = compositionLocalOf<MonkeySize> { error("DsSize not provided") }