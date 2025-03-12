package com.zomato.sushi.compose.atoms.textfield

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.VisualTransformation
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.TextTypeSpec

@Immutable
data class SushiTextFieldProps(
    val id: String? = null,
    val text: String? = null,
    val textStyle: TextTypeSpec? = null,
    val placeholder: SushiTextProps? = null,
    val enabled: Boolean? = null,
    val readOnly: Boolean? = null,
    val isError: Boolean? = null,
    val label: SushiTextProps? = null,
    val keyboardOptions: KeyboardOptions? = null,
    val keyboardActions: KeyboardActions? = null,
    val singleLine: Boolean? = null,
    val maxLines: Int? = null,
    val minLines: Int? = null,
    val shape: Shape? = null,
    val visualTransformation: VisualTransformation? = null,
    val supportText: SushiTextProps? = null,
    val prefixIcon: SushiIconProps? = null,
    val suffixIcon: SushiIconProps? = null,
    val prefixText: SushiTextProps? = null,
    val suffixText: SushiTextProps? = null,
    val colors: SushiTextFieldColors? = null,
)

