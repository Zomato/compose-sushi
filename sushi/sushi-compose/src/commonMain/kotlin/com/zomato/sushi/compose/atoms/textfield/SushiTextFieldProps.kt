package com.zomato.sushi.compose.atoms.textfield

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.TextTypeSpec

/**
 * Properties for configuring a SushiTextField component.
 * 
 * SushiTextField is a customizable text input field that allows users to enter
 * and edit text. These properties control the appearance and behavior of the text field.
 *
 * @property id Optional identifier for the text field
 * @property text Current text value displayed in the field
 * @property textStyle Typography style for the input text
 * @property placeholder Text displayed when the field is empty
 * @property enabled Whether the text field is interactive (true) or disabled (false)
 * @property readOnly Whether the text field allows user input (false) or is read-only (true)
 * @property isError Whether to display the text field in an error state
 * @property label Optional label text displayed above the text field
 * @property keyboardOptions Options controlling the behavior of the software keyboard
 * @property keyboardActions Actions to perform based on keyboard input
 * @property singleLine Whether the text field should be limited to a single line
 * @param showResetButton Show a reset button to clear the text field's input (default is true)
 * @property maxLines Maximum number of lines to display when not in single line mode
 * @property minLines Minimum number of lines to display
 * @property shape The shape of the text field container
 * @property visualTransformation Optional transformation for displaying the text (e.g., password masking)
 * @property supportText Optional supporting text displayed below the text field
 * @property prefixIcon Optional icon displayed at the start of the text field (visible when the field is not empty, or in focus)
 * @property leadingIcon Optional icon displayed at the start of the text field (always visible)
 * @property suffixIcon Optional icon displayed at the end of the text field (visible when the field is not empty, or in focus)
 * @property trailingIcon Optional icon displayed at the end of the text field (always visible)
 * @property prefixText Optional text displayed at the start of the text field (visible when the field is not empty, or in focus)
 * @property suffixText Optional text displayed at the end of the text field (visible when the field is not empty, or in focus)
 * @property selection Optional text selection/cursor position. When provided, enables TextFieldValue mode for enhanced text control
 * @property colors Color scheme for the text field's various states
 * 
 * @author gupta.anirudh@zomato.com
 */
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
    val showResetButton: Boolean? = null,
    val maxLines: Int? = null,
    val minLines: Int? = null,
    val shape: Shape? = null,
    val visualTransformation: VisualTransformation? = null,
    val supportText: SushiTextProps? = null,
    val prefixIcon: SushiIconProps? = null,
    val leadingIcon: SushiIconProps? = null,
    val suffixIcon: SushiIconProps? = null,
    val trailingIcon: SushiIconProps? = null,
    val prefixText: SushiTextProps? = null,
    val suffixText: SushiTextProps? = null,
    val textFieldValue: TextFieldValue? = null,
    val colors: SushiTextFieldColors? = null,
)
