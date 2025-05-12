package com.zomato.sushi.compose.atoms.textfield

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.icon.SushiIconSize
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.TextTypeSpec
import com.zomato.sushi.compose.atoms.text.asTextTypeSpec
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.modifiers.ifNonNull
import com.zomato.sushi.compose.utils.takeIfSpecified
import com.zomato.sushi.compose.utils.takeIfUnspecified

/**
 * A customizable text input field component for the Sushi design system.
 *
 * SushiTextField provides a standard text field with support for:
 * - Labels and placeholder text
 * - Error states and support text
 * - Prefix and suffix text/icons
 * - Custom styling via colors and shapes
 * - Keyboard options and actions
 * - Accessibility features
 *
 * This component wraps the Material3 OutlinedTextField to maintain consistency
 * with the design system while leveraging the functionality of the standard component.
 *
 * @param text Current [TextFieldValue] value displayed in the field
 * @param onValueChange Callback that provides the updated [TextFieldValue] when the user changes the field
 * @param modifier The modifier to be applied to the component
 * @param id Optional identifier for the text field
 * @param textStyle Typography style for the input text
 * @param placeholder Text displayed when the field is empty
 * @param enabled Whether the text field is interactive (true) or disabled (false)
 * @param readOnly Whether the text field allows user input (false) or is read-only (true)
 * @param isError Whether to display the text field in an error state
 * @param label Optional label text displayed above the text field
 * @param keyboardOptions Options controlling the behavior of the software keyboard
 * @param keyboardActions Actions to perform based on keyboard input
 * @param singleLine Whether the text field should be limited to a single line
 * @param showResetButton Show a reset button to clear the text field's input (default is true)
 * @param maxLines Maximum number of lines to display when not in single line mode
 * @param minLines Minimum number of lines to display
 * @param shape The shape of the text field container
 * @param visualTransformation Optional transformation for displaying the text (e.g., password masking)
 * @param supportText Optional supporting text displayed below the text field
 * @param prefixIcon Optional icon displayed at the start of the text field (visible when the field is not empty, or in focus)
 * @param leadingIcon Optional icon displayed at the start of the text field (always visible)
 * @param suffixIcon Optional icon displayed at the end of the text field (visible when the field is not empty, or in focus)
 * @param trailingIcon Optional icon displayed at the end of the text field (always visible)
 * @param prefixText Optional text displayed at the start of the text field (visible when the field is not empty, or in focus)
 * @param suffixText Optional text displayed at the end of the text field (visible when the field is not empty, or in focus)
 * @param colors Color scheme for the text field's various states
 * @param interactionSource Optional interaction source that will be used to handle interactions with the text field
 * @param prefix Optional custom content to display at the start of the text field
 * @param suffix Optional custom content to display at the end of the text field
 * @param label Optional custom content to display as the text field label
 * @param supportingText Optional custom content to display as supporting text below the field
 * @param placeholder Optional custom content to display when the field is empty
 */
