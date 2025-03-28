package com.zomato.sushi.compose.atoms.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.zomato.sushi.core.SushiColorToken
import com.zomato.sushi.compose.foundation.SushiTheme

private val DEFAULT_TINT = ColorVariation.Variation500
private val DEFAULT_ALPHA = 1.0

private sealed class ColorDataInfo private constructor() {
    data class Token(val token: SushiColorToken) : ColorDataInfo()
    data class NameTint(
        val colorName: ColorName,
        val tint: ColorVariation
    ) : ColorDataInfo()
}

/**
 * A color specification that integrates with the Sushi design system's color management.
 *
 * SushiColorData provides a type-safe way to reference and use colors from the design system,
 * supporting both semantic color tokens and named colors with specific tints. It automatically
 * adapts to theme changes and ensures consistent color usage throughout the application.
 *
 * Colors can be created in two primary ways:
 * 1. From a SushiColorToken (semantic reference like "primary", "secondary")
 * 2. From a ColorName and ColorVariation combination (like "Red500" or "Blue300")
 * 
 * Both approaches support optional alpha (transparency) values.
 *
 * @property colorInfo Internal representation of how the color is defined
 * @property alpha Transparency value between 0.0 (transparent) and 1.0 (opaque)
 * 
 * @author gupta.anirudh@zomato.com
 */
@Stable
data class SushiColorData private constructor(
    private val colorInfo: ColorDataInfo,
    private val alpha: Double = DEFAULT_ALPHA
) : ColorSpec {

    /**
     * Creates a SushiColorData from a color token and optional alpha.
     * 
     * @param token The SushiColorToken to use (e.g., primary, secondary)
     * @param alpha Transparency value between 0.0 (transparent) and 1.0 (opaque)
     */
    constructor(token: SushiColorToken, alpha: Double = 1.0) : this(ColorDataInfo.Token(token), alpha)
    
    /**
     * Creates a SushiColorData from a color name, tint variation, and optional alpha.
     * 
     * @param colorName The name of the color (e.g., Red, Blue, Green)
     * @param tint The tint/variation of the color (e.g., 100, 500, 900)
     * @param alpha Transparency value between 0.0 (transparent) and 1.0 (opaque)
     */
    constructor(colorName: ColorName, tint: ColorVariation = DEFAULT_TINT, alpha: Double = 1.0) : this(ColorDataInfo.NameTint(colorName, tint), alpha)

    override val value: Color
        @Composable @Stable get() {
            val alphaF = (alpha.coerceIn(0.0, 1.0)).toFloat() // Convert transparency to 0-255 range
            return when (val colorInfo = colorInfo) {
                is ColorDataInfo.Token -> {
                    SushiTheme.colorTokenMapper.invoke(colorInfo.token).value.copy(alpha = alphaF)
                }

                is ColorDataInfo.NameTint -> {
                    val baseColor = getColor(colorInfo.colorName, colorInfo.tint, SushiTheme.colors).value
                    Color(
                        red = baseColor.red,
                        green = baseColor.green,
                        blue = baseColor.blue,
                        alpha = alphaF
                    )
                }
            }
        }

    companion object {
        /**
         * Creates a SushiColorData from a color token and optional alpha.
         * 
         * This factory method provides a more readable alternative to the constructor
         * for creating color data from tokens.
         * 
         * @param token The SushiColorToken to use (e.g., primary, secondary)
         * @param alpha Transparency value between 0.0 (transparent) and 1.0 (opaque)
         * @return A SushiColorData instance using the specified token
         */
        fun fromToken(
            token: SushiColorToken,
            alpha: Double = DEFAULT_ALPHA
        ): SushiColorData {
            return SushiColorData(
                colorInfo = ColorDataInfo.Token(token),
                alpha = alpha
            )
        }

        /**
         * Creates a SushiColorData from a color name, tint variation, and optional alpha.
         * 
         * This factory method provides a more readable alternative to the constructor
         * for creating color data from named colors.
         * 
         * @param colorName The name of the color (e.g., Red, Blue, Green)
         * @param tint The tint/variation of the color (e.g., 100, 500, 900)
         * @param alpha Transparency value between 0.0 (transparent) and 1.0 (opaque)
         * @return A SushiColorData instance using the specified color name and tint
         */
        fun fromColorName(
            colorName: ColorName,
            tint: ColorVariation = DEFAULT_TINT,
            alpha: Double = DEFAULT_ALPHA
        ): SushiColorData {
            return SushiColorData(
                colorInfo = ColorDataInfo.NameTint(
                    colorName = colorName,
                    tint = tint
                ),
                alpha = alpha
            )
        }
    }
}
