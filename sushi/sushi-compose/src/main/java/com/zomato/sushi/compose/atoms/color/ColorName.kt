package com.zomato.sushi.compose.atoms.color


/**
 * Defines the standard color names available in the Sushi design system.
 * Each color name has multiple variations/tints which can be accessed via ColorVariation.
 * 
 * This enum provides a type-safe way to reference colors in the design system
 * without needing to know the specific RGB values.
 *
 * @property colorName The string identifier of the color
 * 
 * @author gupta.anirudh@zomato.com
 */
enum class ColorName(val colorName: String) {
    Black("black"),
    White("white"),
    Red("red"),
    Green("green"),
    Blue("blue"),
    Grey("grey"),
    Yellow("yellow"),
    Purple("purple"),
    Lime("lime"),
    Indigo("indigo"),
    Cider("cider"),
    Teal("teal"),
    Orange("orange"),
    Brown("brown"),
    Pink("pink"),
    Corn("corn"),
    Avacado("avacado"),
    Gold("gold"),
    Theme("theme"),
    Accent("accent"),
    Onion("onion"),
    Charcoal("charcoal"),
    Honey("honey"),
    Tangerine("tangerine"),
    Slate("slate"),
    Transparent("transparent"),
    ThemeGreen("theme_green"),
    ThemeCorn("theme_corn"),
    BrandColor("brand_color");

    companion object {
        /**
         * Finds a ColorName enum value by its string identifier.
         *
         * @param colorName The string identifier of the color
         * @return The corresponding ColorName or null if no match is found
         */
        fun fromColorName(colorName: String?): ColorName? {
            return colorName?.let { entries.firstOrNull { it.colorName == colorName } }
        }
    }
}
