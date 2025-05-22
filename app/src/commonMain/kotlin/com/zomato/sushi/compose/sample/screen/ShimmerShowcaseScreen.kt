package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.icon.SushiIconSize
import com.zomato.sushi.compose.atoms.shimmer.SushiShimmer
import com.zomato.sushi.compose.atoms.shimmer.SushiShimmerProps
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.modifiers.shimmer.SushiShimmerProgress
import com.zomato.sushi.compose.modifiers.shimmer.SushiShimmerType
import com.zomato.sushi.compose.modifiers.shimmer.shimmer
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import kotlinx.serialization.Serializable

@Serializable
object ShimmerShowcaseScreen

@Composable
fun ShimmerShowcaseScreen(
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
                    .padding(horizontal = 16.dp)
            ) {
                AppTopBar(
                    title = "Shimmer Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )
                
                // === PART 1: SushiShimmer Examples ===
                SectionTitle("SushiShimmer Examples")
                
                // Example 1: Basic Shimmer with Default Properties
                ExampleTitle("1. Basic Shimmer")
                SushiShimmer(
                    props = SushiShimmerProps(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // Header with circle and text
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            ShimmerItem(
                                Modifier
                                    .size(50.dp)
                                    .clip(CircleShape)
                            )
                            Column {
                                ShimmerItem(
                                    Modifier
                                        .height(16.dp)
                                        .width(150.dp)
                                        .clip(RoundedCornerShape(4.dp))
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                ShimmerItem(
                                    Modifier
                                        .height(12.dp)
                                        .width(100.dp)
                                        .clip(RoundedCornerShape(4.dp))
                                )
                            }
                        }
                        
                        // Content
                        ShimmerItem(
                            Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                                .clip(RoundedCornerShape(8.dp))
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(32.dp))
                
                // Example 2: Custom Colors
                ExampleTitle("2. Custom Colors")
                SushiShimmer(
                    props = SushiShimmerProps(
                        bgColor = SushiTheme.colors.blue.v100,
                        animationColor = SushiTheme.colors.blue.v300
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        repeat(3) {
                            ShimmerItem(
                                Modifier
                                    .fillMaxWidth()
                                    .height(24.dp)
                                    .clip(RoundedCornerShape(4.dp))
                            )
                        }
                        
                        ShimmerItem(
                            Modifier
                                .fillMaxWidth(0.7f)
                                .height(24.dp)
                                .clip(RoundedCornerShape(4.dp))
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(32.dp))
                
                // Example 3: Custom Animation Parameters
                ExampleTitle("3. Faster Animation")
                SushiShimmer(
                    props = SushiShimmerProps(
                        animationDuration = 800,      // Faster animation (800ms)
                        animationDelay = 0,           // No delay between animations
                        animationWidth = 100f         // Wider animation band
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        repeat(4) {
                            ShimmerItem(
                                Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(32.dp))
                
                // Example 4: Shimmer Text
                ExampleTitle("4. Shimmer Text")
                SushiShimmer(
                    props = SushiShimmerProps(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        ShimmerText(
                            sushiTextProps = SushiTextProps(
                                text = "This is a shimmer text headline",
                                type = SushiTextType.Bold700
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                        
                        ShimmerText(
                            sushiTextProps = SushiTextProps(
                                text = "This is a longer paragraph text that demonstrates how the shimmer effect works on multiple lines of text content in your application.",
                                type = SushiTextType.Regular400
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(32.dp))
                
                // Example 5: Custom Angle and Combined Elements
                ExampleTitle("5. Custom Angle & Combined Elements")
                SushiShimmer(
                    props = SushiShimmerProps(
                        angleOffset = 100f,  // Steeper angle for the shimmer effect
                        bgColor = SushiTheme.colors.grey.v200,
                        animationColor = SushiTheme.colors.white
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // Card-like shimmer with image and description
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            // Image placeholder
                            ShimmerItem(
                                Modifier
                                    .size(80.dp)
                                    .clip(RoundedCornerShape(8.dp))
                            )
                            
                            // Content
                            Column(
                                Modifier.weight(1f),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                ShimmerItem(
                                    Modifier
                                        .fillMaxWidth(0.8f)
                                        .height(20.dp)
                                        .clip(RoundedCornerShape(4.dp))
                                )
                                
                                ShimmerItem(
                                    Modifier
                                        .fillMaxWidth()
                                        .height(16.dp)
                                        .clip(RoundedCornerShape(4.dp))
                                )
                                
                                ShimmerItem(
                                    Modifier
                                        .fillMaxWidth(0.6f)
                                        .height(16.dp)
                                        .clip(RoundedCornerShape(4.dp))
                                )
                                
                                Row(
                                    Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    ShimmerItem(
                                        Modifier
                                            .width(70.dp)
                                            .height(24.dp)
                                            .clip(RoundedCornerShape(12.dp))
                                    )
                                    
                                    ShimmerItem(
                                        Modifier
                                            .width(70.dp)
                                            .height(24.dp)
                                            .clip(RoundedCornerShape(12.dp))
                                    )
                                }
                            }
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(40.dp))
                
                // === PART 2: Modifier.shimmer() Examples ===
                SectionTitle("Modifier.shimmer() Examples")

                // Example 1: Basic Shimmer Modifier (Overlay)
                ExampleTitle("1. Basic Shimmer Modifier (Overlay)")
                var shimmerEnabled1 by remember { mutableStateOf(true) }

                Column {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .shimmer(
                                    enabled = shimmerEnabled1,
                                    type = SushiShimmerType.Overlay(
                                        color = Color.White.copy(alpha = 0.7f),
                                        shape = RectangleShape
                                    )
                                ),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            SushiIcon(
                                props = SushiIconProps(
                                    code = SushiIconCodes.IconLocation,
                                    size = SushiIconSize.Size500,
                                    color = SushiTheme.colors.base.theme.v500
                                )
                            )

                            Column {
                                SushiText(
                                    props = SushiTextProps(
                                        text = "Zomato Headquarters",
                                        type = SushiTextType.SemiBold600
                                    )
                                )

                                SushiText(
                                    props = SushiTextProps(
                                        text = "New Delhi, India",
                                        type = SushiTextType.Regular400,
                                        color = SushiTheme.colors.text.secondary
                                    )
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Example 2: Filled Shimmer with Custom Shape
                ExampleTitle("2. Filled Shimmer with Custom Shape")
                var shimmerEnabled2 by remember { mutableStateOf(true) }

                Column {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .height(60.dp)
                    ) {
                        SushiButton(
                            props = SushiButtonProps(
                                text = "Submit Order",
                                prefixIcon = SushiIconProps(code = SushiIconCodes.IconMerchantShop)
                            ),
                            onClick = { },
                            modifier = Modifier
                                .fillMaxWidth()
                                .shimmer(
                                    enabled = shimmerEnabled2,
                                    type = SushiShimmerType.Filled(
                                        shape = RoundedCornerShape(8.dp),
                                        shapeColor = SushiTheme.colors.grey.v200.value,
                                        color = Color.White
                                    )
                                )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Example 3: Shimmer on Image
                ExampleTitle("3. Shimmer on Image (Content Loading)")
                var shimmerEnabled3 by remember { mutableStateOf(true) }

                Column {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(16.dp)
                            .background(
                                SushiTheme.colors.blue.v100.value,
                                RoundedCornerShape(16.dp)
                            )
                            .shimmer(
                                enabled = shimmerEnabled3,
                                type = SushiShimmerType.Overlay(
                                    color = Color.White.copy(alpha = 0.7f),
                                    shape = RoundedCornerShape(16.dp)
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        SushiIcon(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconImageBox,
                                size = SushiIconSize.Size800,
                                color = SushiTheme.colors.blue.v300
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Example 4: Shimmer with Text and Profile
                ExampleTitle("4. Shimmer with User Profile")
                var shimmerEnabled4 by remember { mutableStateOf(true) }

                Column {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .shimmer(
                                enabled = shimmerEnabled4,
                                type = SushiShimmerType.Overlay(
                                    color = Color.White.copy(alpha = 0.7f),
                                    shape = RoundedCornerShape(8.dp)
                                ),
                                disableInteractions = true // Blocks interactions when shimmer is enabled
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // Profile picture
                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .background(
                                    SushiTheme.colors.base.theme.v200.value,
                                    CircleShape
                                )
                                .border(2.dp, SushiTheme.colors.base.theme.v500.value, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("JD", color = SushiTheme.colors.base.theme.v700.value)
                        }

                        // User info
                        Column {
                            SushiText(
                                props = SushiTextProps(
                                    text = "John Doe",
                                    type = SushiTextType.SemiBold600
                                )
                            )

                            SushiText(
                                props = SushiTextProps(
                                    text = "Premium Member",
                                    type = SushiTextType.Regular400,
                                    color = SushiTheme.colors.green.v700
                                )
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Example 5: Custom Progress Shimmer
                ExampleTitle("5. Custom Progress Shimmer")
                var shimmerEnabled5 by remember { mutableStateOf(true) }
                var progress by remember { mutableStateOf(0.3f) }

                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Progress: ${(progress * 100).toInt()}%")

                        // Adjustable progress
                        Row {
                            SushiButton(
                                props = SushiButtonProps(text = "-"),
                                onClick = { progress = (progress - 0.1f).coerceIn(0f, 1f) },
                                modifier = Modifier.size(40.dp)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            SushiButton(
                                props = SushiButtonProps(text = "+"),
                                onClick = { progress = (progress + 0.1f).coerceIn(0f, 1f) },
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                            .padding(horizontal = 16.dp)
                            .background(SushiTheme.colors.grey.v200.value, RoundedCornerShape(10.dp))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(progress)
                                .fillMaxHeight()
                                .background(
                                    SushiColorData(ColorName.Green, ColorVariation.Variation500).value,
                                    RoundedCornerShape(10.dp)
                                )
                                .shimmer(
                                    enabled = shimmerEnabled5,
                                    type = SushiShimmerType.Overlay(
                                        color = Color.White.copy(alpha = 0.5f),
                                        shape = RoundedCornerShape(10.dp)
                                    ),
                                    progress = SushiShimmerProgress.Progress { progress }
                                )
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Composable
private fun SectionTitle(title: String) {
    SushiText(
        props = SushiTextProps(
            text = title,
            type = SushiTextType.Bold700,
            color = SushiTheme.colors.text.primary
        ),
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

@Composable
private fun ExampleTitle(title: String) {
    SushiText(
        props = SushiTextProps(
            text = title,
            type = SushiTextType.SemiBold600,
            color = SushiTheme.colors.text.primary
        ),
        modifier = Modifier.padding(bottom = 12.dp)
    )
}

@Composable
@SushiPreview
private fun ShimmerShowcaseScreenPreview() {
    AppTheme {
        ShimmerShowcaseScreen()
    }
}