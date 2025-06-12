package com.zomato.sushi.compose.foundation

/**
 * Defines the color scheme types available in the Sushi design system.
 *
 * This enum is used to differentiate between light and dark mode color schemes
 * throughout the application, allowing components to adapt their appearance
 * based on the active color scheme.
 *
 * @author gupta.anirudh@zomato.com
 */
enum class SushiColorSchemeType {
    /** Standard light mode color scheme with light backgrounds and dark text */
    Light, 
    
    /** Dark mode color scheme with dark backgrounds and light text */
    Dark
}