@Composable
fun SushiTextField(
    text: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    id: String? = null,
    textStyle: TextTypeSpec? = null,
    placeholder: SushiTextProps? = null,
    enabled: Boolean? = null,
    readOnly: Boolean? = null,
    isError: Boolean? = null,
    label: SushiTextProps? = null,
    keyboardOptions: KeyboardOptions? = null,
    keyboardActions: KeyboardActions? = null,
    singleLine: Boolean? = null,
    showResetButton: Boolean? = null,
    maxLines: Int? = null,
    minLines: Int? = null,
    shape: Shape? = null,
    visualTransformation: VisualTransformation? = null,
    supportText: SushiTextProps? = null,
    prefixIcon: SushiIconProps? = null,
    leadingIcon: SushiIconProps? = null,
    suffixIcon: SushiIconProps? = null,
    trailingIcon: SushiIconProps? = null,
    prefixText: SushiTextProps? = null,
    suffixText: SushiTextProps? = null,
    colors: SushiTextFieldColors? = null,
    interactionSource: MutableInteractionSource? = null,
    prefixProvider: @Composable (() -> Unit)? = null,
    leadingIconProvider: @Composable (() -> Unit)? = null,
    suffixProvider: @Composable (() -> Unit)? = null,
    trailingIconProvider: @Composable (() -> Unit)? = null,
    labelProvider: @Composable (() -> Unit)? = null,
    supportingTextProvider: @Composable (() -> Unit)? = null,
    placeholderProvider: @Composable (() -> Unit)? = null,
    onPrefixIconClick: (() -> Unit)? = null,
    onLeadingIconClick: (() -> Unit)? = null,
    onSuffixIconClick: (() -> Unit)? = null,
    onTrailingIconClick: (() -> Unit)? = null,
) {
    SushiComponentBase(
        modifier
            .height(IntrinsicSize.Max)
            .width(IntrinsicSize.Max)
            .testTag("SushiTextField")
    ) {
        SushiTextFieldImpl(
            propsId = id,
            propsText = null,
            propsTextFieldValue = text,
            propsTextStyle = textStyle,
            propsPlaceholder = placeholder,
            propsEnabled = enabled,
            propsReadOnly = readOnly,
            propsIsError = isError,
            propsLabel = label,
            propsKeyboardOptions = keyboardOptions,
            propsKeyboardActions = keyboardActions,
            propsSingleLine = singleLine,
            propsShowResetButton = showResetButton,
            propsMaxLines = maxLines,
            propsMinLines = minLines,
            propsShape = shape,
            propsVisualTransformation = visualTransformation,
            propsSupportText = supportText,
            propsPrefixIcon = prefixIcon,
            propsLeadingIcon = leadingIcon,
            propsSuffixIcon = suffixIcon,
            propsTrailingIcon = trailingIcon,
            propsPrefixText = prefixText,
            propsSuffixText = suffixText,
            propsColors = colors,
            onValueChange = {},
            onTextFieldValueChange = onValueChange,
            modifier = Modifier.fillMaxSize(),
            interactionSource = interactionSource,
            prefix = prefixProvider,
            leadingIcon = leadingIconProvider,
            suffix = suffixProvider,
            trailingIcon = trailingIconProvider,
            label = labelProvider,
            supportingText = supportingTextProvider,
            placeholder = placeholderProvider,
            onPrefixIconClick = onPrefixIconClick,
            onLeadingIconClick = onLeadingIconClick,
            onSuffixIconClick = onSuffixIconClick,
            onTrailingIconClick = onTrailingIconClick
        )
    }
}

/**
 * A customizable text input field component for the Sushi design system.
 *
 * SushiTextField provides a standard text field with support for:
 * - Labels and placeholder text
 * - Error states and support text
 * - Prefix and suffix text/icons
 * - Custom styling via colors and shapes
 * - Keyboard options and actions
 * - Accessibility features
 *
 * This component wraps the Material3 OutlinedTextField to maintain consistency
 * with the design system while leveraging the functionality of the standard component.
 *
 * @param text Current text value displayed in the field
 * @param onValueChange Callback that provides the updated text when the user edits the field
 * @param modifier The modifier to be applied to the component
 * @param id Optional identifier for the text field
 * @param textStyle Typography style for the input text
 * @param placeholder Text displayed when the field is empty
 * @param enabled Whether the text field is interactive (true) or disabled (false)
 * @param readOnly Whether the text field allows user input (false) or is read-only (true)
 * @param isError Whether to display the text field in an error state
 * @param label Optional label text displayed above the text field
 * @param keyboardOptions Options controlling the behavior of the software keyboard
 * @param keyboardActions Actions to perform based on keyboard input
 * @param singleLine Whether the text field should be limited to a single line
 * @param showResetButton Show a reset button to clear the text field's input (default is true)
 * @param maxLines Maximum number of lines to display when not in single line mode
 * @param minLines Minimum number of lines to display
 * @param shape The shape of the text field container
 * @param visualTransformation Optional transformation for displaying the text (e.g., password masking)
 * @param supportText Optional supporting text displayed below the text field
 * @param prefixIcon Optional icon displayed at the start of the text field (visible when the field is not empty, or in focus)
 * @param leadingIcon Optional icon displayed at the start of the text field (always visible)
 * @param suffixIcon Optional icon displayed at the end of the text field (visible when the field is not empty, or in focus)
 * @param trailingIcon Optional icon displayed at the end of the text field (always visible)
 * @param prefixText Optional text displayed at the start of the text field (visible when the field is not empty, or in focus)
 * @param suffixText Optional text displayed at the end of the text field (visible when the field is not empty, or in focus)
 * @param colors Color scheme for the text field's various states
 * @param interactionSource Optional interaction source that will be used to handle interactions with the text field
 * @param prefix Optional custom content to display at the start of the text field
 * @param suffix Optional custom content to display at the end of the text field
 * @param label Optional custom content to display as the text field label
 * @param supportingText Optional custom content to display as supporting text below the field
 * @param placeholder Optional custom content to display when the field is empty
 */
