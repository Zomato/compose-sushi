package com.zomato.sushi.compose.atoms.radio

import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * @author gupta.anirudh@zomato.com
 */
@ExperimentalSushiApi
@Immutable
data class SushiRadioButtonProps(
    val id: String? = Default.id,
    val selected: Boolean? = Default.selected,
    val text: SushiTextProps? = Default.text,
    val subText: SushiTextProps? = Default.subText,
    val enabled: Boolean? = Default.enabled,
    val unselectedColor: ColorSpec = Default.unselectedColor,
    val selectedColor: ColorSpec = Default.selectedColor,
    val padding: Dp? = Default.padding,
    val verticalAlignment: Alignment.Vertical? = Default.verticalAlignment,
    val direction: RadioButtonDirection? = Default.direction
) {
    companion object {
        val Default = SushiRadioButtonProps(
            id = null,
            selected = null,
            text = null,
            subText = null,
            enabled = null,
            unselectedColor = SushiUnspecified.asColorSpec(),
            selectedColor = SushiUnspecified.asColorSpec(),
            padding = null,
            verticalAlignment = null,
            direction = null
        )
    }
}