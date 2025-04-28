package com.zomato.sushi.compose.atoms.textfield

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.text.asTextTypeSpec
import com.zomato.sushi.compose.foundation.SushiTheme

/**
 * Provides default values and utility functions for SushiTextField components.
 * These defaults are used when specific properties are not provided in SushiTextFieldProps.
 */
object SushiTextFieldDefaults {
    /**
     * Default shape for text fields with rounded corners.
     */
    val shape = RoundedCornerShape(12.dp)
    
    /**
     * Default text style for the input text.
     */
    val textStyle @Composable get() = SushiTheme.typography.regular300.asTextTypeSpec()
    
    /**
     * Default text style for supporting text displayed below the field.
     */
    val supportTextStyle @Composable get() = SushiTheme.typography.regular100.asTextTypeSpec()
    
    /**
     * Default text style for the label displayed above the field.
     */
    val labelTextStyle @Composable get() = SushiTheme.typography.regular100.asTextTypeSpec()

    /**
     * Creates a default set of text field colors for an outlined text field.
     * These colors are based on the current theme and follow the design system's
     * color guidelines for text fields in different states.
     *
     * @return A SushiTextFieldColors object with all colors defined
     */
    @Composable
    fun outlinedColors(
        focusedTextColor: ColorSpec = SushiTheme.colors.text.primary,
        unfocusedTextColor: ColorSpec = SushiTheme.colors.text.primary,
        disabledTextColor: ColorSpec = SushiTheme.colors.text.disabled,
        errorTextColor: ColorSpec = SushiTheme.colors.text.primary,
        focusedContainerColor: ColorSpec = SushiTheme.colors.surface.primary,
        unfocusedContainerColor: ColorSpec = SushiTheme.colors.surface.primary,
        disabledContainerColor: ColorSpec = SushiTheme.colors.surface.disabled,
        errorContainerColor: ColorSpec = SushiTheme.colors.surface.primary,
        cursorColor: ColorSpec = SushiTheme.colors.text.primary,
        errorCursorColor: ColorSpec = SushiTheme.colors.text.primary,
        textSelectionColors: TextSelectionColors = LocalTextSelectionColors.current,
        focusedIndicatorColor: ColorSpec = SushiTheme.colors.border.inverse,
        unfocusedIndicatorColor: ColorSpec = SushiTheme.colors.border.moderate,
        disabledIndicatorColor: ColorSpec = SushiTheme.colors.surface.disabled,
        errorIndicatorColor: ColorSpec = SushiTheme.colors.border.error,
        focusedLeadingIconColor: ColorSpec = SushiTheme.colors.text.primary,
        unfocusedLeadingIconColor: ColorSpec = SushiTheme.colors.text.primary,
        disabledLeadingIconColor: ColorSpec = SushiTheme.colors.text.disabled,
        errorLeadingIconColor: ColorSpec = SushiTheme.colors.text.primary,
        focusedTrailingIconColor: ColorSpec = SushiTheme.colors.text.primary,
        unfocusedTrailingIconColor: ColorSpec = SushiTheme.colors.text.primary,
        disabledTrailingIconColor: ColorSpec = SushiTheme.colors.text.disabled,
        errorTrailingIconColor: ColorSpec = SushiTheme.colors.text.primary,
        focusedLabelColor: ColorSpec = SushiTheme.colors.text.primary,
        unfocusedLabelColor: ColorSpec = SushiTheme.colors.text.quaternary,
        disabledLabelColor: ColorSpec = SushiTheme.colors.text.disabled,
        errorLabelColor: ColorSpec = SushiTheme.colors.text.error,
        focusedPlaceholderColor: ColorSpec = SushiTheme.colors.text.tertiary,
        unfocusedPlaceholderColor: ColorSpec = SushiTheme.colors.text.quaternary,
        disabledPlaceholderColor: ColorSpec = SushiTheme.colors.text.disabled,
        errorPlaceholderColor: ColorSpec = SushiTheme.colors.text.tertiary,
        focusedSupportingTextColor: ColorSpec = SushiTheme.colors.text.primary,
        unfocusedSupportingTextColor: ColorSpec = SushiTheme.colors.text.primary,
        disabledSupportingTextColor: ColorSpec = SushiTheme.colors.text.disabled,
        errorSupportingTextColor: ColorSpec = SushiTheme.colors.text.error,
        focusedPrefixColor: ColorSpec = SushiTheme.colors.text.primary,
        unfocusedPrefixColor: ColorSpec = SushiTheme.colors.text.primary,
        disabledPrefixColor: ColorSpec = SushiTheme.colors.text.disabled,
        errorPrefixColor: ColorSpec = SushiTheme.colors.text.primary,
        focusedSuffixColor: ColorSpec = SushiTheme.colors.text.primary,
        unfocusedSuffixColor: ColorSpec = SushiTheme.colors.text.primary,
        disabledSuffixColor: ColorSpec = SushiTheme.colors.text.disabled,
        errorSuffixColor: ColorSpec = SushiTheme.colors.text.primary,
    ) = SushiTextFieldColors(
        focusedTextColor = focusedTextColor,
        unfocusedTextColor = unfocusedTextColor,
        disabledTextColor = disabledTextColor,
        errorTextColor = errorTextColor,
        focusedContainerColor = focusedContainerColor,
        unfocusedContainerColor = unfocusedContainerColor,
        disabledContainerColor = disabledContainerColor,
        errorContainerColor = errorContainerColor,
        cursorColor = cursorColor,
        errorCursorColor = errorCursorColor,
        textSelectionColors = textSelectionColors,
        focusedIndicatorColor = focusedIndicatorColor,
        unfocusedIndicatorColor = unfocusedIndicatorColor,
        disabledIndicatorColor = disabledIndicatorColor,
        errorIndicatorColor = errorIndicatorColor,
        focusedLeadingIconColor = focusedLeadingIconColor,
        unfocusedLeadingIconColor = unfocusedLeadingIconColor,
        disabledLeadingIconColor = disabledLeadingIconColor,
        errorLeadingIconColor = errorLeadingIconColor,
        focusedTrailingIconColor = focusedTrailingIconColor,
        unfocusedTrailingIconColor = unfocusedTrailingIconColor,
        disabledTrailingIconColor = disabledTrailingIconColor,
        errorTrailingIconColor = errorTrailingIconColor,
        focusedLabelColor = focusedLabelColor,
        unfocusedLabelColor = unfocusedLabelColor,
        disabledLabelColor = disabledLabelColor,
        errorLabelColor = errorLabelColor,
        focusedPlaceholderColor = focusedPlaceholderColor,
        unfocusedPlaceholderColor = unfocusedPlaceholderColor,
        disabledPlaceholderColor = disabledPlaceholderColor,
        errorPlaceholderColor = errorPlaceholderColor,
        focusedSupportingTextColor = focusedSupportingTextColor,
        unfocusedSupportingTextColor = unfocusedSupportingTextColor,
        disabledSupportingTextColor = disabledSupportingTextColor,
        errorSupportingTextColor = errorSupportingTextColor,
        focusedPrefixColor = focusedPrefixColor,
        unfocusedPrefixColor = unfocusedPrefixColor,
        disabledPrefixColor = disabledPrefixColor,
        errorPrefixColor = errorPrefixColor,
        focusedSuffixColor = focusedSuffixColor,
        unfocusedSuffixColor = unfocusedSuffixColor,
        disabledSuffixColor = disabledSuffixColor,
        errorSuffixColor = errorSuffixColor,
    )
}