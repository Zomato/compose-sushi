package com.zomato.sushi.compose.atoms.radio

import android.annotation.SuppressLint
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.takeIfSpecified

/**
 * A customizable radio button component for the Sushi design system.
 *
 * SushiRadioButton provides a standard radio button implementation with support for:
 * - Primary and secondary text labels
 * - Custom positioning (radio button at start or end)
 * - Vertical alignment control
 * - Custom colors for selected and unselected states
 * - Custom content through the infoContent parameter
 * - Accessibility through semantic properties
 *
 * Radio buttons are typically used in groups where only one option can be selected at a time,
 * though this component doesn't enforce that behavior - it's up to the parent component to
 * manage the selected state across a group of radio buttons.
 *
 * @param props The properties to configure the radio button appearance and behavior
 * @param onClick Callback invoked when the radio button is clicked
 * @param modifier The modifier to be applied to the component
 * @param interactionSource Source of interactions for the radio button
 * @param infoContent Optional custom content to replace the standard text labels
 *
 * @author gupta.anirudh@zomato.com
 */
@Composable
fun SushiRadioButton(
    props: SushiRadioButtonProps,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    infoContent: (@Composable RowScope.() -> Unit)? = null
) {
    SushiComponentBase(
        modifier
            .testTag("SushiRadioButton")
            .height(IntrinsicSize.Max)
            .width(IntrinsicSize.Max)
    ) {
        SushiRadioButtonImpl(
            props,
            onClick,
            Modifier.fillMaxSize(),
            interactionSource = interactionSource,
            infoContent = infoContent
        )
    }
}

@Composable
private fun SushiRadioButtonImpl(
    props: SushiRadioButtonProps,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    @SuppressLint("SlotReused") infoContent: (@Composable RowScope.() -> Unit)? = null
) {
    val isSelected = props.selected ?: SushiRadioButtonDefaults.isSelected
    val isEnabled = props.enabled ?: SushiRadioButtonDefaults.isEnabled

    Row(
        modifier
            .selectable(
                selected = isSelected,
                onClick = onClick,
                enabled = isEnabled,
                role = Role.RadioButton,
                interactionSource = interactionSource,
                indication = null
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val selectedColor = props.selectedColor.takeIfSpecified() ?: SushiTheme.colors.base.theme.v500
        val selectedColorDisabled = SushiTheme.colors.grey.v500

        val unselectedColor = props.unselectedColor.takeIfSpecified() ?: SushiTheme.colors.base.theme.v500
        val unselectedColorDisabled = SushiTheme.colors.grey.v500

        val padding = props.padding ?: SushiRadioButtonDefaults.padding
        val verticalAlignment = props.verticalAlignment ?: SushiRadioButtonDefaults.verticalAlignment
        val direction = props.direction ?: SushiRadioButtonDefaults.direction

        if (direction == RadioButtonDirection.End) {
            if (infoContent != null) {
                infoContent()
            } else {
                InfoContentImpl(props, Modifier.weight(1f, fill = false))
            }
        }

        RadioButton(
            selected = isSelected,
            onClick = null,
            Modifier
                .align(verticalAlignment)
                .padding(
                    start = padding.takeIf { direction == RadioButtonDirection.End } ?: 0.dp,
                    top = padding,
                    end = padding.takeIf { direction == RadioButtonDirection.Start } ?: 0.dp,
                    bottom = padding
                )
                .size(SushiRadioButtonDefaults.radioButtonSize),
            enabled = isEnabled,
            colors = RadioButtonDefaults.colors(
                selectedColor = selectedColor.value,
                unselectedColor = unselectedColor.value,
                disabledSelectedColor = selectedColorDisabled.value,
                disabledUnselectedColor = unselectedColorDisabled.value
            ),
            interactionSource = interactionSource
        )

        if (direction == RadioButtonDirection.Start) {
            if (infoContent != null) {
                infoContent()
            } else {
                InfoContentImpl(props, Modifier.weight(1f, fill = false))
            }
        }
    }
}

@Composable
private fun RowScope.InfoContentImpl(
    props: SushiRadioButtonProps,
    modifier: Modifier = Modifier
) {
    if (props.text != null || props.subText != null) {
        Column(
            modifier,
            horizontalAlignment = Alignment.Start
        ) {
            props.text?.let {
                SushiText(
                    props = it.copy(
                        type = it.type ?: SushiRadioButtonDefaults.textType
                    ),
                    Modifier.padding(top = SushiTheme.dimens.spacing.mini, bottom = SushiTheme.dimens.spacing.mini)
                )
            }
            props.subText?.let {
                SushiText(
                    props = it.copy(
                        type = it.type ?: SushiRadioButtonDefaults.textType
                    ),
                    Modifier.padding(top = SushiTheme.dimens.spacing.nano, bottom = SushiTheme.dimens.spacing.mini)
                )
            }
        }
    }
}

@SushiPreview
@Composable
private fun SushiCheckboxPreview1() {
    SushiPreview {
        Column {
            var firstSelected by remember {
                mutableStateOf(false)
            }
            SushiRadioButton(
                SushiRadioButtonProps(
                    selected = firstSelected == true,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends")
                ),
                onClick = {
                    firstSelected = true
                },
                Modifier.padding(bottom = 10.dp)
            )
            SushiRadioButton(
                SushiRadioButtonProps(
                    selected = firstSelected == false,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends")
                ),
                onClick = {
                    firstSelected = false
                }
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiCheckboxPreview2() {
    SushiPreview {
        Column {
            var firstSelected by remember {
                mutableStateOf(false)
            }
            SushiRadioButton(
                SushiRadioButtonProps(
                    selected = firstSelected == true,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                    verticalAlignment = Alignment.Top
                ),
                onClick = {
                    firstSelected = true
                }
            )
            SushiRadioButton(
                SushiRadioButtonProps(
                    selected = firstSelected == false,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                    verticalAlignment = Alignment.Top,
                    enabled = false
                ),
                onClick = {
                    firstSelected = false
                }
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiCheckboxPreview3() {
    SushiPreview {
        Column {
            var firstSelected by remember {
                mutableStateOf(false)
            }
            SushiRadioButton(
                SushiRadioButtonProps(
                    selected = firstSelected == true,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                    direction = RadioButtonDirection.End
                ),
                onClick = {
                    firstSelected = true
                },
                Modifier.padding(bottom = 10.dp)
            )
            SushiRadioButton(
                SushiRadioButtonProps(
                    selected = firstSelected == false,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                    direction = RadioButtonDirection.End
                ),
                onClick = {
                    firstSelected = false
                }
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiCheckboxPreview4() {
    SushiPreview {
        Column {
            var firstSelected by remember {
                mutableStateOf(false)
            }
            SushiRadioButton(
                SushiRadioButtonProps(
                    selected = firstSelected == true,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                    subText = SushiTextProps(text = "subText"),
                    verticalAlignment = Alignment.CenterVertically,
                    direction = RadioButtonDirection.Start
                ),
                onClick = {
                    firstSelected = true
                },
                Modifier.fillMaxWidth()
            )
            SushiRadioButton(
                SushiRadioButtonProps(
                    selected = firstSelected == false,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                    subText = SushiTextProps(text = "subText"),
                    verticalAlignment = Alignment.Bottom,
                    enabled = false,
                    direction = RadioButtonDirection.End
                ),
                onClick = {
                    firstSelected = false
                }
            )
        }
    }
}
