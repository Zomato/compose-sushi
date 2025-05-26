package com.zomato.sushi.compose.atoms.text

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.icon.asIconSizeSpec
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.markdown.MarkdownParser
import com.zomato.sushi.compose.markdown.MarkdownParserProps
import com.zomato.sushi.compose.modifiers.atomClickable
import com.zomato.sushi.compose.modifiers.ifNonNull
import com.zomato.sushi.compose.utils.takeIfSpecified

/**
 * @author gupta.anirudh@zomato.com
 *
 * A customizable text component that supports various styling options, decorations, prefix/suffix icons,
 * and expandable text functionality.
 *
 * Features:
 * - Text styling with different typography styles
 * - Optional prefix and suffix icons or custom composables
 * - Text decorations like underline and strikethrough
 * - Support for markdown formatting
 * - Expandable text with "read more" functionality
 * - Text alignment and arrangement customization
 *
 * @param props The properties to configure the text appearance and behavior
 * @param modifier The modifier to be applied to the component
 * @param prefix An optional composable to display before the text
 * @param suffix An optional composable to display after the text
 * @param onTextLayout Callback that provides the text layout information
 * @param onClick Optional callback to handle click events on the text
 *
 */
@Composable
fun SushiText(
    props: SushiTextProps,
    modifier: Modifier = Modifier,
    prefix: (@Composable () -> Unit)? = null,
    suffix: (@Composable () -> Unit)? = null,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null
) {
    if (props.isValid()) {
        SushiComponentBase(
            modifier
                .width(IntrinsicSize.Max)
                .height(IntrinsicSize.Max)
        ) {
            SushiTextImpl(
                props,
                Modifier.fillMaxSize(),
                prefix = prefix,
                suffix = suffix,
                onTextLayout = onTextLayout,
                onClick = onClick
            )
        }
    }
}

