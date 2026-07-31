package com.zomato.sushi.compose.markdown

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class GradientTextColorProcessorTest {

    @Test
    fun parsesSupportedGradientContract() {
        val result = parseGradientTextConfig(
            "direction=left_right;colors=color.primary@1.0,color.surface.background@0.35"
        )

        assertEquals(
            GradientTextConfig(
                colorStops = listOf(
                    GradientColorStop(token = "color.primary", alpha = 1f),
                    GradientColorStop(token = "color.surface.background", alpha = 0.35f)
                )
            ),
            result
        )
    }

    @Test
    fun parsesDarkModeGradientOverride() {
        val result = parseGradientTextConfig(
            "direction=left_right;colors=color.base.red.500@1.0,color.base.purple.500@1.0;" +
                "dark_colors=color.base.red.400@1.0,color.base.purple.300@1.0"
        )

        assertEquals(
            GradientTextConfig(
                colorStops = listOf(
                    GradientColorStop(token = "color.base.red.500", alpha = 1f),
                    GradientColorStop(token = "color.base.purple.500", alpha = 1f)
                ),
                darkColorStops = listOf(
                    GradientColorStop(token = "color.base.red.400", alpha = 1f),
                    GradientColorStop(token = "color.base.purple.300", alpha = 1f)
                )
            ),
            result
        )
    }

    @Test
    fun selectsDarkModeGradientOverride() {
        val config = GradientTextConfig(
            colorStops = listOf(
                GradientColorStop(token = "color.base.red.500", alpha = 1f),
                GradientColorStop(token = "color.base.purple.500", alpha = 1f)
            ),
            darkColorStops = listOf(
                GradientColorStop(token = "color.base.red.400", alpha = 1f),
                GradientColorStop(token = "color.base.purple.300", alpha = 1f)
            )
        )

        assertEquals(config.darkColorStops, config.colorStopsFor(isDarkMode = true))
        assertEquals(config.colorStops, config.colorStopsFor(isDarkMode = false))
    }

    @Test
    fun fallsBackToDefaultGradientWhenDarkModeOverrideIsAbsent() {
        val config = GradientTextConfig(
            colorStops = listOf(
                GradientColorStop(token = "color.primary", alpha = 1f),
                GradientColorStop(token = "color.secondary", alpha = 1f)
            )
        )

        assertEquals(config.colorStops, config.colorStopsFor(isDarkMode = true))
    }

    @Test
    fun rejectsInvalidDarkModeGradientOverride() {
        val result = parseGradientTextConfig(
            "direction=left_right;colors=color.base.red.500@1.0,color.base.purple.500@1.0;" +
                "dark_colors=color.base.red.400@1.0,purple-300@1.0"
        )

        assertNull(result)
    }

    @Test
    fun rejectsUnsupportedDirection() {
        val result = parseGradientTextConfig(
            "direction=top_bottom;colors=color.primary@1.0,color.surface.background@0.35"
        )

        assertNull(result)
    }

    @Test
    fun rejectsAlphaOutsideSupportedRange() {
        val result = parseGradientTextConfig(
            "direction=left_right;colors=color.primary@1.1,color.surface.background@0.35"
        )

        assertNull(result)
    }

    @Test
    fun rejectsGradientWithFewerThanTwoValidTokens() {
        val result = parseGradientTextConfig(
            "direction=left_right;colors=color.primary@1.0,red-500@0.35"
        )

        assertNull(result)
    }
}
