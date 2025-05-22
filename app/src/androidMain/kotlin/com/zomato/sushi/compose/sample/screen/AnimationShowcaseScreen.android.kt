package com.zomato.sushi.compose.sample.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.zomato.sushi.compose.atoms.animation.LottieCompositionSource
import com.zomato.sushi.compose.atoms.animation.SushiAnimation
import com.zomato.sushi.compose.atoms.animation.SushiAnimationPlayback
import com.zomato.sushi.compose.atoms.animation.rememberSushiAnimationProps

@Composable
internal actual fun CustomProgressAnimation(modifier: Modifier) {
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