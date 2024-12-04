package com.zomato.sushi.compose.atoms.image

import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiUnspecified

@ExperimentalSushiApi
@Immutable
data class SushiImageProps(
    val painter: Painter? = Default.painter,
    val bgColor: ColorSpec = Default.bgColor,
    val aspectRatio: Float? = Default.aspectRatio,
    val height: Dp? = Default.height,
    val width: Dp? = Default.width,
    val shape: Shape? = Default.shape,
    val contentDescription: String? = Default.contentDescription,
    val contentScale: ContentScale? = Default.contentScale,
    val alpha: Float? = Default.alpha,
    val scaleFactor: Float? = Default.scaleFactor,
    val alignment: Alignment? = Default.alignment,
    val colorFilter: ColorFilter? = Default.colorFilter
) {
    companion object {
        val Default = SushiImageProps(
            painter = null,
            bgColor = SushiUnspecified.asColorSpec(),
            aspectRatio = null,
            height = null,
            width = null,
            shape = null,
            contentDescription = null,
            contentScale = null,
            alpha = null,
            scaleFactor = null,
            alignment = null,
            colorFilter = null,
        )
    }
}