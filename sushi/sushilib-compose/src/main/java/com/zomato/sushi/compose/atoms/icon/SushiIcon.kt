@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.icon

import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.internal.Base
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.foundation.WasabiFontFamily
import com.zomato.sushi.compose.internal.Preview
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.atomClickable
import com.zomato.sushi.compose.utils.ifNonNull
import com.zomato.sushi.compose.utils.takeIfSpecified

private object Defaults {
    val size = SushiIconSize.Size100
}

/**
 * @author gupta.anirudh@zomato.com
 */
@ExperimentalSushiApi
@Composable
fun SushiIcon(
    props: SushiIconProps,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
) {
    Base(modifier) {
        SushiIconImpl(
            props,
            Modifier.align(Alignment.Center),
            onClick = onClick
        )
    }
}

@Composable
private fun SushiIconImpl(
    props: SushiIconProps,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    val size = props.size?.size ?: Defaults.size.size
    val parsedIcon = props.parsedIcon
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
    Preview {
        SushiIcon(
            SushiIconProps(
                code = "e926",
                size = SushiIconSize.Size300
            ),
            Modifier
        )
    }
}

@SushiPreview
@Composable
private fun SushiIconPreview2() {
    Preview {
        SushiIcon(
            SushiIconProps(
                code = "e93f",
                color = SushiTheme.colors.red.v500
            ),
            Modifier
        )
    }
}

@SushiPreview
@Composable
private fun SushiIconPreview3() {
    Preview {
        SushiIcon(
            SushiIconProps(
                code = "e93f",
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
    Preview {
        SushiIcon(
            SushiIconProps(
                code = "e93f",
                color = SushiTheme.colors.red.v500,
                size = 100.dp.asIconSizeSpec()
            ),
            Modifier.size(200.dp)
        )
    }
}
