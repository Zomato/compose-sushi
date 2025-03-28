package com.zomato.sushi.compose.atoms.separator

import androidx.compose.ui.unit.Dp

/**
 * Defines the various visual styles available for dividers in the Sushi design system.
 * 
 * This interface provides different divider styles ranging from simple straight lines
 * to decorative patterns like zigzags, each with their own visual characteristics.
 */
sealed interface SushiDividerType {
    /**
     * A standard solid straight line divider.
     */
    data object Straight : SushiDividerType
    
    /**
     * A dotted line divider with small, closely spaced dots.
     */
    data object Dotted : SushiDividerType
    
    /**
     * A special pink-colored divider.
     * Note: This style should be moved to a project-specific implementation.
     */
    data object Pink : SushiDividerType // Move to Z
    
    /**
     * A vertical dotted line divider with small, closely spaced dots.
     */
    data object VerticalDotted : SushiDividerType
    
    /**
     * A dashed line divider with small dashes and gaps.
     */
    data object Dashed : SushiDividerType
    
    /**
     * A solid straight line divider with a thicker stroke width.
     */
    data object StraightThick : SushiDividerType
    
    /**
     * A vertical solid straight line divider.
     */
    data object Vertical : SushiDividerType
    
    /**
     * A menu-style divider with a triangular notch.
     * Note: This style should be moved to a project-specific implementation.
     */
    data object Menu : SushiDividerType // Move to Z
    
    /**
     * A dotted line divider with larger spacing between dots.
     */
    data object DottedSpaced : SushiDividerType

    /**
     * A decorative zigzag pattern divider.
     * Note: This style should be moved to a project-specific implementation.
     *
     * @property direction The direction that the zigzag points (Top or Bottom)
     * @property radius The corner radius of the zigzag curves
     * @property width The width of each zigzag segment
     * @property height The height/amplitude of the zigzag pattern
     */
    data class ZigZag(
        val direction: Direction,
        val radius: Dp? = null,
        val width: Dp? = null,
        val height: Dp? = null
    ) : SushiDividerType {
        /**
         * Defines the direction of the zigzag pattern.
         */
        enum class Direction {
            /**
             * ZigZag points upward (peaks at the top)
             */
            Top,
            
            /**
             * ZigZag points downward (peaks at the bottom)
             */
            Bottom
        }
    }
}
