package com.zomato.sushi.compose.atoms.textfield

import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.atoms.color.ColorSpec

/**
 * Defines the complete set of colors used by a SushiTextField in various states.
 * 
 * This class provides fine-grained control over all the color aspects of a text field,
 * including different colors for focused/unfocused states, disabled state, and error state.
 * Each color is defined as a ColorSpec to integrate with the Sushi design system.
 *
 * @property focusedTextColor Color of the input text when the field has focus
 * @property unfocusedTextColor Color of the input text when the field doesn't have focus
 * @property disabledTextColor Color of the input text when the field is disabled
 * @property errorTextColor Color of the input text when the field is in an error state
 * @property focusedContainerColor Background color of the field when it has focus
 * @property unfocusedContainerColor Background color of the field when it doesn't have focus
 * @property disabledContainerColor Background color of the field when it's disabled
 * @property errorContainerColor Background color of the field when it's in an error state
 * @property cursorColor Color of the text cursor
 * @property errorCursorColor Color of the text cursor when in error state
 * @property textSelectionColors Colors for text selection (background and handles)
 * @property focusedIndicatorColor Color of the bottom indicator when the field has focus
 * @property unfocusedIndicatorColor Color of the bottom indicator when the field doesn't have focus
 * @property disabledIndicatorColor Color of the bottom indicator when the field is disabled
 * @property errorIndicatorColor Color of the bottom indicator when the field is in an error state
 * @property focusedLeadingIconColor Color of the leading icon when the field has focus
 * @property unfocusedLeadingIconColor Color of the leading icon when the field doesn't have focus
 * @property disabledLeadingIconColor Color of the leading icon when the field is disabled
 * @property errorLeadingIconColor Color of the leading icon when the field is in an error state
 * @property focusedTrailingIconColor Color of the trailing icon when the field has focus
 * @property unfocusedTrailingIconColor Color of the trailing icon when the field doesn't have focus
 * @property disabledTrailingIconColor Color of the trailing icon when the field is disabled
 * @property errorTrailingIconColor Color of the trailing icon when the field is in an error state
 * @property focusedLabelColor Color of the label text when the field has focus
 * @property unfocusedLabelColor Color of the label text when the field doesn't have focus
 * @property disabledLabelColor Color of the label text when the field is disabled
 * @property errorLabelColor Color of the label text when the field is in an error state
 * @property focusedPlaceholderColor Color of the placeholder text when the field has focus
 * @property unfocusedPlaceholderColor Color of the placeholder text when the field doesn't have focus
 * @property disabledPlaceholderColor Color of the placeholder text when the field is disabled
 * @property errorPlaceholderColor Color of the placeholder text when the field is in an error state
 * @property focusedSupportingTextColor Color of the supporting text when the field has focus
 * @property unfocusedSupportingTextColor Color of the supporting text when the field doesn't have focus
 * @property disabledSupportingTextColor Color of the supporting text when the field is disabled
 * @property errorSupportingTextColor Color of the supporting text when the field is in an error state
 * @property focusedPrefixColor Color of the prefix text/icon when the field has focus
 * @property unfocusedPrefixColor Color of the prefix text/icon when the field doesn't have focus
 * @property disabledPrefixColor Color of the prefix text/icon when the field is disabled
 * @property errorPrefixColor Color of the prefix text/icon when the field is in an error state
 * @property focusedSuffixColor Color of the suffix text/icon when the field has focus
 * @property unfocusedSuffixColor Color of the suffix text/icon when the field doesn't have focus
 * @property disabledSuffixColor Color of the suffix text/icon when the field is disabled
 * @property errorSuffixColor Color of the suffix text/icon when the field is in an error state
 * 
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiTextFieldColors constructor(
    val focusedTextColor: ColorSpec,
    val unfocusedTextColor: ColorSpec,
    val disabledTextColor: ColorSpec,
    val errorTextColor: ColorSpec,
    val focusedContainerColor: ColorSpec,
    val unfocusedContainerColor: ColorSpec,
    val disabledContainerColor: ColorSpec,
    val errorContainerColor: ColorSpec,
    val cursorColor: ColorSpec,
    val errorCursorColor: ColorSpec,
    val textSelectionColors: TextSelectionColors,
    val focusedIndicatorColor: ColorSpec,
    val unfocusedIndicatorColor: ColorSpec,
    val disabledIndicatorColor: ColorSpec,
    val errorIndicatorColor: ColorSpec,
    val focusedLeadingIconColor: ColorSpec,
    val unfocusedLeadingIconColor: ColorSpec,
    val disabledLeadingIconColor: ColorSpec,
    val errorLeadingIconColor: ColorSpec,
    val focusedTrailingIconColor: ColorSpec,
    val unfocusedTrailingIconColor: ColorSpec,
    val disabledTrailingIconColor: ColorSpec,
    val errorTrailingIconColor: ColorSpec,
    val focusedLabelColor: ColorSpec,
    val unfocusedLabelColor: ColorSpec,
    val disabledLabelColor: ColorSpec,
    val errorLabelColor: ColorSpec,
    val focusedPlaceholderColor: ColorSpec,
    val unfocusedPlaceholderColor: ColorSpec,
    val disabledPlaceholderColor: ColorSpec,
    val errorPlaceholderColor: ColorSpec,
    val focusedSupportingTextColor: ColorSpec,
    val unfocusedSupportingTextColor: ColorSpec,
    val disabledSupportingTextColor: ColorSpec,
    val errorSupportingTextColor: ColorSpec,
    val focusedPrefixColor: ColorSpec,
    val unfocusedPrefixColor: ColorSpec,
    val disabledPrefixColor: ColorSpec,
    val errorPrefixColor: ColorSpec,
    val focusedSuffixColor: ColorSpec,
    val unfocusedSuffixColor: ColorSpec,
    val disabledSuffixColor: ColorSpec,
    val errorSuffixColor: ColorSpec,
) {
    /**
     * Converts this SushiTextFieldColors to the Material3 TextFieldColors format.
     * This allows the SushiTextField to use the Material3 TextField implementation
     * while maintaining the Sushi design system's color scheme.
     *
     * @return Material3 TextFieldColors with the equivalent color values
     */
    @Composable
    fun toTextFieldColors(): TextFieldColors {
        return TextFieldColors(
            focusedTextColor = focusedTextColor.value,
            unfocusedTextColor = unfocusedTextColor.value,
            disabledTextColor = disabledTextColor.value,
            errorTextColor = errorTextColor.value,
            focusedContainerColor = focusedContainerColor.value,
            unfocusedContainerColor = unfocusedContainerColor.value,
            disabledContainerColor = disabledContainerColor.value,
            errorContainerColor = errorContainerColor.value,
            cursorColor = cursorColor.value,
            errorCursorColor = errorCursorColor.value,
            textSelectionColors = textSelectionColors,
            focusedIndicatorColor = focusedIndicatorColor.value,
            unfocusedIndicatorColor = unfocusedIndicatorColor.value,
            disabledIndicatorColor = disabledIndicatorColor.value,
            errorIndicatorColor = errorIndicatorColor.value,
            focusedLeadingIconColor = focusedLeadingIconColor.value,
            unfocusedLeadingIconColor = unfocusedLeadingIconColor.value,
            disabledLeadingIconColor = disabledLeadingIconColor.value,
            errorLeadingIconColor = errorLeadingIconColor.value,
            focusedTrailingIconColor = focusedTrailingIconColor.value,
            unfocusedTrailingIconColor = unfocusedTrailingIconColor.value,
            disabledTrailingIconColor = disabledTrailingIconColor.value,
            errorTrailingIconColor = errorTrailingIconColor.value,
            focusedLabelColor = focusedLabelColor.value,
            unfocusedLabelColor = unfocusedLabelColor.value,
            disabledLabelColor = disabledLabelColor.value,
            errorLabelColor = errorLabelColor.value,
            focusedPlaceholderColor = focusedPlaceholderColor.value,
            unfocusedPlaceholderColor = unfocusedPlaceholderColor.value,
            disabledPlaceholderColor = disabledPlaceholderColor.value,
            errorPlaceholderColor = errorPlaceholderColor.value,
            focusedSupportingTextColor = focusedSupportingTextColor.value,
            unfocusedSupportingTextColor = unfocusedSupportingTextColor.value,
            disabledSupportingTextColor = disabledSupportingTextColor.value,
            errorSupportingTextColor = errorSupportingTextColor.value,
            focusedPrefixColor = focusedPrefixColor.value,
            unfocusedPrefixColor = unfocusedPrefixColor.value,
            disabledPrefixColor = disabledPrefixColor.value,
            errorPrefixColor = errorPrefixColor.value,
            focusedSuffixColor = focusedSuffixColor.value,
            unfocusedSuffixColor = unfocusedSuffixColor.value,
            disabledSuffixColor = disabledSuffixColor.value,
            errorSuffixColor = errorSuffixColor.value,
        )
    }
}