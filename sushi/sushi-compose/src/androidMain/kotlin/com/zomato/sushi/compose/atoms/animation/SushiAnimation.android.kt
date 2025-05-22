package com.zomato.sushi.compose.atoms.animation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionResult
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieRetrySignal
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.modifiers.ifNonNull
import com.zomato.sushi.compose.utils.takeIfSpecified

@Composable
actual fun SushiAnimation(
    props: SushiAnimationProps,
    modifier: Modifier
) {
    if (props.source != null) {
        SushiComponentBase(modifier
            .testTag("SushiAnimation")
        ) {
            SushiAnimationImpl(
                props
            )
        }
    }
}

@Composable
private fun SushiAnimationImpl(
    props: SushiAnimationProps,
    modifier: Modifier = Modifier
) {
    if (props.source != null) {
        val source = props.source
        val playback = props.playback ?: SushiAnimationDefaults.playback

        val composition: LottieComposition? = when(source) {
            is LottieCompositionSource -> source.composition
            is LottieResourceSource -> rememberLottieComposition(source).value
        }

        if (composition != null) {
            Box(
                modifier
                    .ifNonNull(props.height) { this.height(it) }
                    .ifNonNull(props.width) { this.width(it) }
                    .ifNonNull(props.aspectRatio) { this.aspectRatio(it) }
                    .ifNonNull(props.bgColor.takeIfSpecified()) { this.background(it.value) }
            ) {
                when (playback) {
                    is SushiAnimationPlayback.AutoPlay -> {
                        LottieAutoPlay(composition, playback)
                    }
                    is SushiAnimationPlayback.Progress -> {
                        LottieWithProgress(composition, playback)
                    }
                }
            }
        }
    }
}

@Composable
private fun LottieAutoPlay(
    composition: LottieComposition,
    playback: SushiAnimationPlayback.AutoPlay,
    modifier: Modifier = Modifier
) {
    val animationState = animateLottieCompositionAsState(
        composition,
        isPlaying = playback.isPlaying,
        restartOnPlay = playback.restartOnPlay,
        reverseOnRepeat = playback.reverseOnRepeat,
        speed = playback.speed,
        iterations = playback.iterations
    )
    LottieAnimation(
        composition = composition,
        progress = { animationState.progress },
        modifier = modifier
    )
}

@Composable
private fun LottieWithProgress(
    composition: LottieComposition,
    progress: SushiAnimationPlayback.Progress,
    modifier: Modifier = Modifier
) {
    LottieAnimation(
        composition = composition,
        progress = progress.valueProvider,
        modifier = modifier
    )
}

@Composable
private fun rememberLottieComposition(source: LottieResourceSource): LottieCompositionResult {
    val retrySignal = rememberLottieRetrySignal()
    val compositionSpec = remember(source) { lottieCompositionSpec(source) }
    val compositionResult: LottieCompositionResult = com.airbnb.lottie.compose.rememberLottieComposition(
        compositionSpec,
        onRetry = { failCount, exception ->
            if (failCount > 2) {
                false
            } else {
                retrySignal.awaitRetry()
                true
            }
        }
    )
    return compositionResult
}

private fun lottieCompositionSpec(source: LottieResourceSource): LottieCompositionSpec {
    return when (source) {
        is LottieAssetSource -> LottieCompositionSpec.Asset(source.assetName)
        is LottieFileSource -> LottieCompositionSpec.File(source.filePath)
        is LottieJsonSource -> LottieCompositionSpec.JsonString(source.jsonString)
        is LottieResourceIdSource -> LottieCompositionSpec.RawRes(source.resId)
        is LottieUrlSource -> LottieCompositionSpec.Url(source.url)
    }
}

@SushiPreview
@Composable
private fun SushiAnimationPreview2() {
    SushiPreview {
        val lottieAnimatable = rememberLottieAnimatable()

        val composition = com.airbnb.lottie.compose.rememberLottieComposition(LottieCompositionSpec.Asset("collection_lottie.json"))

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