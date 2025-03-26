package com.zomato.sushi.compose.atoms.icon

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
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
 * Specification for icon sizes in the Sushi design system.
 * This interface defines a consistent way to specify icon sizes regardless
 * of the underlying unit type (TextUnit or Dp).
 *
 * @author gupta.anirudh@zomato.com
 */
@Immutable
sealed interface IconSizeSpec {
    /**
     * The actual size value as a TextUnit.
     * This is a composable property as some size specs might need access to
     * the composition environment.
     */
    @get:Composable
    @Stable
    val size: TextUnit
}

@JvmInline
internal value class TextUnitIconSizeSpec(private val textUnit: TextUnit) : IconSizeSpec {
    override val size: TextUnit @Composable @Stable get() = textUnit
}

@JvmInline
internal value class DpIconSizeSpec(private val dp: Dp) : IconSizeSpec {
    override val size: TextUnit @Composable @Stable get() = dp.toSp()
}

/**
 * Converts a TextUnit to an IconSizeSpec.
 * This allows using TextUnit values directly as icon sizes.
 *
 * @return An IconSizeSpec representing this TextUnit
 */
fun TextUnit.asIconSizeSpec(): IconSizeSpec = TextUnitIconSizeSpec(this)

/**
 * Converts a Dp value to an IconSizeSpec.
 * This allows using Dp values directly as icon sizes, which will be
 * internally converted to the appropriate TextUnit.
 *
 * @return An IconSizeSpec representing this Dp value
 */
fun Dp.asIconSizeSpec(): IconSizeSpec = DpIconSizeSpec(this)

/**
 * Predefined icon sizes in the Sushi design system.
 * 
 * These sizes follow a consistent scale from smallest (Size50) to largest (Size900)
 * and correspond to specific text sizes in the design system. Using these predefined
 * sizes ensures consistency across the application.
 *
 * @author gupta.anirudh@zomato.com
 */
@Immutable
enum class SushiIconSize : IconSizeSpec {
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

    /**
     * The actual size value as a TextUnit, mapped to the corresponding
     * text size in the Sushi design system.
     */
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
        /**
         * Finds a SushiIconSize enum value by its numeric value.
         *
         * @param size The numeric value (50, 100, 200, etc.)
         * @return The corresponding SushiIconSize or null if no match is found
         */
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
