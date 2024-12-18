@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.R
import com.zomato.sushi.compose.atoms.internal.Base
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.Preview
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.ifNonNull
import com.zomato.sushi.compose.utils.takeIfSpecified

private object Defaults {
    val alignment: Alignment = Alignment.Center
    val contentScale: ContentScale = ContentScale.Fit
    val alpha: Float = 1.0f
    val colorFilter: ColorFilter? = null
}

/**
 * @author gupta.anirudh@zomato.com
 */
@ExperimentalSushiApi
@Composable
fun SushiImage(
    props: SushiImageProps,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Base(modifier) {
        SushiImageImpl(
            props,
            Modifier,
            onClick = onClick
        )
    }
}

@Composable
private fun SushiImageImpl(
    props: SushiImageProps,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    if (props.painter != null) {
        val painter = props.painter
        val bgColor = props.bgColor.takeIfSpecified()
        val contentDescription = props.contentDescription
        val alignment = props.alignment ?: Defaults.alignment
        val contentScale = props.contentScale ?: Defaults.contentScale
        val alpha = props.alpha ?: Defaults.alpha
        val colorFilter = props.colorFilter ?: Defaults.colorFilter

        Image(
            painter,
            contentDescription,
            modifier
                .ifNonNull(onClick) { this.clickable(onClick = it) }
                .ifNonNull(props.shape) { this.clip(it) }
                .ifNonNull(props.height) { this.height(it) }
                .ifNonNull(props.width) { this.width(it) }
                .ifNonNull(props.aspectRatio) { this.aspectRatio(it) }
                .ifNonNull(bgColor) { this.background(it.value) }
                .ifNonNull(props.scaleFactor) { this.scale(it) },
            alignment = alignment,
            contentScale = contentScale,
            alpha = alpha,
            colorFilter = colorFilter
        )
    }
}

@SushiPreview
@Composable
fun SushiImagePreview1() {
    Preview {
        Row(Modifier.width(200.dp)) {
            SushiImage(
                props = SushiImageProps(
                    painterResource(R.drawable.feedback_rating_star),
                    bgColor = SushiTheme.colors.red.v500,
                    width = 50.dp,
                    // height = 10.dp,
                    shape = RoundedCornerShape(10.dp),
                    contentDescription = "star",
                    contentScale = ContentScale.Fit,
                    alpha = 0.7f,
                    scaleFactor = 1f,
                    colorFilter = ColorFilter.grayscale(percentage = 80),
                    aspectRatio = 3f
                ),
                Modifier.weight(1f)
            )
            SushiImage(
                props = SushiImageProps(
                    painterResource(R.drawable.feedback_rating_star),
                    bgColor = SushiTheme.colors.red.v500,
                    width = 50.dp,
                    // height = 10.dp,
                    shape = RoundedCornerShape(10.dp),
                    contentDescription = "star",
                    contentScale = ContentScale.Fit,
                    alpha = 0.3f,
                    scaleFactor = 0.6f,
                    colorFilter = ColorFilter.tint(SushiTheme.colors.green.v900.value, blendMode = BlendMode.SrcIn),
                    aspectRatio = 3f
                ),
                Modifier.weight(1f)
            )
        }
    }
}