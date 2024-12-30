package com.zomato.sushi.compose.atoms.checkbox

import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.text.SushiTextProps

/**
 * @author gupta.anirudh@zomato.com
 */
@ExperimentalSushiApi
@Immutable
data class SushiCheckBoxProps(
    val id: String? = Default.id,
    val checked: Boolean? = Default.checked,
    val text: SushiTextProps? = Default.text,
    val subText: SushiTextProps? = Default.subText,
    val enabled: Boolean? = Default.enabled,
    val color: ColorSpec? = Default.color,
    val size: SushiCheckboxSize? = Default.size,
    val boxPadding: Dp? = Default.boxPadding,
    val verticalAlignment: Alignment.Vertical? = Default.verticalAlignment,
    val direction: CheckBoxDirection? = Default.direction
) {
    companion object {
        val Default = SushiCheckBoxProps(
            id = null,
            checked = null,
            text = null,
            subText = null,
            enabled = null,
            color = null,
            size = null,
            boxPadding = null,
            verticalAlignment = null,
            direction = null
        )
    }
}