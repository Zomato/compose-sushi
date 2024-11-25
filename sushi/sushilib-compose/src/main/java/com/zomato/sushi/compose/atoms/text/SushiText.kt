@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.zomato.sushi.compose.atoms.internal.Base
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.icon.TextUnitIconSizeSpec
import com.zomato.sushi.compose.atoms.internal.scaled
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.Preview
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.markdown.MarkdownParser
import com.zomato.sushi.compose.utils.atomClickable
import com.zomato.sushi.compose.utils.ifNonNull
import com.zomato.sushi.compose.utils.takeIfSpecified

@Immutable
private object Defaults {
    val isMarkDownEnabled: Boolean = true
    val textType: TextTypeSpec = SushiTextType.Regular100
    val textColor: ColorSpec @Composable get() = SushiTheme.colors.text.default.asColorSpec()
    val maxLines: Int = Int.MAX_VALUE
    val overflow: TextOverflow = TextOverflow.Clip
    val softWrap: Boolean = true
    val minLines: Int = 1
    val safeOverflowTextLimit = 4
}

@ExperimentalSushiApi
@Composable
fun SushiText(
    props: SushiTextProps,
    modifier: Modifier = Modifier,
    prefix: (@Composable () -> Unit)? = null,
    suffix: (@Composable () -> Unit)? = null,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null
) {
    Base(modifier) {
        SushiTextImpl(
            props,
            prefix = prefix,
            suffix = suffix,
            onTextLayout = onTextLayout,
            onClick = onClick
        )
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
    Row(
        modifier
            .ifNonNull(onClick) {
                this.atomClickable(onClick = it)
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        val context = LocalContext.current
        val rawText = props.text ?: ""
        val isMarkDownEnabled = props.isMarkDownEnabled ?: Defaults.isMarkDownEnabled
        val textType = props.type ?: Defaults.textType
        val textColor = props.color.takeIfSpecified() ?: Defaults.textColor
        val letterSpacing = props.letterSpacing
        val typeStyle = textType.typeStyle
        val maxLines = props.maxLines ?: Defaults.maxLines

        val localCurrentTextStyle = LocalTextStyle.current
        val textStyle = remember(
            context,
            localCurrentTextStyle,
            typeStyle
        ) {
            val baseStyle = localCurrentTextStyle.merge(typeStyle)
            baseStyle.copy(
                fontSize = baseStyle.fontSize.scaled(context),
                lineHeightStyle = LineHeightStyle(
                    alignment = LineHeightStyle.Alignment.Center,
                    trim = LineHeightStyle.Trim.Both
                )
            )
        }

        val text = remember(context, rawText, isMarkDownEnabled) {
            if (isMarkDownEnabled) {
                MarkdownParser.default.parse(
                    context = context,
                    text = rawText
                )
            } else {
                AnnotatedString(rawText)
            }
        }

        if (prefix != null) {
            prefix()
        } else {
            PrefixIcon(
                props = props.prefixIcon,
                fontSize = textStyle.fontSize,
                textColor = textColor
            )
        }

        val isOverflowTextPresent = !props.overflowText.isNullOrEmpty()
        if (isOverflowTextPresent) {
            var isOverflowing by remember { mutableStateOf(false) }
            var displayableText by remember(text) { mutableStateOf(text) }
            val displayedText = remember(text, displayableText, isOverflowing, props.overflowText) {
                if (isOverflowing) {
                    buildAnnotatedString {
                        append(displayableText)
                        append("… ")
                        append(props.overflowText)
                    }
                } else {
                    text
                }
            }

            Text(
                text = displayedText,
                Modifier.wrapContentSize(),
                color = textColor.value,
                maxLines = maxLines,
                letterSpacing = letterSpacing,
                style = textStyle,
                textDecoration = props.textDecoration,
                textAlign = props.textAlign,
                overflow = props.overflow ?: Defaults.overflow,
                softWrap = Defaults.softWrap,
                minLines = Defaults.minLines,
                onTextLayout = { textLayoutResult: TextLayoutResult ->
                    onTextLayout(textLayoutResult)
                    if (textLayoutResult.hasVisualOverflow) {
                        isOverflowing = true

                        // Calculate the visible text up to the last character within max lines
                        val lastCharIndex = textLayoutResult.getLineEnd(maxLines - 1)
                        displayableText = text.subSequence(0, lastCharIndex - props.overflowText!!.length - Defaults.safeOverflowTextLimit)
                    } else {
                        isOverflowing = false
                    }
                }
            )
        } else {
            Text(
                text = text,
                Modifier.wrapContentSize(),
                color = textColor.value,
                maxLines = maxLines,
                letterSpacing = letterSpacing,
                style = textStyle,
                textDecoration = props.textDecoration,
                textAlign = props.textAlign,
                overflow = props.overflow ?: Defaults.overflow,
                softWrap = Defaults.softWrap,
                minLines = Defaults.minLines,
                onTextLayout = onTextLayout,
            )
        }

        if (suffix != null) {
            suffix()
        } else {
            SuffixIcon(
                props = props.suffixIcon,
                fontSize = textStyle.fontSize,
                textColor = textColor
            )
        }
    }
}

@Composable
private fun RowScope.PrefixIcon(
    props: SushiIconProps?,
    fontSize: TextUnit,
    textColor: ColorSpec
) {
    if (props != null) {
        val actualIconProps = props.copy(
            size = props.size ?: TextUnitIconSizeSpec(fontSize),
            color = props.color.takeIf { it.value.isSpecified } ?: textColor
        )
        SushiIcon(
            props = actualIconProps,
            Modifier.padding(end = SushiTheme.dimens.spacing.mini)
        )
    }
}

@Composable
private fun RowScope.SuffixIcon(
    props: SushiIconProps?,
    fontSize: TextUnit,
    textColor: ColorSpec
) {
    if (props != null) {
        val actualIconProps = props.copy(
            size = props.size ?: TextUnitIconSizeSpec(fontSize),
            color = props.color.takeIf { it.value.isSpecified } ?: textColor
        )
        SushiIcon(
            props = actualIconProps,
            Modifier.padding(start = SushiTheme.dimens.spacing.mini)
        )
    }
}

@Composable
@SushiPreview
fun SushiTextPreview1() {
    Preview {
        Column {
            SushiText(
                props = SushiTextProps(
                    text = "fsdgy",
                    prefixIcon = SushiIconProps(code = "e926"),
                    suffixIcon = SushiIconProps(
                        code = "e93f",
                        color = SushiColorData(ColorName.Blue, ColorVariation.Variation500)
                    ),
                    color = SushiColorData(ColorName.Red, ColorVariation.Variation500),
                    type = SushiTextType.Regular300
                )
            )
            SushiText(
                props = SushiTextProps(
                    text = "fsdgy",
                    prefixIcon = SushiIconProps(code = "e926"),
                    suffixIcon = SushiIconProps(
                        code = "e93f",
                        color = SushiColorData(ColorName.Blue, ColorVariation.Variation500)
                    ),
                    color = SushiTheme.colors.text.success.asColorSpec(),
                    type = SushiTextType.Regular400
                )
            )
            SushiText(
                props = SushiTextProps(
                    text = "a_fsdgy_\n[<bold-800|{red-500|fs}>ad**gy**google](https://google.com)\nfs~~dg~~y",
                    prefixIcon = SushiIconProps(code = "e926"),
                    suffixIcon = SushiIconProps(
                        code = "e93f",
                        color = SushiTheme.colors.blue.v500.asColorSpec()
                    ),
                    color = SushiTheme.colors.text.success.asColorSpec(),
                    maxLines = 3,
                    letterSpacing = 4.sp,
                    type = SushiTextType.Regular900
                )
            )
            SushiText(
                props = SushiTextProps(
                    text = "Free",
                    prefixIcon = SushiIconProps(code = "edae"),
                    color = SushiTheme.colors.text.primary.asColorSpec(),
                    type = SushiTextType.Regular900
                )
            )
            SushiText(
                props = SushiTextProps(
                    text = "Lorem Ipsum is simply dummy \ntext of the printing and typesetting industry. Lorem \nIpsum has been the industry's standard dummy text ever since t\nhehe",
                    maxLines = 3,
                    prefixIcon = SushiIconProps(code = "edae"),
                    color = SushiTheme.colors.text.primary.asColorSpec(),
                    type = SushiTextType.Regular900,
                    overflowText = "Read More"
                )
            )
        }
    }
}
