package com.zomato.sushi.compose.atoms.separator

import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.foundation.SushiUnspecified

@ExperimentalSushiApi
@Immutable
data class SushiDividerProps(
    val type: SushiDividerType? = Default.type,
    val color: ColorSpec? = Default.color,
    val isLeftIndented: Boolean? = Default.isLeftIndented,
    val isRightIndented: Boolean? = Default.isLeftIndented,
    val isBothIndented: Boolean? = Default.isLeftIndented
) {
    companion object {
        val Default = SushiDividerProps(
            type = SushiDividerType.STRAIGHT,
            color = SushiUnspecified.asColorSpec(),
            isLeftIndented = null,
            isRightIndented = null,
            isBothIndented = null
        )
    }
}
