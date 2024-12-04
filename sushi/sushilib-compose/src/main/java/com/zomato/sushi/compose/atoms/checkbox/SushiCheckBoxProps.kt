package com.zomato.sushi.compose.atoms.checkbox

import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.text.SushiTextProps

@ExperimentalSushiApi
@Immutable
data class SushiCheckBoxProps(
    val id: String? = Default.id,
    val isChecked: Boolean? = Default.isChecked,
    val text: SushiTextProps? = Default.text,
    val subText: SushiTextProps? = Default.subText,
    val isEnabled: Boolean? = Default.isEnabled,
    val color: ColorSpec? = Default.color,
    val size: SushiCheckboxSize? = Default.size,
    val boxPadding: Dp? = Default.boxPadding,
    val verticalAlignment: Alignment.Vertical? = Default.verticalAlignment,
    val direction: CheckBoxDirection? = Default.direction
) {
    companion object {
        val Default = SushiCheckBoxProps(
            id = null,
            isChecked = null,
            text = null,
            subText = null,
            isEnabled = null,
            color = null,
            size = null,
            boxPadding = null,
            verticalAlignment = null,
            direction = null
        )

        // fun fromCheckboxData(data: CheckBoxData, defaults: SushiCheckboxData = Default): SushiCheckboxData {
        //     return SushiCheckboxData(
        //         isChecked = data.isChecked ?: defaults.isChecked,
        //         text = data.text?.let { SushiTextData.fromTextData(it) } ?: defaults.text,
        //         isEnabled = data.isDisabled?.not() ?: defaults.isEnabled,
        //         color = data.color?.asSpec() ?: defaults.color,
        //         size = data.size?.let { getCheckboxSize(data) } ?: defaults.size,
        //         removeExtraInteractionPadding = defaults.removeExtraInteractionPadding
        //     )
        // }
        //
        // private fun getCheckboxSize(data: CheckBoxData): SushiCheckboxSize = when (data.size) {
        //     CheckBoxData.SIZE_MINI -> SushiCheckboxSize.MINI
        //     else -> SushiCheckboxSize.DEFAULT
        // }
    }
}