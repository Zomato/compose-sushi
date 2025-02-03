package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.takeIfSpecified

/**
 * @author gupta.anirudh@zomato.com
 */
@Composable
internal fun SushiOutlineButton(
    props: SushiButtonProps,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: (@Composable SushiButtonContentScope.() -> Unit)? = null
) {
    val color = props.color.takeIfSpecified() ?: SushiTheme.colors.button.secondaryBackground
    val disabledColor = color

    val fontColor = props.fontColor.takeIfSpecified() ?: SushiTheme.colors.button.secondaryLabel
    val fontColorPressed = props.fontColor.takeIfSpecified() ?: SushiTheme.colors.button.secondaryLabelPressed
    val fontColorDisabled = SushiTheme.colors.button.secondaryLabelDisabled

    val borderStrokeColor = props.borderColor.takeIfSpecified() ?: SushiTheme.colors.button.secondaryBorder
    val borderStrokeColorPressed = props.borderColor.takeIfSpecified() ?: SushiTheme.colors.button.secondaryBorderPressed
    val borderStrokeColorDisabled = SushiTheme.colors.button.secondaryBorderDisabled

    val minHeight = with(SushiButtonDefaults) { getButtonMinHeight(props.sizeOrDefault) }

    SushiSurfaceButtonImpl(
        props = props,
        modifier = modifier
            .heightIn(min = minHeight),
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
private fun SushiOutlineButtonPreview1() {
    SushiPreview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Outline,
                text = "Tsogy",
                enabled = false
            ),
            onClick = {}
        )
    }
}

@SushiPreview
@Composable
private fun SushiOutlineButtonPreview2() {
    SushiPreview {
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
private fun SushiOutlineButtonPreview3() {
    SushiPreview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Outline,
                text = "Tsogy",
                // subText = "hehe"
            ),
            onClick = {}
        )
    }
}

@SushiPreview
@Composable
private fun SushiOutlineButtonPreview4() {
    SushiPreview {
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


@SushiPreview
@Composable
private fun SushiOutlineButtonPreview5() {
    SushiPreview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Outline,
                text = "Large",
                size = SushiButtonSize.Large
            ),
            onClick = {}
        )
    }
}