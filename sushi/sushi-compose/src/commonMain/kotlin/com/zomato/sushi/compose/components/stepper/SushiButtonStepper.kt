
package com.zomato.sushi.compose.components.stepper

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.icon.SushiIconSize
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.foundation.SushiUnspecified
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.shapes.squircle.SquircleShape
import com.zomato.sushi.compose.utils.takeIfSpecified

/**
 * A button stepper component that transitions between an icon button and a stepper.
 *
 * SushiButtonStepper provides a space-efficient control for quantity selection:
 * - When count is 0: Displays as an icon button (e.g., "+" or "cart" icon)
 * - When count > 0: Displays as a full stepper with increment/decrement controls
 * - When decremented to 0: Transitions back to icon button
 *
 * The component uses SushiStepper internally for the stepper functionality and supports
 * smooth animated transitions between button and stepper states.
 *
 * Features:
 * - Animated transitions between button and stepper states
 * - Customizable icon, colors, and shapes
 * - Multiple size variants through stepperSize
 * - Support for maximum limits
 * - Disabled state with custom message
 *
 * @param props The properties to configure the button stepper's appearance and behavior
 * @param onIncrement Callback invoked when the increment button is clicked
 * @param onDecrement Callback invoked when the decrement button is clicked
 * @param onDisabledClick Callback invoked when the stepper is clicked while disabled
 * @param onIncrementFail Callback invoked when attempting to increment beyond maxCount
 * @param modifier The modifier to be applied to the component
 *
 * Created by AI Assistant
 */