@Composable
fun SushiTextField(
    text: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    id: String? = null,
    textStyle: TextTypeSpec? = null,
    placeholder: SushiTextProps? = null,
    enabled: Boolean? = null,
    readOnly: Boolean? = null,
    isError: Boolean? = null,
    label: SushiTextProps? = null,
    keyboardOptions: KeyboardOptions? = null,
    keyboardActions: KeyboardActions? = null,
    singleLine: Boolean? = null,
    showResetButton: Boolean? = null,
    maxLines: Int? = null,
    minLines: Int? = null,
    shape: Shape? = null,
    visualTransformation: VisualTransformation? = null,
    supportText: SushiTextProps? = null,
    prefixIcon: SushiIconProps? = null,
    leadingIcon: SushiIconProps? = null,
    suffixIcon: SushiIconProps? = null,
    trailingIcon: SushiIconProps? = null,
    prefixText: SushiTextProps? = null,
    suffixText: SushiTextProps? = null,
    colors: SushiTextFieldColors? = null,
    interactionSource: MutableInteractionSource? = null,
    prefixProvider: @Composable (() -> Unit)? = null,
    leadingIconProvider: @Composable (() -> Unit)? = null,
    suffixProvider: @Composable (() -> Unit)? = null,
    trailingIconProvider: @Composable (() -> Unit)? = null,
    labelProvider: @Composable (() -> Unit)? = null,
    supportingTextProvider: @Composable (() -> Unit)? = null,
    placeholderProvider: @Composable (() -> Unit)? = null,
    onPrefixIconClick: (() -> Unit)? = null,
    onLeadingIconClick: (() -> Unit)? = null,
    onSuffixIconClick: (() -> Unit)? = null,
    onTrailingIconClick: (() -> Unit)? = null,
) {
    SushiComponentBase(
        modifier
            .height(IntrinsicSize.Max)
            .width(IntrinsicSize.Max)
            .testTag("SushiTextField")
    ) {
        SushiTextFieldImpl(
            propsId = id,
            propsText = text,
            propsTextFieldValue = null,
            propsTextStyle = textStyle,
            propsPlaceholder = placeholder,
            propsEnabled = enabled,
            propsReadOnly = readOnly,
            propsIsError = isError,
            propsLabel = label,
            propsKeyboardOptions = keyboardOptions,
            propsKeyboardActions = keyboardActions,
            propsSingleLine = singleLine,
            propsShowResetButton = showResetButton,
            propsMaxLines = maxLines,
            propsMinLines = minLines,
            propsShape = shape,
            propsVisualTransformation = visualTransformation,
            propsSupportText = supportText,
            propsPrefixIcon = prefixIcon,
            propsLeadingIcon = leadingIcon,
            propsSuffixIcon = suffixIcon,
            propsTrailingIcon = trailingIcon,
            propsPrefixText = prefixText,
            propsSuffixText = suffixText,
            propsColors = colors,
            onValueChange = onValueChange,
            onTextFieldValueChange = {},
            modifier = Modifier.fillMaxSize(),
            interactionSource = interactionSource,
            prefix = prefixProvider,
            leadingIcon = leadingIconProvider,
            suffix = suffixProvider,
            trailingIcon = trailingIconProvider,
            label = labelProvider,
            supportingText = supportingTextProvider,
            placeholder = placeholderProvider,
            onPrefixIconClick = onPrefixIconClick,
            onLeadingIconClick = onLeadingIconClick,
            onSuffixIconClick = onSuffixIconClick,
            onTrailingIconClick = onTrailingIconClick
        )
    }
}

/**
 * A customizable text input field component for the Sushi design system.
 * 
 * SushiTextField provides a standard text field with support for:
 * - Labels and placeholder text
 * - Error states and support text
 * - Prefix and suffix text/icons
 * - Custom styling via colors and shapes
 * - Keyboard options and actions
 * - Accessibility features
 *
 * This component wraps the Material3 OutlinedTextField to maintain consistency
 * with the design system while leveraging the functionality of the standard component.
 *
 * @param props The properties to configure the text field's appearance and behavior
 * @param onValueChange Callback that provides the updated text when the user edits the field
 * @param modifier The modifier to be applied to the component
 * @param interactionSource Optional interaction source that will be used to handle interactions with the text field
 * @param prefix Optional custom content to display at the start of the text field
 * @param suffix Optional custom content to display at the end of the text field
 * @param label Optional custom content to display as the text field label
 * @param supportingText Optional custom content to display as supporting text below the field
 * @param placeholder Optional custom content to display when the field is empty
 */
