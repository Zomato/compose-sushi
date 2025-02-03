@file:SuppressLint("ComposePreviewPublic")

package com.zomato.sushi.compose.atoms.animation

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieComposition
import com.zomato.sushi.compose.internal.SushiPreview

class SushiAnimationTest {

    @SushiPreview
    @Composable
    fun SushiAnimationPreview1() {
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
    fun SushiAnimationPreview2() {
        SushiPreview {
            val lottieAnimatable = rememberLottieAnimatable()

            val composition = rememberLottieComposition(LottieCompositionSpec.Asset("collection_lottie.json"))

            val props by rememberSushiAnimationProps(
                source = LottieCompositionSource(composition.value),
                playback = SushiAnimationPlayback.Progress { 1f - lottieAnimatable.progress }
            )

            LaunchedEffect(Unit) {
                lottieAnimatable.animate(
                    composition = composition.value,
                    iterations = 10
                )
            }

            SushiAnimation(props)
        }
    }

    @SushiPreview
    @Composable
    fun SushiAnimationPreview3() {
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
}