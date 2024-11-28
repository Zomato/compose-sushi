@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.asIconSizeSpec
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.asTextTypeSpec
import com.zomato.sushi.compose.utils.takeIfSpecified

@Composable
internal fun SushiSurfaceButtonImpl(
    props: SushiButtonProps,
    onClick: () -> Unit,
    color: ColorSpec,
    colorDisabled: ColorSpec,
    fontColor: ColorSpec,
    fontColorPressed: ColorSpec,
    fontColorDisabled: ColorSpec,
    borderStrokeColor: ColorSpec,
    borderStrokeColorPressed: ColorSpec,
    borderStrokeColorDisabled: ColorSpec,
    borderStrokeWidth: Dp,
    modifier: Modifier = Modifier,
    content: (@Composable SushiButtonContentScope.() -> Unit)? = null
) {
    var isTapped by remember { mutableStateOf(false) }
    val isDisabled = props.isDisabled == true

    val appliedStrokeColor = when {
        isDisabled -> borderStrokeColorDisabled
        isTapped -> borderStrokeColorPressed
        else -> borderStrokeColor
    }
    val minHeight: Dp = getButtonMinHeight(props.getButtonSizeWithDefaults())

    Button(
        onClick = onClick,
        modifier
            .semantics { role = Role.Button }
            .pointerInput(props) {
                while (true) {
                    awaitPointerEventScope {
                        awaitFirstDown(false)
                        isTapped = true
                        waitForUpOrCancellation()
                        isTapped = false
                    }
                }
            }
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                enabled = !isDisabled,
                onClick = onClick
            )
            .heightIn(min = minHeight),
        enabled = !isDisabled,
        shape = props.getButtonShapeWithDefaults(),
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = color.value,
            contentColor = if (isTapped) fontColorPressed.value else fontColor.value,
            disabledContainerColor = colorDisabled.value,
            disabledContentColor = fontColorDisabled.value
        ),
        border = borderStrokeWidth.takeIf { it > 0.dp }?.let {
            BorderStroke(borderStrokeWidth, appliedStrokeColor.value)
        }
    ) {
        if (content != null) {
            val contentScopeData = remember(isTapped, isDisabled) {
                object : SushiButtonContentScope, RowScope by this {
                    override val isTapped: Boolean
                        get() = isTapped
                    override val isDisabled: Boolean
                        get() = isDisabled
                }
            }
            contentScopeData.content()
        } else {
            SushiSurfaceButtonImplContent(
                props = props,
                isDisabled = isDisabled,
                isTapped = isTapped,
                fontColorDisabled = fontColorDisabled,
                fontColorPressed = fontColorPressed,
                fontColor = fontColor
            )
        }
    }
}

@Composable
private fun SushiSurfaceButtonImplContent(
    props: SushiButtonProps,
    isDisabled: Boolean,
    isTapped: Boolean,
    fontColorDisabled: ColorSpec,
    fontColorPressed: ColorSpec,
    fontColor: ColorSpec
) {

    val appliedFontColor = when {
        isDisabled -> fontColorDisabled
        isTapped -> fontColorPressed
        else -> fontColor
    }

    val textType = props.fontType?.typeStyle ?: getButtonTextType(props.getButtonSizeWithDefaults())
    val defaultIconSize: TextUnit = getButtonIconSize(props.getButtonSizeWithDefaults())
    val iconPadding: Dp = props.iconSpacing ?: getButtonIconPadding(props.getButtonSizeWithDefaults())

    val prefixIcon = props.prefixIcon?.copy(
        size = props.prefixIcon.size ?: defaultIconSize.asIconSizeSpec(),
        color = props.prefixIcon.color.takeIfSpecified() ?: appliedFontColor
    )
    val suffixIcon = props.suffixIcon?.copy(
        size = props.suffixIcon.size ?: defaultIconSize.asIconSizeSpec(),
        color = props.suffixIcon.color.takeIfSpecified() ?: appliedFontColor
    )
    Column(horizontalAlignment = props.getButtonAlignmentWithDefaults()) {
        Row {
            if (prefixIcon != null) {
                SushiIcon(
                    props = prefixIcon,
                    Modifier.padding(end = iconPadding)
                )
            }
            SushiText(
                SushiTextProps(
                    text = props.text,
                    color = appliedFontColor,
                    type = textType.asTextTypeSpec(),
                    isMarkDownEnabled = props.isMarkDownEnabled
                )
            )
            if (suffixIcon != null) {
                SushiIcon(
                    props = suffixIcon,
                    Modifier.padding(start = iconPadding)
                )
            }
        }
        if (!props.subtext.isNullOrEmpty()) {
            SushiText(
                SushiTextProps(
                    text = props.subtext,
                    color = appliedFontColor,
                    type = props.getSubtextTextStyle(textType).asTextTypeSpec()
                )
            )
        }
    }
}