@Composable
fun SushiTextField(
    props: SushiTextFieldProps,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource? = null,
    prefixProvider: @Composable (() -> Unit)? = null,
    leadingIconProvider: @Composable (() -> Unit)? = null,
    suffixProvider: @Composable (() -> Unit)? = null,
    trailingIconProvider: @Composable (() -> Unit)? = null,
    labelProvider: @Composable (() -> Unit)? = null,
    supportingTextProvider: @Composable (() -> Unit)? = null,
    placeholderProvider: @Composable (() -> Unit)? = null,
    onPrefixIconClick: (() -> Unit)? = null,
    onLeadingIconClick: (() -> Unit)? = null,
    onSuffixIconClick: (() -> Unit)? = null,
    onTrailingIconClick: (() -> Unit)? = null,
) {
    SushiComponentBase(
        modifier
            .height(IntrinsicSize.Max)
            .width(IntrinsicSize.Max)
            .testTag("SushiTextField")
    ) {
        SushiTextFieldImpl(
            propsId = props.id,
            propsText = props.text,
            propsTextFieldValue = null,
            propsTextStyle = props.textStyle,
            propsPlaceholder = props.placeholder,
            propsEnabled = props.enabled,
            propsReadOnly = props.readOnly,
            propsIsError = props.isError,
            propsLabel = props.label,
            propsKeyboardOptions = props.keyboardOptions,
            propsKeyboardActions = props.keyboardActions,
            propsSingleLine = props.singleLine,
            propsShowResetButton = props.showResetButton,
            propsMaxLines = props.maxLines,
            propsMinLines = props.minLines,
            propsShape = props.shape,
            propsVisualTransformation = props.visualTransformation,
            propsSupportText = props.supportText,
            propsPrefixIcon = props.prefixIcon,
            propsLeadingIcon = props.leadingIcon,
            propsSuffixIcon = props.suffixIcon,
            propsTrailingIcon = props.trailingIcon,
            propsPrefixText = props.prefixText,
            propsSuffixText = props.suffixText,
            propsColors = props.colors,
            onValueChange = onValueChange,
            onTextFieldValueChange = {},
            modifier = Modifier.fillMaxSize(),
            interactionSource = interactionSource,
            prefix = prefixProvider,
            leadingIcon = leadingIconProvider,
            suffix = suffixProvider,
            trailingIcon = trailingIconProvider,
            label = labelProvider,
            supportingText = supportingTextProvider,
            placeholder = placeholderProvider,
            onPrefixIconClick = onPrefixIconClick,
            onLeadingIconClick = onLeadingIconClick,
            onSuffixIconClick = onSuffixIconClick,
            onTrailingIconClick = onTrailingIconClick
        )
    }
}

