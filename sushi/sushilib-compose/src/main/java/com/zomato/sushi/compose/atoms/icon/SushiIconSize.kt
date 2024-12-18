@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.icon

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.foundation.SushiTextSize050
import com.zomato.sushi.compose.foundation.SushiTextSize100
import com.zomato.sushi.compose.foundation.SushiTextSize200
import com.zomato.sushi.compose.foundation.SushiTextSize300
import com.zomato.sushi.compose.foundation.SushiTextSize400
import com.zomato.sushi.compose.foundation.SushiTextSize500
import com.zomato.sushi.compose.foundation.SushiTextSize600
import com.zomato.sushi.compose.foundation.SushiTextSize700
import com.zomato.sushi.compose.foundation.SushiTextSize800
import com.zomato.sushi.compose.foundation.SushiTextSize900
import com.zomato.sushi.compose.utils.toSp

/**
 * @author gupta.anirudh@zomato.com
 */
@ExperimentalSushiApi
@Immutable
sealed interface IconSizeSpec {
    @get:Composable
    @Stable
    val size: TextUnit
}

@ExperimentalSushiApi
@JvmInline
internal value class TextUnitIconSizeSpec(private val textUnit: TextUnit) : IconSizeSpec {
    override val size: TextUnit @Composable @Stable get() = textUnit
}

@ExperimentalSushiApi
@JvmInline
internal value class DpIconSizeSpec(private val dp: Dp) : IconSizeSpec {
    override val size: TextUnit @Composable @Stable get() = dp.toSp()
}

fun TextUnit.asIconSizeSpec(): IconSizeSpec = TextUnitIconSizeSpec(this)
fun Dp.asIconSizeSpec(): IconSizeSpec = DpIconSizeSpec(this)

/**
 * @author gupta.anirudh@zomato.com
 */
@ExperimentalSushiApi
@Immutable
enum class SushiIconSize: IconSizeSpec {
    Size50,
    Size100,
    Size200,
    Size300,
    Size400,
    Size500,
    Size600,
    Size700,
    Size800,
    Size900;


    override val size: TextUnit
        @Composable @Stable get() = when (this) {
            Size50 -> SushiTextSize050
            Size100 -> SushiTextSize100
            Size200 -> SushiTextSize200
            Size300 -> SushiTextSize300
            Size400 -> SushiTextSize400
            Size500 -> SushiTextSize500
            Size600 -> SushiTextSize600
            Size700 -> SushiTextSize700
            Size800 -> SushiTextSize800
            Size900 -> SushiTextSize900
        }

    companion object {
        fun fromSize(size: Int): SushiIconSize? = when (size) {
            50 -> Size50
            100 -> Size100
            200 -> Size200
            300 -> Size300
            400 -> Size400
            500 -> Size500
            600 -> Size600
            700 -> Size700
            800 -> Size800
            900 -> Size900
            else -> null
        }
    }
}