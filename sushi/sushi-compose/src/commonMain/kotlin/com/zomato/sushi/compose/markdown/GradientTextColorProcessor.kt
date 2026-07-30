package com.zomato.sushi.compose.markdown

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.core.SushiColorToken

/**
 * Applies a left-to-right gradient to text using semantic color tokens.
 *
 * Supported syntax:
 * `{gradient(direction=left_right;colors=color.primary@1.0,color.secondary@0.5)|text}`
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
        @Composable get() = listOf(SushiTheme.colorTokenMapper)

    @Composable
    override fun process(props: MarkdownParserProps, src: AnnotatedString): AnnotatedString {
        val colorTokenMapper = SushiTheme.colorTokenMapper
        val transformations = mutableListOf<Transformation>()

        REGEX.findAll(src).forEach { matchResult ->
            val config = matchResult.groups[CONFIG_GROUP]?.value
                ?.let(::parseGradientTextConfig)
            val transformedText = matchResult.groups[TEXT_GROUP]
                ?.let { src.subSequence(it.getTextRange()) }
                ?: return@forEach
            val colors = config?.colorStops?.mapNotNull { colorStop ->
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
    val colorStops: List<GradientColorStop>
)

internal data class GradientColorStop(
    val token: String,
    val alpha: Float
)

private const val DIRECTION_PREFIX = "direction="
private const val COLORS_PREFIX = "colors="
private const val LEFT_TO_RIGHT = "left_right"
private const val COLOR_TOKEN_PREFIX = "color."
private const val COLOR_ALPHA_SEPARATOR = '@'
private const val EXPECTED_CONFIG_PART_COUNT = 2
private const val MIN_GRADIENT_COLOR_COUNT = 2

/** Parses the supported gradient text descriptor into validated semantic color stops. */
internal fun parseGradientTextConfig(config: String): GradientTextConfig? {
    val configParts = config.split(';')
    if (configParts.size != EXPECTED_CONFIG_PART_COUNT) return null

    val direction = configParts.first().trim().removePrefix(DIRECTION_PREFIX)
    if (direction != LEFT_TO_RIGHT || !configParts.first().trim().startsWith(DIRECTION_PREFIX)) {
        return null
    }

    val colorsPart = configParts.last().trim()
    if (!colorsPart.startsWith(COLORS_PREFIX)) return null

    val colorStops = colorsPart.removePrefix(COLORS_PREFIX)
        .split(',')
        .map(::parseGradientColorStop)
    if (colorStops.any { it == null }) return null

    return colorStops.filterNotNull()
        .takeIf { it.size >= MIN_GRADIENT_COLOR_COUNT }
        ?.let(::GradientTextConfig)
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
