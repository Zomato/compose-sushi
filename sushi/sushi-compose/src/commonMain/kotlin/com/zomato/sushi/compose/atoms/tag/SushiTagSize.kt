package com.zomato.sushi.compose.atoms.tag


/**
 * Defines the size variants available for SushiTag components.
 * 
 * SushiTag supports multiple sizes to accommodate different UI contexts,
 * ranging from the smallest (Nano) to the largest (ExtraLarge). Each size
 * affects the tag's padding, text size, and icon size.
 * 
 * - ExtraLarge: The largest size, suitable for prominent tags
 * - Large: A bigger size for emphasis
 * - Medium: Standard size for most use cases
 * - Small: Compact size for tight spaces
 * - Tiny: Very small size for minimal visual footprint
 * - Nano: The smallest size, for highly compact layouts
 *
 * Created by Kashish on 10,January,2025
 * Zomato, Gurgaon, India.
 */

enum class SushiTagSize {
    ExtraLarge, Large, Medium, Small, Tiny, Nano
}