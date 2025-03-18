package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.icon.SushiIconSize
import com.zomato.sushi.compose.atoms.icon.asIconSizeSpec
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.BaseScreen
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import kotlinx.serialization.Serializable

@Serializable
object IconShowcaseScreen

@Composable
fun IconShowcaseScreen(
    modifier: Modifier = Modifier
) {
    BaseScreen(modifier) {
        Scaffold(
            modifier = modifier.fillMaxSize(),
            containerColor = SushiTheme.colors.surface.primary.value
        ) { innerPadding ->
            Column(
                Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
            ) {
                AppTopBar(
                    title = "Icon Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        start = SushiTheme.dimens.spacing.base,
                        end = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )

                // Examples section
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(SushiTheme.dimens.spacing.base)
                ) {
                    // 1. Basic icon
                    SectionTitle("Basic Icons")
                    IconWithDescription(
                        props = SushiIconProps(code = SushiIconCodes.IconMoon),
                        description = "1. Default icon"
                    )

                    // 2. Icon with custom color
                    IconWithDescription(
                        props = SushiIconProps(
                            code = SushiIconCodes.IconMoon,
                            color = SushiColorData(ColorName.Red, ColorVariation.Variation500)
                        ),
                        description = "2. Icon with custom color"
                    )

                    // 3. Icon with theme color
                    IconWithDescription(
                        props = SushiIconProps(
                            code = SushiIconCodes.IconMoon,
                            color = SushiTheme.colors.blue.v700
                        ),
                        description = "3. Icon with theme color"
                    )

                    Spacer(Modifier.height(16.dp))

                    // 4-11. Icons with different sizes
                    SectionTitle("Icon Sizes")
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        // 4. Size50
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            SushiIcon(
                                SushiIconProps(
                                    code = SushiIconCodes.IconMStarfilled,
                                    size = SushiIconSize.Size50
                                )
                            )
                            SushiText(SushiTextProps(text="Size50", type = SushiTextType.Regular100))
                        }

                        // 5. Size200
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            SushiIcon(
                                SushiIconProps(
                                    code = SushiIconCodes.IconMStarfilled,
                                    size = SushiIconSize.Size200
                                )
                            )
                            SushiText(SushiTextProps(text="Size200", type = SushiTextType.Regular100))
                        }

                        // 6. Size500
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            SushiIcon(
                                SushiIconProps(
                                    code = SushiIconCodes.IconMStarfilled,
                                    size = SushiIconSize.Size500
                                )
                            )
                            SushiText(SushiTextProps(text="Size500", type = SushiTextType.Regular100))
                        }

                        // 7. Size900
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            SushiIcon(
                                SushiIconProps(
                                    code = SushiIconCodes.IconMStarfilled,
                                    size = SushiIconSize.Size900
                                )
                            )
                            SushiText(SushiTextProps(text="Size900", type = SushiTextType.Regular100))
                        }
                    }

                    // 8. Custom size using DP
                    IconWithDescription(
                        props = SushiIconProps(
                            code = SushiIconCodes.IconMStarfilled,
                            size = 48.dp.asIconSizeSpec()
                        ),
                        description = "8. Custom size using DP (48.dp)"
                    )

                    // 9. Custom size using SP
                    IconWithDescription(
                        props = SushiIconProps(
                            code = SushiIconCodes.IconMStarfilled,
                            size = 36.sp.asIconSizeSpec()
                        ),
                        description = "9. Custom size using SP (36.sp)"
                    )

                    // 10. Size300
                    IconWithDescription(
                        props = SushiIconProps(
                            code = SushiIconCodes.IconMStarfilled,
                            size = SushiIconSize.Size300
                        ),
                        description = "10. Size300 from SushiIconSize enum"
                    )

                    // 11. Size700
                    IconWithDescription(
                        props = SushiIconProps(
                            code = SushiIconCodes.IconMStarfilled,
                            size = SushiIconSize.Size700
                        ),
                        description = "11. Size700 from SushiIconSize enum"
                    )

                    Spacer(Modifier.height(16.dp))

                    // 12-17. Different icon types
                    SectionTitle("Icon Types")
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        // 12. Check icon
                        IconWithLabel(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconCheck,
                                size = SushiIconSize.Size400
                            ),
                            label = "12. Check"
                        )

                        // 13. Cross icon
                        IconWithLabel(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconCross,
                                size = SushiIconSize.Size400
                            ),
                            label = "13. Cross"
                        )

                        // 14. Heart icon
                        IconWithLabel(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconHeart,
                                size = SushiIconSize.Size400
                            ),
                            label = "14. Heart"
                        )

                        // 15. Search icon
                        IconWithLabel(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconSearch,
                                size = SushiIconSize.Size400
                            ),
                            label = "15. Search"
                        )
                    }

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        // 16. Location icon
                        IconWithLabel(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconLocation,
                                size = SushiIconSize.Size400
                            ),
                            label = "16. Location"
                        )

                        // 17. Call icon
                        IconWithLabel(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconCall,
                                size = SushiIconSize.Size400
                            ),
                            label = "17. Call"
                        )

                        // 18. Direction icon
                        IconWithLabel(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconDirection,
                                size = SushiIconSize.Size400
                            ),
                            label = "18. Direction"
                        )

                        // 19. Share icon
                        IconWithLabel(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconShare,
                                size = SushiIconSize.Size400
                            ),
                            label = "19. Share"
                        )
                    }

                    Spacer(Modifier.height(16.dp))

                    // 20-23. Icon colors
                    SectionTitle("Icon Colors")
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        // 20. Red color
                        IconWithLabel(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconHeart,
                                size = SushiIconSize.Size500,
                                color = SushiColorData(ColorName.Red, ColorVariation.Variation500)
                            ),
                            label = "20. Red"
                        )

                        // 21. Green color
                        IconWithLabel(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconCheckCircleFill,
                                size = SushiIconSize.Size500,
                                color = SushiColorData(ColorName.Green, ColorVariation.Variation500)
                            ),
                            label = "21. Green"
                        )

                        // 22. Blue color
                        IconWithLabel(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconInfo,
                                size = SushiIconSize.Size500,
                                color = SushiColorData(ColorName.Blue, ColorVariation.Variation500)
                            ),
                            label = "22. Blue"
                        )

                        // 23. Yellow color
                        IconWithLabel(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconMStarfilled,
                                size = SushiIconSize.Size500,
                                color = SushiColorData(ColorName.Yellow, ColorVariation.Variation500)
                            ),
                            label = "23. Yellow"
                        )
                    }

                    Spacer(Modifier.height(16.dp))

                    // 24-27. Icons in containers
                    SectionTitle("Icons in Containers")
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        // 24. Icon in circle
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(SushiTheme.colors.surface.secondary.value),
                            contentAlignment = Alignment.Center
                        ) {
                            SushiIcon(
                                props = SushiIconProps(
                                    code = SushiIconCodes.IconBell,
                                    size = SushiIconSize.Size300
                                ),
                                modifier = Modifier
                            )
                        }
                        SushiText(
                            SushiTextProps(text=
                                "24. Circle",
                                type = SushiTextType.Regular200,
                            ),
                            Modifier.padding(top = 4.dp)
                        )

                        // 25. Icon in rounded rectangle
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(SushiTheme.colors.surface.secondary.value),
                            contentAlignment = Alignment.Center
                        ) {
                            SushiIcon(
                                props = SushiIconProps(
                                    code = SushiIconCodes.IconEnvelope,
                                    size = SushiIconSize.Size300
                                )
                            )
                        }
                        SushiText(
                            SushiTextProps(
                                text= "25. Rounded",
                                type = SushiTextType.Regular100
                            ),
                            modifier = Modifier.padding(top = 4.dp)
                        )

                        // 26. Icon with border
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .border(
                                    width = 2.dp,
                                    color = SushiTheme.colors.blue.v500.value,
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            SushiIcon(
                                props = SushiIconProps(
                                    code = SushiIconCodes.IconHeadphone,
                                    size = SushiIconSize.Size300
                                )
                            )
                        }
                        SushiText(
                            SushiTextProps(
                                text= "26. Bordered",
                                type = SushiTextType.Regular100
                            ),
                            modifier = Modifier.padding(top = 4.dp)
                        )

                        // 27. Icon with colored background
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(SushiTheme.colors.green.v100.value),
                            contentAlignment = Alignment.Center
                        ) {
                            SushiIcon(
                                props = SushiIconProps(
                                    code = SushiIconCodes.IconVerifyCheck,
                                    size = SushiIconSize.Size300,
                                    color = SushiTheme.colors.green.v700
                                )
                            )
                        }
                        SushiText(
                            SushiTextProps(
                                text= "27. Colored"
                                , type = SushiTextType.Regular100
                            ),
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }

                    Spacer(Modifier.height(16.dp))

                    // 28-31. Interactive icons
                    SectionTitle("Interactive Icons")

                    // 28. Clickable icon
                    var clickCount by remember { mutableStateOf(0) }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        SushiIcon(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconThumbUpFill,
                                size = SushiIconSize.Size500,
                                color = if (clickCount > 0) SushiTheme.colors.blue.v500 else SushiTheme.colors.text.secondary
                            ),
                            onClick = { clickCount++ }
                        )
                        SushiText(
                            SushiTextProps(
                                text = "28. Clickable icon (clicks: $clickCount)",
                            ),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                    // 29. Toggle icon
                    var toggled by remember { mutableStateOf(false) }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        SushiIcon(
                            props = SushiIconProps(
                                code = if (toggled) SushiIconCodes.IconHeartEmpty else SushiIconCodes.IconHeart,
                                size = SushiIconSize.Size500,
                                color = if (toggled) SushiColorData(ColorName.Red, ColorVariation.Variation500) else SushiTheme.colors.text.primary
                            ),
                            onClick = { toggled = !toggled }
                        )
                        SushiText(
                            SushiTextProps(
                                text = "29. Toggle icon state (${if (toggled) "Filled" else "Outline"})"
                            ),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                    // 30. Icon with indicator
                    Box(contentAlignment = Alignment.TopEnd) {
                        SushiIcon(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconBell,
                                size = SushiIconSize.Size600
                            )
                        )
                        Box(
                            Modifier
                                .size(12.dp)
                                .clip(CircleShape)
                                .background(SushiColorData(ColorName.Red, ColorVariation.Variation500).value)
                        )
                    }
                    SushiText(
                        SushiTextProps(
                            text = "30. Icon with notification indicator"
                        ),
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    Spacer(Modifier.height(16.dp))

                    // 32-35. Commonly used icon sets
                    SectionTitle("Common Icon Sets")

                    // 32. Navigation icons
                    IconRow(
                        title = "32. Navigation Icons",
                        icons = listOf(
                            SushiIconProps(code = SushiIconCodes.IconBack, size = SushiIconSize.Size400) to "Back",
                            SushiIconProps(code = SushiIconCodes.IconChevronLeft, size = SushiIconSize.Size400) to "Left",
                            SushiIconProps(code = SushiIconCodes.IconChevronRight, size = SushiIconSize.Size400) to "Right",
                            SushiIconProps(code = SushiIconCodes.IconChevronDown, size = SushiIconSize.Size400) to "Down"
                        )
                    )

                    // 33. Social icons
                    IconRow(
                        title = "33. Social Icons",
                        icons = listOf(
                            SushiIconProps(code = SushiIconCodes.IconFacebookCircle, size = SushiIconSize.Size400) to "FB",
                            SushiIconProps(code = SushiIconCodes.IconTwitterCircle, size = SushiIconSize.Size400) to "Twitter",
                            SushiIconProps(code = SushiIconCodes.IconGoogleCircle, size = SushiIconSize.Size400) to "Google",
                            SushiIconProps(code = SushiIconCodes.IconInstagramCircle, size = SushiIconSize.Size400) to "Insta"
                        )
                    )

                    // 34. Action icons
                    IconRow(
                        title = "34. Action Icons",
                        icons = listOf(
                            SushiIconProps(code = SushiIconCodes.IconPlus, size = SushiIconSize.Size400) to "Add",
                            SushiIconProps(code = SushiIconCodes.IconCross, size = SushiIconSize.Size400) to "Delete",
                            SushiIconProps(code = SushiIconCodes.IconPencilEdit, size = SushiIconSize.Size400) to "Edit",
                            SushiIconProps(code = SushiIconCodes.IconRefresh, size = SushiIconSize.Size400) to "Refresh"
                        )
                    )

                    // 35. Status icons
                    IconRow(
                        title = "35. Status Icons",
                        icons = listOf(
                            SushiIconProps(
                                code = SushiIconCodes.IconCheckCircleFill,
                                size = SushiIconSize.Size400,
                                color = SushiTheme.colors.green.v500
                            ) to "Success",
                            SushiIconProps(
                                code = SushiIconCodes.IconExclamation,
                                size = SushiIconSize.Size400,
                                color = SushiTheme.colors.yellow.v500
                            ) to "Warning",
                            SushiIconProps(
                                code = SushiIconCodes.IconCrossCircleFill,
                                size = SushiIconSize.Size400,
                                color = SushiTheme.colors.red.v500
                            ) to "Error",
                            SushiIconProps(
                                code = SushiIconCodes.IconInfo,
                                size = SushiIconSize.Size400,
                                color = SushiTheme.colors.blue.v500
                            ) to "Info"
                        )
                    )

                    Spacer(Modifier.height(16.dp))

                    // 36-40. Special use cases
                    SectionTitle("Special Use Cases")

                    // 36. Icon pair (filled and outline)
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        SushiIcon(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconLocationFill,
                                size = SushiIconSize.Size500
                            )
                        )
                        Spacer(Modifier.padding(8.dp))
                        SushiIcon(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconLocation,
                                size = SushiIconSize.Size500
                            )
                        )
                        SushiText(
                            SushiTextProps(
                                text="36. Icon pair (filled and outline)"
                            ),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                    // 37. Icon sequence
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        SushiIcon(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconScooterSharp,
                                size = SushiIconSize.Size400,
                                color = SushiTheme.colors.green.v500
                            )
                        )
                        SushiIcon(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconChevronRight,
                                size = SushiIconSize.Size300
                            )
                        )
                        SushiIcon(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconLocationPin,
                                size = SushiIconSize.Size400,
                                color = SushiTheme.colors.red.v500
                            )
                        )
                        SushiText(
                            SushiTextProps(
                                text = "37. Icon sequence"
                            ),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                    // 38. Icon with label
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(SushiTheme.colors.surface.secondary.value)
                            .padding(8.dp)
                    ) {
                        SushiIcon(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconInfo,
                                size = SushiIconSize.Size500,
                                color = SushiTheme.colors.blue.v500
                            )
                        )
                        SushiText(
                            SushiTextProps(
                                text = "38. Icon with label in container"
                            ),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                    // 39. Icon grid
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        SushiText(SushiTextProps(text = "39. Icon grid"), modifier = Modifier.padding(bottom = 8.dp))
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Box(
                                Modifier
                                    .size(60.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(SushiTheme.colors.surface.secondary.value),
                                contentAlignment = Alignment.Center
                            ) {
                                SushiIcon(
                                    props = SushiIconProps(
                                        code = SushiIconCodes.IconDelivery,
                                        size = SushiIconSize.Size400
                                    )
                                )
                            }

                            Box(
                                Modifier
                                    .size(60.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(SushiTheme.colors.surface.secondary.value),
                                contentAlignment = Alignment.Center
                            ) {
                                SushiIcon(
                                    props = SushiIconProps(
                                        code = SushiIconCodes.IconBookTable,
                                        size = SushiIconSize.Size400
                                    )
                                )
                            }

                            Box(
                                Modifier
                                    .size(60.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(SushiTheme.colors.surface.secondary.value),
                                contentAlignment = Alignment.Center
                            ) {
                                SushiIcon(
                                    props = SushiIconProps(
                                        code = SushiIconCodes.IconShare,
                                        size = SushiIconSize.Size400
                                    )
                                )
                            }
                        }
                    }

                    // 40. Animated icon (representation)
                    var animatedState by remember { mutableStateOf(0) }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        SushiText(SushiTextProps(text="40. Animated icon (tap to simulate)"), modifier = Modifier.padding(bottom = 8.dp))
                        Box(
                            Modifier
                                .size(80.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(SushiTheme.colors.surface.secondary.value)
                                .clickable {
                                    animatedState = (animatedState + 1) % 3
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            when (animatedState) {
                                0 -> SushiIcon(
                                    props = SushiIconProps(
                                        code = SushiIconCodes.IconHeart,
                                        size = 40.dp.asIconSizeSpec(),
                                        color = SushiTheme.colors.text.primary
                                    )
                                )
                                1 -> SushiIcon(
                                    props = SushiIconProps(
                                        code = SushiIconCodes.IconHeart,
                                        size = 50.dp.asIconSizeSpec(),
                                        color = SushiTheme.colors.red.v300
                                    )
                                )
                                2 -> SushiIcon(
                                    props = SushiIconProps(
                                        code = SushiIconCodes.IconHeart,
                                        size = 60.dp.asIconSizeSpec(),
                                        color = SushiTheme.colors.red.v500
                                    )
                                )
                            }
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
            type = SushiTextType.SemiBold600,
            color = SushiTheme.colors.text.primary
        ),
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
private fun IconWithDescription(
    props: SushiIconProps,
    description: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SushiIcon(props = props)
        SushiText(
            SushiTextProps(
                text = description,
            ),
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
private fun IconWithLabel(
    props: SushiIconProps,
    label: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        SushiIcon(props = props)
        SushiText(
            SushiTextProps(
                text = label,
                type = SushiTextType.Regular200,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
private fun IconRow(
    title: String,
    icons: List<Pair<SushiIconProps, String>>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(vertical = 8.dp)) {
        SushiText(SushiTextProps(text=title), modifier = Modifier.padding(bottom = 8.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            icons.forEach { (props, label) ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    SushiIcon(props = props)
                    SushiText(
                        SushiTextProps(
                            text = label,
                            type = SushiTextType.Regular100
                        ),
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
@SushiPreview
private fun IconShowcaseScreenPreview() {
    AppTheme {
        IconShowcaseScreen()
    }
}