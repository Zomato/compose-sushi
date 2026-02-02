package com.zomato.sushi.compose.atoms.text

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.zomato.sushi.compose.foundation.OkraFontFamily
import com.zomato.sushi.compose.foundation.SushiFontWeight
import com.zomato.sushi.compose.foundation.SushiTextSize050
import com.zomato.sushi.compose.foundation.SushiTextSize500
import com.zomato.sushi.compose.internal.SushiPreview
import kotlin.jvm.JvmInline

/**
 * @author gupta.anirudh@zomato.com
 */
@JvmInline
@Stable
private value class ProviderTextTypeSpec(
    val provider: @Composable () -> TextTypeSpec
) : TextTypeSpec {
    override val typeStyle: TextStyle
        @Composable @Stable get() {
            return provider().typeStyle
        }
}

/**
 * Creates a [TextTypeSpec] backed by a composable provider.
 *
 * This is useful when a [TextTypeSpec] is required in a non-composable context,
 * but its value depends on composable state, or when animating text size or color.
 *
 * @author gupta.anirudh@zomato.com
 */
fun textTypeSpec(provider: @Composable () -> TextTypeSpec): TextTypeSpec {
    return ProviderTextTypeSpec(provider)
}

@Composable
@SushiPreview
private fun ProviderTextTypeSpecPreview() {
    SushiPreview {
        val animatedTextSize = remember { Animatable(SushiTextSize050.value) }
        LaunchedEffect(Unit) {
            while (true) {
                animatedTextSize.animateTo(SushiTextSize500.value, tween(1000))
                animatedTextSize.animateTo(SushiTextSize050.value, tween(1000))
            }
        }
        val animatedColor = remember { androidx.compose.animation.Animatable(Color.Red) }
        LaunchedEffect(Unit) {
            while (true) {
                animatedColor.animateTo(Color.Green, tween(1000))
                animatedColor.animateTo(Color.Blue, tween(1000))
                animatedColor.animateTo(Color.Red, tween(1000))
            }
        }
        val animatedFontWeight = remember { Animatable(SushiFontWeight.Light.weight.toFloat()) }
        LaunchedEffect(Unit) {
            while (true) {
                animatedFontWeight.animateTo(SushiFontWeight.ExtraBold.weight.toFloat(), tween(1000))
                animatedFontWeight.animateTo(SushiFontWeight.Light.weight.toFloat(), tween(1000))
            }
        }
        SushiText(
            SushiTextProps(
                text = "Text",
                type = textTypeSpec {
                    TextStyle(
                        fontSize = animatedTextSize.value.sp,
                        fontWeight = FontWeight(animatedFontWeight.value.toInt()),
                        fontFamily = OkraFontFamily,
                        color = animatedColor.value
                    )
                        .asTextTypeSpec()
                }
            )
        )
    }
}