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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.R
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.modifiers.ifNonNull
import com.zomato.sushi.compose.utils.takeIfSpecified

/**
 * @author gupta.anirudh@zomato.com
 */
@Composable
fun SushiImage(
    props: SushiImageProps,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    if (props.painter != null) {
        SushiComponentBase(modifier
            .testTag("SushiImage")
        ) {
            SushiImageImpl(
                props,
                Modifier,
                onClick = onClick
            )
        }
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
        val alignment = props.alignment ?: SushiImageDefaults.alignment
        val contentScale = props.contentScale ?: SushiImageDefaults.contentScale
        val alpha = props.alpha ?: SushiImageDefaults.alpha
        val colorFilter = props.colorFilter ?: SushiImageDefaults.colorFilter

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
private fun SushiImagePreview1() {
    SushiPreview {
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