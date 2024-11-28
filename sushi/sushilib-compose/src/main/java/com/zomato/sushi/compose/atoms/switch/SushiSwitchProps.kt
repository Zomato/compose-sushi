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
    val subText: SushiTextProps? = Default.subText,
    val isEnabled: Boolean? = Default.isEnabled,
    val color: ColorSpec = Default.color,
    val padding: Dp? = Default.padding,
    val verticalAlignment: Alignment.Vertical? = Default.verticalAlignment,
    val direction: SwitchDirection? = Default.direction
) {
    companion object {
        val Default = SushiSwitchProps(
            id = null,
            isChecked = null,
            text = null,
            subText = null,
            isEnabled = null,
            color = SushiUnspecified.asColorSpec(),
            padding = null,
            verticalAlignment = null,
            direction = null
        )
    }
}