@SuppressLint("ComposeParameterOrder")
@Composable
private fun SushiTextFieldImpl(
    propsId: String?,
    propsText: String?,
    propsTextFieldValue: TextFieldValue?,
    propsTextStyle: TextTypeSpec?,
    propsPlaceholder: SushiTextProps?,
    propsEnabled: Boolean?,
    propsReadOnly: Boolean?,
    propsIsError: Boolean?,
    propsLabel: SushiTextProps?,
    propsKeyboardOptions: KeyboardOptions?,
    propsKeyboardActions: KeyboardActions?,
    propsSingleLine: Boolean?,
    propsShowResetButton: Boolean?,
    propsMaxLines: Int?,
    propsMinLines: Int?,
    propsShape: Shape?,
    propsVisualTransformation: VisualTransformation?,
    propsSupportText: SushiTextProps?,
    propsPrefixIcon: SushiIconProps?,
    propsLeadingIcon: SushiIconProps?,
    propsSuffixIcon: SushiIconProps?,
    propsTrailingIcon: SushiIconProps?,
    propsPrefixText: SushiTextProps?,
    propsSuffixText: SushiTextProps?,
    propsColors: SushiTextFieldColors?,
    onValueChange: (String) -> Unit,
    onTextFieldValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource? = null,
    prefix: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    label: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    onPrefixIconClick: (() -> Unit)? = null,
    onLeadingIconClick: (() -> Unit)? = null,
    onSuffixIconClick: (() -> Unit)? = null,
    onTrailingIconClick: (() -> Unit)? = null,
) {
    val enabled = propsEnabled != false
    val readOnly = propsReadOnly == true
    val textStyle = propsTextStyle ?: SushiTextFieldDefaults.textStyle
    val isError = propsIsError == true
    val singleLine = propsSingleLine == true
    val maxLines = propsMaxLines ?: if (singleLine) 1 else Int.MAX_VALUE
    val minLines = propsMinLines ?: 1
    val shape = propsShape ?: SushiTextFieldDefaults.shape
    val colors = propsColors ?: SushiTextFieldDefaults.outlinedColors()
    val text = propsText ?: ""
    val textFieldValue = propsTextFieldValue ?: TextFieldValue("")
    val showResetButton = (text.isNotEmpty() || textFieldValue.text.isNotEmpty()) && propsShowResetButton != false && !readOnly

    val interactionSource = interactionSource ?: remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val resolvedLabel = label ?: propsLabel?.let {
        getLabelTextComposable(
            it,
            isFocused = isFocused,
            isError = isError,
            isDisabled = !enabled,
            colors = colors,
        )
    }

    val resolvedPlaceholder: @Composable () -> Unit = {
        if (placeholder != null) {
            placeholder()
        } else {
            PlaceHolder(
                propsPlaceholder,
                isFocused = isFocused,
                isError = isError,
                isDisabled = !enabled,
                colors = colors,
                defaultTextStyle = textStyle.typeStyle
            )
        }
    }

    val resolvedPrefix: @Composable () -> Unit = {
        if (prefix != null) {
            prefix()
        } else {
            Prefix(
                propsPrefixText = propsPrefixText,
                propsPrefixIcon = propsPrefixIcon,
                isFocused = isFocused,
                isError = isError,
                isDisabled = !enabled,
                colors = colors,
                defaultPrefixTextStyle = textStyle.typeStyle,
                onPrefixIconClick = onPrefixIconClick
            )
        }
    }

    val resolvedLeadingIcon = if (leadingIcon != null) {
        { leadingIcon() }
    } else {
        getLeadingComposable(
            propsLeadingIcon = propsLeadingIcon,
            isFocused = isFocused,
            isError = isError,
            isDisabled = !enabled,
            colors = colors,
            onLeadingIconClick = onLeadingIconClick
        )
    }

    val resolvedSuffix: @Composable () -> Unit = {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (showResetButton) {
                SushiIcon(
                    SushiIconProps(
                        SushiIconCodes.IconCrossCircleFill,
                        color = SushiTheme.colors.grey.v500,
                        size = SushiIconSize.Size200
                    ),
                    Modifier
                        .clickable { onValueChange("") }
                        .padding(
                            start = SushiTheme.dimens.spacing.nano,
                            end = SushiTheme.dimens.spacing.nano
                        )
                )
            }
            if (suffix != null) {
                suffix()
            } else {
                Suffix(
                    propsSuffixText = propsSuffixText,
                    propsSuffixIcon = propsSuffixIcon,
                    isFocused = isFocused,
                    isError = isError,
                    isDisabled = !enabled,
                    colors = colors,
                    defaultPrefixTextStyle = textStyle.typeStyle,
                    onSuffixIconClick = onSuffixIconClick
                )
            }
        }
    }

    val resolvedTrailingIcon = if (trailingIcon != null) {
        { trailingIcon() }
    } else {
        getTrailingComposable(
            propsTrailingIcon = propsTrailingIcon,
            isFocused = isFocused,
            isError = isError,
            isDisabled = !enabled,
            colors = colors,
            onTrailingIconClick = onTrailingIconClick
        )
    }

    val resolvedSupportingText = supportingText ?: propsSupportText?.let { getSupportTextComposable(it) }

    val resolvedVisualTransformation = propsVisualTransformation ?: VisualTransformation.None

    val resolvedKeyboardOptions = propsKeyboardOptions ?: KeyboardOptions.Default
    val resolvedKeyboardActions = propsKeyboardActions ?: KeyboardActions.Default

    val resolvedColors = colors.toTextFieldColors()

    if (propsTextFieldValue != null) {
        OutlinedTextField(
            value = textFieldValue,
            onValueChange = { onTextFieldValueChange(it) },
            modifier = modifier,
            enabled = enabled,
            readOnly = readOnly,
            textStyle = textStyle.typeStyle,
            label = resolvedLabel,
            placeholder = resolvedPlaceholder,
            prefix = resolvedPrefix,
            leadingIcon = resolvedLeadingIcon,
            suffix = resolvedSuffix,
            trailingIcon = resolvedTrailingIcon,
            supportingText = resolvedSupportingText,
            isError = isError,
            visualTransformation = resolvedVisualTransformation,
            keyboardOptions = resolvedKeyboardOptions,
            keyboardActions = resolvedKeyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            interactionSource = interactionSource,
            shape = shape,
            colors = resolvedColors
        )
    } else {
        OutlinedTextField(
            value = text,
            onValueChange = { onValueChange(it) },
            modifier = modifier,
            enabled = enabled,
            readOnly = readOnly,
            textStyle = textStyle.typeStyle,
            label = resolvedLabel,
            placeholder = resolvedPlaceholder,
            prefix = resolvedPrefix,
            leadingIcon = resolvedLeadingIcon,
            suffix = resolvedSuffix,
            trailingIcon = resolvedTrailingIcon,
            supportingText = resolvedSupportingText,
            isError = isError,
            visualTransformation = resolvedVisualTransformation,
            keyboardOptions = resolvedKeyboardOptions,
            keyboardActions = resolvedKeyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            interactionSource = interactionSource,
            shape = shape,
            colors = resolvedColors
        )
    }
}

