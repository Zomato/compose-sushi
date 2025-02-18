package com.zomato.sushi.compose.internal

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import com.zomato.sushi.compose.foundation.SushiColorTokenMapper
import com.zomato.sushi.compose.foundation.SushiDimension
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.foundation.SushiTypography
import com.zomato.sushi.compose.foundation.sushiDarkColorScheme
import com.zomato.sushi.compose.foundation.sushiLightColorScheme

/**
 * @author gupta.anirudh@zomato.com
 */
@Composable
fun SushiPreview(
    typography: SushiTypography = SushiTheme.typography,
    dimens: SushiDimension = SushiTheme.dimens,
    colorTokenMapper: SushiColorTokenMapper = SushiTheme.colorTokenMapper,
    content: @Composable () -> Unit
) {
    val colorScheme = if (isSystemInDarkTheme()) {
        sushiDarkColorScheme()
    } else {
        sushiLightColorScheme()
    }
    CompositionLocalProvider(
        LocalInspectionMode provides true
    ) {
        SushiTheme(
            colorScheme = colorScheme,
            typography = typography,
            dimens = dimens,
            colorTokenMapper = colorTokenMapper,
            content = content
        )
    }
}

@SuppressLint("ComposePreviewNaming")
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    name = "LightMode",
    apiLevel = 34
)
@Preview(
    showBackground = true,
    backgroundColor = 0xFF17171C,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    name = "DarkMode",
    apiLevel = 34
)
annotation class SushiPreview