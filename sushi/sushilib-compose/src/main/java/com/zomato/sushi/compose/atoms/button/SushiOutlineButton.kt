@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.Preview
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.takeIfSpecified

@Composable
internal fun SushiOutlineButton(
    props: SushiButtonProps,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: (@Composable SushiButtonContentScope.() -> Unit)? = null
) {
    val color = props.color.takeIfSpecified() ?: SushiTheme.colors.button.secondaryBackground.asColorSpec()
    val disabledColor = SushiTheme.colors.button.backgroundDisabled.asColorSpec()

    val fontColor = props.fontColor.takeIfSpecified() ?: SushiTheme.colors.button.secondaryLabel.asColorSpec()
    val fontColorPressed = props.fontColor.takeIfSpecified() ?: SushiTheme.colors.button.secondaryLabelPressed.asColorSpec()
    val fontColorDisabled = SushiTheme.colors.button.secondaryLabelDisabled.asColorSpec()

    val borderStrokeColor = props.borderColor.takeIfSpecified() ?: SushiTheme.colors.button.secondaryBorder.asColorSpec()
    val borderStrokeColorPressed = props.borderColor.takeIfSpecified() ?: SushiTheme.colors.button.secondaryBorderPressed.asColorSpec()
    val borderStrokeColorDisabled = SushiTheme.colors.button.secondaryBorderDisabled.asColorSpec()

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
        borderStrokeWidth = 1.dp,
        onClick = onClick,
        content = content
    )
}

@SushiPreview
@Composable
fun SushiOutlineButtonPreview1() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Outline,
                text = "Tsogy",
                isDisabled = true
            ),
            onClick = {}
        )
    }
}

@SushiPreview
@Composable
fun SushiOutlineButtonPreview2() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Outline,
                text = "Tsogy"
            ),
            onClick = {}
        )
    }
}

@SushiPreview
@Composable
fun SushiOutlineButtonPreview3() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Outline,
                text = "Tsogy",
                subtext = "hehe"
            ),
            onClick = {}
        )
    }
}

@SushiPreview
@Composable
fun SushiOutlineButtonPreview4() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Outline,
                text = "Small",
                size = SushiButtonSize.Small
            ),
            onClick = {}
        )
    }
}