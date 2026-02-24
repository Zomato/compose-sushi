package com.zomato.sushi.compose.animation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Spring.DampingRatioNoBouncy
import androidx.compose.animation.core.Spring.StiffnessMedium
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.spring
import androidx.compose.runtime.Stable
import kotlin.math.sqrt

/**
 * Damping for a spring with no bounciness (when stiffness is [StiffnessMedium] and mass is 1). This damping ratio will create a critically
 * damped spring that returns to equilibrium within the shortest amount of time without
 * oscillating.
 */
private const val DampingNoBouncy: Float = 77f

private const val Mass = 1f

/**
 * Creates a [SpringSpec] that uses the given physical spring constants (i.e. [damping],
 * [stiffness] and [mass]). The provided damping value is converted internally to
 * a damping ratio using `damping / (2 * sqrt(stiffness * mass))`.
 * The optional [visibilityThreshold] defines when the animation should be
 * considered to be visually close enough to round off to its target.
 *
 * Invalid values (negative, zero, NaN, or infinite inputs) are automatically
 * replaced with safe defaults to avoid crashes or invalid animation states.
 *
 * @param damping the physical damping constant of the spring. [DampingNoBouncy] by default.
 * @param stiffness stiffness of the spring. [Spring.StiffnessMedium] by default.
 * @param mass the mass of the spring. [Mass] by default.
 * @param visibilityThreshold optionally specifies the visibility threshold.
 */
@Stable
fun <T> spring(
    damping: Float = DampingNoBouncy,
    stiffness: Float = StiffnessMedium,
    mass: Float = Mass,
    visibilityThreshold: T? = null
): SpringSpec<T> {
    val safeStiffness = when {
        stiffness.isNaN() || stiffness <= 0f -> StiffnessMedium
        stiffness.isInfinite() -> StiffnessMedium
        else -> stiffness
    }

    val safeMass = when {
        mass.isNaN() || mass <= 0f -> Mass
        mass.isInfinite() -> Mass
        else -> mass
    }

    val safeDamping = when {
        damping.isNaN() || damping < 0f -> DampingNoBouncy
        damping.isInfinite() -> DampingNoBouncy
        else -> damping
    }

    val sqrtTerm = safeStiffness * safeMass
    val denominator = 2f * sqrt(sqrtTerm)

    val dampingRatio = if (
        denominator == 0f ||
        denominator.isNaN() ||
        denominator.isInfinite()
    ) {
        Spring.DampingRatioNoBouncy
    } else {
        (safeDamping / denominator).let {
            if (it.isNaN() || it.isInfinite()) {
                Spring.DampingRatioNoBouncy
            } else {
                it
            }
        }
    }

    return spring(
        dampingRatio = dampingRatio,
        stiffness = safeStiffness,
        visibilityThreshold = visibilityThreshold
    )
}