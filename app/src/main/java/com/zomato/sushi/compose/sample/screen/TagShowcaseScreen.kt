package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.icon.SushiIconSize
import com.zomato.sushi.compose.atoms.tag.SushiTag
import com.zomato.sushi.compose.atoms.tag.SushiTagProps
import com.zomato.sushi.compose.atoms.tag.SushiTagSize
import com.zomato.sushi.compose.atoms.tag.SushiTagType
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
object TagShowcaseScreen

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TagShowcaseScreen(
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
            ) {
                AppTopBar(
                    title = "Tag Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        start = SushiTheme.dimens.spacing.base,
                        end = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = SushiTheme.dimens.spacing.base)
                ) {
                    // 1. Basic Tag Types
                    SectionTitle("Basic Tag Types")

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // 1. Rounded Tag
                        SushiTag(
                            props = SushiTagProps(
                                text = "1. Rounded",
                                type = SushiTagType.Rounded,
                                size = SushiTagSize.Medium
                            )
                        )

                        // 2. Capsule Tag
                        SushiTag(
                            props = SushiTagProps(
                                text = "2. Capsule",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Medium
                            )
                        )

                        // 3. Rounded Outline
                        SushiTag(
                            props = SushiTagProps(
                                text = "3. RoundedOutline",
                                type = SushiTagType.RoundedOutline,
                                size = SushiTagSize.Medium
                            )
                        )

                        // 4. Capsule Outline
                        SushiTag(
                            props = SushiTagProps(
                                text = "4. CapsuleOutline",
                                type = SushiTagType.CapsuleOutline,
                                size = SushiTagSize.Medium
                            )
                        )

                        // 5. Rounded Dashed
                        SushiTag(
                            props = SushiTagProps(
                                text = "5. RoundedDashed",
                                type = SushiTagType.RoundedDashed,
                                size = SushiTagSize.Medium
                            )
                        )

                        // 6. Capsule Dashed
                        SushiTag(
                            props = SushiTagProps(
                                text = "6. CapsuleDashed",
                                type = SushiTagType.CapsuleDashed,
                                size = SushiTagSize.Medium
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Tag Sizes
                    SectionTitle("Tag Sizes")

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // 7. Nano Size
                        SushiTag(
                            props = SushiTagProps(
                                text = "7. Nano",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Nano
                            )
                        )

                        // 8. Tiny Size
                        SushiTag(
                            props = SushiTagProps(
                                text = "8. Tiny",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Tiny
                            )
                        )

                        // 9. Small Size
                        SushiTag(
                            props = SushiTagProps(
                                text = "9. Small",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Small
                            )
                        )

                        // 10. Medium Size
                        SushiTag(
                            props = SushiTagProps(
                                text = "10. Medium",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Medium
                            )
                        )

                        // 11. Large Size
                        SushiTag(
                            props = SushiTagProps(
                                text = "11. Large",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Large
                            )
                        )

                        // 12. Extra Large Size
                        SushiTag(
                            props = SushiTagProps(
                                text = "12. Extra Large",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.ExtraLarge
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Custom Colors
                    SectionTitle("Custom Colors")

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // 13. Custom Background Color
                        SushiTag(
                            props = SushiTagProps(
                                text = "13. Background Color",
                                type = SushiTagType.Rounded,
                                size = SushiTagSize.Medium,
                                color = SushiColorData(ColorName.Red, ColorVariation.Variation500)
                            )
                        )

                        // 14. Custom Text Color
                        SushiTag(
                            props = SushiTagProps(
                                text = "14. Text Color",
                                type = SushiTagType.Rounded,
                                size = SushiTagSize.Medium,
                                color = SushiColorData(ColorName.Blue, ColorVariation.Variation100),
                                fontColor = SushiColorData(ColorName.Blue, ColorVariation.Variation900)
                            )
                        )

                        // 15. Custom Border Color
                        SushiTag(
                            props = SushiTagProps(
                                text = "15. Border Color",
                                type = SushiTagType.RoundedOutline,
                                size = SushiTagSize.Medium,
                                borderColor = SushiColorData(ColorName.Green, ColorVariation.Variation600)
                            )
                        )

                        // 16. Dark Background, Light Text
                        SushiTag(
                            props = SushiTagProps(
                                text = "16. Dark & Light",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Medium,
                                color = SushiColorData(ColorName.Black, ColorVariation.Variation900),
                                fontColor = SushiColorData(ColorName.White, ColorVariation.Variation900)
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Tags with Icons
                    SectionTitle("Tags with Icons")

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // 17. Tag with Prefix Icon
                        SushiTag(
                            props = SushiTagProps(
                                text = "17. Prefix Icon",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Medium,
                                prefixIcon = SushiIconProps(code = SushiIconCodes.IconStarFill)
                            )
                        )

                        // 18. Tag with Suffix Icon
                        SushiTag(
                            props = SushiTagProps(
                                text = "18. Suffix Icon",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Medium,
                                suffixIcon = SushiIconProps(code = SushiIconCodes.IconChevronRight)
                            )
                        )

                        // 19. Tag with Both Icons
                        SushiTag(
                            props = SushiTagProps(
                                text = "19. Both Icons",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Medium,
                                prefixIcon = SushiIconProps(code = SushiIconCodes.IconStarFill),
                                suffixIcon = SushiIconProps(code = SushiIconCodes.IconChevronRight)
                            )
                        )

                        // 20. Custom Color Icon
                        SushiTag(
                            props = SushiTagProps(
                                text = "20. Colored Icon",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Medium,
                                prefixIcon = SushiIconProps(
                                    code = SushiIconCodes.IconStarFill,
                                    color = SushiColorData(ColorName.Yellow, ColorVariation.Variation500)
                                )
                            )
                        )

                        // 21. Custom Icon Size
                        SushiTag(
                            props = SushiTagProps(
                                text = "21. Large Icon",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Medium,
                                prefixIcon = SushiIconProps(
                                    code = SushiIconCodes.IconStarFill,
                                    size = SushiIconSize.Size500
                                )
                            )
                        )

                        // 22. Custom Icon Spacing
                        SushiTag(
                            props = SushiTagProps(
                                text = "22. Icon Spacing",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Medium,
                                prefixIcon = SushiIconProps(code = SushiIconCodes.IconStarFill),
                                iconSpacing = 12.dp
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Custom Shapes
                    SectionTitle("Custom Shapes")

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // 23. Circle Shape
                        SushiTag(
                            props = SushiTagProps(
                                text = "23",
                                type = SushiTagType.Rounded,
                                size = SushiTagSize.Medium,
                                shape = CircleShape
                            )
                        )

                        // 24. Custom Corner Radius
                        SushiTag(
                            props = SushiTagProps(
                                text = "24. Custom Radius",
                                type = SushiTagType.Rounded,
                                size = SushiTagSize.Medium,
                                shape = RoundedCornerShape(12.dp)
                            )
                        )

                        // 25. Cut Corner Shape
                        SushiTag(
                            props = SushiTagProps(
                                text = "25. Cut Corners",
                                type = SushiTagType.Rounded,
                                size = SushiTagSize.Medium,
                                shape = CutCornerShape(8.dp)
                            )
                        )

                        // 26. Asymmetric Shape
                        SushiTag(
                            props = SushiTagProps(
                                text = "26. Asymmetric",
                                type = SushiTagType.Rounded,
                                size = SushiTagSize.Medium,
                                shape = RoundedCornerShape(
                                    topStart = 16.dp,
                                    topEnd = 0.dp,
                                    bottomStart = 0.dp,
                                    bottomEnd = 16.dp
                                )
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Markdown Support
                    SectionTitle("Markdown Support")

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // 27. Bold Markdown
                        SushiTag(
                            props = SushiTagProps(
                                text = "27. **Bold** Text",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Medium,
                                markdown = true
                            )
                        )

                        // 28. Italic Markdown
                        SushiTag(
                            props = SushiTagProps(
                                text = "28. _Italic_ Text",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Medium,
                                markdown = true
                            )
                        )

                        // 29. Combined Markdown
                        SushiTag(
                            props = SushiTagProps(
                                text = "29. **Bold** & _Italic_",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Medium,
                                markdown = true
                            )
                        )

                        // 30. Disabled Markdown
                        SushiTag(
                            props = SushiTagProps(
                                text = "30. **Raw** _Text_",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Medium,
                                markdown = false
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Interactive Tags
                    SectionTitle("Interactive Tags")

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // 31. Clickable Tag (with State)
                        var clicked by remember { mutableStateOf(false) }
                        SushiTag(
                            props = SushiTagProps(
                                text = if (clicked) "31. Clicked!" else "31. Click Me",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Medium,
                                color = if (clicked)
                                    SushiColorData(ColorName.Green, ColorVariation.Variation500)
                                else SushiColorData(ColorName.Blue, ColorVariation.Variation500)
                            ),
                            onClick = { clicked = !clicked }
                        )

                        // 32. Toggle Tag
                        var selected by remember { mutableStateOf(false) }
                        SushiTag(
                            props = SushiTagProps(
                                text = "32. Toggle",
                                type = if (selected) SushiTagType.Capsule else SushiTagType.CapsuleOutline,
                                size = SushiTagSize.Medium,
                                color = if (selected) SushiTheme.colors.blue.v500 else SushiTheme.colors.surface.primary,
                                fontColor = if (selected) SushiTheme.colors.white else SushiTheme.colors.blue.v500,
                                borderColor = SushiTheme.colors.blue.v500
                            ),
                            onClick = { selected = !selected }
                        )

                        // 33. Animated Icon Tag (Simulated)
                        var rotated by remember { mutableStateOf(false) }
                        SushiTag(
                            props = SushiTagProps(
                                text = "33. Rotate Icon",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Medium,
                                suffixIcon = SushiIconProps(code = SushiIconCodes.IconRefresh)
                            ),
                            content = {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                                ) {
                                    SushiText(
                                        props = SushiTextProps(
                                            text = "33. Rotate",
                                            type = SushiTextType.Regular400
                                        )
                                    )
                                    Spacer(modifier = Modifier.padding(4.dp))
                                    Box(
                                        modifier = Modifier.rotate(if (rotated) 180f else 0f)
                                    ) {
                                        SushiIcon(
                                            props = SushiIconProps(
                                                code = SushiIconCodes.IconRefresh
                                            )
                                        )
                                    }
                                }
                            },
                            onClick = { rotated = !rotated }
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Common Use Cases
                    SectionTitle("Common Use Cases")

                    // 34. Status Tags
                    SectionSubtitle("34. Status Tags")
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Success Status
                        SushiTag(
                            props = SushiTagProps(
                                text = "Success",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Small,
                                color = SushiColorData(ColorName.Green, ColorVariation.Variation100),
                                fontColor = SushiColorData(ColorName.Green, ColorVariation.Variation800),
                                prefixIcon = SushiIconProps(
                                    code = SushiIconCodes.IconCheckCircle,
                                    color = SushiColorData(ColorName.Green, ColorVariation.Variation800)
                                )
                            )
                        )

                        // Warning Status
                        SushiTag(
                            props = SushiTagProps(
                                text = "Warning",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Small,
                                color = SushiColorData(ColorName.Yellow, ColorVariation.Variation100),
                                fontColor = SushiColorData(ColorName.Yellow, ColorVariation.Variation800),
                                prefixIcon = SushiIconProps(
                                    code = SushiIconCodes.IconExclamation,
                                    color = SushiColorData(ColorName.Yellow, ColorVariation.Variation800)
                                )
                            )
                        )

                        // Error Status
                        SushiTag(
                            props = SushiTagProps(
                                text = "Error",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Small,
                                color = SushiColorData(ColorName.Red, ColorVariation.Variation100),
                                fontColor = SushiColorData(ColorName.Red, ColorVariation.Variation800),
                                prefixIcon = SushiIconProps(
                                    code = SushiIconCodes.IconCrossCircleFill,
                                    color = SushiColorData(ColorName.Red, ColorVariation.Variation800)
                                )
                            )
                        )

                        // Info Status
                        SushiTag(
                            props = SushiTagProps(
                                text = "Info",
                                type = SushiTagType.Capsule,
                                size = SushiTagSize.Small,
                                color = SushiColorData(ColorName.Blue, ColorVariation.Variation100),
                                fontColor = SushiColorData(ColorName.Blue, ColorVariation.Variation800),
                                prefixIcon = SushiIconProps(
                                    code = SushiIconCodes.IconInfo,
                                    color = SushiColorData(ColorName.Blue, ColorVariation.Variation800)
                                )
                            )
                        )
                    }

                    // 35. Category Tags
                    SectionSubtitle("35. Category Tags")
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        val categories = listOf("Food", "Travel", "Technology", "Health", "Music")
                        val colors = listOf(
                            SushiColorData(ColorName.Red, ColorVariation.Variation500),
                            SushiColorData(ColorName.Blue, ColorVariation.Variation500),
                            SushiColorData(ColorName.Green, ColorVariation.Variation500),
                            SushiColorData(ColorName.Orange, ColorVariation.Variation500),
                            SushiColorData(ColorName.Purple, ColorVariation.Variation500)
                        )

                        categories.forEachIndexed { index, category ->
                            SushiTag(
                                props = SushiTagProps(
                                    text = category,
                                    type = SushiTagType.RoundedOutline,
                                    size = SushiTagSize.Small,
                                    borderColor = colors[index]
                                )
                            )
                        }
                    }

                    // 36. Badges
                    SectionSubtitle("36. User Badges")
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        // User Avatar (Simulated)
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(SushiTheme.colors.grey.v200.value)
                        )

                        Column(
                            modifier = Modifier.padding(start = 12.dp)
                        ) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "John Doe",
                                    type = SushiTextType.Medium500
                                )
                            )

                            FlowRow(
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                                modifier = Modifier.padding(top = 4.dp)
                            ) {
                                SushiTag(
                                    props = SushiTagProps(
                                        text = "Pro",
                                        type = SushiTagType.Capsule,
                                        size = SushiTagSize.Tiny,
                                        color = SushiColorData(ColorName.Gold, ColorVariation.Variation500),
                                        fontColor = SushiColorData(ColorName.Black, ColorVariation.Variation900)
                                    )
                                )

                                SushiTag(
                                    props = SushiTagProps(
                                        text = "Top Reviewer",
                                        type = SushiTagType.Capsule,
                                        size = SushiTagSize.Tiny,
                                        color = SushiColorData(ColorName.Purple, ColorVariation.Variation500),
                                        fontColor = SushiColorData(ColorName.White, ColorVariation.Variation900)
                                    )
                                )
                            }
                        }
                    }

                    // 37. Feature Tags
                    SectionSubtitle("37. Product Feature Tags")
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = SushiTheme.colors.surface.secondary.value
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                verticalAlignment = Alignment.Top,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                SushiText(
                                    props = SushiTextProps(
                                        text = "Premium Coffee",
                                        type = SushiTextType.SemiBold600
                                    ),
                                    modifier = Modifier.weight(1f)
                                )

                                SushiTag(
                                    props = SushiTagProps(
                                        text = "NEW",
                                        type = SushiTagType.CapsuleDashed,
                                        size = SushiTagSize.Tiny,
                                        color = SushiColorData(ColorName.Orange, ColorVariation.Variation100),
                                        fontColor = SushiColorData(ColorName.Orange, ColorVariation.Variation800),
                                        borderColor = SushiColorData(ColorName.Orange, ColorVariation.Variation500)
                                    )
                                )
                            }

                            SushiText(
                                props = SushiTextProps(
                                    text = "Ethically sourced specialty coffee with rich flavor notes",
                                    type = SushiTextType.Regular400
                                ),
                                modifier = Modifier.padding(vertical = 8.dp)
                            )

                            FlowRow(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                SushiTag(
                                    props = SushiTagProps(
                                        text = "Specialty",
                                        type = SushiTagType.RoundedOutline,
                                        size = SushiTagSize.Nano
                                    )
                                )

                                SushiTag(
                                    props = SushiTagProps(
                                        text = "Organic",
                                        type = SushiTagType.RoundedOutline,
                                        size = SushiTagSize.Nano
                                    )
                                )

                                SushiTag(
                                    props = SushiTagProps(
                                        text = "Fair Trade",
                                        type = SushiTagType.RoundedOutline,
                                        size = SushiTagSize.Nano
                                    )
                                )
                            }
                        }
                    }

                    // 38. Discount Tags
                    SectionSubtitle("38. Discount Tags")
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = SushiTheme.colors.surface.secondary.value
                        )
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                SushiText(
                                    props = SushiTextProps(
                                        text = "Restaurant Name",
                                        type = SushiTextType.Medium500
                                    )
                                )

                                SushiText(
                                    props = SushiTextProps(
                                        text = "Italian, Pizza • 2.3 km",
                                        type = SushiTextType.Regular300,
                                        color = SushiTheme.colors.text.secondary
                                    )
                                )

                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    modifier = Modifier.padding(top = 8.dp)
                                ) {
                                    SushiTag(
                                        props = SushiTagProps(
                                            text = "50% OFF",
                                            type = SushiTagType.Capsule,
                                            size = SushiTagSize.Tiny,
                                            color = SushiColorData(ColorName.Red, ColorVariation.Variation600),
                                            fontColor = SushiColorData(ColorName.White, ColorVariation.Variation900)
                                        )
                                    )

                                    SushiTag(
                                        props = SushiTagProps(
                                            text = "FREE DELIVERY",
                                            type = SushiTagType.RoundedOutline,
                                            size = SushiTagSize.Tiny,
                                            borderColor = SushiColorData(ColorName.Green, ColorVariation.Variation600),
                                            fontColor = SushiColorData(ColorName.Green, ColorVariation.Variation600)
                                        )
                                    )
                                }
                            }

                            // Restaurant image placeholder
                            Box(
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(SushiTheme.colors.grey.v200.value)
                            )
                        }
                    }

                    // 39. Filter Tags
                    SectionSubtitle("39. Filter Tags")
                    Column(modifier = Modifier.padding(vertical = 8.dp)) {
                        SushiText(
                            props = SushiTextProps(
                                text = "Filters",
                                type = SushiTextType.Medium500
                            ),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            var selectedFilters = remember {
                                mutableStateOf(setOf("Vegetarian", "Offers"))
                            }

                            val filters = listOf("Vegetarian", "Non-Veg", "Offers", "Rated 4+", "Pure Veg", "Nearest")

                            filters.forEach { filter ->
                                val isSelected = selectedFilters.value.contains(filter)
                                SushiTag(
                                    props = SushiTagProps(
                                        text = filter,
                                        type = if (isSelected) SushiTagType.Capsule else SushiTagType.CapsuleOutline,
                                        size = SushiTagSize.Small,
                                        color = if (isSelected) SushiTheme.colors.base.theme.v500 else SushiTheme.colors.surface.primary,
                                        fontColor = if (isSelected) SushiTheme.colors.white else SushiTheme.colors.base.theme.v500,
                                        borderColor = SushiTheme.colors.base.theme.v500,
                                        prefixIcon = if (isSelected) SushiIconProps(
                                            code = SushiIconCodes.IconCheck,
                                            color = if (isSelected) SushiTheme.colors.white else SushiTheme.colors.base.theme.v500
                                        ) else null
                                    ),
                                    onClick = {
                                        selectedFilters.value = if (isSelected) {
                                            selectedFilters.value - filter
                                        } else {
                                            selectedFilters.value + filter
                                        }
                                    }
                                )
                            }
                        }
                    }

                    // 40. Tags with Custom Content
                    SectionSubtitle("40. Custom Content Tags")
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)
                    ) {
                        // Rating Tag
                        SushiTag(
                            props = SushiTagProps(
                                type = SushiTagType.Capsule,
                                color = SushiColorData(ColorName.Green, ColorVariation.Variation600)
                            ),
                            content = {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                                ) {
                                    SushiIcon(
                                        props = SushiIconProps(
                                            code = SushiIconCodes.IconStarFill,
                                            color = SushiTheme.colors.white
                                        )
                                    )
                                    SushiText(
                                        props = SushiTextProps(
                                            text = "4.9",
                                            type = SushiTextType.SemiBold600,
                                            color = SushiTheme.colors.white
                                        ),
                                        modifier = Modifier.padding(start = 4.dp)
                                    )
                                }
                            }
                        )

                        // Time Tag
                        SushiTag(
                            props = SushiTagProps(
                                type = SushiTagType.RoundedOutline,
                                borderColor = SushiTheme.colors.grey.v600
                            ),
                            content = {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                                ) {
                                    SushiIcon(
                                        props = SushiIconProps(
                                            code = SushiIconCodes.IconClock,
                                            color = SushiTheme.colors.grey.v600
                                        )
                                    )
                                    SushiText(
                                        props = SushiTextProps(
                                            text = "25-30 min",
                                            type = SushiTextType.Regular400,
                                            color = SushiTheme.colors.grey.v600
                                        ),
                                        modifier = Modifier.padding(start = 4.dp)
                                    )
                                }
                            }
                        )

                        // Price Range Tag
                        SushiTag(
                            props = SushiTagProps(
                                type = SushiTagType.RoundedDashed,
                                borderColor = SushiTheme.colors.blue.v600
                            ),
                            content = {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                                ) {
                                    SushiText(
                                        props = SushiTextProps(
                                            text = "$$$",
                                            type = SushiTextType.Medium500,
                                            color = SushiTheme.colors.blue.v600
                                        )
                                    )
                                }
                            }
                        )

                        // Status Tag with Progress Indicator (Simulated)
                        SushiTag(
                            props = SushiTagProps(
                                type = SushiTagType.Capsule,
                                color = SushiTheme.colors.purple.v100,
                                fontColor = SushiTheme.colors.purple.v800
                            ),
                            content = {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                                ) {
                                    // Simulated progress indicator
                                    Box(
                                        modifier = Modifier
                                            .size(8.dp)
                                            .clip(CircleShape)
                                            .background(SushiTheme.colors.purple.v800.value)
                                    )
                                    SushiText(
                                        props = SushiTextProps(
                                            text = "In Progress",
                                            type = SushiTextType.Regular400,
                                            color = SushiTheme.colors.purple.v800
                                        ),
                                        modifier = Modifier.padding(start = 8.dp)
                                    )
                                }
                            }
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
private fun SectionSubtitle(title: String) {
    SushiText(
        props = SushiTextProps(
            text = title,
            type = SushiTextType.Medium500,
            color = SushiTheme.colors.text.primary
        ),
        modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
    )
}

@Composable
@SushiPreview
private fun TagShowcaseScreenPreview() {
    AppTheme {
        TagShowcaseScreen()
    }
}