@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.checkbox

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.testTag
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

/**
 * @author gupta.anirudh@zomato.com
 */
@ExperimentalSushiApi
enum class SushiCheckboxSize {
    Mini, Default
}

private object Defaults {
    const val isChecked = false
    const val isEnabled = true
    val checkBoxSize = 21.dp
    val padding @Composable get() = SushiTheme.dimens.spacing.macro
    val verticalAlignment = Alignment.Top
    val direction = CheckBoxDirection.Start
}

/**
 * @author gupta.anirudh@zomato.com
 */
@ExperimentalSushiApi
@Composable
fun SushiCheckBox(
    props: SushiCheckBoxProps,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    infoContent: (@Composable RowScope.() -> Unit)? = null
) {
    Base(modifier
        .testTag("SushiCheckBox")
        .height(IntrinsicSize.Max)
        .width(IntrinsicSize.Max)
    ) {
        SushiCheckBoxImpl(
            props,
            onCheckedChange,
            Modifier.fillMaxSize(),
            interactionSource = interactionSource,
            infoContent = infoContent
        )
    }
}

@Composable
private fun SushiCheckBoxImpl(
    props: SushiCheckBoxProps,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    @SuppressLint("SlotReused") infoContent: (@Composable RowScope.() -> Unit)? = null
) {

    val isChecked = props.checked ?: Defaults.isChecked
    val isEnabled = props.enabled ?: Defaults.isEnabled

    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val enabledColor = props.color ?: SushiTheme.colors.theme.v600
        val disabledColor = SushiTheme.colors.grey.v500
        val padding = props.boxPadding ?: Defaults.padding
        val verticalAlignment = props.verticalAlignment ?: Defaults.verticalAlignment
        val scale = when (props.size) {
            SushiCheckboxSize.Mini -> 0.75f
            SushiCheckboxSize.Default -> 0.90f
            null -> 1f
        }
        val direction = props.direction ?: Defaults.direction

        if (direction == CheckBoxDirection.End) {
            if (infoContent != null) {
                infoContent()
            } else {
                InfoContentImpl(props, Modifier.weight(1f, fill = false))
            }
        }

        CompositionLocalProvider(LocalMinimumInteractiveComponentSize provides 0.dp) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = null,
                Modifier
                    .align(verticalAlignment)
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
                    uncheckedBoxColor = SushiTheme.colors.surface.primary.value,
                    disabledCheckedBoxColor = disabledColor.value,
                    disabledBorderColor = disabledColor.value,
                    disabledUncheckedBoxColor = SushiTheme.colors.surface.primary.value,
                    disabledUncheckedBorderColor = disabledColor.value
                ),
                interactionSource = interactionSource
            )
            if (direction == CheckBoxDirection.Start) {
                if (infoContent != null) {
                    infoContent()
                } else {
                    InfoContentImpl(props, Modifier.weight(1f, fill = false))
                }
            }
        }
    }
}

@Composable
private fun RowScope.InfoContentImpl(
    props: SushiCheckBoxProps,
    modifier: Modifier = Modifier
) {
    if (props.text != null || props.subText != null) {
        val defaultTextType = when(props.size) {
            SushiCheckboxSize.Mini -> SushiTextType.Regular100
            SushiCheckboxSize.Default -> SushiTextType.Regular300
            else -> SushiTextType.Regular300
        }
        Column(
            modifier,
            horizontalAlignment = Alignment.Start
        ) {
            props.text?.let {
                SushiText(
                    props = it.copy(
                        type = it.type ?: defaultTextType
                    ),
                    Modifier.padding(top = SushiTheme.dimens.spacing.mini, bottom = SushiTheme.dimens.spacing.mini)
                )
            }
            props.subText?.let {
                SushiText(
                    props = it.copy(
                        type = it.type ?: defaultTextType
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
    Preview {
        var checked by remember {
            mutableStateOf(false)
        }
        Column {
            SushiCheckBox(
                SushiCheckBoxProps(
                    checked = checked,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                    size = SushiCheckboxSize.Default
                ),
                onCheckedChange = { checked = !checked }
            )
            SushiCheckBox(
                SushiCheckBoxProps(
                    checked = checked,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                    size = SushiCheckboxSize.Mini
                ),
                onCheckedChange = { checked = !checked }
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiCheckboxPreview2() {
    Preview {
        var checked by remember {
            mutableStateOf(false)
        }
        Column {
            SushiCheckBox(
                SushiCheckBoxProps(
                    checked = checked,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                    subText = SushiTextProps(text = "SubText"),
                    size = SushiCheckboxSize.Default,
                    verticalAlignment = Alignment.Top,
                ),
                onCheckedChange = { checked = !checked }
            )
            SushiCheckBox(
                SushiCheckBoxProps(
                    checked = checked,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                    size = SushiCheckboxSize.Mini,
                    verticalAlignment = Alignment.Bottom,
                    enabled = false
                ),
                onCheckedChange = { checked = !checked }
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiCheckboxPreview3() {
    Preview {
        var checked by remember {
            mutableStateOf(false)
        }

        Column(horizontalAlignment = Alignment.End) {
            SushiCheckBox(
                SushiCheckBoxProps(
                    checked = checked,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                    size = SushiCheckboxSize.Default,
                    direction = CheckBoxDirection.End
                ),
                onCheckedChange = { checked = !checked }
            )
            SushiCheckBox(
                SushiCheckBoxProps(
                    checked = checked,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                    size = SushiCheckboxSize.Mini,
                    direction = CheckBoxDirection.End
                ),
                onCheckedChange = { checked = !checked }
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiCheckboxPreview4() {
    Preview {
        var checked by remember {
            mutableStateOf(false)
        }
        Column(horizontalAlignment = Alignment.End) {
            SushiCheckBox(
                SushiCheckBoxProps(
                    checked = checked,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                    size = SushiCheckboxSize.Default,
                    verticalAlignment = Alignment.Top,
                    direction = CheckBoxDirection.End
                ),
                onCheckedChange = { checked = !checked },
                Modifier.fillMaxWidth()
            )
            SushiCheckBox(
                SushiCheckBoxProps(
                    checked = checked,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                    subText = SushiTextProps(text = "SubText"),
                    size = SushiCheckboxSize.Mini,
                    verticalAlignment = Alignment.Top,
                    enabled = false,
                    direction = CheckBoxDirection.End
                ),
                onCheckedChange = { checked = !checked }
            )
        }
    }
}
