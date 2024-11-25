@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.animation

import androidx.annotation.RawRes
import androidx.compose.runtime.Immutable
import com.airbnb.lottie.LottieComposition
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

@Immutable
@ExperimentalSushiApi
sealed interface SushiAnimationSource


sealed interface LottieSource : SushiAnimationSource

@JvmInline
value class LottieAsset(val assetName: String) : LottieSource

@JvmInline
value class LottieFile(val filePath: String) : LottieSource

@JvmInline
value class LottieJson(val jsonString: String) : LottieSource

@JvmInline
value class LottieResource(@RawRes val resId: Int) : LottieSource

@JvmInline
value class LottieUrl(val url: String) : LottieSource

@JvmInline
value class LottieCompositionSource(val composition: LottieComposition?) : LottieSource