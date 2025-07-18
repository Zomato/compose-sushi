package com.zomato.sushi.compose.atoms.icon

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.FontFamily
import com.zomato.sushi.compose.foundation.WasabiFontFamily

/**
 * Provides the font family that will be used to render [SushiIcon]
 */
val LocalSushiIconFontFamily = staticCompositionLocalOf<FontFamily> {
    WasabiFontFamily
}