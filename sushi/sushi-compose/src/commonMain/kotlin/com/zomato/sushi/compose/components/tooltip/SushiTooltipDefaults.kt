package com.zomato.sushi.compose.components.tooltip

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupPositionProvider
import com.zomato.sushi.compose.components.tooltip.base.DefaultTooltipCaretShape
import com.zomato.sushi.compose.components.tooltip.base.TooltipPositionProviderImpl

@OptIn(ExperimentalMaterial3Api::class)
object SushiTooltipDefaults {

    fun caretShape() = DefaultCaretShape

    val noCaretShape: Shape = RoundedCornerShape(12.dp)

    val caretSize: DpSize = DpSize(16.dp, 8.dp)

    val containerShape = RoundedCornerShape(12.dp)

    internal val DefaultCaretShape: Shape = DefaultTooltipCaretShape(caretSize)

    val maxWidth: Dp
        @Composable get() {
            return LocalWindowInfo.current.containerDpSize.width * 0.8f
        }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun rememberTooltipPositionProvider(
        positioning: TooltipAnchorPosition,
        spacingBetweenTooltipAndAnchor: Dp = SpacingBetweenTooltipAndAnchor,
    ): PopupPositionProvider {
        val tooltipAnchorSpacing =
            with(LocalDensity.current) { spacingBetweenTooltipAndAnchor.roundToPx() }
        return remember(tooltipAnchorSpacing, positioning) {
            TooltipPositionProviderImpl(positioning, { tooltipAnchorSpacing })
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun rememberTooltipPositionProvider(
        positioning: TooltipAnchorPosition,
        spacingBetweenTooltipAndAnchorProvider: Density.() -> Dp
    ): PopupPositionProvider {
        val density = LocalDensity.current
        val tooltipAnchorSpacingProvider = remember(spacingBetweenTooltipAndAnchorProvider, density) {
            { with(density) { spacingBetweenTooltipAndAnchorProvider().roundToPx() } }
        }
        return remember(tooltipAnchorSpacingProvider, positioning) {
            TooltipPositionProviderImpl(positioning, tooltipAnchorSpacingProvider)
        }
    }
}