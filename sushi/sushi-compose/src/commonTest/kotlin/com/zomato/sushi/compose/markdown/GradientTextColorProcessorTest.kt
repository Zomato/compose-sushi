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
