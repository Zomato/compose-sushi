@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.asIconSizeSpec
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.asTextTypeSpec
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.foundation.SushiTheme
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
    val isTapped = remember { mutableStateOf(false) }
    val isDisabled = props.isDisabled == true

    val appliedStrokeColor = when {
        isDisabled -> borderStrokeColorDisabled
        isTapped.value -> borderStrokeColorPressed
        else -> borderStrokeColor
    }

    val contentPadding = when (props.getButtonSizeWithDefaults()) {
        SushiButtonSize.Small -> PaddingValues(horizontal = SushiTheme.dimens.spacing.extra, vertical = SushiTheme.dimens.spacing.mini)
        SushiButtonSize.Medium -> PaddingValues(horizontal = SushiTheme.dimens.spacing.extra, vertical = SushiTheme.dimens.spacing.macro)
        SushiButtonSize.Large -> PaddingValues(horizontal = SushiTheme.dimens.spacing.extra, vertical = SushiTheme.dimens.spacing.macro)
    }

    ButtonImpl(
        onClick = onClick,
        modifier
            .pointerInput(isTapped) {
                while (true) {
                    awaitPointerEventScope {
                        awaitFirstDown(false)
                        isTapped.value = true
                        waitForUpOrCancellation()
                        isTapped.value = false
                    }
                }
            }
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(),
                enabled = !isDisabled,
                onClick = onClick
            ),
        enabled = !isDisabled,
        contentPadding = contentPadding,
        shape = props.getButtonShapeWithDefaults(),
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = color.value,
            contentColor = if (isTapped.value) fontColorPressed.value else fontColor.value,
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
                    override val isTapped: State<Boolean>
                        get() = isTapped
                }
            }
            contentScopeData.content()
        } else {
            SushiSurfaceButtonImplContent(
                props = props,
                isDisabled = isDisabled,
                isTapped = isTapped.value,
                fontColorDisabled = fontColorDisabled,
                fontColorPressed = fontColorPressed,
                fontColor = fontColor,
                Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
private fun RowScope.SushiSurfaceButtonImplContent(
    props: SushiButtonProps,
    isDisabled: Boolean,
    isTapped: Boolean,
    fontColorDisabled: ColorSpec,
    fontColorPressed: ColorSpec,
    fontColor: ColorSpec,
    modifier: Modifier
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

    val horizontalArrangement = props.getButtonHorizontalArrangementWithDefaults()
    val verticalAlignment = props.getButtonVerticalAlignmentWithDefaults()

    Row(
        modifier,
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = verticalAlignment
    ) {
        if (prefixIcon != null) {
            SushiIcon(
                props = prefixIcon,
                Modifier.padding(end = iconPadding)
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            SushiText(
                SushiTextProps(
                    text = props.text,
                    color = appliedFontColor,
                    type = textType.asTextTypeSpec(),
                    isMarkDownEnabled = props.isMarkDownEnabled
                )
            )
            if (!props.subText.isNullOrEmpty()) {
                SushiText(
                    SushiTextProps(
                        text = props.subText,
                        color = appliedFontColor,
                        type = props.getSubtextTextStyle(textType).asTextTypeSpec()
                    )
                )
            }
        }
        if (suffixIcon != null) {
            SushiIcon(
                props = suffixIcon,
                Modifier.padding(start = iconPadding)
            )
        }
    }
}