package com.zomato.sushi.compose.foundation

import androidx.compose.ui.text.font.FontWeight

internal enum class FontTypes(val label: String, val marker: Int) {
    Light("light", 0),
    Regular("regular", 1),
    Medium("medium", 2),
    SemiBold("semibold", 3),
    Bold("bold", 4),
    ExtraBold("extrabold", 5);

    companion object {
        fun fromLabel(label: String?): FontTypes? = entries.firstOrNull { it.label == label }
        fun fromMarker(marker: Int?): FontTypes? = entries.firstOrNull { it.marker == marker }
    }
}

internal inline fun FontTypes.fontWeight(): FontWeight = FontWeight((this.marker + 3) * 100)