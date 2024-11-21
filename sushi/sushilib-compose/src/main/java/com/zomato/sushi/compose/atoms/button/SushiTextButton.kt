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
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.asIconSizeSpec
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.TextUnitTextType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.Preview
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.takeIfSpecified

@Composable
internal fun SushiTextButton(
    props: SushiButtonProps,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: (@Composable SushiButtonContentScope.() -> Unit)? = null
) {
    var isTapped by remember(props) { mutableStateOf(false) }
    val isDisabled = props.isDisabled == true

    val bgColor = props.color.takeIfSpecified() ?: SushiTheme.colors.button.ghostBackground.asColorSpec()
    val bgColorPressed = props.color.takeIfSpecified() ?: SushiTheme.colors.button.ghostBackgroundPressed.asColorSpec()
    val bgColorDisabled = bgColor   // todox: change needed?

    val appliedBgColor = when {
        isDisabled -> bgColorDisabled
        isTapped -> bgColorPressed
        else -> bgColor
    }

    Box(
        modifier
            .semantics { role = Role.Button }
            .pointerInput(isTapped) {
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
                interactionSource = interactionSource,
                indication = null,
                enabled = !isDisabled,
                onClick = onClick
            )
            .background(color = appliedBgColor.value),
        propagateMinConstraints = true
    ) {
        Row(
            Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val contentScopeData = remember(isTapped, isDisabled) {
                object : SushiButtonContentScope, RowScope by this {
                    override val isTapped: Boolean
                        get() = isTapped
                    override val isDisabled: Boolean
                        get() = isDisabled
                }
            }
            if (content != null) {
                contentScopeData.content()
            } else {
                SushiTextButtonContent(
                    data = props,
                    isDisabled = isDisabled,
                    isTapped = isTapped
                )
            }
        }
    }
}

@Composable
private fun SushiTextButtonContent(
    data: SushiButtonProps,
    isDisabled: Boolean,
    isTapped: Boolean
) {
    val fontColor = data.fontColor.takeIfSpecified() ?: SushiTheme.colors.button.ghostLabel.asColorSpec()
    val fontColorPressed = data.fontColor.takeIfSpecified() ?: SushiTheme.colors.button.ghostLabelPressed.asColorSpec()
    val fontColorDisabled = SushiTheme.colors.button.ghostLabelDisabled.asColorSpec()

    val appliedFontColor = when {
        isDisabled -> fontColorDisabled
        isTapped -> fontColorPressed
        else -> fontColor
    }

    val textSize: TextUnit = getButtonTextSize(data.getButtonSizeWithDefaults())
    val defaultIconSize: TextUnit = getButtonIconSize(data.getButtonSizeWithDefaults()) // todox
    val iconPadding: Dp = data.iconSpacing ?: getButtonIconPadding(data.getButtonSizeWithDefaults())

    val prefixIcon = data.prefixIcon?.copy(
        size = data.prefixIcon.size ?: defaultIconSize.asIconSizeSpec(),
        color = data.prefixIcon.color.takeIfSpecified() ?: appliedFontColor
    )

    val suffixIcon = data.suffixIcon?.copy(
        size = data.suffixIcon.size ?: defaultIconSize.asIconSizeSpec(),
        color = data.suffixIcon.color.takeIfSpecified() ?: appliedFontColor
    )

    Column(horizontalAlignment = data.getButtonAlignmentWithDefaults()) {
        Row {
            if (prefixIcon != null) {
                SushiIcon(
                    props = prefixIcon,
                    Modifier.padding(end = iconPadding)
                )
            }
            SushiText(
                SushiTextProps(
                    text = data.text,
                    type = TextUnitTextType(TextStyle(fontSize = textSize)),
                    color = appliedFontColor,
                    prefixIcon = data.prefixIcon,
                    suffixIcon = data.suffixIcon,
                    isMarkDownEnabled = data.isMarkDownEnabled
                )
            )
            if (suffixIcon != null) {
                SushiIcon(
                    props = suffixIcon,
                    Modifier.padding(start = iconPadding)
                )
            }
        }
        if (!data.subtext.isNullOrEmpty()) {
            SushiText(
                SushiTextProps(
                    text = data.subtext,
                    color = appliedFontColor,
                    type = data.getSubtextTextType(textSize)
                )
            )
        }
    }
}

@SushiPreview
@Composable
fun SushiTextButtonPreview1() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Text,
                text = "Tsogy",
                isDisabled = true
            ),
            onClick = {}
        )
    }
}

@SushiPreview
@Composable
fun SushiTextButtonPreview2() {
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
fun SushiTextButtonPreview3() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Text,
                text = "Tsogy",
                subtext = "hehe"
            ),
            onClick = {}
        )
    }
}

@SushiPreview
@Composable
fun SushiTextButtonPreview4() {
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
