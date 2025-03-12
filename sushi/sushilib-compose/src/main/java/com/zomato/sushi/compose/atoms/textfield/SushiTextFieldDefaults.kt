package com.zomato.sushi.compose.atoms.textfield

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.text.asTextTypeSpec
import com.zomato.sushi.compose.foundation.SushiTheme

object SushiTextFieldDefaults {
    val shape = RoundedCornerShape(12.dp)
    val textStyle @Composable get() = SushiTheme.typography.regular300.asTextTypeSpec()
    val supportTextStyle @Composable get() = SushiTheme.typography.regular100.asTextTypeSpec()
    val labelTextStyle @Composable get() = SushiTheme.typography.regular100.asTextTypeSpec()

    @Composable
    fun outlinedColors() = SushiTextFieldColors(
        focusedTextColor = SushiTheme.colors.text.primary,
        unfocusedTextColor = SushiTheme.colors.text.primary,
        disabledTextColor = SushiTheme.colors.text.disabled,
        errorTextColor = SushiTheme.colors.text.error,
        focusedContainerColor = SushiTheme.colors.surface.primary,
        unfocusedContainerColor = SushiTheme.colors.surface.primary,
        disabledContainerColor = SushiTheme.colors.surface.disabled,
        errorContainerColor = SushiTheme.colors.surface.disabled,
        cursorColor = SushiTheme.colors.text.primary,
        errorCursorColor = SushiTheme.colors.text.primary,
        textSelectionColors = LocalTextSelectionColors.current,
        focusedIndicatorColor = SushiTheme.colors.surface.inverse,
        unfocusedIndicatorColor = SushiTheme.colors.surface.disabled,
        disabledIndicatorColor = SushiTheme.colors.surface.disabled,
        errorIndicatorColor = SushiTheme.colors.surface.error,
        focusedLeadingIconColor = SushiTheme.colors.text.primary,
        unfocusedLeadingIconColor = SushiTheme.colors.text.primary,
        disabledLeadingIconColor = SushiTheme.colors.text.disabled,
        errorLeadingIconColor = SushiTheme.colors.text.error,
        focusedTrailingIconColor = SushiTheme.colors.text.primary,
        unfocusedTrailingIconColor = SushiTheme.colors.text.primary,
        disabledTrailingIconColor = SushiTheme.colors.text.disabled,
        errorTrailingIconColor = SushiTheme.colors.text.error,
        focusedLabelColor = SushiTheme.colors.text.primary,
        unfocusedLabelColor = SushiTheme.colors.text.primary,
        disabledLabelColor = SushiTheme.colors.text.disabled,
        errorLabelColor = SushiTheme.colors.text.error,
        focusedPlaceholderColor = SushiTheme.colors.text.tertiary,
        unfocusedPlaceholderColor = SushiTheme.colors.text.tertiary,
        disabledPlaceholderColor = SushiTheme.colors.text.disabled,
        errorPlaceholderColor = SushiTheme.colors.text.error,
        focusedSupportingTextColor = SushiTheme.colors.text.primary,
        unfocusedSupportingTextColor = SushiTheme.colors.text.primary,
        disabledSupportingTextColor = SushiTheme.colors.text.disabled,
        errorSupportingTextColor = SushiTheme.colors.text.error,
        focusedPrefixColor = SushiTheme.colors.text.primary,
        unfocusedPrefixColor = SushiTheme.colors.text.primary,
        disabledPrefixColor = SushiTheme.colors.text.disabled,
        errorPrefixColor = SushiTheme.colors.text.error,
        focusedSuffixColor = SushiTheme.colors.text.primary,
        unfocusedSuffixColor = SushiTheme.colors.text.primary,
        disabledSuffixColor = SushiTheme.colors.text.disabled,
        errorSuffixColor = SushiTheme.colors.text.error,
    )
}