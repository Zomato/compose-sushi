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
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview

/**
 * @author gupta.anirudh@zomato.com
 *
 * A customizable checkbox component for the Sushi design system.
 *
 * SushiCheckBox provides a standard checkbox implementation with support for:
 * - Different sizes (Mini, Default)
 * - Primary and secondary text labels
 * - Custom positioning (checkbox at start or end)
 * - Vertical alignment control
 * - Custom content through the infoContent parameter
 * - Consistent styling with the design system
 *
 * @param props The properties to configure the checkbox appearance and behavior
 * @param onCheckedChange Callback invoked when the checkbox checked state changes
 * @param modifier The modifier to be applied to the component
 * @param interactionSource Source of interactions for the checkbox
 * @param infoContent Optional custom content to replace the standard text labels
 */
@Composable
fun SushiCheckBox(
    props: SushiCheckBoxProps,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    infoContent: (@Composable RowScope.() -> Unit)? = null
) {
    SushiComponentBase(modifier
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

    val isChecked = props.checked ?: SushiCheckBoxDefaults.isChecked
    val isEnabled = props.enabled ?: SushiCheckBoxDefaults.isEnabled

    Row(
        modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = isEnabled,
                role = Role.Checkbox,
                onClick = {
                    onCheckedChange.invoke(!isChecked)
                }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val enabledColor = props.color ?: SushiTheme.colors.base.theme.v600
        val disabledColor = SushiTheme.colors.grey.v500
        val padding = props.boxPadding ?: SushiCheckBoxDefaults.padding
        val verticalAlignment = props.verticalAlignment ?: SushiCheckBoxDefaults.verticalAlignment
        val scale = when (props.size) {
            SushiCheckboxSize.Mini -> 0.75f
            SushiCheckboxSize.Default -> 0.90f
            null -> 1f
        }
        val direction = props.direction ?: SushiCheckBoxDefaults.direction

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
                    .padding(
                        start = padding.takeIf { direction == CheckBoxDirection.End } ?: 0.dp,
                        top = padding,
                        end = padding.takeIf { direction == CheckBoxDirection.Start } ?: 0.dp,
                        bottom = padding
                    )
                    .scale(scale)
                    .size(SushiCheckBoxDefaults.checkBoxSize * scale),
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
        val defaultTextType = with(SushiCheckBoxDefaults) { props.textType }
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
    SushiPreview {
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
    SushiPreview {
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
    SushiPreview {
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
    SushiPreview {
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
