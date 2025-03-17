package com.zomato.sushi.compose.atoms.animation

import androidx.annotation.RawRes
import androidx.compose.runtime.Immutable
import com.airbnb.lottie.LottieComposition

/**
 * Base interface representing the source of an animation in the Sushi design system.
 * This serves as the root for all animation source types that can be used in SushiAnimation.
 *
 * @author gupta.anirudh@zomato.com
 */
@Immutable
sealed interface SushiAnimationSource

/**
 * Base interface representing a Lottie animation source.
 * Extends SushiAnimationSource to specifically identify Lottie-based animations.
 */
sealed interface LottieSource : SushiAnimationSource

/**
 * Base interface for Lottie animations loaded from various resource types.
 * Extends LottieSource to represent animations that need to be loaded from files, 
 * assets, URLs, or other resource types.
 */
sealed interface LottieResourceSource : LottieSource

/**
 * Represents a Lottie animation loaded from an asset file.
 *
 * @property assetName Path to the asset in the assets directory
 */
@JvmInline value class LottieAssetSource(val assetName: String) : LottieResourceSource

/**
 * Represents a Lottie animation loaded from a file in the file system.
 *
 * @property filePath Path to the file in the file system
 */
@JvmInline value class LottieFileSource(val filePath: String) : LottieResourceSource

/**
 * Represents a Lottie animation loaded from a JSON string.
 *
 * @property jsonString The JSON string containing the Lottie animation data
 */
@JvmInline value class LottieJsonSource(val jsonString: String) : LottieResourceSource

/**
 * Represents a Lottie animation loaded from an Android resource.
 *
 * @property resId The resource ID of the Lottie animation file
 */
@JvmInline value class LottieResourceIdSource(@RawRes val resId: Int) : LottieResourceSource

/**
 * Represents a Lottie animation loaded from a URL.
 *
 * @property url The URL from which to load the Lottie animation
 */
@JvmInline value class LottieUrlSource(val url: String) : LottieResourceSource

/**
 * Represents a pre-loaded Lottie composition.
 * This can be used when the LottieComposition has already been loaded elsewhere
 * and can be directly provided to the animation component.
 *
 * @property composition The pre-loaded LottieComposition object
 */
@JvmInline value class LottieCompositionSource(val composition: LottieComposition?) : LottieSource