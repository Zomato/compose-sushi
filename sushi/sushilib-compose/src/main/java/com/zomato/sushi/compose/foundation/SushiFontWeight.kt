package com.zomato.sushi.compose.foundation

import androidx.compose.ui.text.font.FontWeight

/**
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
        fun fromLabel(label: String?): SushiFontWeight? = entries.firstOrNull { it.label == label }
    }
}

internal inline fun SushiFontWeight.fontWeight(): FontWeight = FontWeight(this.weight)