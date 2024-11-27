@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
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

@ExperimentalSushiApi
data class SushiColorData private constructor(
    private val colorInfo: ColorDataInfo,
    private val alpha: Double = DEFAULT_ALPHA
) : ColorSpec {

    constructor(token: SushiColorToken, alpha: Double = 1.0) : this(ColorDataInfo.Token(token), alpha)
    constructor(colorName: ColorName, tint: ColorVariation = DEFAULT_TINT, alpha: Double = 1.0) : this(ColorDataInfo.NameTint(colorName, tint), alpha)

    override val value: Color
        @Composable @Stable get() {
            val alphaF = (alpha.coerceIn(0.0, 1.0)).toFloat() // Convert transparency to 0-255 range
            return when (val colorInfo = colorInfo) {
                is ColorDataInfo.Token -> {
                    SushiTheme.colorTokenMapper.invoke(colorInfo.token).value
                }

                // todox: remove if not needed anymore
                // is ZCColorDataInfo.Token -> {
                //     val context = LocalContext.current
                //     val colorInt = context.getResolvedColorToken(colorInfo.token)
                //     Color(colorInt).copy(alpha = alphaF)
                // }

                is ColorDataInfo.NameTint -> {
                    val baseColor = getColor(colorInfo.colorName, colorInfo.tint)
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

        fun fromToken(
            token: SushiColorToken,
            alpha: Double = DEFAULT_ALPHA
        ): SushiColorData {
            return SushiColorData(
                colorInfo = ColorDataInfo.Token(token),
                alpha = alpha
            )
        }

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
