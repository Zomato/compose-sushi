package com.zomato.sushi.compose.components.stepper

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
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
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.atoms.text.transform
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.foundation.SushiUnspecified
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.modifiers.invisibleIf
import com.zomato.sushi.compose.shapes.squircle.SquircleShape
import com.zomato.sushi.compose.utils.takeIfSpecified
import com.zomato.sushi.compose.utils.toSp

/**
 * Created by Nitin Kumar on 08/01/25.
 * Zomato, Gurgaon, India.
 */

@Composable
fun SushiStepper(
    props: SushiStepperProps,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    onDisabledClick: () -> Unit,
    onIncrementFail: () -> Unit,
    modifier: Modifier = Modifier
) {
    val currentCount = props.count ?: 0
    val maxCount = props.maxCount ?: Int.MAX_VALUE
    val stepperSize = props.stepperSize ?: SushiStepperSize.Normal

    val stepperDimensions = rememberStepperDimensions(stepperSize)
    val stepperEnabledState by rememberStepperEnabledState(props.stepperEnabledState ?: true)
    val shape = props.shape ?: rememberDefaultStepperShape(stepperSize)
    val colorConfig = props.colorConfig ?: rememberDefaultStepperColorConfig(
        stepperEnabledState = stepperEnabledState,
        stepperCurrentCount = currentCount,
        stepperMaxCount = maxCount
    )
    val stepperText = props.text
    val disabledMessage = props.disabledMessage
    val titleText = getStepperTitleText(
        stepperText = stepperText,
        stepperEnabledState = stepperEnabledState,
        stepperCurrentCount = currentCount,
        stepperMaxCount = maxCount,
        disabledMessage = disabledMessage
    )
    Box(
        modifier = modifier
            .testTag("SushiStepper")
            .width(IntrinsicSize.Max)
            .height(IntrinsicSize.Max)
            .defaultMinSize(stepperDimensions.width, stepperDimensions.height)
            .background(color = colorConfig.bgColor.value, shape = shape)
            .border(
                border = BorderStroke(color = colorConfig.borderColor.value, width = 0.7.dp),
                shape = shape
            ), contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .animateContentSize()
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Minus Icon
            SushiIcon(modifier = Modifier
                .padding(horizontal = SushiTheme.dimens.spacing.micro)
                .invisibleIf(currentCount == 0 || !disabledMessage?.text.isNullOrBlank()),
                props = SushiIconProps(
                    code = SushiIconCodes.IconRemove, // icon code for "minus",
                    color = colorConfig.negativeActionButtonColor,
                    size = StepperDefaults.getStepperIconSize(stepperSize)
                ),
                onClick = {
                    when {
                        !stepperEnabledState -> {
                            if (currentCount != 0) onDisabledClick()
                        }
                        else -> {
                            when (currentCount) {
                                0 -> { onIncrement() }
                                in 1..maxCount -> {
                                    onDecrement()
                                }
                            }
                        }
                    }
                })

            // Count Display with Animation
            Box(
                modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
            ) {
                AnimatedContent(
                    targetState = titleText, transitionSpec = {
                        if ((targetState.toString().toIntOrNull() ?: 0) > (initialState.toString().toIntOrNull() ?: 0)) {
                            (slideInVertically { height -> height } + fadeIn()).togetherWith(
                                slideOutVertically { height -> -height } + fadeOut())
                        } else {
                            (slideInVertically { height -> -height } + fadeIn()).togetherWith(
                                slideOutVertically { height -> height } + fadeOut())
                        }.using(
                            SizeTransform(clip = false)
                        )
                    }, label = "stepper in out animation"
                ) { text ->
                    val fontSize = StepperDefaults.getStepperTextFontSizeInDp(stepperSize).toSp()
                    SushiText(modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight(align = Alignment.CenterVertically) // Align text vertically to center
                        .wrapContentWidth(align = Alignment.CenterHorizontally), // Align text horizontally to center
                        props = SushiTextProps(text = text,
                            color = colorConfig.textColor,
                            type = (disabledMessage?.let {
                                disabledMessage.type ?: SushiTextType.Regular100
                            } ?: StepperDefaults.getStepperTextFontType(stepperSize)).transform {
                                it.copy(
                                    fontSize = fontSize
                                )
                            },
                            maxLines = disabledMessage?.maxLines ?: 1
                        ),
                        onClick = {
                            when {
                                !stepperEnabledState -> {
                                    onDisabledClick()
                                }
                                else -> {
                                    when (currentCount) {
                                        0 -> {
                                            onIncrement()
                                        }
                                        in 1 until maxCount -> {}
                                        else -> {}
                                    }
                                }
                            }
                        })
                }
            }

            // Add Icon
            SushiIcon(modifier = Modifier
                .padding(
                    top = if (currentCount == 0) SushiTheme.dimens.spacing.micro else SushiTheme.dimens.spacing.femto,
                    start = SushiTheme.dimens.spacing.micro,
                    end = SushiTheme.dimens.spacing.micro
                )
                .invisibleIf(!disabledMessage?.text.isNullOrBlank())
                .align(if (currentCount == 0) Alignment.Top else Alignment.CenterVertically),
                props = SushiIconProps(
                    code = SushiIconCodes.IconPlus, // icon code for "plus"
                    color = if (currentCount >= maxCount) colorConfig.maxCountPositiveActionButtonColor.takeIfSpecified()
                        ?: colorConfig.positiveActionButtonColor else colorConfig.positiveActionButtonColor,
                    size = StepperDefaults.getStepperIconSize(stepperSize)
                ),
                onClick = {
                    when {
                        !stepperEnabledState -> {
                            onDisabledClick()
                        }

                        currentCount < maxCount -> {
                            onIncrement()
                        }

                        else -> {
                            onIncrementFail()
                        }
                    }
                })
        }
    }
}

