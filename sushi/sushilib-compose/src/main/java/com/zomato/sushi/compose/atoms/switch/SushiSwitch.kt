@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.switch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
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
    const val isChecked = false
    const val isEnabled = true
    val switchSize = 21.dp
    val padding @Composable get() = SushiTheme.dimens.spacing.extra
    val verticalAlignment = Alignment.Top
    val textType = SushiTextType.Regular300
    val direction = SwitchDirection.Start
}

@ExperimentalSushiApi
@Composable
fun SushiSwitch(
    props: SushiSwitchProps,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    infoContent: (@Composable RowScope.() -> Unit)? = null
) {
    Base(modifier
        .height(IntrinsicSize.Max)
        .width(IntrinsicSize.Max)
    ) {
        SushiSwitchImpl(
            props,
            onCheckedChange,
            Modifier.fillMaxSize(),
            interactionSource = interactionSource,
            infoContent = infoContent
        )
    }
}

@Composable
private fun SushiSwitchImpl(
    props: SushiSwitchProps,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    infoContent: (@Composable RowScope.() -> Unit)? = null
) {

    val isChecked = props.isChecked ?: Defaults.isChecked
    val isEnabled = props.isEnabled ?: Defaults.isEnabled

    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val enabledColor = props.color.takeIfSpecified() ?: SushiTheme.colors.theme.v500
        val padding = props.padding ?: Defaults.padding
        val verticalAlignment = props.verticalAlignment ?: Defaults.verticalAlignment
        val direction = props.direction ?: Defaults.direction

        if (direction == SwitchDirection.End) {
            if (infoContent != null) {
                infoContent()
            } else {
                InfoContentImpl(props, Modifier.weight(1f, fill = false))
            }
        }

        SwitchImpl(
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
                    onClick = { onCheckedChange.invoke(!isChecked) }
                )
                .size(Defaults.switchSize),
            enabled = isEnabled,
            colors = SwitchDefaults.colors(
                checkedThumbColor = enabledColor.value,
                checkedTrackColor = SushiTheme.colors.theme.v300.value,
                uncheckedThumbColor = SushiTheme.colors.grey.v200.value,
                uncheckedTrackColor = SushiTheme.colors.grey.v500.value,
                disabledCheckedThumbColor = SushiTheme.colors.grey.v400.value,
                disabledCheckedTrackColor = SushiTheme.colors.grey.v200.value,
                disabledUncheckedThumbColor = SushiTheme.colors.grey.v400.value,
                disabledUncheckedTrackColor = SushiTheme.colors.grey.v200.value,
            ),
            interactionSource = interactionSource
        )

        if (direction == SwitchDirection.Start) {
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
    props: SushiSwitchProps,
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
fun SushiSwitchPreview1() {
    Preview {
        var checked by remember {
            mutableStateOf(false)
        }
        Column {
            SushiSwitch(
                SushiSwitchProps(
                    isChecked = checked,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                ),
                onCheckedChange = { checked = !checked }
            )
            SushiSwitch(
                SushiSwitchProps(
                    isChecked = checked,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                ),
                onCheckedChange = { checked = !checked }
            )
        }
    }
}

@SushiPreview
@Composable
fun SushiSwitchPreview2() {
    Preview {
        var checked by remember {
            mutableStateOf(false)
        }
        Column {
            SushiSwitch(
                SushiSwitchProps(
                    isChecked = checked,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                    verticalAlignment = Alignment.Bottom,
                ),
                onCheckedChange = { checked = !checked }
            )
            SushiSwitch(
                SushiSwitchProps(
                    isChecked = checked,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                    verticalAlignment = Alignment.Bottom,
                    isEnabled = false
                ),
                onCheckedChange = { checked = !checked }
            )
        }
    }
}

@SushiPreview
@Composable
fun SushiSwitchPreview3() {
    Preview {
        var checked by remember {
            mutableStateOf(false)
        }

        Column(horizontalAlignment = Alignment.End) {
            SushiSwitch(
                SushiSwitchProps(
                    isChecked = checked,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                    direction = SwitchDirection.End
                ),
                onCheckedChange = { checked = !checked }
            )
            SushiSwitch(
                SushiSwitchProps(
                    isChecked = checked,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                    direction = SwitchDirection.End
                ),
                onCheckedChange = { checked = !checked }
            )
        }
    }
}

@SushiPreview
@Composable
fun SushiSwitchPreview4() {
    Preview {
        var checked by remember {
            mutableStateOf(false)
        }
        Column(horizontalAlignment = Alignment.End) {
            SushiSwitch(
                SushiSwitchProps(
                    isChecked = checked,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                    verticalAlignment = Alignment.Top,
                    direction = SwitchDirection.End
                ),
                onCheckedChange = { checked = !checked }
            )
            SushiSwitch(
                SushiSwitchProps(
                    isChecked = checked,
                    text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                    verticalAlignment = Alignment.Top,
                    isEnabled = false,
                    direction = SwitchDirection.End
                ),
                onCheckedChange = { checked = !checked }
            )
        }
    }
}
