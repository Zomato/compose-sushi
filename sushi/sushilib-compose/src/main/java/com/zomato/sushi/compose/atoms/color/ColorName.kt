package com.zomato.sushi.compose.atoms.color

import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

/**
 * @author gupta.anirudh@zomato.com
 */
@ExperimentalSushiApi
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
        fun fromColorName(colorName: String?): ColorName? {
            return colorName?.let { entries.firstOrNull { it.colorName == colorName } }
        }
    }
}
