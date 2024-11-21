package com.zomato.sushi.compose.foundation

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

@ExperimentalSushiApi
@Immutable
data class SushiDimension(
    val spacing: Spacing = Spacing(),
    val cornerRadius: Dp = SushiCornerRadius
) {

    data class Spacing(
        val femto: Dp = SushiSpacingFemto,
        val pico: Dp = SushiSpacingPico,
        val nano: Dp = SushiSpacingNano,
        val micro: Dp = SushiSpacingMicro,
        val mini: Dp = SushiSpacingMini,
        val macro: Dp = SushiSpacingMacro,
        val base: Dp = SushiSpacingBase,
        val extra: Dp = SushiSpacingExtra,
        val loose: Dp = SushiSpacingLoose,
        val alone: Dp = SushiSpacingAlone,
        val pageSide: Dp = SushiSpacingPageSide,
        val between: Dp = SushiSpacingBetween,
        val betweenLarge: Dp = SushiSpacingBetweenLarge,
        val betweenSmall: Dp = SushiSpacingBetweenSmall
    )

}