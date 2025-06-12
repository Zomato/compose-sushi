package com.zomato.sushi.compose.foundation

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import com.zomato.sushi.compose.foundation.FontLoader.getFontBytes
import composesushi.sushi_compose.generated.resources.Res.readBytes

object FontLoader {
    private val cache = mutableMapOf<String, ByteArray>()

    suspend fun preloadFonts() {
        cache["font/okra_thin.ttf"] = readBytes("font/okra_thin.ttf")
        cache["font/okra_extralight.ttf"] = readBytes("font/okra_extralight.ttf")
        cache["font/okra_light.ttf"] = readBytes("font/okra_light.ttf")
        cache["font/okra_regular.ttf"] = readBytes("font/okra_regular.ttf")
        cache["font/okra_medium.ttf"] = readBytes("font/okra_medium.ttf")
        cache["font/okra_semibold.ttf"] = readBytes("font/okra_semibold.ttf")
        cache["font/okra_bold.ttf"] = readBytes("font/okra_bold.ttf")
        cache["font/wasabicons.ttf"] = readBytes("font/wasabicons.ttf")
    }

    fun getFontBytes(key: String): ByteArray = cache[key]!!
}

// TODO: Migrate to FontResource version of Font() when its available
// https://youtrack.jetbrains.com/issue/CMP-8231/Async-font-loading-support-for-iOS-targets
actual val OkraFontFamily: FontFamily = FontFamily(
    Font(
        "com.zomato.sushi.compose.okraThin",
        { getFontBytes("font/okra_thin.ttf") },
        FontWeight(50)
    ),
    Font(
        "com.zomato.sushi.compose.okraThin",
        { getFontBytes("font/okra_thin.ttf") },
        FontWeight.W100
    ),
    Font(
        "com.zomato.sushi.compose.okraExtralight",
        { getFontBytes("font/okra_extralight.ttf") },
        FontWeight.W200
    ),
    Font(
        "com.zomato.sushi.compose.okraLight",
        { getFontBytes("font/okra_light.ttf") },
        FontWeight.W300
    ),
    Font(
        "com.zomato.sushi.compose.okraRegular",
        { getFontBytes("font/okra_regular.ttf") },
        FontWeight.W400
    ),
    Font(
        "com.zomato.sushi.compose.okraRegular",
        { getFontBytes("font/okra_regular.ttf") },
        FontWeight.W500
    ),
    Font(
        "com.zomato.sushi.compose.okraMedium",
        { getFontBytes("font/okra_medium.ttf") },
        FontWeight.W600
    ),
    Font(
        "com.zomato.sushi.compose.okraSemibold",
        { getFontBytes("font/okra_semibold.ttf") },
        FontWeight.W700
    ),
    Font(
        "com.zomato.sushi.compose.okraBold",
        { getFontBytes("font/okra_bold.ttf") },
        FontWeight.W800
    ),
    Font(
        "com.zomato.sushi.compose.okraBold",
        { getFontBytes("font/okra_bold.ttf") },
        FontWeight.W900
    ),
)

actual val WasabiFontFamily: FontFamily = FontFamily(
    Font("com.zomato.sushi.compose.okraThin", { getFontBytes("font/wasabicons.ttf") })
)

/**
 * Default Material Typography with Okra font family applied to all text styles.
 *
 * This ensures that standard Material components will use the Sushi design system's
 * primary font family while maintaining Material's typography scale.
 */
internal actual val MaterialTypography = Typography().let {
    val okraFontFamily = OkraFontFamily
    it.copy(
        displayLarge = it.displayLarge.copy(fontFamily = okraFontFamily),
        displayMedium = it.displayMedium.copy(fontFamily = okraFontFamily),
        displaySmall = it.displaySmall.copy(fontFamily = okraFontFamily),
        headlineLarge = it.headlineLarge.copy(fontFamily = okraFontFamily),
        headlineMedium = it.headlineMedium.copy(fontFamily = okraFontFamily),
        headlineSmall = it.headlineSmall.copy(fontFamily = okraFontFamily),
        titleLarge = it.titleLarge.copy(fontFamily = okraFontFamily),
        titleMedium = it.titleMedium.copy(fontFamily = okraFontFamily),
        titleSmall = it.titleSmall.copy(fontFamily = okraFontFamily),
        bodyLarge = it.bodyLarge.copy(fontFamily = okraFontFamily),
        bodyMedium = it.bodyMedium.copy(fontFamily = okraFontFamily),
        bodySmall = it.bodySmall.copy(fontFamily = okraFontFamily),
        labelLarge = it.labelLarge.copy(fontFamily = okraFontFamily),
        labelMedium = it.labelMedium.copy(fontFamily = okraFontFamily),
        labelSmall = it.labelSmall.copy(fontFamily = okraFontFamily)
    )
}