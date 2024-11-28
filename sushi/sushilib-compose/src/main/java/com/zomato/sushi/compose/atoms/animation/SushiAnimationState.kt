package com.zomato.sushi.compose.atoms.animation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.airbnb.lottie.compose.LottieCompositionResult
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

// todox: need another layer on top of Props? remove if not needed
@OptIn(ExperimentalSushiApi::class)
class SushiAnimationState @OptIn(ExperimentalSushiApi::class) constructor(
    props: SushiAnimationProps
) {
    var props: SushiAnimationProps by mutableStateOf(props)
    var compositionResult: LottieCompositionResult? by mutableStateOf(null)
}