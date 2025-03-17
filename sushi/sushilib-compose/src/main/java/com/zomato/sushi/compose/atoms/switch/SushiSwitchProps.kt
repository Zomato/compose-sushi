package com.zomato.sushi.compose.atoms.switch

import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * Properties for configuring a SushiSwitch component.
 *
 * @property id Optional identifier for the switch
 * @property isChecked Whether the switch is checked (on) or unchecked (off)
 * @property text Primary text properties to display alongside the switch
 * @property subText Secondary text properties to display below the primary text
 * @property isEnabled Whether the switch is interactive (true) or disabled (false)
 * @property color The color for the switch when checked
 * @property padding The padding around the switch component
 * @property verticalAlignment The vertical alignment of the switch relative to its text
 * @property direction The position of the switch relative to its text (Start or End)
 *
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiSwitchProps(
    val id: String? = null,
    val isChecked: Boolean? = null,
    val text: SushiTextProps? = null,
    val subText: SushiTextProps? = null,
    val isEnabled: Boolean? = null,
    val color: ColorSpec = SushiUnspecified.asColorSpec(),
    val padding: Dp? = null,
    val verticalAlignment: Alignment.Vertical? = null,
    val direction: SwitchDirection? = null,
)