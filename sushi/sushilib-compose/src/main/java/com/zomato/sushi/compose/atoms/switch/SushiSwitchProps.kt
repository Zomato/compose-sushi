package com.zomato.sushi.compose.atoms.switch

import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.foundation.SushiUnspecified

// todox: need to impl?
// subtitle
// clickActionData
// actionIds
// shouldAnimateCheckbox
// animationData
@ExperimentalSushiApi
@Immutable
data class SushiSwitchProps(
    val id: String? = Default.id,
    val isChecked: Boolean? = Default.isChecked,
    val text: SushiTextProps? = Default.text,
    val isEnabled: Boolean? = Default.isEnabled,
    val color: ColorSpec = Default.color,
    val padding: Dp? = Default.padding,
    val alignment: Alignment.Vertical? = Default.alignment,
    val direction: SwitchDirection? = Default.direction
) {
    companion object {
        val Default = SushiSwitchProps(
            id = null,
            isChecked = null,
            text = null,
            isEnabled = null,
            color = SushiUnspecified.asColorSpec(),
            padding = null,
            alignment = null,
            direction = null
        )
    }
}