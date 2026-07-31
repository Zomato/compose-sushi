package com.zomato.sushi.compose.markdown

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.foundation.isDarkMode
import com.zomato.sushi.core.SushiColorToken

/**
 * Applies a left-to-right gradient to text using semantic color tokens.
 *
 * Supported syntax:
 * `{gradient(direction=left_right;colors=color.primary@1.0,color.secondary@0.5)|text}`
 *
 * An optional `dark_colors` section overrides the colors in dark mode:
 * `{gradient(direction=left_right;colors=color.base.red.500@1.0,color.base.purple.500@1.0;dark_colors=color.base.red.400@1.0,color.base.purple.300@1.0)|text}`
 */
class GradientTextColorProcessor : Processor {

    private data class Transformation(
        val start: Int,
        val end: Int,
        val transformedText: AnnotatedString,
        val brush: Brush?
    )

    private companion object {
        val REGEX = "(\\{gradient\\()(.+?)(\\)\\|)((.|\\n)+?)(\\})".toRegex()
        const val CONFIG_GROUP = 2
        const val TEXT_GROUP = 4
    }

    override val cacheKeys: List<Any>
        @Composable get() = listOf(SushiTheme.colorTokenMapper, SushiTheme.isDarkMode)

    @Composable
    override fun process(props: MarkdownParserProps, src: AnnotatedString): AnnotatedString {
        val colorTokenMapper = SushiTheme.colorTokenMapper
        val isDarkMode = SushiTheme.isDarkMode
        val transformations = mutableListOf<Transformation>()

        REGEX.findAll(src).forEach { matchResult ->
            val config = matchResult.groups[CONFIG_GROUP]?.value
                ?.let(::parseGradientTextConfig)
            val transformedText = matchResult.groups[TEXT_GROUP]
                ?.let { src.subSequence(it.getTextRange()) }
                ?: return@forEach
            val colors = config?.colorStopsFor(isDarkMode)?.mapNotNull { colorStop ->
                colorTokenMapper(SushiColorToken(colorStop.token)).value
                    .takeIf { color -> color.isSpecified }
                    ?.copy(alpha = colorStop.alpha)
            }
            val brush = colors
                ?.takeIf { it.size >= MIN_GRADIENT_COLOR_COUNT }
                ?.let { Brush.horizontalGradient(it) }

            transformations.add(
                Transformation(
                    start = matchResult.range.first,
                    end = matchResult.range.last + 1,
                    transformedText = transformedText,
                    brush = brush
                )
            )
        }

        return buildAnnotatedString {
            var currentStartIndex = 0

            transformations.forEach { transformation ->
                append(src.subSequence(currentStartIndex, transformation.start))
                append(transformation.transformedText)
                transformation.brush?.let { brush ->
                    addStyle(
                        style = SpanStyle(brush = brush),
                        start = length - transformation.transformedText.length,
                        end = length
                    )
                }
                currentStartIndex = transformation.end
            }

            append(src.subSequence(currentStartIndex, src.length))
        }
    }
}

internal data class GradientTextConfig(
    val colorStops: List<GradientColorStop>,
    val darkColorStops: List<GradientColorStop>? = null
)

internal data class GradientColorStop(
    val token: String,
    val alpha: Float
)

private const val CONFIG_SEPARATOR = '='
private const val DIRECTION_KEY = "direction"
private const val COLORS_KEY = "colors"
private const val DARK_COLORS_KEY = "dark_colors"
private const val LEFT_TO_RIGHT = "left_right"
private const val COLOR_TOKEN_PREFIX = "color."
private const val COLOR_ALPHA_SEPARATOR = '@'
private const val MIN_GRADIENT_COLOR_COUNT = 2

/** Parses the supported gradient text descriptor into validated semantic color stops. */
internal fun parseGradientTextConfig(config: String): GradientTextConfig? {
    val supportedKeys = setOf(DIRECTION_KEY, COLORS_KEY, DARK_COLORS_KEY)
    val configEntries = config.split(';').map { part ->
        val separatorIndex = part.indexOf(CONFIG_SEPARATOR)
        if (separatorIndex <= 0 || separatorIndex == part.lastIndex) return null

        part.substring(0, separatorIndex).trim() to
            part.substring(separatorIndex + 1).trim()
    }
    val keys = configEntries.map { it.first }
    if (keys.any { it !in supportedKeys } || keys.distinct().size != keys.size) return null

    val configMap = configEntries.toMap()
    if (configMap[DIRECTION_KEY] != LEFT_TO_RIGHT) return null

    val colorStops = configMap[COLORS_KEY]
        ?.let(::parseGradientColorStops)
        ?: return null
    val darkColorStops = configMap[DARK_COLORS_KEY]?.let { colors ->
        parseGradientColorStops(colors) ?: return null
    }

    return GradientTextConfig(
        colorStops = colorStops,
        darkColorStops = darkColorStops
    )
}

/** Returns the active theme's stops, falling back to the default colors in dark mode. */
internal fun GradientTextConfig.colorStopsFor(isDarkMode: Boolean): List<GradientColorStop> =
    if (isDarkMode) darkColorStops ?: colorStops else colorStops

private fun parseGradientColorStops(value: String): List<GradientColorStop>? {
    val colorStops = value.split(',').map(::parseGradientColorStop)
    if (colorStops.any { it == null }) return null

    return colorStops.filterNotNull().takeIf { it.size >= MIN_GRADIENT_COLOR_COUNT }
}

/** Parses and validates one `<semantic-token>@<alpha>` gradient color stop. */
private fun parseGradientColorStop(value: String): GradientColorStop? {
    val separatorIndex = value.lastIndexOf(COLOR_ALPHA_SEPARATOR)
    if (separatorIndex <= 0 || separatorIndex == value.lastIndex) return null

    val token = value.substring(0, separatorIndex).trim()
    val alpha = value.substring(separatorIndex + 1).trim().toFloatOrNull()
    if (!token.startsWith(COLOR_TOKEN_PREFIX) || alpha == null || alpha !in 0f..1f) return null

    return GradientColorStop(token = token, alpha = alpha)
}