private fun getLabelTextComposable(
    label: SushiTextProps,
    isFocused: Boolean,
    isError: Boolean,
    isDisabled: Boolean,
    colors: SushiTextFieldColors,
): @Composable () -> Unit {
    return {
        val defaultColor = when {
            isDisabled -> colors.disabledLabelColor
            isError -> colors.errorLabelColor
            isFocused -> colors.focusedLabelColor
            else -> colors.unfocusedLabelColor
        }.value

        val defaultTextStyle = SushiTextFieldDefaults.labelTextStyle
        val placeholder = remember(label, defaultTextStyle, defaultColor) {
            label.copy(
                type = label.type ?: defaultTextStyle,
                color = label.color.takeIfUnspecified { defaultColor }
            )
        }
        SushiText(placeholder)
    }
}

@Composable
private fun PlaceHolder(
    placeholder: SushiTextProps?,
    isFocused: Boolean,
    isError: Boolean,
    isDisabled: Boolean,
    colors: SushiTextFieldColors,
    defaultTextStyle: TextStyle
) {
    val defaultColor = when {
        isDisabled -> colors.disabledPlaceholderColor
        isError -> colors.errorPlaceholderColor
        isFocused -> colors.focusedPlaceholderColor
        else -> colors.unfocusedPlaceholderColor
    }.value

    if (placeholder != null) {
        val placeholder = remember(placeholder, defaultTextStyle, defaultColor) {
            placeholder.copy(
                type = placeholder.type ?: defaultTextStyle.asTextTypeSpec(),
                color = placeholder.color.takeIfUnspecified { defaultColor }
            )
        }
        SushiText(
            placeholder
        )
    }
}

@Composable
private fun getLeadingComposable(
    propsLeadingIcon: SushiIconProps?,
    isFocused: Boolean,
    isError: Boolean,
    isDisabled: Boolean,
    colors: SushiTextFieldColors,
    onLeadingIconClick: (() -> Unit)? = null,
): (@Composable () -> Unit)? {
    if (propsLeadingIcon == null) {
        return null
    }
    return {
        val defaultColor = when {
            isDisabled -> colors.disabledLeadingIconColor
            isError -> colors.errorLeadingIconColor
            isFocused -> colors.focusedLeadingIconColor
            else -> colors.unfocusedLeadingIconColor
        }.value

        val leadingIcon = remember(propsLeadingIcon) {
            propsLeadingIcon.copy(
                size = propsLeadingIcon.size ?: SushiIconSize.Size200,
                color = propsLeadingIcon.color.takeIfUnspecified { defaultColor }
            )
        }
        SushiIcon(
            leadingIcon,
            Modifier
                .ifNonNull(onLeadingIconClick) { this.clickable(onClick = it) }
                .padding(start = SushiTheme.dimens.spacing.micro)
        )
    }
}