@Composable
private fun getStepperTitleText(
    stepperText: String?,
    stepperEnabledState: Boolean,
    stepperCurrentCount: Int,
    stepperMaxCount: Int,
    disabledMessage: SushiTextProps?
): CharSequence {
    return if (stepperEnabledState) {
        when (stepperCurrentCount) {
            0 -> "ADD"
            in 1 until stepperMaxCount -> stepperCurrentCount.toString()
            else -> StepperDefaults.getDefaultTextForStepper(stepperText)
        }
    } else {
        disabledMessage?.text ?: if (stepperCurrentCount == 0) "ADD" else StepperDefaults.getDefaultTextForStepper(
            stepperText
        )
    }
}

@Composable
private fun rememberStepperDimensions(stepperSize: SushiStepperSize): StepperDefaults.Dimensions {
    return remember(stepperSize) {
        StepperDefaults.getDimensions(stepperSize)
    }
}

@Composable
private fun rememberStepperEnabledState(stepperEnabledState: Boolean): State<Boolean> {
    return rememberUpdatedState(stepperEnabledState)
}

@Composable
private fun rememberDefaultStepperShape(stepperSize: SushiStepperSize): Shape {
    val mini = SushiTheme.dimens.spacing.mini
    val macro = SushiTheme.dimens.spacing.macro
    return remember(stepperSize) {
        RoundedCornerShape(
            when (stepperSize) {
                SushiStepperSize.Small -> mini
                else -> macro
            }
        )
    }
}

@Composable
private fun rememberDefaultStepperColorConfig(
    stepperEnabledState: Boolean,
    stepperCurrentCount: Int,
    stepperMaxCount: Int
): SushiStepperColorConfig {
    val defaultColorConfig = SushiStepperColorConfig.defaults()
    val enabledNonZeroConfig = SushiStepperColorConfig.enabledNonZero()
    val enabledZeroConfig = SushiStepperColorConfig.enabledZero()
    val disabledConfig = SushiStepperColorConfig.disabled()

    return remember(stepperEnabledState) {
        when {
            stepperEnabledState -> {
                when (stepperCurrentCount) {
                    0 -> enabledZeroConfig
                    in 1 until stepperMaxCount -> enabledNonZeroConfig
                    else -> defaultColorConfig
                }
            }

            else -> disabledConfig
        }
    }
}

