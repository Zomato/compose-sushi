package com.zomato.sushi.compose.components.media

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.animation.LottieAssetSource
import com.zomato.sushi.compose.atoms.animation.SushiAnimation
import com.zomato.sushi.compose.atoms.animation.SushiAnimationPlayback
import com.zomato.sushi.compose.atoms.animation.rememberSushiAnimationProps
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.image.SushiImage
import com.zomato.sushi.compose.atoms.image.SushiImageProps
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import org.jetbrains.compose.resources.painterResource
import composesushi.sushi_compose.generated.resources.Res
import composesushi.sushi_compose.generated.resources.sushi_rating_star

/**
 * @author gupta.anirudh@zomato.com
 *
 * A unified media component for the Sushi design system that can display different types of media.
 *
 * SushiMedia provides a single interface for displaying various types of visual content,
 * currently supporting static images and animations. It automatically renders the appropriate
 * component based on the type of media specified in the properties.
 *
 * This abstraction allows for easier transitions between different media types and
 * provides a consistent API for displaying visual content.
 *
 * Usage examples:
 * ```
 * // Display an image
 * SushiMedia(
 *   props = SushiMediaProps.Image(imageProps),
 *   modifier = Modifier.size(200.dp)
 * )
 * 
 * // Display an animation
 * SushiMedia(
 *   props = SushiMediaProps.Animation(animationProps),
 *   modifier = Modifier.size(200.dp)
 * )
 * ```
 *
 * @param props The properties specifying which type of media to render and its configuration
 * @param modifier The modifier to be applied to the component
 * 
 * @author gupta.anirudh@zomato.com
 */
@Composable
fun SushiMedia(
    props: SushiMediaProps,
    modifier: Modifier = Modifier
) {
    when (props) {
        is SushiMediaProps.Animation -> {
            SushiAnimation(
                props.props,
                modifier
            )
        }
        is SushiMediaProps.Image -> {
            SushiImage(
                props.props,
                modifier
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiMediaPreview1() {
    SushiPreview {
        val animationProps by rememberSushiAnimationProps(
            source = LottieAssetSource("collection_lottie.json"),
            playback = SushiAnimationPlayback.AutoPlay(
                isPlaying = true,
                restartOnPlay = true,
                reverseOnRepeat = false,
                speed = 1f,
                iterations = 10
            )
        )

        val imageProps = SushiImageProps(
            painter = painterResource(Res.drawable.sushi_rating_star),
            bgColor = SushiTheme.colors.red.v500,
            width = 50.dp,
            shape = RoundedCornerShape(10.dp),
            contentDescription = "star",
            contentScale = ContentScale.Fit,
            alpha = 0.3f,
            scaleFactor = 0.6f,
            colorFilter = ColorFilter.tint(
                SushiTheme.colors.green.v900.value,
                blendMode = BlendMode.SrcIn
            ),
            aspectRatio = 1f
        )

        var mediaProps: SushiMediaProps by remember {
            mutableStateOf(
                SushiMediaProps.Image(imageProps)
            )
        }

        Column {
            SushiButton(
                SushiButtonProps(text = "Click to Toggle"),
                onClick = {
                    mediaProps = if (mediaProps is SushiMediaProps.Image) {
                        SushiMediaProps.Animation(animationProps)
                    } else {
                        SushiMediaProps.Image(imageProps)
                    }
                }
            )
            SushiMedia(mediaProps)
        }
    }
}