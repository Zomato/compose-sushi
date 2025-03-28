package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.foundation.SushiTheme
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

    SushiButtonContentImpl(
        props = props,
        isDisabled = isDisabled,
        isTapped = isTapped,
        fontColorDisabled = fontColorDisabled,
        fontColorPressed = fontColorPressed,
        fontColor = fontColor,
        modifier
    )
}

@SushiPreview
@Composable
private fun SushiTextButtonPreview1() {
    SushiPreview {
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
    SushiPreview {
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
    SushiPreview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Text,
                text = "Tsogy",
                subText = "hehe",
                prefixIcon = SushiIconProps(code = SushiIconCodes.IconScooterSharp),
                suffixIcon = SushiIconProps(code = SushiIconCodes.IconScooterSharp),
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
    SushiPreview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Text,
                text = "Tsogy",
                subText = "hehe",
                prefixIcon = SushiIconProps(code = SushiIconCodes.IconScooterSharp),
                suffixIcon = SushiIconProps(code = SushiIconCodes.IconScooterSharp),
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
    SushiPreview {
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
