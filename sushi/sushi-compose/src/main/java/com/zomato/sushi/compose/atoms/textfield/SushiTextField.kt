package com.zomato.sushi.compose.atoms.textfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.VisualTransformation
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.asTextTypeSpec
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview

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
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    label: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
) {
    SushiComponentBase(
        modifier
            .height(IntrinsicSize.Max)
            .width(IntrinsicSize.Max)
            .testTag("SushiTextField")
    ) {
        SushiTextFieldImpl(
            props = props,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxSize(),
            interactionSource = interactionSource,
            prefix = prefix,
            suffix = suffix,
            label = label,
            supportingText = supportingText,
            placeholder = placeholder,
        )
    }
}

@Composable
private fun SushiTextFieldImpl(
    props: SushiTextFieldProps,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    label: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
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

    OutlinedTextField(
        value = props.text ?: "",
        onValueChange = { onValueChange(it) },
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle.typeStyle,
        label = label ?: props.label?.let { getLabelTextComposable(it) },
        placeholder = {
            if (placeholder != null) {
                placeholder()
            } else {
                PlaceHolder(
                    props.placeholder,
                    defaultTextStyle = textStyle.typeStyle
                )
            }
        },
        // leadingIcon = ,
        // trailingIcon = ,
        prefix = {
            if (prefix != null) {
                prefix()
            } else {
                Prefix(
                    props = props,
                    defaultPrefixTextStyle = textStyle.typeStyle
                )
            }
        },
        suffix = {
            if (suffix != null) {
                suffix()
            } else {
                Suffix(
                    props = props,
                    defaultPrefixTextStyle = textStyle.typeStyle
                )
            }
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
    label: SushiTextProps
): @Composable () -> Unit {
    return {
        val defaultTextStyle = SushiTextFieldDefaults.labelTextStyle
        val placeholder = remember(label, defaultTextStyle) {
            label.copy(type = label.type ?: defaultTextStyle)
        }
        SushiText(placeholder)
    }
}

@Composable
private fun PlaceHolder(
    placeholder: SushiTextProps?,
    defaultTextStyle: TextStyle
) {
    if (placeholder != null) {
        val placeholder = remember(placeholder, defaultTextStyle) {
            placeholder.copy(type = placeholder.type ?: defaultTextStyle.asTextTypeSpec())
        }
        SushiText(
            placeholder
        )
    }
}

@Composable
private fun Prefix(
    props: SushiTextFieldProps,
    defaultPrefixTextStyle: TextStyle
) {
    Row {
        if (props.prefixText != null) {
            val prefixText = remember(props.prefixText, defaultPrefixTextStyle) {
                props.prefixText.copy(type = props.prefixText.type ?: defaultPrefixTextStyle.asTextTypeSpec())
            }
            SushiText(prefixText)
        }
        if (props.prefixIcon != null) {
            SushiIcon(props.prefixIcon)
        }
    }
}

@Composable
private fun Suffix(
    props: SushiTextFieldProps,
    defaultPrefixTextStyle: TextStyle
) {
    Row {
        if (props.suffixText != null) {
            val suffixText = remember(props.suffixText, defaultPrefixTextStyle) {
                props.suffixText.copy(type = props.suffixText.type ?: defaultPrefixTextStyle.asTextTypeSpec())
            }
            SushiText(suffixText)
        }
        if (props.suffixIcon != null) {
            SushiIcon(props.suffixIcon)
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
                prefix = {
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
            mutableStateOf("20.99")
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