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
 * Properties for configuring a SushiImage component.
 *
 * SushiImageProps encapsulates all the parameters needed to customize the appearance
 * and behavior of an image in the Sushi design system. It provides extensive control
 * over size, shape, content scaling, color filters, and more.
 *
 * @property painter The painter responsible for drawing the image content
 * @property bgColor The background color behind the image
 * @property aspectRatio The width to height ratio to maintain (e.g., 16/9 = 1.78)
 * @property height The explicit height for the image (optional)
 * @property width The explicit width for the image (optional)
 * @property shape The shape to clip the image to (e.g., RoundedCornerShape)
 * @property contentDescription Accessibility description of the image for screen readers
 * @property contentScale How the image should be scaled within its bounds (e.g., Fit, Crop)
 * @property alpha Opacity level from 0.0 (transparent) to 1.0 (opaque)
 * @property scaleFactor Additional scaling factor applied to the image size
 * @property alignment How the image should be aligned within its bounds
 * @property colorFilter Optional filter to apply color transformations to the image
 *
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