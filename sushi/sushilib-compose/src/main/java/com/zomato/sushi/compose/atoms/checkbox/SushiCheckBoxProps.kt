package com.zomato.sushi.compose.atoms.checkbox

import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.text.SushiTextProps

/**
 * @author gupta.anirudh@zomato.com
 *
 * Properties for configuring a SushiCheckBox component.
 *
 * @property id Optional identifier for the checkbox
 * @property checked Whether the checkbox is checked (true) or unchecked (false)
 * @property text Primary text properties to display alongside the checkbox
 * @property subText Secondary text properties to display below the primary text
 * @property enabled Whether the checkbox is interactive (true) or disabled (false)
 * @property color The color for the checkbox when checked
 * @property size The size variant of the checkbox (Mini or Default)
 * @property boxPadding The padding around the checkbox component
 * @property verticalAlignment The vertical alignment of the checkbox relative to its text
 * @property direction The position of the checkbox relative to its text (Start or End)
*/
@Immutable
data class SushiCheckBoxProps(
    val id: String? = null,
    val checked: Boolean? = null,
    val text: SushiTextProps? = null,
    val subText: SushiTextProps? = null,
    val enabled: Boolean? = null,
    val color: ColorSpec? = null,
    val size: SushiCheckboxSize? = null,
    val boxPadding: Dp? = null,
    val verticalAlignment: Alignment.Vertical? = null,
    val direction: CheckBoxDirection? = null,
)