@Composable
private fun Prefix(
    propsPrefixText: SushiTextProps?,
    propsPrefixIcon: SushiIconProps?,
    isFocused: Boolean,
    isError: Boolean,
    isDisabled: Boolean,
    colors: SushiTextFieldColors,
    defaultPrefixTextStyle: TextStyle,
    onPrefixIconClick: (() -> Unit)? = null,
) {
    val defaultColor = when {
        isDisabled -> colors.disabledLeadingIconColor
        isError -> colors.errorLeadingIconColor
        isFocused -> colors.focusedLeadingIconColor
        else -> colors.unfocusedLeadingIconColor
    }.value

    Row {
        if (propsPrefixText != null) {
            val prefixText = remember(propsPrefixText, defaultPrefixTextStyle, defaultColor) {
                propsPrefixText.copy(
                    type = propsPrefixText.type ?: defaultPrefixTextStyle.asTextTypeSpec(),
                    color = propsPrefixText.color.takeIfUnspecified { defaultColor }
                )
            }
            SushiText(prefixText)
        }
        if (propsPrefixIcon != null) {
            val prefixIcon = remember(propsPrefixIcon) {
                propsPrefixIcon.copy(
                    size = propsPrefixIcon.size ?: SushiIconSize.Size200,
                    color = propsPrefixIcon.color.takeIfUnspecified { defaultColor }
                )
            }
            SushiIcon(
                prefixIcon,
                Modifier
                    .ifNonNull(onPrefixIconClick) { this.clickable(onClick = it) }
                    .padding(start = SushiTheme.dimens.spacing.micro)
            )
        }
    }
}

@SuppressLint("ComposeParameterOrder")
@Composable
private fun Suffix(
    propsSuffixText: SushiTextProps? = null,
    propsSuffixIcon: SushiIconProps? = null,
    isFocused: Boolean,
    isError: Boolean,
    isDisabled: Boolean,
    colors: SushiTextFieldColors,
    defaultPrefixTextStyle: TextStyle,
    onSuffixIconClick: (() -> Unit)? = null
) {
    val defaultColor = when {
        isDisabled -> colors.disabledTrailingIconColor
        isError -> colors.errorTrailingIconColor
        isFocused -> colors.focusedTrailingIconColor
        else -> colors.unfocusedTrailingIconColor
    }.value

    Row(
        Modifier
            .height(IntrinsicSize.Max)
    ) {
        if (propsSuffixText != null || propsSuffixIcon != null) {
            Spacer(
                Modifier
                    .padding(vertical = 2.dp, horizontal = 4.dp)
                    .background(colors.unfocusedIndicatorColor.value)
                    .width(1.dp)
                    .fillMaxHeight()
            )
        }
        if (propsSuffixText != null) {
            val suffixText = remember(propsSuffixText, defaultPrefixTextStyle, defaultColor) {
                propsSuffixText.copy(
                    type = propsSuffixText.type ?: defaultPrefixTextStyle.asTextTypeSpec(),
                    color = propsSuffixText.color.takeIfUnspecified { defaultColor }
                )
            }
            SushiText(suffixText)
        }
        if (propsSuffixIcon != null) {
            val suffixIcon = remember(propsSuffixIcon) {
                propsSuffixIcon.copy(
                    size = propsSuffixIcon.size ?:SushiIconSize.Size200,
                    color = propsSuffixIcon.color.takeIfUnspecified { defaultColor }
                )
            }
            SushiIcon(
                suffixIcon,
                Modifier
                    .ifNonNull(onSuffixIconClick) { this.clickable(onClick = it) }
                    .padding(end = SushiTheme.dimens.spacing.micro)
            )
        }
    }
}

