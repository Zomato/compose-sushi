@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.icon.asIconSizeSpec
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.asTextTypeSpec
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.Preview
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.takeIfSpecified

/**
 * @author gupta.anirudh@zomato.com
 */
@Composable
internal fun SushiTextButton(
    props: SushiButtonProps,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: (@Composable SushiButtonContentScope.() -> Unit)? = null
) {
    val isTapped = remember(props) { mutableStateOf(false) }
    val isDisabled = props.enabled == false

    val bgColor = props.color.takeIfSpecified() ?: SushiTheme.colors.button.ghostBackground
    val bgColorPressed = props.color.takeIfSpecified() ?: SushiTheme.colors.button.ghostBackgroundPressed
    val bgColorDisabled = bgColor

    val appliedBgColor = when {
        isDisabled -> bgColorDisabled
        isTapped.value -> bgColorPressed
        else -> bgColor
    }

    Box(
        modifier
            .semantics { role = Role.Button }
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
                interactionSource = interactionSource,
                indication = null,
                enabled = !isDisabled,
                onClick = onClick
            )
            .background(color = appliedBgColor.value)
    ) {
        Row(
            Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val contentScopeData = remember(isTapped) {
                object : SushiButtonContentScope, RowScope by this {
                    override val isTapped: State<Boolean>
                        get() = isTapped
                }
            }
            if (content != null) {
                contentScopeData.content()
            } else {
                SushiTextButtonContent(
                    props = props,
                    isDisabled = isDisabled,
                    isTapped = isTapped.value,
                    Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
private fun RowScope.SushiTextButtonContent(
    props: SushiButtonProps,
    isDisabled: Boolean,
    isTapped: Boolean,
    modifier: Modifier = Modifier
) {
    val fontColor = props.fontColor.takeIfSpecified() ?: SushiTheme.colors.button.ghostLabel
    val fontColorPressed = props.fontColor.takeIfSpecified() ?: SushiTheme.colors.button.ghostLabelPressed
    val fontColorDisabled = SushiTheme.colors.button.ghostLabelDisabled

    val appliedFontColor = when {
        isDisabled -> fontColorDisabled
        isTapped -> fontColorPressed
        else -> fontColor
    }

    val textType: TextStyle = props.fontType?.typeStyle ?: TextStyle(fontSize = getButtonTextSize(props.getButtonSizeWithDefaults()))
    val defaultIconSize: TextUnit = props.fontType?.typeStyle?.fontSize ?: getButtonIconSize(props.getButtonSizeWithDefaults())
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
                    type = textType.asTextTypeSpec(),
                    color = appliedFontColor,
                    isMarkDownEnabled = props.markdown
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

@SushiPreview
@Composable
private fun SushiTextButtonPreview1() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Text,
                text = "Tsogy",
                enabled = false
            ),
            onClick = {}
        )
    }
}

@SushiPreview
@Composable
private fun SushiTextButtonPreview2() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Text,
                text = "Tsogy"
            ),
            onClick = {}
        )
    }
}

@SushiPreview
@Composable
private fun SushiTextButtonPreview3() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Text,
                text = "Tsogy",
                subText = "hehe",
                prefixIcon = SushiIconProps(code = "edae"),
                suffixIcon = SushiIconProps(code = "edae"),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ),
            onClick = {},
        )
    }
}

@SushiPreview
@Composable
private fun SushiTextButtonPreview4() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Text,
                text = "Tsogy",
                subText = "hehe",
                prefixIcon = SushiIconProps(code = "edae"),
                suffixIcon = SushiIconProps(code = "edae"),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ),
            onClick = {},
            Modifier.fillMaxWidth().height(200.dp)
        )
    }
}

@SushiPreview
@Composable
private fun SushiTextButtonPreview5() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Text,
                text = "Small",
                size = SushiButtonSize.Small
            ),
            onClick = {}
        )
    }
}
