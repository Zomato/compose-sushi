package com.zomato.sushi.compose.atoms.tag


/**
 * Defines the size variants available for SushiTag components.
 * 
 * SushiTag supports multiple sizes to accommodate different UI contexts,
 * ranging from the smallest (Nano) to the largest (ExtraLarge). Each size
 * affects the tag's padding, text size, and icon size.
 * 
 * - EXTRA_LARGE: The largest size, suitable for prominent tags
 * - LARGE: A bigger size for emphasis
 * - MEDIUM: Standard size for most use cases
 * - SMALL: Compact size for tight spaces
 * - TINY: Very small size for minimal visual footprint
 * - NANO: The smallest size, for highly compact layouts
 *
 * Created by Kashish on 10,January,2025
 * Zomato, Gurgaon, India.
 */

enum class SushiTagSize {
    EXTRA_LARGE, LARGE, MEDIUM, SMALL, TINY, NANO
}