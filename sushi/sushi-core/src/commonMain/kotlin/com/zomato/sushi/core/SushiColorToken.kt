package com.zomato.sushi.core

/**
 * Interface for representing color tokens in the Sushi design system.
 * 
 * A color token is a symbolic reference to a color value which may vary based on theme,
 * context, or other factors. Using tokens instead of direct color references helps
 * maintain consistency across the design system and enables dynamic theming capabilities.
 * 
 * Color tokens are identified by string identifiers, typically in a dot notation format
 * such as "color.primary" or "color.surface.background".
 *
 * @property token The string identifier for the color token
 *
 * @author gupta.anirudh@zomato.com
 */
interface SushiColorToken {
    val token: String
}

/**
 * Factory function for creating SushiColorToken instances.
 * 
 * This function provides a convenient way to create color tokens without
 * needing to define explicit implementing classes. It's particularly useful
 * when defining one-off color tokens or working with design systems that
 * expose token-based APIs.
 *
 * Example usage:
 * ```
 * val primaryToken = SushiColorToken("color.primary")
 * val surfaceToken = SushiColorToken("color.surface.background")
 * ```
 *
 * @param token The string identifier for the color token
 * @return A SushiColorToken instance with the specified token string
 */
fun SushiColorToken(token: String) = object : SushiColorToken {
    override val token: String get() = token
}