@Composable
private fun getTrailingComposable(
    propsTrailingIcon: SushiIconProps?,
    isFocused: Boolean,
    isError: Boolean,
    isDisabled: Boolean,
    colors: SushiTextFieldColors,
    onTrailingIconClick: (() -> Unit)? = null
): (@Composable () -> Unit)? {
    if (propsTrailingIcon == null) {
        return null
    }
    return {
        val defaultColor = when {
            isDisabled -> colors.disabledTrailingIconColor
            isError -> colors.errorTrailingIconColor
            isFocused -> colors.focusedTrailingIconColor
            else -> colors.unfocusedTrailingIconColor
        }.value

        Row(
            Modifier
                .width(IntrinsicSize.Max)
                .height(IntrinsicSize.Max)
                .defaultMinSize(minWidth = 48.dp, minHeight = 48.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(
                Modifier
                    .padding(vertical = 2.dp, horizontal = 4.dp)
                    .background(colors.unfocusedIndicatorColor.value)
                    .width(1.dp)
                    .fillMaxHeight()
            )
            Box(
                Modifier.weight(1f)
            ) {
                val trailingIcon = remember(propsTrailingIcon) {
                    propsTrailingIcon.copy(
                        size = propsTrailingIcon.size ?:SushiIconSize.Size200,
                        color = propsTrailingIcon.color.takeIfUnspecified { defaultColor }
                    )
                }
                SushiIcon(
                    trailingIcon,
                    Modifier
                        .align(Alignment.Center)
                        .ifNonNull(onTrailingIconClick) { this.clickable(onClick = it) }
                        .padding(end = SushiTheme.dimens.spacing.micro)
                )
            }
        }
    }
}

private fun getSupportTextComposable(
    text: SushiTextProps
): @Composable () -> Unit {
    return {
        val defaultTextStyle = SushiTextFieldDefaults.supportTextStyle
        val text = remember(text, defaultTextStyle) {
            text.copy(type = text.type ?: defaultTextStyle)
        }
        SushiText(text)
    }
}

@SushiPreview
@Composable
private fun SushiTextFieldPreview1() {
    SushiPreview {
        var text by remember {
            mutableStateOf("")
        }

        Column(horizontalAlignment = Alignment.End) {
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "1",
                    text = text,
                    placeholder = SushiTextProps(text = "Enter text"),
                    label = SushiTextProps(text = "Label")
                ),
                onValueChange = {
                    text = it
                },
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiTextFieldPreview2() {
    SushiPreview {
        var text by remember {
            mutableStateOf("Hello")
        }

        Column(horizontalAlignment = Alignment.End) {
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "1",
                    text = text,
                    placeholder = SushiTextProps(text = "Enter text")
                ),
                onValueChange = {
                    text = it
                }
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiTextFieldPreview3() {
    SushiPreview {
        var text by remember {
            mutableStateOf("9999999999")
        }

        Column(horizontalAlignment = Alignment.End) {
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "1",
                    text = text,
                    prefixText = SushiTextProps(text = "+91")
                ),
                onValueChange = {
                    text = it
                }
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiTextFieldPreview4() {
    SushiPreview {
        var text by remember {
            mutableStateOf("9999999999")
        }

        Column(horizontalAlignment = Alignment.End) {
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "1",
                    text = text,
                    prefixIcon = SushiIconProps(SushiIconCodes.IconSafteySheild)
                ),
                onValueChange = {
                    text = it
                }
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiTextFieldPreview5() {
    SushiPreview {
        var text by remember {
            mutableStateOf("20.99")
        }

        Column(horizontalAlignment = Alignment.End) {
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "1",
                    text = text,
                    suffixText = SushiTextProps(text = "AED")
                ),
                onValueChange = {
                    text = it
                }
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiTextFieldPreview6() {
    SushiPreview {
        var text by remember {
            mutableStateOf("20.99")
        }

        Column(horizontalAlignment = Alignment.End) {
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "1",
                    text = text,
                    suffixIcon = SushiIconProps(code = SushiIconCodes.IconSafteySheild)
                ),
                onValueChange = {
                    text = it
                }
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiTextFieldPreview7() {
    SushiPreview {
        var text by remember {
            mutableStateOf("9999999999")
        }

        Column(horizontalAlignment = Alignment.End) {
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "1",
                    text = text
                ),
                prefixProvider = {
                    SushiText(
                        SushiTextProps(
                            text = "+91",
                            type = SushiTheme.typography.regular500.asTextTypeSpec()
                        )
                    )
                },
                onValueChange = {
                    text = it
                }
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiTextFieldPreview8() {
    SushiPreview {
        var text by remember {
            mutableStateOf("")
        }

        Column(horizontalAlignment = Alignment.End) {
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "1",
                    text = text,
                    suffixIcon = SushiIconProps(code = SushiIconCodes.IconSafteySheild),
                    supportText = SushiTextProps(
                        text = "Something went wrong!",
                        color = Color.Red.asColorSpec()
                    )
                ),
                onValueChange = {
                    text = it
                }
            )
        }
    }
}

@Composable
@SushiPreview
private fun SushiTextFieldPreview9() {
    SushiPreview {
        var text by remember {
            mutableStateOf("")
        }

        Column {
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "1",
                    text = text,
                    supportText = SushiTextProps(
                        text = "Something went wrong!",
                        color = Color.Red.asColorSpec()
                    ),
                    prefixText = SushiTextProps("+91 "),
                    trailingIcon = SushiIconProps(code = SushiIconCodes.IconContactsDroid, size = SushiIconSize.Size400),
                    label = SushiTextProps("Receiver's Phone"),
                    showResetButton = false
                ),
                onValueChange = {
                    text = it
                },
            )
        }
    }
}