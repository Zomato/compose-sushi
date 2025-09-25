package com.zomato.sushi.compose.atoms.textfield

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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.TextRange
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
 * - Enhanced text control with TextRange when selection is specified
 *
 * This component wraps the Material3 OutlinedTextField to maintain consistency
 * with the design system while leveraging the functionality of the standard component.
 *
 * @param props The properties to configure the text field's appearance and behavior
 * @param onValueChange Callback that provides the updated text when the user edits the field
 * @param onTextFieldValueChange Optional callback for TextFieldValue when selection is used
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
    SushiComponentBase(
        modifier
            .height(IntrinsicSize.Max)
            .width(IntrinsicSize.Max)
            .testTag("SushiTextField")
    ) {
        SushiTextFieldImpl(
            props = props,
            onTextFieldValueChange = onTextFieldValueChange,
            modifier = Modifier.fillMaxSize(),
            interactionSource = interactionSource,
            prefix = prefix,
            leadingIcon = leadingIcon,
            suffix = suffix,
            trailingIcon = trailingIcon,
            label = label,
            supportingText = supportingText,
            placeholder = placeholder,
            onPrefixIconClick = onPrefixIconClick,
            onLeadingIconClick = onLeadingIconClick,
            onSuffixIconClick = onSuffixIconClick,
            onTrailingIconClick = onTrailingIconClick
        )
    }
}