@Composable
fun SushiButtonStepper(
    props: SushiButtonStepperProps,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    onDisabledClick: () -> Unit,
    onIncrementFail: () -> Unit,
    modifier: Modifier = Modifier
) {
    val currentCount = props.count ?: 0
    val stepperEnabledState by rememberUpdatedState(props.stepperEnabledState ?: true)

    Box(
        modifier = modifier
            .testTag("SushiButtonStepper"),
        contentAlignment = Alignment.Center
    ) {
        AnimatedContent(
            targetState = currentCount > 0,
            transitionSpec = {
                (fadeIn() + scaleIn(initialScale = 0.8f)).togetherWith(
                    fadeOut() + scaleOut(targetScale = 0.8f)
                ).using(
                    SizeTransform(clip = false)
                )
            },
            label = "button_stepper_transition"
        ) { isStepperMode ->
            if (isStepperMode) {
                // Show stepper when count > 0
                val stepperProps = SushiStepperProps(
                    text = currentCount.toString(),
                    count = currentCount,
                    maxCount = props.maxCount,
                    stepperSize = props.stepperSize,
                    stepperEnabledState = props.stepperEnabledState,
                    colorConfig = props.colorConfig,
                    shape = props.shape,
                    disabledMessage = props.disabledMessage
                )
                
                SushiStepper(
                    props = stepperProps,
                    onIncrement = onIncrement,
                    onDecrement = onDecrement,
                    onDisabledClick = onDisabledClick,
                    onIncrementFail = onIncrementFail,
                    modifier = Modifier
                )
            } else {
                // Show icon button when count is 0
                val iconCode = props.iconCode ?: SushiIconCodes.IconPlus
                val iconSize = props.iconSize ?: SushiIconSize.Size300
                val iconColor = props.iconColor?.takeIfSpecified()
                    ?: SushiTheme.colors.red.v500
                val buttonBgColor = props.buttonBackgroundColor?.takeIfSpecified()
                    ?: SushiTheme.colors.white
                val buttonBorderColor = props.buttonBorderColor?.takeIfSpecified()
                    ?: SushiTheme.colors.red.v500
                val buttonShape = props.buttonShape ?: props.shape ?: CircleShape
                
                val buttonSize = getButtonSizeFromStepperSize(props.stepperSize ?: SushiStepperSize.Normal)
                
                Box(
                    modifier = Modifier
                        .size(buttonSize)
                        .background(color = buttonBgColor.value, shape = buttonShape)
                        .border(
                            border = BorderStroke(
                                color = buttonBorderColor.value,
                                width = 0.7.dp
                            ),
                            shape = buttonShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    SushiIcon(
                        props = SushiIconProps(
                            code = iconCode,
                            color = iconColor,
                            size = iconSize
                        ),
                        onClick = {
                            if (stepperEnabledState) {
                                onIncrement()
                            } else {
                                onDisabledClick()
                            }
                        }
                    )
                }
            }
        }
    }
}

/**
 * Get button size based on stepper size
 */
@Composable
private fun getButtonSizeFromStepperSize(stepperSize: SushiStepperSize) = when (stepperSize) {
    SushiStepperSize.Small -> 26.dp
    SushiStepperSize.SmallV2 -> 30.dp
    SushiStepperSize.Medium -> 32.dp
    SushiStepperSize.Normal -> 40.dp
    SushiStepperSize.Large -> 48.dp
}

// Preview Composables
@SushiPreview
@Composable
private fun ButtonStepperZeroStatePreview() {
    SushiPreview {
        var count by remember { mutableIntStateOf(0) }
        SushiButtonStepper(
            props = SushiButtonStepperProps(
                count = count,
                maxCount = 10,
                stepperSize = SushiStepperSize.Normal,
                stepperEnabledState = true,
                iconCode = SushiIconCodes.IconPlus,
                iconSize = SushiIconSize.Size300,
                shape = SquircleShape(SushiTheme.dimens.spacing.base)
            ),
            onIncrement = { count++ },
            onDecrement = { count-- },
            onDisabledClick = {},
            onIncrementFail = {}
        )
    }
}

@SushiPreview
@Composable
private fun ButtonStepperActiveStatePreview() {
    SushiPreview {
        var count by remember { mutableIntStateOf(3) }
        SushiButtonStepper(
            props = SushiButtonStepperProps(
                count = count,
                maxCount = 10,
                stepperSize = SushiStepperSize.Normal,
                stepperEnabledState = true,
                iconCode = SushiIconCodes.IconPlus,
                shape = SquircleShape(SushiTheme.dimens.spacing.base),
                colorConfig = SushiStepperColorConfig(
                    textColor = SushiTheme.colors.white,
                    positiveActionButtonColor = SushiTheme.colors.white,
                    negativeActionButtonColor = SushiTheme.colors.white,
                    bgColor = SushiTheme.colors.stepper.primaryBackground,
                    borderColor = SushiTheme.colors.red.v500,
                    maxCountPositiveActionButtonColor = SushiUnspecified.asColorSpec()
                )
            ),
            onIncrement = { count++ },
            onDecrement = { count-- },
            onDisabledClick = {},
            onIncrementFail = {}
        )
    }
}

@SushiPreview
@Composable
private fun ButtonStepperSmallPreview() {
    SushiPreview {
        var count by remember { mutableIntStateOf(0) }
        SushiButtonStepper(
            props = SushiButtonStepperProps(
                count = count,
                maxCount = 10,
                stepperSize = SushiStepperSize.Small,
                stepperEnabledState = true,
                iconCode = SushiIconCodes.IconPlus,
                iconSize = SushiIconSize.Size200,
                shape = SquircleShape(SushiTheme.dimens.spacing.mini)
            ),
            onIncrement = { count++ },
            onDecrement = { count-- },
            onDisabledClick = {},
            onIncrementFail = {}
        )
    }
}

@SushiPreview
@Composable
private fun ButtonStepperMediumPreview() {
    SushiPreview {
        var count by remember { mutableIntStateOf(0) }
        SushiButtonStepper(
            props = SushiButtonStepperProps(
                count = count,
                maxCount = 10,
                stepperSize = SushiStepperSize.Medium,
                stepperEnabledState = true,
                iconCode = SushiIconCodes.IconPlus,
                shape = SquircleShape(SushiTheme.dimens.spacing.base)
            ),
            onIncrement = { count++ },
            onDecrement = { count-- },
            onDisabledClick = {},
            onIncrementFail = {}
        )
    }
}

@SushiPreview
@Composable
private fun ButtonStepperLargePreview() {
    SushiPreview {
        var count by remember { mutableIntStateOf(2) }
        SushiButtonStepper(
            props = SushiButtonStepperProps(
                count = count,
                maxCount = 10,
                stepperSize = SushiStepperSize.Large,
                stepperEnabledState = true,
                iconCode = SushiIconCodes.IconPlus,
                iconSize = SushiIconSize.Size400,
                shape = SquircleShape(SushiTheme.dimens.spacing.base)
            ),
            onIncrement = { count++ },
            onDecrement = { count-- },
            onDisabledClick = {},
            onIncrementFail = {}
        )
    }
}

@SushiPreview
@Composable
private fun ButtonStepperDisabledPreview() {
    SushiPreview {
        var count by remember { mutableIntStateOf(0) }
        SushiButtonStepper(
            props = SushiButtonStepperProps(
                count = count,
                maxCount = 10,
                stepperSize = SushiStepperSize.Normal,
                stepperEnabledState = false,
                iconCode = SushiIconCodes.IconPlus,
                shape = SquircleShape(SushiTheme.dimens.spacing.base)
            ),
            onIncrement = { count++ },
            onDecrement = { count-- },
            onDisabledClick = {},
            onIncrementFail = {}
        )
    }
}

@SushiPreview
@Composable
private fun ButtonStepperCustomColorPreview() {
    SushiPreview {
        var count by remember { mutableIntStateOf(0) }
        SushiButtonStepper(
            props = SushiButtonStepperProps(
                count = count,
                maxCount = 10,
                stepperSize = SushiStepperSize.Normal,
                stepperEnabledState = true,
                iconCode = SushiIconCodes.IconAddOns,
                iconSize = SushiIconSize.Size300,
                iconColor = SushiTheme.colors.green.v500,
                buttonBackgroundColor = SushiTheme.colors.green.v050,
                buttonBorderColor = SushiTheme.colors.green.v500,
                shape = SquircleShape(SushiTheme.dimens.spacing.base),
                colorConfig = SushiStepperColorConfig(
                    textColor = SushiTheme.colors.green.v500,
                    positiveActionButtonColor = SushiTheme.colors.green.v500,
                    negativeActionButtonColor = SushiTheme.colors.green.v500,
                    bgColor = SushiTheme.colors.green.v050,
                    borderColor = SushiTheme.colors.green.v500,
                    maxCountPositiveActionButtonColor = SushiUnspecified.asColorSpec()
                )
            ),
            onIncrement = { count++ },
            onDecrement = { count-- },
            onDisabledClick = {},
            onIncrementFail = {}
        )
    }
}
