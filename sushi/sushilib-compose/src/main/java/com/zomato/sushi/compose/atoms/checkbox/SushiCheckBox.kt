@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.checkbox

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.internal.Base
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme

@ExperimentalSushiApi
enum class SushiCheckboxSize {
    Mini, Default
}

private object Defaults {
    const val isChecked = false
    const val isEnabled = true
    val checkBoxSize = 21.dp
    val padding @Composable get() = SushiTheme.dimens.spacing.macro
    val alignment = Alignment.Top
    val direction = CheckBoxDirection.Start
}

@ExperimentalSushiApi
@Composable
fun SushiCheckBox(
    props: SushiCheckBoxProps,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    infoContent: (@Composable () -> Unit)? = null
) {
    Base(modifier) {
        SushiCheckBoxImpl(
            props,
            onCheckedChange,
            interactionSource = interactionSource,
            infoContent = infoContent
        )
    }
}

@Composable
private fun SushiCheckBoxImpl(
    props: SushiCheckBoxProps,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    infoContent: (@Composable () -> Unit)? = null
) {

    val isChecked = props.isChecked ?: Defaults.isChecked
    val isEnabled = props.isEnabled ?: Defaults.isEnabled

    Row(
        modifier
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val enabledColor = props.color ?: SushiTheme.colors.theme.v500
        val disabledColor = SushiTheme.colors.grey.v500
        val padding = props.padding ?: Defaults.padding
        val alignment = props.alignment ?: Defaults.alignment
        val scale = when (props.size) {
            SushiCheckboxSize.Mini -> 0.75f
            SushiCheckboxSize.Default -> 1f
            null -> 1f
        }
        val direction = props.direction ?: Defaults.direction

        if (direction == CheckBoxDirection.End) {
            if (infoContent != null) {
                infoContent()
            } else {
                InfoContentImpl(props)
            }
        }

        Box(Modifier.fillMaxHeight()) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = null,
                Modifier
                    .align(when (alignment) {
                        Alignment.Top -> Alignment.TopStart
                        Alignment.CenterVertically -> Alignment.CenterStart
                        Alignment.Bottom -> Alignment.BottomStart
                        else -> Alignment.TopStart
                    })
                    .padding(padding)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        enabled = isEnabled,
                        role = Role.Checkbox,
                        onClick = {
                            onCheckedChange?.invoke(!isChecked)
                        }
                    )
                    .scale(scale)
                    .size(Defaults.checkBoxSize * scale),
                enabled = isEnabled,
                colors = CheckboxDefaults.colors().copy(
                    checkedBoxColor = enabledColor.value,
                    checkedBorderColor = enabledColor.value,
                    uncheckedBorderColor = enabledColor.value,
                    uncheckedBoxColor = SushiTheme.colors.white.value,
                    disabledCheckedBoxColor = disabledColor.value,
                    disabledBorderColor = disabledColor.value,
                    disabledUncheckedBoxColor = SushiTheme.colors.white.value,
                    disabledUncheckedBorderColor = disabledColor.value
                ),
                interactionSource = interactionSource
            )
        }
        if (direction == CheckBoxDirection.Start) {
            if (infoContent != null) {
                infoContent()
            } else {
                InfoContentImpl(props)
            }
        }
    }
}

@Composable
private fun RowScope.InfoContentImpl(
    props: SushiCheckBoxProps
) {
    props.text?.let {
        val defaultTextType = when(props.size) {
            SushiCheckboxSize.Mini -> SushiTextType.Regular100
            SushiCheckboxSize.Default -> SushiTextType.Regular300
            else -> SushiTextType.Regular300
        }
        SushiText(
            props = it.copy(
                type = it.type ?: defaultTextType
            ),
            Modifier.padding(top = SushiTheme.dimens.spacing.mini, bottom = SushiTheme.dimens.spacing.mini)
        )
    }
}

@Preview
@Composable
fun SushiCheckboxPreview1() {
    var checked by remember {
        mutableStateOf(false)
    }
    Column {
        SushiCheckBox(
            SushiCheckBoxProps(
                isChecked = checked,
                text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                size = SushiCheckboxSize.Default
            ),
            onCheckedChange = { checked = !checked }
        )
        SushiCheckBox(
            SushiCheckBoxProps(
                isChecked = checked,
                text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                size = SushiCheckboxSize.Mini
            ),
            onCheckedChange = { checked = !checked }
        )
    }
}

@Preview
@Composable
fun SushiCheckboxPreview2() {
    var checked by remember {
        mutableStateOf(false)
    }
    Column {
        SushiCheckBox(
            SushiCheckBoxProps(
                isChecked = checked,
                text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                size = SushiCheckboxSize.Default,
                alignment = Alignment.Bottom,
            ),
            onCheckedChange = { checked = !checked }
        )
        SushiCheckBox(
            SushiCheckBoxProps(
                isChecked = checked,
                text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                size = SushiCheckboxSize.Mini,
                alignment = Alignment.Bottom,
                isEnabled = false
            ),
            onCheckedChange = { checked = !checked }
        )
    }
}

@Preview
@Composable
fun SushiCheckboxPreview3() {
    var checked by remember {
        mutableStateOf(false)
    }

    Column(horizontalAlignment = Alignment.End) {
        SushiCheckBox(
            SushiCheckBoxProps(
                isChecked = checked,
                text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                size = SushiCheckboxSize.Default,
                direction = CheckBoxDirection.End
            ),
            onCheckedChange = { checked = !checked }
        )
        SushiCheckBox(
            SushiCheckBoxProps(
                isChecked = checked,
                text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                size = SushiCheckboxSize.Mini,
                direction = CheckBoxDirection.End
            ),
            onCheckedChange = { checked = !checked }
        )
    }
}

@Preview
@Composable
fun SushiCheckboxPreview4() {
    var checked by remember {
        mutableStateOf(false)
    }
    Column(horizontalAlignment = Alignment.End) {
        SushiCheckBox(
            SushiCheckBoxProps(
                isChecked = checked,
                text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                size = SushiCheckboxSize.Default,
                alignment = Alignment.Top,
                direction = CheckBoxDirection.End
            ),
            onCheckedChange = { checked = !checked }
        )
        SushiCheckBox(
            SushiCheckBoxProps(
                isChecked = checked,
                text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                size = SushiCheckboxSize.Mini,
                alignment = Alignment.Top,
                isEnabled = false,
                direction = CheckBoxDirection.End
            ),
            onCheckedChange = { checked = !checked }
        )
    }
}
