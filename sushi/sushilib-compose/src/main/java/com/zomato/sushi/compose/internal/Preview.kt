@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.internal

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.foundation.ColorTokenMapper
import com.zomato.sushi.compose.foundation.SushiDimension
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.foundation.SushiTypography
import com.zomato.sushi.compose.foundation.sushiDarkColorScheme
import com.zomato.sushi.compose.foundation.sushiLightColorScheme
import java.io.IOException

@Composable
internal fun Preview(
    typography: SushiTypography = SushiTheme.typography,
    dimens: SushiDimension = SushiTheme.dimens,
    colorTokenMapper: ColorTokenMapper = SushiTheme.colorTokenMapper,
    content: @Composable () -> Unit
) {
    if (!LocalInspectionMode.current) {
        throw IOException("Only allowed in inspection mode")
    }
    val colorScheme = if (isSystemInDarkTheme()) {
        sushiDarkColorScheme()
    } else {
        sushiLightColorScheme()
    }
    SushiTheme(
        colorScheme = colorScheme,
        typography = typography,
        dimens = dimens,
        colorTokenMapper = colorTokenMapper,
        content = content
    )
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF, uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    name = "Light Mode"
)
@Preview(
    showBackground = true,
    backgroundColor = 0xFF17171C,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    name = "Dark Mode"
)
internal annotation class SushiPreview