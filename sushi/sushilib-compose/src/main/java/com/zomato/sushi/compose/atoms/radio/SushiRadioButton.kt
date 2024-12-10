@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.radio

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
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.internal.Base
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.Preview
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.takeIfSpecified

private object Defaults {
    const val isSelected = false
    const val isEnabled = true
    val radioButtonSize = 21.dp
    val padding @Composable get() = SushiTheme.dimens.spacing.macro
    val verticalAlignment = Alignment.Top
    val textType = SushiTextType.Regular300
    val direction = RadioButtonDirection.Start
}

@ExperimentalSushiApi
@Composable
fun SushiRadioButton(
    props: SushiRadioButtonProps,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    infoContent: (@Composable RowScope.() -> Unit)? = null
) {
    Base(modifier
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
    infoContent: (@Composable RowScope.() -> Unit)? = null
) {
    val isSelected = props.selected ?: Defaults.isSelected
    val isEnabled = props.enabled ?: Defaults.isEnabled

    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val selectedColor = props.selectedColor.takeIfSpecified() ?: SushiTheme.colors.theme.v500
        val selectedColorDisabled = SushiTheme.colors.grey.v500

        val unselectedColor = props.unselectedColor.takeIfSpecified() ?: SushiTheme.colors.theme.v500
        val unselectedColorDisabled = SushiTheme.colors.grey.v500

        val padding = props.padding ?: Defaults.padding
        val verticalAlignment = props.verticalAlignment ?: Defaults.verticalAlignment
        val direction = props.direction ?: Defaults.direction

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
                .padding(padding)
                .selectable(
                    selected = isSelected,
                    onClick = onClick,
                    enabled = isEnabled,
                    role = Role.RadioButton,
                    interactionSource = interactionSource,
                    indication = null
                )
                .size(Defaults.radioButtonSize),
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
                        type = it.type ?: Defaults.textType
                    ),
                    Modifier.padding(top = SushiTheme.dimens.spacing.mini, bottom = SushiTheme.dimens.spacing.mini)
                )
            }
            props.subText?.let {
                SushiText(
                    props = it.copy(
                        type = it.type ?: Defaults.textType
                    ),
                    Modifier.padding(top = SushiTheme.dimens.spacing.nano, bottom = SushiTheme.dimens.spacing.mini)
                )
            }
        }
    }
}

@SushiPreview
@Composable
fun SushiCheckboxPreview1() {
    Preview {
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
fun SushiCheckboxPreview2() {
    Preview {
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
fun SushiCheckboxPreview3() {
    Preview {
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
fun SushiCheckboxPreview4() {
    Preview {
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
