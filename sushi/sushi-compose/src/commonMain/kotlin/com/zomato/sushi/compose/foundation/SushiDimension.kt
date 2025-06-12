package com.zomato.sushi.compose.foundation

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

/**
 * Encapsulates dimension values used throughout the Sushi design system.
 * 
 * SushiDimension provides access to standard spacing and corner radius values,
 * ensuring visual consistency across the application. These dimensions are used
 * by components for standard spacing, padding, margins, and shape definitions.
 *
 * @property spacing Collection of standard spacing values for different use cases
 * @property cornerRadius Standard corner radius for rounded shapes
 *
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiDimension(
    val spacing: Spacing = Spacing(),
    val cornerRadius: Dp = SushiCornerRadius
) {

    /**
     * Collection of standard spacing values used throughout the design system.
     * 
     * The naming convention ranges from smallest (femto) to largest (alone),
     * with additional specialized spacing values for specific use cases.
     */
    data class Spacing(
        /** No spacing */
        val femto: Dp = SushiSpacingFemto,
        
        /** Minimal spacing */
        val pico: Dp = SushiSpacingPico,
        
        /** Very small spacing */
        val nano: Dp = SushiSpacingNano,
        
        /** Small spacing */
        val micro: Dp = SushiSpacingMicro,
        
        /** Medium-small spacing */
        val mini: Dp = SushiSpacingMini,
        
        /** Medium spacing */
        val macro: Dp = SushiSpacingMacro,
        
        /** Medium-large spacing */
        val large: Dp = SushiSpacingLarge,
        
        /** Standard spacing */
        val base: Dp = SushiSpacingBase,
        
        /** Large spacing */
        val extra: Dp = SushiSpacingExtra,
        
        /** Extra-large spacing */
        val loose: Dp = SushiSpacingLoose,
        
        /** Maximum spacing */
        val alone: Dp = SushiSpacingAlone,
        
        /** Standard page side padding */
        val pageSide: Dp = SushiSpacingPageSide,
        
        /** Standard spacing between items */
        val between: Dp = SushiSpacingBetween,
        
        /** Larger spacing between items */
        val betweenLarge: Dp = SushiSpacingBetweenLarge,
        
        /** Smaller spacing between items */
        val betweenSmall: Dp = SushiSpacingBetweenSmall
    )
}
