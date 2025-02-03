package com.zomato.sushi.compose.atoms.image

import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiImageProps(
    val painter: Painter? = null,
    val bgColor: ColorSpec = SushiUnspecified.asColorSpec(),
    val aspectRatio: Float? = null,
    val height: Dp? = null,
    val width: Dp? = null,
    val shape: Shape? = null,
    val contentDescription: String? = null,
    val contentScale: ContentScale? = null,
    val alpha: Float? = null,
    val scaleFactor: Float? = null,
    val alignment: Alignment? = null,
    val colorFilter: ColorFilter? = null,
)