package com.zomato.sushi.compose.atoms.shimmer

import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.atoms.color.ColorSpec

/**
 * Properties for configuring a SushiShimmer component.
 * 
 * SushiShimmer is a loading state indicator that displays animated gradient effects
 * over placeholder content. These properties control the appearance and behavior
 * of the animation.
 *
 * @property bgColor The background color of the shimmer effect
 * @property animationColor The highlight color that moves across the shimmer
 * @property animationWidth The width of the highlight gradient in dp
 * @property angleOffset The angle offset of the gradient to create diagonal effects
 * @property animationDuration The duration of one complete animation cycle in milliseconds
 * @property animationDelay The delay between animation cycles in milliseconds
 */
@Immutable
data class SushiShimmerProps(
    val bgColor: ColorSpec? = null,
    val animationColor: ColorSpec? = null,
    val animationWidth: Float? = null,
    val angleOffset: Float? = null,
    val animationDuration: Int? = null,
    val animationDelay: Int? = null
)