@Composable
private fun SushiTextFieldImpl(
    props: SushiTextFieldProps,
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
    val enabled = props.enabled != false
    val readOnly = props.readOnly == true
    val textStyle = props.textStyle ?: SushiTextFieldDefaults.textStyle
    val isError = props.isError == true
    val singleLine = props.singleLine == true
    val maxLines = props.maxLines ?: if (singleLine) 1 else Int.MAX_VALUE
    val minLines = props.minLines ?: 1
    val shape = props.shape ?: SushiTextFieldDefaults.shape
    val colors = props.colors ?: SushiTextFieldDefaults.outlinedColors()
    val textFieldValue = props.textFieldValue ?: TextFieldValue("")

    val useTextFieldValue = props.textFieldValue != null
    val actualText = if (useTextFieldValue) props.textFieldValue.text else ""
    val showResetButton = actualText.isNotEmpty() && props.showResetButton != false && !readOnly

    val interactionSource = interactionSource ?: remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    OutlinedTextField(
        value = textFieldValue,
        onValueChange = { onTextFieldValueChange(it) },
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle.typeStyle,
        label = label ?: props.label?.let {
            getLabelTextComposable(
                it,
                isFocused = isFocused,
                isError = isError,
                isDisabled = !enabled,
                colors = colors,
            )
        },
        placeholder = {
            if (placeholder != null) {
                placeholder()
            } else {
                PlaceHolder(
                    props.placeholder,
                    isFocused = isFocused,
                    isError = isError,
                    isDisabled = !enabled,
                    colors = colors,
                    defaultTextStyle = textStyle.typeStyle
                )
            }
        },
        prefix = {
            if (prefix != null) {
                prefix()
            } else {
                Prefix(
                    props = props,
                    isFocused = isFocused,
                    isError = isError,
                    isDisabled = !enabled,
                    colors = colors,
                    defaultPrefixTextStyle = textStyle.typeStyle,
                    onPrefixIconClick = onPrefixIconClick
                )
            }
        },
        leadingIcon = if (leadingIcon != null) {
            { leadingIcon() }
        } else {
            getLeadingComposable(
                props = props,
                isFocused = isFocused,
                isError = isError,
                isDisabled = !enabled,
                colors = colors,
                onLeadingIconClick = onLeadingIconClick
            )
        },
        suffix = {
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
                            .clickable { onTextFieldValueChange(TextFieldValue("")) }
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
                        props = props,
                        isFocused = isFocused,
                        isError = isError,
                        isDisabled = !enabled,
                        colors = colors,
                        defaultPrefixTextStyle = textStyle.typeStyle,
                        onSuffixIconClick = onSuffixIconClick
                    )
                }
            }
        },
        trailingIcon = if (trailingIcon != null) {
            { trailingIcon() }
        } else {
            getTrailingComposable(
                props = props,
                isFocused = isFocused,
                isError = isError,
                isDisabled = !enabled,
                colors = colors,
                onTrailingIconClick = onTrailingIconClick
            )
        },
        supportingText = supportingText ?: props.supportText?.let { getSupportTextComposable(it) },
        isError = isError,
        visualTransformation = props.visualTransformation ?: VisualTransformation.None,
        keyboardOptions = props.keyboardOptions ?: KeyboardOptions.Default,
        keyboardActions = props.keyboardActions ?: KeyboardActions.Default,
        singleLine = singleLine,
        maxLines = maxLines,
        minLines = minLines,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors.toTextFieldColors()
    )
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
    props: SushiTextFieldProps,
    isFocused: Boolean,
    isError: Boolean,
    isDisabled: Boolean,
    colors: SushiTextFieldColors,
    onLeadingIconClick: (() -> Unit)? = null,
): (@Composable () -> Unit)? {
    if (props.leadingIcon == null) {
        return null
    }
    return {
        val defaultColor = when {
            isDisabled -> colors.disabledLeadingIconColor
            isError -> colors.errorLeadingIconColor
            isFocused -> colors.focusedLeadingIconColor
            else -> colors.unfocusedLeadingIconColor
        }.value

        val leadingIcon = remember(props.leadingIcon) {
            props.leadingIcon.copy(
                size = props.leadingIcon.size ?: SushiIconSize.Size200,
                color = props.leadingIcon.color.takeIfUnspecified { defaultColor }
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
    props: SushiTextFieldProps,
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
        if (props.prefixText != null) {
            val prefixText = remember(props.prefixText, defaultPrefixTextStyle, defaultColor) {
                props.prefixText.copy(
                    type = props.prefixText.type ?: defaultPrefixTextStyle.asTextTypeSpec(),
                    color = props.prefixText.color.takeIfUnspecified { defaultColor }
                )
            }
            SushiText(prefixText)
        }
        if (props.prefixIcon != null) {
            val prefixIcon = remember(props.prefixIcon) {
                props.prefixIcon.copy(
                    size = props.prefixIcon.size ?: SushiIconSize.Size200,
                    color = props.prefixIcon.color.takeIfUnspecified { defaultColor }
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

@Composable
private fun Suffix(
    props: SushiTextFieldProps,
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
        if (props.suffixText != null || props.suffixIcon != null) {
            Spacer(
                Modifier
                    .padding(vertical = 2.dp, horizontal = 4.dp)
                    .background(colors.unfocusedIndicatorColor.value)
                    .width(1.dp)
                    .fillMaxHeight()
            )
        }
        if (props.suffixText != null) {
            val suffixText = remember(props.suffixText, defaultPrefixTextStyle, defaultColor) {
                props.suffixText.copy(
                    type = props.suffixText.type ?: defaultPrefixTextStyle.asTextTypeSpec(),
                    color = props.suffixText.color.takeIfUnspecified { defaultColor }
                )
            }
            SushiText(suffixText)
        }
        if (props.suffixIcon != null) {
            val suffixIcon = remember(props.suffixIcon) {
                props.suffixIcon.copy(
                    size = props.suffixIcon.size ?:SushiIconSize.Size200,
                    color = props.suffixIcon.color.takeIfUnspecified { defaultColor }
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
    props: SushiTextFieldProps,
    isFocused: Boolean,
    isError: Boolean,
    isDisabled: Boolean,
    colors: SushiTextFieldColors,
    onTrailingIconClick: (() -> Unit)? = null
): (@Composable () -> Unit)? {
    if (props.trailingIcon == null) {
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
                val trailingIcon = remember(props.trailingIcon) {
                    props.trailingIcon.copy(
                        size = props.trailingIcon.size ?:SushiIconSize.Size200,
                        color = props.trailingIcon.color.takeIfUnspecified { defaultColor }
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
        var textFieldValue by remember {
            mutableStateOf(TextFieldValue(""))
        }

        Column(horizontalAlignment = Alignment.End) {
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "1",
                    textFieldValue = textFieldValue,
                    placeholder = SushiTextProps(text = "Enter text"),
                    label = SushiTextProps(text = "Label")
                ),
                onTextFieldValueChange = {
                    textFieldValue = it
                },
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiTextFieldPreview2() {
    SushiPreview {
        var textFieldValue by remember {
            mutableStateOf(TextFieldValue("Hello"))
        }

        Column(horizontalAlignment = Alignment.End) {
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "1",
                    textFieldValue = textFieldValue,
                    placeholder = SushiTextProps(text = "Enter text")
                ),
                onTextFieldValueChange = {
                    textFieldValue = it
                }
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiTextFieldPreview3() {
    SushiPreview {
        var textFieldValue by remember {
            mutableStateOf(TextFieldValue("9999999999"))
        }

        Column(horizontalAlignment = Alignment.End) {
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "1",
                    textFieldValue = textFieldValue,
                    prefixText = SushiTextProps(text = "+91")
                ),
                onTextFieldValueChange = {
                    textFieldValue = it
                }
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiTextFieldPreview4() {
    SushiPreview {
        var textFieldValue by remember {
            mutableStateOf(TextFieldValue("9999999999"))
        }

        Column(horizontalAlignment = Alignment.End) {
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "1",
                    textFieldValue = textFieldValue,
                    prefixIcon = SushiIconProps(SushiIconCodes.IconSafteySheild)
                ),
                onTextFieldValueChange = {
                    textFieldValue = it
                }
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiTextFieldPreview5() {
    SushiPreview {
        var textFieldValue by remember {
            mutableStateOf(TextFieldValue("20.99"))
        }

        Column(horizontalAlignment = Alignment.End) {
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "1",
                    textFieldValue = textFieldValue,
                    suffixText = SushiTextProps(text = "AED")
                ),
                onTextFieldValueChange = {
                    textFieldValue = it
                }
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiTextFieldPreview6() {
    SushiPreview {
        var textFieldValue by remember {
            mutableStateOf(TextFieldValue("20.99"))
        }

        Column(horizontalAlignment = Alignment.End) {
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "1",
                    textFieldValue = textFieldValue,
                    suffixIcon = SushiIconProps(code = SushiIconCodes.IconSafteySheild)
                ),
                onTextFieldValueChange = {
                    textFieldValue = it
                }
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiTextFieldPreview7() {
    SushiPreview {
        var textFieldValue by remember {
            mutableStateOf(TextFieldValue("9999999999"))
        }

        Column(horizontalAlignment = Alignment.End) {
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "1",
                    textFieldValue = textFieldValue
                ),
                prefix = {
                    SushiText(
                        SushiTextProps(
                            text = "+91",
                            type = SushiTheme.typography.regular500.asTextTypeSpec()
                        )
                    )
                },
                onTextFieldValueChange = {
                    textFieldValue = it
                }
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiTextFieldPreview8() {
    SushiPreview {
        var textFieldValue by remember {
            mutableStateOf(TextFieldValue(""))
        }

        Column(horizontalAlignment = Alignment.End) {
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "1",
                    textFieldValue = textFieldValue,
                    suffixIcon = SushiIconProps(code = SushiIconCodes.IconSafteySheild),
                    supportText = SushiTextProps(
                        text = "Something went wrong!",
                        color = Color.Red.asColorSpec()
                    )
                ),
                onTextFieldValueChange = {
                    textFieldValue = it
                }
            )
        }
    }
}

@Composable
@SushiPreview
private fun SushiTextFieldPreview9() {
    SushiPreview {
        var textFieldValue by remember {
            mutableStateOf(TextFieldValue(""))
        }

        Column {
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "1",
                    textFieldValue = textFieldValue,
                    supportText = SushiTextProps(
                        text = "Something went wrong!",
                        color = Color.Red.asColorSpec()
                    ),
                    prefixText = SushiTextProps("+91 "),
                    trailingIcon = SushiIconProps(code = SushiIconCodes.IconContactsDroid, size = SushiIconSize.Size400),
                    label = SushiTextProps("Receiver's Phone"),
                    showResetButton = false
                ),
                onTextFieldValueChange = {
                    textFieldValue = it
                },
            )
        }
    }
}