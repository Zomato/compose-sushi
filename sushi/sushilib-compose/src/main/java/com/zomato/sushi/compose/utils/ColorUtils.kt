@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.isSpecified
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.transform

/**
 * @author gupta.anirudh@zomato.com
 */

fun Color.takeIfSpecified() = this.takeIf { it.isSpecified }

@Composable
inline fun ColorSpec.takeIfSpecified() = this.takeIf { it.value.isSpecified }

inline fun ColorSpec.takeIfUnspecified(crossinline altColor: () -> Color) = this.transform {
    if (it.isSpecified) {
        it
    } else {
        altColor()
    }
}