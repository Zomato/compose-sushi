package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.foundation.SushiTheme

/**
 * @author gupta.anirudh@zomato.com
 */
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
    val isTapped = remember(props) { mutableStateOf(false) }
    val isDisabled = props.enabled == false

    val appliedStrokeColor = when {
        isDisabled -> borderStrokeColorDisabled
        isTapped.value -> borderStrokeColorPressed
        else -> borderStrokeColor
    }

    val contentPadding = with(SushiButtonDefaults) {
        when (props.sizeOrDefault) {
            SushiButtonSize.Small -> PaddingValues(horizontal = SushiTheme.dimens.spacing.extra, vertical = SushiTheme.dimens.spacing.mini)
            SushiButtonSize.Medium -> PaddingValues(horizontal = SushiTheme.dimens.spacing.extra, vertical = SushiTheme.dimens.spacing.macro)
            SushiButtonSize.Large -> PaddingValues(horizontal = SushiTheme.dimens.spacing.extra, vertical = SushiTheme.dimens.spacing.macro)
        }
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
        shape = with(SushiButtonDefaults) { props.shapeOrDefault },
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
            SushiButtonContentImpl(
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