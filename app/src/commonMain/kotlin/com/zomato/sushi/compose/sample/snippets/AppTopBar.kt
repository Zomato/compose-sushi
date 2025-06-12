package com.zomato.sushi.compose.sample.snippets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.icon.SushiIconSize
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.sample.ui.theme.AppColorMode
import com.zomato.sushi.compose.sample.ui.theme.AppTheme

@Composable
fun AppTopBar(
    title: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(SushiTheme.dimens.spacing.extra)
    ) {
        val themeManager = AppTheme.themeController
        SushiText(
            SushiTextProps(
                text = title,
                type = SushiTextType.Bold900,
                overflow = TextOverflow.Ellipsis
            ),
            Modifier.weight(1f)
        )
        SushiIcon(
            props = SushiIconProps(
                code = SushiIconCodes.IconMoon,
                size = SushiIconSize.Size700,
            ),
            Modifier
                .clickable {
                    themeManager.updateDarkMode(!themeManager.darkMode.value)
                }
        )
        SushiIcon(
            props = SushiIconProps(
                code = SushiIconCodes.IconTheme,
                size = SushiIconSize.Size700
            ),
            Modifier
                .clickable {
                    themeManager.updateColorMode(
                        when (themeManager.colorMode.value) {
                            AppColorMode.Red -> AppColorMode.Green
                            AppColorMode.Green -> AppColorMode.Red
                        }
                    )
                }
        )
    }
}