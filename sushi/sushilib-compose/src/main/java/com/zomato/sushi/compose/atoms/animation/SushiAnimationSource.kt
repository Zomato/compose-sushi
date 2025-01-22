package com.zomato.sushi.compose.atoms.animation

import androidx.annotation.RawRes
import androidx.compose.runtime.Immutable
import com.airbnb.lottie.LottieComposition

/**
 * @author gupta.anirudh@zomato.com
 */

@Immutable
sealed interface SushiAnimationSource

sealed interface LottieSource : SushiAnimationSource

sealed interface LottieResourceSource : LottieSource
@JvmInline value class LottieAssetSource(val assetName: String) : LottieResourceSource
@JvmInline value class LottieFileSource(val filePath: String) : LottieResourceSource
@JvmInline value class LottieJsonSource(val jsonString: String) : LottieResourceSource
@JvmInline value class LottieResourceIdSource(@RawRes val resId: Int) : LottieResourceSource
@JvmInline value class LottieUrlSource(val url: String) : LottieResourceSource

@JvmInline value class LottieCompositionSource(val composition: LottieComposition?) : LottieSource