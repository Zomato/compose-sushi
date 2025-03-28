package com.zomato.sushi.compose.atoms.icon

import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.foundation.WasabiFontFamily
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.modifiers.atomClickable
import com.zomato.sushi.compose.modifiers.ifNonNull
import com.zomato.sushi.compose.utils.takeIfSpecified

/**
 * A composable component that displays an icon from the Sushi design system.
 *
 * SushiIcon renders icons from the Wasabi icon font based on the provided properties.
 * It supports customization of size, color, and click interactions.
 *
 * @param props The properties to configure the icon appearance
 * @param modifier The modifier to be applied to the icon
 * @param onClick Optional callback to handle click events on the icon
 *
 * @author gupta.anirudh@zomato.com
 */
@Composable
fun SushiIcon(
    props: SushiIconProps,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
) {
    if (props.parsedIcon != null) {
        SushiComponentBase(modifier
            .testTag("SushiIcon")
        ) {
            SushiIconImpl(
                props,
                Modifier.align(Alignment.Center),
                onClick = onClick
            )
        }
    }
}

@Composable
private fun SushiIconImpl(
    props: SushiIconProps,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    val size = props.size?.size ?: SushiIconDefaults.size.size
    val parsedIcon = props.parsedIcon ?: ""
    val context = LocalContext.current
    val baseTextStyle = LocalTextStyle.current
    val color = props.color.takeIfSpecified() ?: SushiTheme.colors.icon.primary
    val fontSizeMultiplier = SushiTheme.fontSizeMultiplier
    val overrideTextStyle = remember(
        context,
        baseTextStyle,
        size,
        fontSizeMultiplier
    ) {
        baseTextStyle.copy(
            fontSize = fontSizeMultiplier(size),
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.Both
            ),
            fontFamily = WasabiFontFamily
        )
    }
    Text(
        text = parsedIcon,
        modifier
            .ifNonNull(onClick) {
                this.atomClickable(onClick = it)
            },
        color = color.value,
        maxLines = 1,
        style = overrideTextStyle,
    )
}

@SushiPreview
@Composable
private fun SushiIconPreview1() {
    SushiPreview {
        SushiIcon(
            SushiIconProps(
                code = SushiIconCodes.IconMoon,
                size = SushiIconSize.Size300
            ),
            Modifier
        )
    }
}

@SushiPreview
@Composable
private fun SushiIconPreview2() {
    SushiPreview {
        SushiIcon(
            SushiIconProps(
                code = SushiIconCodes.IconContactlessDining,
                color = SushiTheme.colors.red.v500
            ),
            Modifier
        )
    }
}

@SushiPreview
@Composable
private fun SushiIconPreview3() {
    SushiPreview {
        SushiIcon(
            SushiIconProps(
                code = SushiIconCodes.IconContactlessDining,
                color = SushiTheme.colors.red.v500,
                size = SushiIconSize.Size900
            ),
            Modifier
        )
    }
}

@SushiPreview
@Composable
private fun SushiIconPreview4() {
    SushiPreview {
        SushiIcon(
            SushiIconProps(
                code = SushiIconCodes.IconContactlessDining,
                color = SushiTheme.colors.red.v500,
                size = 100.dp.asIconSizeSpec()
            ),
            Modifier.size(200.dp)
        )
    }
}