@SushiPreview
@Composable
private fun StepperLargePreview() {
    SushiPreview {
        var count by remember { mutableIntStateOf(1000) }
        SushiStepper(
            props = SushiStepperProps(
                text = count.toString(),
                count = count,
                maxCount = 1003,
                stepperSize = SushiStepperSize.Large,
                stepperEnabledState = true,
                colorConfig = SushiStepperColorConfig(
                    textColor = SushiTheme.colors.red.v500,
                    positiveActionButtonColor = SushiTheme.colors.red.v500,
                    negativeActionButtonColor = SushiTheme.colors.red.v500,
                    bgColor = SushiTheme.colors.red.v050,
                    borderColor = SushiTheme.colors.red.v500,
                    maxCountPositiveActionButtonColor = SushiUnspecified.asColorSpec()
                ),
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
private fun StepperNormalPreview() {
    SushiPreview {
        var count by remember { mutableIntStateOf(0) }
        SushiStepper(
            props = SushiStepperProps(
                text = count.toString(),
                count = count,
                maxCount = 10,
                stepperSize = SushiStepperSize.Normal,
                stepperEnabledState = true,
                colorConfig = SushiStepperColorConfig(
                    textColor = SushiTheme.colors.white,
                    positiveActionButtonColor = SushiTheme.colors.white,
                    negativeActionButtonColor = SushiTheme.colors.white,
                    bgColor = SushiTheme.colors.stepper.primaryBackground,
                    borderColor = SushiTheme.colors.red.v500,
                    maxCountPositiveActionButtonColor = SushiUnspecified.asColorSpec()
                ),
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
private fun StepperNormalPreview2() {
    SushiPreview {
        var count by remember { mutableIntStateOf(3) }
        SushiStepper(
            props = SushiStepperProps(
                text = count.toString(),
                count = count,
                maxCount = 10,
                stepperSize = SushiStepperSize.Normal,
                stepperEnabledState = true,
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
private fun StepperNormalPreview3() {
    SushiPreview {
        var count by remember { mutableIntStateOf(3) }
        SushiStepper(
            props = SushiStepperProps(
                text = count.toString(),
                count = count,
                maxCount = 10,
                stepperSize = SushiStepperSize.Normal,
                stepperEnabledState = false,
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
private fun StepperNormalPreview4() {
    SushiPreview {
        var count by remember { mutableIntStateOf(0) }
        SushiStepper(
            props = SushiStepperProps(
                text = count.toString(),
                count = count,
                maxCount = 10,
                stepperSize = SushiStepperSize.Normal,
                stepperEnabledState = true,
                colorConfig = SushiStepperColorConfig(
                    textColor = SushiTheme.colors.red.v500,
                    positiveActionButtonColor = SushiTheme.colors.red.v500,
                    negativeActionButtonColor = SushiTheme.colors.red.v500,
                    bgColor = SushiTheme.colors.red.v050,
                    borderColor = SushiTheme.colors.red.v500,
                    maxCountPositiveActionButtonColor = SushiUnspecified.asColorSpec()
                ),
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
private fun StepperMediumPreview() {
    SushiPreview {
        var count by remember { mutableIntStateOf(0) }
        SushiStepper(
            props = SushiStepperProps(
                text = count.toString(),
                count = count,
                maxCount = 10,
                stepperSize = SushiStepperSize.Medium,
                stepperEnabledState = true,
                colorConfig = SushiStepperColorConfig(
                    textColor = SushiTheme.colors.white,
                    positiveActionButtonColor = SushiTheme.colors.white,
                    negativeActionButtonColor = SushiTheme.colors.white,
                    bgColor = SushiTheme.colors.stepper.primaryBackground,
                    borderColor = SushiTheme.colors.red.v500,
                    maxCountPositiveActionButtonColor = SushiUnspecified.asColorSpec()
                ),
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
private fun StepperSmallV2Preview() {
    SushiPreview {
        var count by remember { mutableIntStateOf(0) }
        SushiStepper(
            props = SushiStepperProps(
                text = count.toString(),
                count = count,
                maxCount = 10,
                stepperSize = SushiStepperSize.SmallV2,
                stepperEnabledState = true,
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
private fun StepperSmallPreview() {
    SushiPreview {
        var count by remember { mutableIntStateOf(0) }
        SushiStepper(
            props = SushiStepperProps(
                text = count.toString(),
                count = count,
                maxCount = 10,
                stepperSize = SushiStepperSize.Small,
                stepperEnabledState = true,
                colorConfig = SushiStepperColorConfig(
                    textColor = SushiTheme.colors.white,
                    positiveActionButtonColor = SushiTheme.colors.white,
                    negativeActionButtonColor = SushiTheme.colors.white,
                    bgColor = SushiTheme.colors.stepper.primaryBackground,
                    borderColor = SushiTheme.colors.red.v500,
                    maxCountPositiveActionButtonColor = SushiUnspecified.asColorSpec()
                ),
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
private fun StepperSmallPreview2() {
    SushiPreview {
        var count by remember { mutableIntStateOf(15) }
        SushiStepper(
            props = SushiStepperProps(
                text = count.toString(),
                count = count,
                maxCount = 20,
                stepperSize = SushiStepperSize.Small,
                stepperEnabledState = true,
                colorConfig = SushiStepperColorConfig(
                    textColor = SushiTheme.colors.red.v500,
                    positiveActionButtonColor = SushiTheme.colors.red.v500,
                    negativeActionButtonColor = SushiTheme.colors.red.v500,
                    bgColor = SushiTheme.colors.red.v050,
                    borderColor = SushiTheme.colors.red.v500,
                    maxCountPositiveActionButtonColor = SushiUnspecified.asColorSpec()
                ),
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
private fun SmallStepperDisabledPreview() {
    SushiPreview {
        var count by remember { mutableIntStateOf(0) }
        SushiStepper(
            props = SushiStepperProps(
                text = count.toString(),
                count = count,
                maxCount = 10,
                stepperSize = SushiStepperSize.Small,
                stepperEnabledState = false,
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
private fun SmallStepperWithDisabledMessagePreview() {
    SushiPreview {
        SushiStepper(
            props = SushiStepperProps(
                stepperSize = SushiStepperSize.Small,
                stepperEnabledState = false,
                shape = SquircleShape(SushiTheme.dimens.spacing.base),
                disabledMessage = SushiTextProps(text = "Disabled stepper")
            ),
            onIncrement = {},
            onDecrement = {},
            onDisabledClick = {},
            onIncrementFail = {}
        )
    }
}

@SushiPreview
@Composable
private fun SmallStepperWithDisabledMessageAndCustomWidthHeightPreview() {
    SushiPreview {
        SushiStepper(
            modifier = Modifier
                .width(60.dp)
                .height(40.dp),
            props = SushiStepperProps(
                stepperSize = SushiStepperSize.Small,
                stepperEnabledState = false,
                shape = SquircleShape(SushiTheme.dimens.spacing.base),
                disabledMessage = SushiTextProps(text = "Hi")
            ),
            onIncrement = {},
            onDecrement = {},
            onDisabledClick = {},
            onIncrementFail = {}
        )
    }
}
