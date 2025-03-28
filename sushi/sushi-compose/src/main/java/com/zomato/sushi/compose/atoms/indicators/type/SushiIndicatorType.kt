package com.zomato.sushi.compose.atoms.indicators.type

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.indicators.model.DotGraphic

/**
 * Defines the available types of indicators in the Sushi design system.
 * 
 * This sealed interface provides different implementation styles for page indicators,
 * each with its own animation style and customization options.
 *
 * @author gupta.anirudh@zomato.com
 */
sealed interface SushiIndicatorType {
    /**
     * An indicator type where the active dot expands like a balloon.
     *
     * The dot scales up when active and gradually returns to normal size as it
     * becomes inactive. The transition between pages creates a smooth scaling effect.
     *
     * @property dotsGraphic The appearance configuration for the dots
     * @property balloonSizeFactor The maximum size multiplication factor for the active dot
     */
    data class Balloon(
        val dotsGraphic: DotGraphic = DotGraphic(size = 12.dp),
        val balloonSizeFactor: Float = 1.5f,
    ) : SushiIndicatorType

    /**
     * An indicator type where the active dot expands horizontally.
     *
     * The dot widens when active, creating a pill-like shape, and returns to circular
     * form as it becomes inactive.
     *
     * @property dotsGraphic The appearance configuration for the dots
     * @property shiftSizeFactor The maximum width multiplication factor for the active dot
     */
    data class Shift(
        val dotsGraphic: DotGraphic = DotGraphic(),
        val shiftSizeFactor: Float = 3f,
    ) : SushiIndicatorType

    /**
     * An indicator type with a separate selector dot that moves between fixed position dots.
     *
     * This style maintains fixed background dots while an additional "selector" dot
     * smoothly travels between positions to indicate the current page.
     *
     * @property dotsGraphic The appearance configuration for the background dots
     * @property selectorDotGraphic The appearance configuration for the moving selector dot
     */
    data class Spring(
        val dotsGraphic: DotGraphic = DotGraphic(),
        val selectorDotGraphic: DotGraphic = DotGraphic(color = Color.Black),
    ) : SushiIndicatorType
}