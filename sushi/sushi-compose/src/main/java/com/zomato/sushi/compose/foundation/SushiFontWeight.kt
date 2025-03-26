package com.zomato.sushi.compose.foundation

import androidx.compose.ui.text.font.FontWeight

/**
 * Defines the standardized font weight options available in the Sushi design system.
 *
 * @property label String identifier for the font weight
 * @property weight Numeric weight value (standard 100-900 scale)
 * 
 * @author gupta.anirudh@zomato.com
 */
internal enum class SushiFontWeight(val label: String, val weight: Int) {
    Light("light", 300),
    Regular("regular", 400),
    Medium("medium", 500),
    SemiBold("semibold", 600),
    Bold("bold", 700),
    ExtraBold("extrabold", 800);

    companion object {
        /**
         * Finds a SushiFontWeight enum value by its string label.
         *
         * @param label The string identifier for the font weight
         * @return The corresponding SushiFontWeight or null if no match is found
         */
        fun fromLabel(label: String?): SushiFontWeight? = entries.firstOrNull { it.label == label }
    }
}

/**
 * Extension function to convert a SushiFontWeight to a Compose FontWeight.
 *
 * @return FontWeight corresponding to this SushiFontWeight
 */
internal inline fun SushiFontWeight.fontWeight(): FontWeight = FontWeight(this.weight)