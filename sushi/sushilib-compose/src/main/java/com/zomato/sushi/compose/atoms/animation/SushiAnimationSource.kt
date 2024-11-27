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

sealed interface LottieContent : LottieSource
@JvmInline value class LottieAsset(val assetName: String) : LottieContent
@JvmInline value class LottieFile(val filePath: String) : LottieContent
@JvmInline value class LottieJson(val jsonString: String) : LottieContent
@JvmInline value class LottieResource(@RawRes val resId: Int) : LottieContent
@JvmInline value class LottieUrl(val url: String) : LottieContent

@JvmInline value class LottieCompositionSource(val composition: LottieComposition?) : LottieSource