@Composable
private fun SushiTextImpl(
    props: SushiTextProps,
    modifier: Modifier = Modifier,
    prefix: (@Composable () -> Unit)? = null,
    suffix: (@Composable () -> Unit)? = null,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null
) {
    val textAlign = props.textAlign
    val horizontalArrangement = props.horizontalArrangement ?: SushiTextDefaults.horizontalArrangementFromAlignment(textAlign)
    val verticalAlignment = props.verticalAlignment ?: Alignment.CenterVertically

    Row(
        modifier
            .ifNonNull(onClick) { this.atomClickable(onClick = it) },
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement
    ) {
        val context = LocalContext.current
        val rawText = props.text ?: ""
        val isMarkdown = props.markdown ?: SushiTextDefaults.isMarkDown
        val textType = props.type ?: SushiTextDefaults.textType
        val textColor = props.color.takeIfSpecified() ?: SushiTextDefaults.textColor
        val overflowTextColor = props.overflowTextColor?.takeIfSpecified() ?: textColor
        val letterSpacing = props.letterSpacing
        val typeStyle = textType.typeStyle
        val maxLines = props.maxLines ?: SushiTextDefaults.maxLines
        val textDecoration = props.textDecoration
        val textAlign = props.textAlign
        val overflow = props.overflow ?: SushiTextDefaults.overflow
        val softWrap = SushiTextDefaults.softWrap
        val minLines = SushiTextDefaults.minLines
        val overflowText = props.overflowText
        val prefixSpacing = props.prefixSpacing ?: SushiTextDefaults.prefixSpacing
        val suffixSpacing = props.suffixSpacing ?: SushiTextDefaults.suffixSpacing
        val fontSizeMultiplier = SushiTheme.fontSizeMultiplier
        val textBrush = props.textBrush

        var textLayoutResult: TextLayoutResult? by remember { mutableStateOf(null) }

        val localCurrentTextStyle = LocalTextStyle.current
        val textStyle = remember(
            context,
            localCurrentTextStyle,
            typeStyle,
            fontSizeMultiplier,
            textBrush
        ) {
            val baseStyle = localCurrentTextStyle.merge(typeStyle)
            baseStyle.copy(
                fontSize = fontSizeMultiplier(baseStyle.fontSize),
                lineHeightStyle = LineHeightStyle(
                    alignment = LineHeightStyle.Alignment.Center,
                    trim = LineHeightStyle.Trim.Both
                ),
                brush = textBrush
            )
        }
        val markdownParserProps = remember(fontSizeMultiplier) {
            MarkdownParserProps.default.copy(
                fontSizeMultiplier = fontSizeMultiplier
            )
        }

        val text = when {
            isMarkdown -> {
                MarkdownParser.default.parse(
                    text = rawText,
                    props = markdownParserProps
                )
            }
            rawText is AnnotatedString -> {
                rawText
            }
            else -> {
                remember(rawText) { AnnotatedString(rawText.toString()) }
            }
        }

        PrefixIcon(
            props = props.prefixIcon,
            fontSize = textStyle.fontSize,
            textColor = textColor,
            spacing = prefixSpacing,
            prefix = prefix
        )

        if (!overflowText.isNullOrEmpty()) {
            ExpandableBaseSushiText(
                text = text,
                maxLines = maxLines,
                textColor = textColor,
                letterSpacing = letterSpacing,
                textStyle = textStyle,
                textDecoration = null,
                textAlign = textAlign,
                onTextLayout = {
                    textLayoutResult = it
                    onTextLayout(it)
                },
                overflowText = overflowText,
                overflowTextColor = overflowTextColor,
                Modifier
                    .ifNonNull(textDecoration) {
                        this.textDecoration(
                            textDecoration = it,
                            textLayoutResult = textLayoutResult,
                            fontWeight = textStyle.fontWeight,
                            fontSize = textStyle.fontSize,
                            defaultColor = textColor
                        )
                    }
                    .weight(1f, fill = false)
            )
        } else {
            BaseSushiText(
                text = text,
                textColor = textColor,
                maxLines = maxLines,
                letterSpacing = letterSpacing,
                textStyle = textStyle,
                textDecoration = null,
                textAlign = textAlign,
                overflow = overflow,
                softWrap = softWrap,
                minLines = minLines,
                onTextLayout = {
                    textLayoutResult = it
                    onTextLayout(it)
                },
                Modifier
                    .ifNonNull(textDecoration) {
                        this.textDecoration(
                            textDecoration = it,
                            textLayoutResult = textLayoutResult,
                            fontWeight = textStyle.fontWeight,
                            fontSize = textStyle.fontSize,
                            defaultColor = textColor
                        )
                    }
                    .weight(1f, fill = false)
            )
        }

        SuffixIcon(
            props = props.suffixIcon,
            fontSize = textStyle.fontSize,
            textColor = textColor,
            spacing = suffixSpacing,
            suffix = suffix
        )
    }
}

@Composable
private fun RowScope.PrefixIcon(
    props: SushiIconProps?,
    fontSize: TextUnit,
    textColor: ColorSpec,
    spacing: Dp,
    prefix: (@Composable () -> Unit)? = null,
) {
    when {
        prefix != null -> prefix()
        props != null -> {
            val actualIconProps = props.copy(
                size = props.size ?: fontSize.asIconSizeSpec(),
                color = props.color.takeIf { it.value.isSpecified } ?: textColor
            )
            SushiIcon(
                props = actualIconProps,
                Modifier.padding(end = spacing)
            )
        }
    }
}

