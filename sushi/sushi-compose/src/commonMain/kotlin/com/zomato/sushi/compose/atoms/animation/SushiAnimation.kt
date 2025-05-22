package com.zomato.sushi.compose.atoms.animation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.zomato.sushi.compose.internal.SushiPreview

/**
 * Creates and remembers SushiAnimationProps from the provided source and playback configuration.
 * This composable function helps maintain state for animation properties.
 *
 * @param source The animation source to be displayed
 * @param playback The playback configuration controlling how the animation plays
 * @return A State object containing the animation properties
 *
 * @author gupta.anirudh@zomato.com
 */
@Composable
fun rememberSushiAnimationProps(
    source: SushiAnimationSource?,
    playback: SushiAnimationPlayback?
): State<SushiAnimationProps> {
    return remember(source, playback) {
        mutableStateOf(
            SushiAnimationProps(
                source = source,
                playback = playback
            )
        )
    }
}

/**
 * A composable component for displaying animations in the Sushi design system.
 * Supports Lottie animations from various sources with customizable playback behavior.
 *
 * @param props The properties to configure the animation appearance and behavior
 * @param modifier The modifier to be applied to the component
 *
 * @author gupta.anirudh@zomato.com
 */
@Composable
expect fun SushiAnimation(
    props: SushiAnimationProps,
    modifier: Modifier = Modifier
)

@SushiPreview
@Composable
private fun SushiAnimationPreview1() {
    SushiPreview {
        val props by rememberSushiAnimationProps(
            source = LottieAssetSource("collection_lottie.json"),
            playback = SushiAnimationPlayback.AutoPlay(
                isPlaying = true,
                restartOnPlay = true,
                reverseOnRepeat = false,
                speed = 1f,
                iterations = 10
            )
        )

        SushiAnimation(props)
    }
}

@SushiPreview
@Composable
private fun SushiAnimationPreview3() {
    SushiPreview {
        val durationMs = 1650 / 2
        var targetValue by remember { mutableFloatStateOf(0f) }

        val progress by animateFloatAsState(
            targetValue = targetValue,
            animationSpec = tween(durationMs),
            label = "keyframe",
            finishedListener = {
                targetValue = 1 - targetValue
            }
        )

        LaunchedEffect(Unit) {
            targetValue = 1f
        }

        val props by rememberSushiAnimationProps(
            source = LottieAssetSource("collection_lottie.json"),
            playback = SushiAnimationPlayback.Progress { progress }
        )

        SushiAnimation(props)
    }
}