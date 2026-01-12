package com.zomato.sushi.compose.atoms.animation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.RenderMode
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationState
import com.airbnb.lottie.compose.LottieCompositionResult
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieRetrySignal
import com.zomato.sushi.compose.accessibility.contentDescription
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.modifiers.ifNonNull
import com.zomato.sushi.compose.utils.takeIfSpecified

actual class SushiLottieAnimationState actual constructor() {
    var composition: LottieComposition? by mutableStateOf(null)
        internal set
    var animationState: LottieAnimationState? by mutableStateOf(null)
        internal set
}

@Composable
actual fun SushiAnimation(
    props: SushiAnimationProps,
    modifier: Modifier,
    state: SushiAnimationState,
    onClick: (() -> Unit)?
) {
    if (props.source != null) {
        SushiComponentBase(modifier
            .testTag("SushiAnimation")
        ) {
            SushiAnimationImpl(
                props,
                state = state,
                onClick = onClick
            )
        }
    }
}

@Composable
private fun SushiAnimationImpl(
    props: SushiAnimationProps,
    state: SushiAnimationState,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    if (props.source != null) {
        val source = props.source
        val playback = props.playback ?: SushiAnimationDefaults.playback

        val height = when {
            props.height != null -> props.height
            props.aspectRatio != null && props.width != null -> props.width / props.aspectRatio
            else -> null
        }

        val width = when {
            props.width != null -> props.width
            props.aspectRatio != null && props.height != null -> props.height * props.aspectRatio
            else -> null
        }

        val composition: LottieComposition? = when(source) {
            is LottieCompositionSource -> source.composition
            is LottieResourceSource -> rememberLottieComposition(source).value
        }

        LaunchedEffect(composition) {
            state.lottieState.composition = composition
        }

        if (composition != null) {
            val lottieModifier = modifier
                .ifNonNull(props.contentDescription) { this.contentDescription(it) }
                .ifNonNull(onClick) { this.clickable(onClick = it) }
                .ifNonNull(props.shape) { this.clip(it) }
                .ifNonNull(props.alpha) { this.alpha(it) }
                .ifNonNull(height) { this.height(it) }
                .ifNonNull(width) { this.width(it) }
                .ifNonNull(props.aspectRatio) { this.aspectRatio(it) }
                .ifNonNull(props.bgColor?.takeIfSpecified()) { this.background(it.value) }
                .ifNonNull(props.scaleFactor) { this.scale(it) }

            when (playback) {
                is SushiAnimationPlayback.AutoPlay -> {
                    LottieAutoPlay(
                        composition = composition,
                        playback = playback,
                        state = state,
                        modifier = lottieModifier
                    )
                }

                is SushiAnimationPlayback.Progress -> {
                    LottieWithProgress(
                        composition = composition,
                        progress = playback,
                        state = state,
                        modifier = lottieModifier
                    )
                }
            }
        }
    }
}

@Composable
private fun LottieAutoPlay(
    composition: LottieComposition,
    playback: SushiAnimationPlayback.AutoPlay,
    state: SushiAnimationState,
    modifier: Modifier = Modifier
) {
    val animationState = animateLottieCompositionAsState(
        composition,
        isPlaying = playback.isPlaying.value,
        restartOnPlay = playback.restartOnPlay,
        reverseOnRepeat = playback.reverseOnRepeat,
        speed = playback.speed,
        iterations = playback.iterations
    )

    LaunchedEffect(animationState) {
        state.lottieState.animationState = animationState
    }

    LottieAnimation(
        composition = composition,
        progress = { animationState.progress },
        renderMode = RenderMode.HARDWARE,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun LottieWithProgress(
    composition: LottieComposition,
    progress: SushiAnimationPlayback.Progress,
    state: SushiAnimationState,
    modifier: Modifier = Modifier
) {
    SideEffect {
        if (state.lottieState.animationState != null) {
            state.lottieState.animationState = null
        }
    }

    LottieAnimation(
        composition = composition,
        progress = progress.valueProvider,
        renderMode = RenderMode.HARDWARE,
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