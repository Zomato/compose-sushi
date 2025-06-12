package com.zomato.sushi.compose.atoms.color

/**
 * Defines the standard tint/shade variations available for colors in the Sushi design system.
 *
 * Each variation represents a different intensity or shade of a base color, with lower
 * numbers generally being lighter and higher numbers being darker. The standard Material
 * Design convention of using variations from 50 (lightest) to 900 (darkest) is followed.
 *
 * @property variation The numeric value representing the shade variation
 * @author gupta.anirudh@zomato.com
 */
enum class ColorVariation(val variation: Int) {
    Variation50(50),
    Variation100(100),
    Variation200(200),
    Variation300(300),
    Variation400(400),
    Variation500(500),
    Variation600(600),
    Variation700(700),
    Variation800(800),
    Variation900(900);

    companion object {
        /**
         * Finds a ColorVariation enum value by its numeric value.
         *
         * @param variation The numeric value of the variation
         * @return The corresponding ColorVariation or null if no match is found
         */
        fun fromInt(variation: Int): ColorVariation? {
            return entries.firstOrNull { it.variation == variation }
        }
    }
}
