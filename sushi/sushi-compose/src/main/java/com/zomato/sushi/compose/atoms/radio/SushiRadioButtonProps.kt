package com.zomato.sushi.compose.atoms.radio

import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * Properties for configuring a SushiRadioButton component.
 *
 * @property id Optional identifier for the radio button
 * @property selected Whether the radio button is selected (true) or unselected (false)
 * @property text Primary text properties to display alongside the radio button
 * @property subText Secondary text properties to display below the primary text
 * @property enabled Whether the radio button is interactive (true) or disabled (false)
 * @property unselectedColor The color for the radio button when unselected
 * @property selectedColor The color for the radio button when selected
 * @property padding The padding around the radio button component
 * @property verticalAlignment The vertical alignment of the radio button relative to its text
 * @property direction The position of the radio button relative to its text (Start or End)
 *
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiRadioButtonProps(
    val id: String? = null,
    val selected: Boolean? = null,
    val text: SushiTextProps? = null,
    val subText: SushiTextProps? = null,
    val enabled: Boolean? = null,
    val unselectedColor: ColorSpec = SushiUnspecified.asColorSpec(),
    val selectedColor: ColorSpec = SushiUnspecified.asColorSpec(),
    val padding: Dp? = null,
    val verticalAlignment: Alignment.Vertical? = null,
    val direction: RadioButtonDirection? = null,
)