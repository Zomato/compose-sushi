@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.Preview
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.takeIfSpecified

@Composable
internal fun SushiSolidButton(
    props: SushiButtonProps,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: (@Composable SushiButtonContentScope.() -> Unit)? = null
) {
    val color = props.color.takeIfSpecified() ?: SushiTheme.colors.button.primaryBackground
    val disabledColor = SushiTheme.colors.button.backgroundDisabled

    val fontColor = props.fontColor.takeIfSpecified() ?: SushiTheme.colors.button.primaryLabel
    val fontColorPressed = props.fontColor.takeIfSpecified() ?: SushiTheme.colors.button.primaryLabelPressed
    val fontColorDisabled = SushiTheme.colors.button.primaryLabelDisabled

    val borderStrokeColor = color
    val borderStrokeColorPressed = color
    val borderStrokeColorDisabled = SushiTheme.colors.button.secondaryBorderDisabled

    SushiSurfaceButtonImpl(
        props = props,
        modifier = modifier,
        color = color,
        colorDisabled = disabledColor,
        fontColor = fontColor,
        fontColorPressed = fontColorPressed,
        fontColorDisabled = fontColorDisabled,
        borderStrokeColor = borderStrokeColor,
        borderStrokeColorPressed = borderStrokeColorPressed,
        borderStrokeColorDisabled = borderStrokeColorDisabled,
        borderStrokeWidth = 0.dp,
        onClick = onClick,
        content = content
    )
}

@SushiPreview
@Composable
fun SushiSolidButtonPreview1() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Solid,
                text = "Tsogy",
                isDisabled = true
            ),
            onClick = {}
        )
    }
}

@SushiPreview
@Composable
fun SushiSolidButtonPreview2() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Solid,
                text = "Tsogy"
            ),
            onClick = {}
        )
    }
}

@SushiPreview
@Composable
fun SushiSolidButtonPreview3() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Solid,
                text = "Tsogy",
                subtext = "hehe"
            ),
            onClick = {}
        )
    }
}

@SushiPreview
@Composable
fun SushiSolidButtonPreview4() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Solid,
                text = "Small",
                size = SushiButtonSize.Small
            ),
            onClick = {}
        )
    }
}