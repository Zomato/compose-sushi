package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.Preview
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.takeIfSpecified

/**
 * @author gupta.anirudh@zomato.com
 */
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
        borderStrokeWidth = 0.dp,
        onClick = onClick,
        content = content
    )
}

@SushiPreview
@Composable
private fun SushiSolidButtonPreview1() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Solid,
                text = "Tsogy",
                enabled = false
            ),
            onClick = {}
        )
    }
}

@SushiPreview
@Composable
private fun SushiSolidButtonPreview2() {
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
private fun SushiSolidButtonPreview3() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Solid,
                text = "Tsogy",
                // subText = "hehe"
            ),
            onClick = {}
        )
    }
}

@SushiPreview
@Composable
private fun SushiSolidButtonPreview4() {
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


@SushiPreview
@Composable
private fun SushiSolidButtonPreview5() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Solid,
                text = "Large",
                size = SushiButtonSize.Large,
                prefixIcon = SushiIconProps(code = SushiIconCodes.IconScooterSharp),
                suffixIcon = SushiIconProps(code = SushiIconCodes.IconScooterSharp),
            ),
            onClick = {}
        )
    }
}

@SushiPreview
@Composable
private fun SushiSolidButtonPreview6() {
    Preview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Solid,
                text = "Large",
                size = SushiButtonSize.Large,
                suffixIcon = SushiIconProps(code = SushiIconCodes.IconNextArrowCircleFill),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ),
            onClick = {},
            Modifier.width(180.dp).height(70.dp)
        )
    }
}