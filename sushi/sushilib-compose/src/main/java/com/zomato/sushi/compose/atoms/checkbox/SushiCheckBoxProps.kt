package com.zomato.sushi.compose.atoms.checkbox

import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.text.SushiTextProps

/**
 * @author gupta.anirudh@zomato.com
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