package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.zomato.sushi.compose.atoms.text.SushiTextDecoration
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.takeIfSpecified

/**
 * @author fi-app
 *
 * A specialized button implementation that displays text with an underline decoration.
 * This is part of the SushiButton family and follows its design language.
 *
 * The underlined text style is typically used for links or actions with minimal visual impact.
 */
@Composable
internal fun SushiUnderlineButton(
    props: SushiButtonProps,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: (@Composable SushiButtonContentScope.() -> Unit)? = null
) {
    // We leverage the SushiTextButton implementation, but ensure text has the underline decoration
    // This is primarily handled in SushiButtonContentImpl where we check for SushiButtonType.Underline
    val fontColor = props.fontColor.takeIfSpecified() ?: SushiTheme.colors.button.ghostLabel
    val fontColorPressed =
        props.fontColor.takeIfSpecified() ?: SushiTheme.colors.button.ghostLabelPressed
    val fontColorDisabled = SushiTheme.colors.button.ghostLabelDisabled

    // Use the existing text button implementation as it provides the right behavior
    SushiTextButton(
        props = props,
        onClick = onClick,
        modifier = modifier,
        interactionSource = interactionSource,
        content = content
    )
}

@SushiPreview
@Composable
private fun SushiUnderlineButtonPreview1() {
    SushiPreview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Underline,
                text = "Underlined Link Button",
                enabled = true
            ),
            onClick = {}
        )
    }
}

@SushiPreview
@Composable
private fun SushiUnderlineButtonPreview2() {
    SushiPreview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Underline,
                text = "Disabled Link Button",
                enabled = false
            ),
            onClick = {}
        )
    }
}

@SushiPreview
@Composable
private fun SushiUnderlineButtonPreview3() {
    SushiPreview {
        SushiButton(
            SushiButtonProps(
                type = SushiButtonType.Underline,
                text = "Small Link Button",
                size = SushiButtonSize.Small
            ),
            onClick = {}
        )
    }
}