@Composable
private fun ExpandableBaseSushiText(
    text: AnnotatedString,
    maxLines: Int,
    textColor: ColorSpec,
    letterSpacing: TextUnit,
    textStyle: TextStyle,
    textDecoration: TextDecoration?,
    textAlign: TextAlign?,
    onTextLayout: (TextLayoutResult) -> Unit,
    overflowText: String,
    overflowTextColor: ColorSpec,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        var cutText by remember(text) { mutableStateOf<AnnotatedString?>(null) }
        var expanded by remember { mutableStateOf(false) }
        val textLayoutResultState = remember { mutableStateOf<TextLayoutResult?>(null) }
        val seeMoreSizeState = remember { mutableStateOf<IntSize?>(null) }
        val seeMoreOffsetState = remember { mutableStateOf<Offset?>(null) }

        val textLayoutResult = textLayoutResultState.value
        val seeMoreSize = seeMoreSizeState.value
        val seeMoreOffset = seeMoreOffsetState.value

        LaunchedEffect(text, expanded, textLayoutResult, seeMoreSize, maxLines) {
            val lastLineIndex = maxLines - 1
            if (!expanded && textLayoutResult != null && seeMoreSize != null
                && lastLineIndex + 1 == textLayoutResult.lineCount
                && textLayoutResult.isLineEllipsized(lastLineIndex)
            ) {
                var lastCharIndex = textLayoutResult.getLineEnd(lastLineIndex, visibleEnd = true) + 1
                var charRect: Rect
                do {
                    lastCharIndex -= 1
                    charRect = textLayoutResult.getCursorRect(lastCharIndex)
                } while (
                    charRect.left > textLayoutResult.size.width - seeMoreSize.width
                )
                seeMoreOffsetState.value = Offset(charRect.left, charRect.bottom - seeMoreSize.height)
                cutText = AnnotatedString(text.substring(startIndex = 0, endIndex = lastCharIndex))
            }
        }

        BaseSushiText(
            text = cutText ?: text,
            textColor = textColor,
            maxLines = if (expanded) Int.MAX_VALUE else maxLines,
            letterSpacing = letterSpacing,
            textStyle = textStyle,
            textDecoration = textDecoration,
            textAlign = textAlign,
            overflow = TextOverflow.Ellipsis,
            softWrap = SushiTextDefaults.softWrap,
            minLines = SushiTextDefaults.minLines,
            onTextLayout = {
                onTextLayout(it)
                textLayoutResultState.value = it
            },
            Modifier
        )

        if (!expanded) {
            val density = LocalDensity.current
            Text(
                " …$overflowText",
                color = overflowTextColor.value,
                letterSpacing = letterSpacing,
                style = textStyle,
                textDecoration = textDecoration,
                onTextLayout = { seeMoreSizeState.value = it.size },
                modifier = Modifier
                    .then(
                        if (seeMoreOffset != null)
                            Modifier.offset(
                                x = with(density) { seeMoreOffset.x.toDp() },
                                y = with(density) { seeMoreOffset.y.toDp() },
                            )
                        else
                            Modifier
                    )
                    .clickable {
                        expanded = true
                        cutText = null
                    }
                    .alpha(if (seeMoreOffset != null) 1f else 0f)
            )
        }
    }
}

@Composable
private fun BaseSushiText(
    text: AnnotatedString,
    textColor: ColorSpec,
    maxLines: Int,
    letterSpacing: TextUnit,
    textStyle: TextStyle,
    textDecoration: TextDecoration?,
    textAlign: TextAlign?,
    overflow: TextOverflow,
    softWrap: Boolean,
    minLines: Int,
    onTextLayout: (TextLayoutResult) -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier.wrapContentSize(),
        color = textColor.value,
        maxLines = maxLines,
        letterSpacing = letterSpacing,
        style = textStyle,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        softWrap = softWrap,
        minLines = minLines,
        onTextLayout = onTextLayout,
    )
}

@Composable
private fun RowScope.SuffixIcon(
    props: SushiIconProps?,
    fontSize: TextUnit,
    textColor: ColorSpec,
    spacing: Dp,
    suffix: (@Composable () -> Unit)? = null
) {
    when {
        suffix != null -> suffix()
        props != null -> {
            val actualIconProps = props.copy(
                size = props.size ?: fontSize.asIconSizeSpec(),
                color = props.color.takeIf { it.value.isSpecified } ?: textColor
            )
            SushiIcon(
                props = actualIconProps,
                Modifier.padding(start = spacing)
            )
        }
    }
}

private fun SushiTextProps.isValid(): Boolean {
    return !this.text.isNullOrEmpty() || this.prefixIcon != null || this.suffixIcon != null
}

