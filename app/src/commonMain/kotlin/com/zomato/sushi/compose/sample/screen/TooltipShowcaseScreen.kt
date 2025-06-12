package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.image.SushiImageProps
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.components.tooltip.SushiTooltip
import com.zomato.sushi.compose.components.tooltip.SushiTooltipBox
import com.zomato.sushi.compose.components.tooltip.SushiTooltipProps
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import composesushi.sushi_compose.generated.resources.Res
import composesushi.sushi_compose.generated.resources.sushi_rating_star
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.painterResource

@Serializable
object TooltipShowcaseScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TooltipShowcaseScreen(
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
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 32.dp)
            ) {
                AppTopBar(
                    title = "Tooltip Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        start = SushiTheme.dimens.spacing.base,
                        end = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )

                // 1. Basic Tooltip
                SectionTitle("1. Basic Text Tooltip")
                SectionDescription("A simple tooltip with text only")

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val tooltipState = rememberTooltipState()
                    val scope = rememberCoroutineScope()

                    SushiTooltipBox(
                        positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
                        tooltip = {
                            SushiTooltip(
                                props = SushiTooltipProps(
                                    text = SushiTextProps(
                                        text = "This is a basic tooltip with text only",
                                        color = SushiTheme.colors.text.inverse
                                    )
                                )
                            )
                        },
                        state = tooltipState
                    ) {
                        SushiButton(
                            props = SushiButtonProps(text = "Hover or Click Me"),
                            onClick = {
                                scope.launch {
                                    tooltipState.show()
                                }
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Tooltip with Prefix and Suffix Icons
                SectionTitle("2. Tooltip with Prefix and Suffix Icons")
                SectionDescription("Tooltip with icons before and after text")

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val tooltipState = rememberTooltipState()
                    val scope = rememberCoroutineScope()

                    SushiTooltipBox(
                        positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
                        tooltip = {
                            SushiTooltip(
                                props = SushiTooltipProps(
                                    text = SushiTextProps(
                                        text = "Important information",
                                        color = SushiTheme.colors.text.inverse,
                                        type = SushiTextType.Medium500
                                    ),
                                    prefixImage = SushiImageProps(
                                        painterResource(Res.drawable.sushi_rating_star),
                                        width = 20.dp,
                                        contentDescription = "Info",
                                        contentScale = ContentScale.Fit,
                                        colorFilter = ColorFilter.tint(
                                            SushiTheme.colors.yellow.v500.value,
                                            BlendMode.SrcIn
                                        )
                                    ),
                                    suffixImage = SushiImageProps(
                                        painterResource(Res.drawable.sushi_rating_star),
                                        width = 20.dp,
                                        contentDescription = "Info",
                                        contentScale = ContentScale.Fit,
                                        colorFilter = ColorFilter.tint(
                                            SushiTheme.colors.yellow.v500.value,
                                            BlendMode.SrcIn
                                        )
                                    )
                                )
                            )
                        },
                        state = tooltipState
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(SushiTheme.colors.surface.secondary.value)
                                .border(1.dp, SushiTheme.colors.border.moderate.value, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            SushiIcon(
                                props = SushiIconProps(
                                    code = SushiIconCodes.IconInfo,
                                    color = SushiTheme.colors.base.theme.v500
                                ),
                                onClick = {
                                    scope.launch {
                                        tooltipState.show()
                                    }
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 3. Custom Colored Tooltip
                SectionTitle("3. Custom Colored Tooltip")
                SectionDescription("Tooltip with custom background color")

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val tooltipState = rememberTooltipState()
                    val scope = rememberCoroutineScope()

                    SushiTooltipBox(
                        positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
                        tooltip = {
                            SushiTooltip(
                                props = SushiTooltipProps(
                                    text = SushiTextProps(
                                        text = "Warning: This action cannot be undone",
//                                        color = Color.White
                                    ),
                                    containerColor = SushiColorData(ColorName.Red, ColorVariation.Variation600),
                                    prefixImage = SushiImageProps(
                                        painterResource(Res.drawable.sushi_rating_star),
                                        width = 20.dp,
                                        contentDescription = "Warning",
                                        contentScale = ContentScale.Fit,
                                        colorFilter = ColorFilter.tint(
                                            Color.White,
                                            BlendMode.SrcIn
                                        )
                                    )
                                )
                            )
                        },
                        state = tooltipState
                    ) {
                        SushiButton(
                            props = SushiButtonProps(
                                text = "Delete Item",
                                color = SushiTheme.colors.red.v500
                            ),
                            onClick = {
                                scope.launch {
                                    tooltipState.show()
                                }
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 4. Custom Shape Tooltip
                SectionTitle("4. Custom Shape Tooltip")
                SectionDescription("Tooltip with custom shape and no caret")

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val tooltipState = rememberTooltipState()
                    val scope = rememberCoroutineScope()

                    SushiTooltipBox(
                        positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
                        tooltip = {
                            SushiTooltip(
                                props = SushiTooltipProps(
                                    text = SushiTextProps(
                                        text = "This tooltip has a custom shape with no caret",
                                        color = SushiTheme.colors.text.inverse
                                    ),
                                    caretSize = DpSize.Unspecified,  // No caret
                                    shape = RoundedCornerShape(16.dp)  // More rounded corners
                                )
                            )
                        },
                        state = tooltipState
                    ) {
                        SushiButton(
                            props = SushiButtonProps(
                                text = "Custom Shape"
                            ),
                            onClick = {
                                scope.launch {
                                    tooltipState.show()
                                }
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 5. Tooltip with Custom Shadow
                SectionTitle("5. Tooltip with Custom Shadow")
                SectionDescription("Tooltip with pronounced shadow elevation")

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val tooltipState = rememberTooltipState()
                    val scope = rememberCoroutineScope()

                    SushiTooltipBox(
                        positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
                        tooltip = {
                            SushiTooltip(
                                props = SushiTooltipProps(
                                    text = SushiTextProps(
                                        text = "This tooltip has a larger shadow for emphasis",
                                        color = SushiTheme.colors.text.inverse
                                    ),
                                    shadowElevation = 12.dp  // Higher elevation for more pronounced shadow
                                )
                            )
                        },
                        state = tooltipState
                    ) {
                        SushiButton(
                            props = SushiButtonProps(
                                text = "Elevated Tooltip"
                            ),
                            onClick = {
                                scope.launch {
                                    tooltipState.show()
                                }
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 6. Custom Content Tooltip
                SectionTitle("6. Custom Content Tooltip")
                SectionDescription("Tooltip with completely custom content instead of using props")

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val tooltipState = rememberTooltipState()
                    val scope = rememberCoroutineScope()

                    SushiTooltipBox(
                        positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
                        tooltip = {
                            SushiTooltip(
                                props = SushiTooltipProps(
                                    containerColor = SushiTheme.colors.blue.v700
                                ),
                                content = {
                                    Column(
                                        modifier = Modifier.padding(16.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        SushiText(
                                            props = SushiTextProps(
                                                text = "Custom Tooltip",
                                                type = SushiTextType.Bold600,
//                                                color = Color.White,
                                                textAlign = TextAlign.Center
                                            )
                                        )

                                        Spacer(modifier = Modifier.height(8.dp))

                                        Box(
                                            modifier = Modifier
                                                .size(40.dp)
                                                .clip(CircleShape)
                                                .background(Color.White.copy(alpha = 0.2f)),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            SushiIcon(
                                                props = SushiIconProps(
                                                    code = SushiIconCodes.IconInfo,
//                                                    color = SushiColorData(color = Color.White)
                                                )
                                            )
                                        }

                                        Spacer(modifier = Modifier.height(8.dp))

                                        SushiText(
                                            props = SushiTextProps(
                                                text = "This is a tooltip with completely custom content",
                                                type = SushiTextType.Regular400,
//                                                color = Color.White,
                                                textAlign = TextAlign.Center
                                            )
                                        )

                                        Spacer(modifier = Modifier.height(8.dp))

                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            SushiButton(
                                                props = SushiButtonProps(text = "Learn More"),
                                                onClick = {
                                                    // Handle learn more action
                                                    scope.launch {
                                                        tooltipState.dismiss()
                                                    }
                                                },
                                                modifier = Modifier.weight(1f)
                                            )

                                            SushiButton(
                                                props = SushiButtonProps(text = "Dismiss"),
                                                onClick = {
                                                    scope.launch {
                                                        tooltipState.dismiss()
                                                    }
                                                },
                                                modifier = Modifier.weight(1f)
                                            )
                                        }
                                    }
                                }
                            )
                        },
                        state = tooltipState
                    ) {
                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape)
                                .background(SushiTheme.colors.blue.v500.value),
                            contentAlignment = Alignment.Center
                        ) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "PRO",
                                    type = SushiTextType.Bold700,
//                                    color = Color.White
                                ),
                                onClick = {
                                    scope.launch {
                                        tooltipState.show()
                                    }
                                }
                            )
                        }
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
            type = SushiTextType.Bold600,
            color = SushiTheme.colors.text.primary
        ),
        modifier = Modifier.padding(
            horizontal = 16.dp,
            vertical = 4.dp
        )
    )
}

@Composable
private fun SectionDescription(description: String) {
    SushiText(
        props = SushiTextProps(
            text = description,
            type = SushiTextType.Regular400,
            color = SushiTheme.colors.text.secondary
        ),
        modifier = Modifier.padding(
            horizontal = 16.dp,
            vertical = 4.dp
        )
    )
}

@Composable
@SushiPreview
private fun TooltipShowcaseScreenPreview() {
    AppTheme {
        TooltipShowcaseScreen()
    }
}