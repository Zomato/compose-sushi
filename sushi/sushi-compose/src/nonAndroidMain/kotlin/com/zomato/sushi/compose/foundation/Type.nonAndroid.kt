package com.zomato.sushi.compose.foundation

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import com.zomato.sushi.compose.foundation.FontLoader.getFontBytes
import composesushi.sushi_compose.generated.resources.Res

/**
 * Shared, non-composable font loader for all non-Android targets (iOS, desktop, JS, Wasm).
 *
 * The fonts live in `commonMain/composeResources/font` and are read once at startup via the
 * suspend [preloadFonts] into an in-memory cache. The non-composable
 * `Font(identity, data, weight, style)` overload then pulls the bytes synchronously from that
 * cache, so the [OkraFontFamily]/[WasabiFontFamily] values stay plain (non-composable) `val`s
 * usable from anywhere.
 *
 * [preloadFonts] MUST be invoked before any Sushi text is rendered. JS and Wasm cannot block, so
 * a preload-then-read cache is the only option there; iOS and desktop reuse the same path for a
 * single shared implementation. Call it from each platform's entry point (see the `:website`
 * `main()` functions and the app's `MainViewController`).
 */
object FontLoader {
    private val cache = mutableMapOf<String, ByteArray>()

    private val fontPaths = listOf(
        "font/okra_thin.ttf",
        "font/okra_extralight.ttf",
        "font/okra_light.ttf",
        "font/okra_regular.ttf",
        "font/okra_medium.ttf",
        "font/okra_semibold.ttf",
        "font/okra_bold.ttf",
        "font/wasabicons.ttf",
    )

    suspend fun preloadFonts() {
        fontPaths.forEach { path ->
            if (!cache.containsKey(path)) {
                cache[path] = Res.readBytes(path)
            }
        }
    }

    fun getFontBytes(key: String): ByteArray = cache[key]
        ?: error("Font '$key' accessed before FontLoader.preloadFonts() completed")
}

/**
 * Defines the Okra font family used as the primary typeface in the Sushi design system.
 *
 * @author gupta.anirudh@zomato.com
 */
// TODO: Migrate to FontResource version of Font() when its available
// https://youtrack.jetbrains.com/issue/CMP-8231/Async-font-loading-support-for-iOS-targets
actual val OkraFontFamily: FontFamily = FontFamily(
    Font("com.zomato.sushi.compose.okraThin", { getFontBytes("font/okra_thin.ttf") }, FontWeight(50)),
    Font("com.zomato.sushi.compose.okraThin", { getFontBytes("font/okra_thin.ttf") }, FontWeight.W100),
    Font("com.zomato.sushi.compose.okraExtralight", { getFontBytes("font/okra_extralight.ttf") }, FontWeight.W200),
    Font("com.zomato.sushi.compose.okraLight", { getFontBytes("font/okra_light.ttf") }, FontWeight.W300),
    Font("com.zomato.sushi.compose.okraRegular", { getFontBytes("font/okra_regular.ttf") }, FontWeight.W400),
    Font("com.zomato.sushi.compose.okraRegular", { getFontBytes("font/okra_regular.ttf") }, FontWeight.W500),
    Font("com.zomato.sushi.compose.okraMedium", { getFontBytes("font/okra_medium.ttf") }, FontWeight.W600),
    Font("com.zomato.sushi.compose.okraSemibold", { getFontBytes("font/okra_semibold.ttf") }, FontWeight.W700),
    Font("com.zomato.sushi.compose.okraBold", { getFontBytes("font/okra_bold.ttf") }, FontWeight.W800),
    Font("com.zomato.sushi.compose.okraBold", { getFontBytes("font/okra_bold.ttf") }, FontWeight.W900),
)

/**
 * Defines the Wasabicons font family used for icons in the Sushi design system.
 *
 * This custom icon font allows rendering vector icons as text characters,
 * enabling efficient icon display with color and size control through text styling.
 */
actual val WasabiFontFamily: FontFamily = FontFamily(
    Font("com.zomato.sushi.compose.wasabicons", { getFontBytes("font/wasabicons.ttf") })
)

/**
 * Default Material Typography with Okra font family applied to all text styles.
 *
 * This ensures that standard Material components will use the Sushi design system's
 * primary font family while maintaining Material's typography scale.
 */
internal actual val MaterialTypography: Typography = Typography().let {
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