@Composable
@SushiPreview
private fun SushiTextPreview1() {
    SushiPreview {
        Column {
            SushiText(
                props = SushiTextProps(
                    text = "fsdgy",
                    prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon),
                    suffixIcon = SushiIconProps(code = SushiIconCodes.IconContactlessDining, color = SushiColorData(ColorName.Blue, ColorVariation.Variation500)),
                    color = SushiColorData(ColorName.Red, ColorVariation.Variation500),
                    type = SushiTextType.Regular300,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    textDecoration = SushiTextDecoration.LineThrough()
                ),
                Modifier.fillMaxWidth()
            )
            SushiText(
                props = SushiTextProps(
                    text = "fsdgy",
                    prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon),
                    suffixIcon = SushiIconProps(code = SushiIconCodes.IconContactlessDining, color = SushiColorData(ColorName.Blue, ColorVariation.Variation500)),
                    color = SushiTheme.colors.text.success,
                    type = SushiTextType.Regular400,
                    textDecoration = SushiTextDecoration.Underline()
                )
            )
            SushiText(
                props = SushiTextProps(
                    text = "a_fsdgy_\n<bold-100|{red-500|fs}>ad**gy**\nfsdgy",
                    prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon),
                    suffixIcon = SushiIconProps(code = SushiIconCodes.IconContactlessDining, color = SushiColorData(ColorName.Blue, ColorVariation.Variation500)),
                    color = SushiTheme.colors.text.success,
                    maxLines = 2,
                    letterSpacing = 2.sp,
                    type = SushiTextType.Regular900,
                    textDecoration = SushiTextDecoration.Underline()
                )
            )
        }
    }
}

@Composable
@SushiPreview
private fun SushiTextPreview2() {
    SushiPreview {
        Column(
            Modifier
                .fillMaxSize()
                .background(SushiTheme.colors.surface.primary.value)) {
            SushiText(
                props = SushiTextProps(
                    text = "fsdgy",
                    prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon),
                    suffixIcon = SushiIconProps(
                        code = SushiIconCodes.IconContactlessDining,
                        color = SushiColorData(ColorName.Blue, ColorVariation.Variation500)
                    ),
                    color = SushiColorData(ColorName.Red, ColorVariation.Variation500),
                    type = SushiTextType.Regular300,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ),
                Modifier.fillMaxWidth()
            )
            SushiText(
                props = SushiTextProps(
                    text = "fsdgy",
                    prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon),
                    suffixIcon = SushiIconProps(
                        code = SushiIconCodes.IconContactlessDining,
                        color = SushiColorData(ColorName.Blue, ColorVariation.Variation500)
                    ),
                    color = SushiTheme.colors.text.success,
                    type = SushiTextType.Regular400
                )
            )
            SushiText(
                props = SushiTextProps(
                    text = "a_fsdgy_\n[<bold-800|{red-500|fs}>ad**gy**google](https://google.com)\nfs~~dg~~y",
                    prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon),
                    suffixIcon = SushiIconProps(
                        code = SushiIconCodes.IconContactlessDining,
                        color = SushiTheme.colors.blue.v500
                    ),
                    color = SushiTheme.colors.text.success,
                    maxLines = 3,
                    letterSpacing = 4.em,
                    type = SushiTextType.Regular900
                )
            )
            SushiText(
                props = SushiTextProps(
                    text = "Free",
                    prefixIcon = SushiIconProps(code = SushiIconCodes.IconScooterSharp),
                    color = SushiTheme.colors.text.primary,
                    type = SushiTextType.Regular900
                )
            )
            SushiText(
                props = SushiTextProps(
                    text = "Lorem Ipsum is simply dummy \ntext of the printing and typesetting industry. Lorem \nIpsum has been the industry's standard dummy text ever since t\nhehe",
                    maxLines = 3,
                    prefixIcon = SushiIconProps(code = SushiIconCodes.IconScooterSharp),
                    color = SushiTheme.colors.text.primary,
                    type = SushiTextType.Regular900,
                    overflowText = "Read More",
                    overflowTextColor = SushiTheme.colors.text.success,
                    verticalAlignment = Alignment.Top,
                    textDecoration = SushiTextDecoration.Underline()
                )
            )
        }
    }
}
