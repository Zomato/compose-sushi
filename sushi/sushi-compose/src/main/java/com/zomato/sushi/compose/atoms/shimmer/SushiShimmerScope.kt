package com.zomato.sushi.compose.atoms.shimmer

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zomato.sushi.compose.atoms.text.SushiTextProps

/**
 * Scope interface for SushiShimmer content.
 *
 * This interface provides functions to create shimmer effects for different
 * types of UI elements within a SushiShimmer component.
 */
interface SushiShimmerScope {
    /**
     * Creates a generic shimmer item with the specified modifier.
     * This can be used to create placeholder shapes with the shimmer effect.
     *
     * @param modifier The modifier to customize the size, shape, and other attributes
     */
    @Composable
    fun ShimmerItem(modifier: Modifier)

    /**
     * Creates a shimmer text with the specified text properties and modifier.
     * This applies the shimmer effect to text content.
     *
     * @param sushiTextProps The text properties to configure the text appearance
     * @param modifier The modifier to customize the text layout
     */
    @Composable
    fun ShimmerText(sushiTextProps: SushiTextProps, modifier: Modifier)
}