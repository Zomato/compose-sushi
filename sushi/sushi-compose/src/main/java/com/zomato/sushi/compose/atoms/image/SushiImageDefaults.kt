package com.zomato.sushi.compose.atoms.image

import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale

/**
 * Provides default values for SushiImage components.
 * These defaults are used when specific properties are not provided in SushiImageProps.
 *
 * @author gupta.anirudh@zomato.com
 */
object SushiImageDefaults {
    internal val alignment: Alignment = Alignment.Center
    internal val contentScale: ContentScale = ContentScale.Fit
    internal val alpha: Float = 1.0f
    internal val colorFilter: ColorFilter? = null
}