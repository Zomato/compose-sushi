package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextDecoration
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.BaseScreen
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import kotlinx.serialization.Serializable

@Serializable
object TextShowcaseScreen

@Composable
fun TextShowcaseScreen(
    modifier: Modifier = Modifier
) {
    BaseScreen(modifier) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = SushiTheme.colors.surface.primary.value
        ) { innerPadding ->
            Column(
                Modifier
                    .padding(innerPadding)
            ) {
                AppTopBar(
                    title = "Text Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        start = SushiTheme.dimens.spacing.base,
                        end = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )

                // Card with examples
                Column(
                    Modifier
                        .verticalScroll(rememberScrollState())
                        .fillMaxWidth()
                        .padding(SushiTheme.dimens.spacing.base)
                ) {
                    // 1. Basic text with default styling
                    SectionTitle("Basic Text")
                    SushiText(
                        props = SushiTextProps(
                            text = "1. Basic text with default styling",
                            type = SushiTextType.Regular400
                        )
                    )

                    Spacer(Modifier.height(16.dp))

                    // 2. Text with custom color
                    SectionTitle("Custom Colors")
                    SushiText(
                        props = SushiTextProps(
                            text = "2. Text with custom color (Red)",
                            color = SushiColorData(ColorName.Red, ColorVariation.Variation500),
                            type = SushiTextType.Regular400
                        )
                    )

                    // 3. Text with theme color
                    SushiText(
                        props = SushiTextProps(
                            text = "3. Text with theme color (Success)",
                            color = SushiTheme.colors.text.success,
                            type = SushiTextType.Regular400
                        )
                    )

                    Spacer(Modifier.height(16.dp))

                    // 4-8. Text with different typography styles
                    SectionTitle("Typography Styles")
                    SushiText(
                        props = SushiTextProps(
                            text = "4. Light Typography (Light100)",
                            type = SushiTextType.Light100
                        )
                    )

                    SushiText(
                        props = SushiTextProps(
                            text = "5. Regular Typography (Regular300)",
                            type = SushiTextType.Regular300
                        )
                    )

                    SushiText(
                        props = SushiTextProps(
                            text = "6. Medium Typography (Medium500)",
                            type = SushiTextType.Medium500
                        )
                    )

                    SushiText(
                        props = SushiTextProps(
                            text = "7. Bold Typography (Bold700)",
                            type = SushiTextType.Bold700
                        )
                    )

                    SushiText(
                        props = SushiTextProps(
                            text = "8. ExtraBold Typography (ExtraBold900)",
                            type = SushiTextType.ExtraBold900
                        )
                    )

                    Spacer(Modifier.height(16.dp))

                    // 9-10. Text with prefix icons
                    SectionTitle("Icons")
                    SushiText(
                        props = SushiTextProps(
                            text = "9. Text with prefix icon",
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon),
                            type = SushiTextType.Regular400
                        )
                    )

                    // 10. Text with suffix icon
                    SushiText(
                        props = SushiTextProps(
                            text = "10. Text with suffix icon",
                            suffixIcon = SushiIconProps(code = SushiIconCodes.IconChevronRight),
                            type = SushiTextType.Regular400
                        )
                    )

                    // 11. Text with both icons
                    SushiText(
                        props = SushiTextProps(
                            text = "11. Text with both icons",
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon),
                            suffixIcon = SushiIconProps(code = SushiIconCodes.IconChevronRight),
                            type = SushiTextType.Regular400
                        )
                    )

                    // 12. Customized icons
                    SushiText(
                        props = SushiTextProps(
                            text = "12. Customized icons with color",
                            prefixIcon = SushiIconProps(
                                code = SushiIconCodes.IconCheck,
                                color = SushiTheme.colors.green.v500
                            ),
                            suffixIcon = SushiIconProps(
                                code = SushiIconCodes.IconChevronRight,
                                color = SushiTheme.colors.blue.v500
                            ),
                            type = SushiTextType.Regular400
                        )
                    )

                    Spacer(Modifier.height(16.dp))

                    // 13-14. Letter spacing examples
                    SectionTitle("Letter Spacing")
                    SushiText(
                        props = SushiTextProps(
                            text = "13. Increased letter spacing (2sp)",
                            letterSpacing = 2.sp,
                            type = SushiTextType.Regular400
                        )
                    )

                    SushiText(
                        props = SushiTextProps(
                            text = "14. Negative letter spacing (-0.5sp)",
                            letterSpacing = (-0.5).sp,
                            type = SushiTextType.Regular400
                        )
                    )

                    Spacer(Modifier.height(16.dp))

                    // 15-16. Text decoration examples
                    SectionTitle("Text Decorations")
                    SushiText(
                        props = SushiTextProps(
                            text = "15. Underlined text",
                            textDecoration = SushiTextDecoration.Underline(),
                            type = SushiTextType.Regular400
                        )
                    )

                    SushiText(
                        props = SushiTextProps(
                            text = "16. Strikethrough text",
                            textDecoration = SushiTextDecoration.LineThrough(),
                            type = SushiTextType.Regular400
                        )
                    )

                    // 17. Custom underline
                    SushiText(
                        props = SushiTextProps(
                            text = "17. Customized underline with color and width",
                            textDecoration = SushiTextDecoration.Underline(
                                color = SushiColorData(ColorName.Red, ColorVariation.Variation500),
                                strokeWidth = 2.dp
                            ),
                            type = SushiTextType.Regular400
                        )
                    )

                    // 18. Custom strikethrough
                    SushiText(
                        props = SushiTextProps(
                            text = "18. Customized strikethrough with dotted style",
                            textDecoration = SushiTextDecoration.LineThrough(
                                dotSize = 2.dp,
                                gapSize = 2.dp
                            ),
                            type = SushiTextType.Regular400
                        )
                    )

                    Spacer(Modifier.height(16.dp))

                    // 19-21. Text alignment examples
                    SectionTitle("Text Alignment")
                    SushiText(
                        props = SushiTextProps(
                            text = "19. Left aligned text (default)",
                            textAlign = TextAlign.Start,
                            type = SushiTextType.Regular400
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    SushiText(
                        props = SushiTextProps(
                            text = "20. Center aligned text",
                            textAlign = TextAlign.Center,
                            type = SushiTextType.Regular400
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    SushiText(
                        props = SushiTextProps(
                            text = "21. Right aligned text",
                            textAlign = TextAlign.End,
                            type = SushiTextType.Regular400
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(16.dp))

                    // 22-24. Max lines and overflow examples
                    SectionTitle("Max Lines & Overflow")
                    SushiText(
                        props = SushiTextProps(
                            text = "22. This is a very long text that should be truncated with ellipsis because we're limiting it to just a single line with the maxLines property.",
                            maxLines = 1,
                            type = SushiTextType.Regular400
                        )
                    )

                    SushiText(
                        props = SushiTextProps(
                            text = "23. This text will show exactly 2 lines and then use the default ellipsis overflow handling for any additional content that doesn't fit.",
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            type = SushiTextType.Regular400
                        )
                    )

                    SushiText(
                        props = SushiTextProps(
                            text = "24. This very long text will be clipped at 1 line without showing any ellipsis due to TextOverflow.Clip setting.",
                            maxLines = 1,
                            overflow = TextOverflow.Clip,
                            type = SushiTextType.Regular400
                        )
                    )

                    Spacer(Modifier.height(16.dp))

                    // 25-26. Read more functionality
                    SectionTitle("Read More Functionality")
                    SushiText(
                        props = SushiTextProps(
                            text = "25. This is an example of text with 'Read more' functionality. When the text is too long to fit within the specified number of lines, a 'Read more' button appears that can be clicked to expand the text to show its entire content.",
                            maxLines = 2,
                            overflowText = "Read more",
                            type = SushiTextType.Regular400
                        )
                    )

                    SushiText(
                        props = SushiTextProps(
                            text = "26. Another example with customized 'Show more' text and a different color for the overflow text to make it stand out more.",
                            maxLines = 2,
                            overflowText = "Show more",
                            overflowTextColor = SushiTheme.colors.blue.v500,
                            type = SushiTextType.Regular400
                        )
                    )

                    Spacer(Modifier.height(16.dp))

                    // 27-28. Horizontal arrangement
                    SectionTitle("Layout Arrangement")
                    SushiText(
                        props = SushiTextProps(
                            text = "27. Space Between",
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon),
                            suffixIcon = SushiIconProps(code = SushiIconCodes.IconChevronRight),
                            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween,
                            type = SushiTextType.Regular400
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    // 28. Vertical alignment
                    SushiText(
                        props = SushiTextProps(
                            text = "28. Top vertical alignment",
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon),
                            verticalAlignment = Alignment.Top,
                            type = SushiTextType.Regular400
                        )
                    )

                    Spacer(Modifier.height(16.dp))

                    // 29-30. Markdown support
                    SectionTitle("Markdown Support")
                    SushiText(
                        props = SushiTextProps(
                            text = "29. Basic **bold** and _italic_ markdown",
                            markdown = true,
                            type = SushiTextType.Regular400
                        )
                    )

                    SushiText(
                        props = SushiTextProps(
                            text = "30. Advanced markdown with [link](https://www.zomato.com) and ~~strikethrough~~",
                            markdown = true,
                            type = SushiTextType.Regular400
                        )
                    )

                    Spacer(Modifier.height(16.dp))

                    // 31. Gradient text
                    SectionTitle("Special Effects")
                    val horizontalGradient = Brush.horizontalGradient(
                        colors = listOf(
                            SushiTheme.colors.blue.v500.value,
                            SushiTheme.colors.purple.v500.value
                        )
                    )

                    SushiText(
                        props = SushiTextProps(
                            text = "31. Gradient text with horizontal brush",
                            textBrush = horizontalGradient,
                            type = SushiTextType.Bold700
                        )
                    )

                    // 32. Vertical gradient
                    val verticalGradient = Brush.verticalGradient(
                        colors = listOf(
                            SushiTheme.colors.red.v500.value,
                            SushiTheme.colors.orange.v500.value
                        )
                    )

                    SushiText(
                        props = SushiTextProps(
                            text = "32. Gradient text with vertical brush",
                            textBrush = verticalGradient,
                            type = SushiTextType.Bold700
                        )
                    )

                    Spacer(Modifier.height(16.dp))

                    // 33-34. Clickable text examples
                    SectionTitle("Interactive Text")
                    SushiText(
                        props = SushiTextProps(
                            text = "33. Clickable text (tap me)",
                            type = SushiTextType.Regular400,
                            color = SushiTheme.colors.blue.v500
                        ),
                        onClick = { /* Handle click */ }
                    )

                    SushiText(
                        props = SushiTextProps(
                            text = "34. Clickable text with icon",
                            type = SushiTextType.Regular400,
                            suffixIcon = SushiIconProps(code = SushiIconCodes.IconChevronRight),
                            color = SushiTheme.colors.blue.v500
                        ),
                        onClick = { /* Handle click */ }
                    )

                    Spacer(Modifier.height(16.dp))

                    // 35-36. Combined features
                    SectionTitle("Combined Features")
                    SushiText(
                        props = SushiTextProps(
                            text = "35. Combining multiple features: colored, bold, with icon",
                            type = SushiTextType.Bold600,
                            color = SushiTheme.colors.green.v700,
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconCheck)
                        )
                    )

                    SushiText(
                        props = SushiTextProps(
                            text = "36. Decorated text with spacing",
                            type = SushiTextType.Medium500,
                            letterSpacing = 1.sp,
                            textDecoration = SushiTextDecoration.Underline(),
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconPencilEdit)
                        )
                    )

                    Spacer(Modifier.height(16.dp))

                    // 37-40. More complex examples
                    SectionTitle("Advanced Examples")

                    // 37. Complex markdown with custom styling
                    SushiText(
                        props = SushiTextProps(
                            text = "<bold-700|{green-500|✓}> 37. Custom styled markdown with **formatting** and _emphasis_",
                            markdown = true,
                            type = SushiTextType.Regular400
                        )
                    )

                    // 38. Notification-style text
                    SushiText(
                        props = SushiTextProps(
                            text = "38. New message from John",
                            prefixIcon = SushiIconProps(
                                code = SushiIconCodes.IconCallRinging,
                                color = SushiTheme.colors.red.v500
                            ),
                            type = SushiTextType.Medium400,
                            suffixIcon = SushiIconProps(
                                code = SushiIconCodes.IconCallRinging,
                                color = SushiTheme.colors.red.v500
                            )
                        )
                    )

                    // 39. Read more with custom prefix
                    SushiText(
                        props = SushiTextProps(
                            text = "39. This is a long description that demonstrates the combination of a prefix icon with 'Read more' functionality. The text will be truncated and can be expanded.",
                            maxLines = 2,
                            overflowText = "Show all",
                            overflowTextColor = SushiTheme.colors.blue.v500,
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon),
                            type = SushiTextType.Regular400
                        )
                    )

                    // 40. Price tag style
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        SushiText(
                            props = SushiTextProps(
                                text = "₹199",
                                type = SushiTextType.Bold600,
                                color = SushiTheme.colors.text.primary
                            )
                        )

                        Spacer(modifier = Modifier.padding(horizontal = 4.dp))

                        SushiText(
                            props = SushiTextProps(
                                text = "₹299",
                                type = SushiTextType.Regular400,
                                color = SushiTheme.colors.text.secondary,
                                textDecoration = SushiTextDecoration.LineThrough()
                            )
                        )

                        Spacer(modifier = Modifier.padding(horizontal = 4.dp))

                        SushiText(
                            props = SushiTextProps(
                                text = "40. 33% off",
                                type = SushiTextType.Medium400,
                                color = SushiTheme.colors.green.v500
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SectionTitle(title: String) {
    SushiText(
        props = SushiTextProps(
            text = title,
            type = SushiTextType.SemiBold600,
            color = SushiTheme.colors.text.primary
        ),
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
@SushiPreview
private fun TextShowcaseScreenPreview() {
    AppTheme {
        TextShowcaseScreen()
    }
}
