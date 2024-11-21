@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.icon

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.LineHeightStyle
import com.zomato.sushi.compose.atoms.internal.Base
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.internal.scaled
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.Preview
import com.zomato.sushi.compose.foundation.WasabiFontFamily
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.atomClickable
import com.zomato.sushi.compose.utils.ifNonNull
import com.zomato.sushi.compose.utils.takeIfSpecified

private object Defaults {
    val size = SushiIconSize.Size100
}

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
    val color = props.color.takeIfSpecified() ?: SushiTheme.colors.icon.primary.asColorSpec()

    val overrideTextStyle = remember(
        context,
        baseTextStyle,
        size
    ) {
        baseTextStyle.copy(
            fontSize = size.scaled(context),
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
fun SushiIconPreview1() {
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
fun SushiIconPreview2() {
    Preview {
        SushiIcon(
            SushiIconProps(
                code = "e93f",
                color = SushiTheme.colors.red.v500.asColorSpec()
            ),
            Modifier
        )
    }
}
