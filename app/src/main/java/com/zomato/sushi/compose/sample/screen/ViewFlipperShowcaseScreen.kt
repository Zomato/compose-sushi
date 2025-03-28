package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.components.viewflipper.SushiViewFlipper
import com.zomato.sushi.compose.components.viewflipper.SushiViewFlipperProps
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.BaseScreen
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import kotlinx.serialization.Serializable

@Serializable
object ViewFlipperShowcaseScreen

@Composable
fun ViewFlipperShowcaseScreen(
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
                    .padding(bottom = 24.dp)
            ) {
                AppTopBar(
                    title = "ViewFlipper Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        start = SushiTheme.dimens.spacing.base,
                        end = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )

                // 1. Basic ViewFlipper with Default Settings
                SectionTitle("1. Basic ViewFlipper")
                SectionDescription("A simple view flipper with default animation and timing")

                val searchSuggestions = persistentListOf(
                    "Search for \"Pizza\"",
                    "Search for \"Burger\"",
                    "Search for \"Momos\"",
                    "Search for \"Ice Cream\"",
                    "Search for \"Chicken\""
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .border(1.dp, SushiTheme.colors.border.moderate.value, RoundedCornerShape(8.dp))
                            .background(SushiTheme.colors.surface.secondary.value),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SushiIcon(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconSearch,
                                color = SushiTheme.colors.text.secondary
                            ),
                            modifier = Modifier.padding(start = 12.dp)
                        )

                        SushiViewFlipper(
                            props = SushiViewFlipperProps(
                                count = searchSuggestions.size
                            ),
                            modifier = Modifier.weight(1f)
                        ) { index ->
                            SushiText(
                                props = SushiTextProps(
                                    text = searchSuggestions[index],
                                    color = SushiTheme.colors.text.secondary,
                                    type = SushiTextType.Regular400
                                ),
                                modifier = Modifier.padding(vertical = 16.dp, horizontal = 12.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Custom Flip Interval
                SectionTitle("2. Custom Flip Interval")
                SectionDescription("ViewFlipper with a faster transition time (1 second)")

                val promotions = persistentListOf(
                    "50% OFF on first order!",
                    "Free delivery this weekend",
                    "Use code WELCOME20 for 20% off",
                    "Order now and get extra rewards"
                )

                var currentPromotionIndex by remember { mutableIntStateOf(0) }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = SushiTheme.colors.green.v050.value
                    ),
                    shape = RoundedCornerShape(8.dp),
                    border = androidx.compose.foundation.BorderStroke(
                        1.dp,
                        SushiTheme.colors.green.v200.value
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SushiIcon(
                            props = SushiIconProps(
                                code = SushiIconCodes.IconPercent,
                                color = SushiTheme.colors.green.v700
                            )
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        SushiViewFlipper(
                            props = SushiViewFlipperProps(
                                count = promotions.size,
                                flipInterval = 1000L  // 1 second flip interval (faster)
                            ),
                            modifier = Modifier.weight(1f),
                            onFlip = { index ->
                                currentPromotionIndex = index
                            }
                        ) { index ->
                            SushiText(
                                props = SushiTextProps(
                                    text = promotions[index],
                                    color = SushiTheme.colors.green.v700,
                                    type = SushiTextType.SemiBold600
                                )
                            )
                        }
                    }
                }

                SushiText(
                    props = SushiTextProps(
                        text = "Current promotion: ${currentPromotionIndex + 1}/${promotions.size}",
                        type = SushiTextType.Regular400,
                        color = SushiTheme.colors.text.secondary
                    ),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // 3. Animation Direction Control
                SectionTitle("3. Animation Direction Control")
                SectionDescription("Demonstrating different flip animation directions")

                val notifications = persistentListOf(
                    "New message from John",
                    "Your order is on the way",
                    "Payment successful",
                    "2 new offers available"
                )

                var flipToTop by remember { mutableStateOf(true) }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Direction toggle button
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "Current direction: ${if(flipToTop) "Flip to top" else "Flip to bottom"}",
                                    type = SushiTextType.Regular400
                                ),
                                modifier = Modifier.weight(1f)
                            )

                            SushiButton(
                                props = SushiButtonProps(
                                    text = "Toggle Direction"
                                ),
                                onClick = {
                                    flipToTop = !flipToTop
                                }
                            )
                        }

                        // Flipper with controlled direction
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = SushiTheme.colors.blue.v050.value
                            ),
                            shape = RoundedCornerShape(8.dp),
                            border = androidx.compose.foundation.BorderStroke(
                                1.dp,
                                SushiTheme.colors.blue.v200.value
                            )
                        ) {
                            SushiViewFlipper(
                                props = SushiViewFlipperProps(
                                    count = notifications.size,
                                    animationDirection = if (flipToTop)
                                        SushiViewFlipperProps.FlipAnimationDirection.FlipToTop
                                    else
                                        SushiViewFlipperProps.FlipAnimationDirection.FlipToBottom
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) { index ->
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    SushiIcon(
                                        props = SushiIconProps(
                                            code = SushiIconCodes.IconBell,
                                            color = SushiTheme.colors.blue.v700
                                        )
                                    )

                                    Spacer(modifier = Modifier.width(12.dp))

                                    SushiText(
                                        props = SushiTextProps(
                                            text = notifications[index],
                                            type = SushiTextType.Medium500,
                                            color = SushiTheme.colors.blue.v700
                                        )
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 4. Play/Pause Control
                SectionTitle("4. Play/Pause Control")
                SectionDescription("ViewFlipper with play/pause functionality")

                val tips = persistentListOf(
                    "Order in advance to avoid waiting times",
                    "Save favorite restaurants for quick access",
                    "Check ratings and reviews before ordering",
                    "Try our new personalized recommendations",
                    "Use filters to find exactly what you want"
                )

                var isPlaying by remember { mutableStateOf(true) }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Play/Pause controls
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "Flipper is ${if(isPlaying) "playing" else "paused"}",
                                    type = SushiTextType.Regular400
                                ),
                                modifier = Modifier.weight(1f)
                            )

                            SushiButton(
                                props = SushiButtonProps(
                                    text = if (isPlaying) "Pause" else "Play"
                                ),
                                onClick = {
                                    isPlaying = !isPlaying
                                }
                            )
                        }

                        // Flipper with play/pause control
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = SushiTheme.colors.surface.secondary.value
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                SushiIcon(
                                    props = SushiIconProps(
                                        code = SushiIconCodes.IconLightningLine,
                                        color = SushiColorData(ColorName.Yellow, ColorVariation.Variation500)
                                    )
                                )

                                Spacer(modifier = Modifier.width(12.dp))

                                SushiViewFlipper(
                                    props = SushiViewFlipperProps(
                                        count = tips.size,
                                        isPlaying = isPlaying
                                    ),
                                    modifier = Modifier.weight(1f)
                                ) { index ->
                                    SushiText(
                                        props = SushiTextProps(
                                            text = "Tip #${index + 1}: ${tips[index]}",
                                            type = SushiTextType.Regular400
                                        )
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 5. Custom Animation Duration
                SectionTitle("5. Custom Animation Duration")
                SectionDescription("ViewFlipper with slower animation transitions")

                val featuredItems = persistentListOf(
                    "Featured: Margherita Pizza",
                    "Featured: Double Cheese Burger",
                    "Featured: Chocolate Brownie",
                    "Featured: Iced Coffee"
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = SushiTheme.colors.purple.v050.value
                        ),
                        shape = RoundedCornerShape(8.dp),
                        border = androidx.compose.foundation.BorderStroke(
                            1.dp,
                            SushiTheme.colors.purple.v200.value
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "Featured Menu Items",
                                    type = SushiTextType.Bold600,
                                    color = SushiTheme.colors.purple.v700
                                )
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            SushiViewFlipper(
                                props = SushiViewFlipperProps(
                                    count = featuredItems.size,
                                    animationDuration = 1200,  // Slower animation (1.2 seconds)
                                    flipInterval = 4000L       // Show each item for 4 seconds
                                ),
                                modifier = Modifier.fillMaxWidth()
                            ) { index ->
                                SushiText(
                                    props = SushiTextProps(
                                        text = featuredItems[index],
                                        type = SushiTextType.Medium500,
                                        color = SushiTheme.colors.purple.v600,
                                        textAlign = TextAlign.Center
                                    ),
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }

                            SushiText(
                                props = SushiTextProps(
                                    text = "Slow transition animation (1.2 seconds)",
                                    type = SushiTextType.Regular400,
                                    color = SushiTheme.colors.text.secondary,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 6. Complex Content with Dynamic Count
                SectionTitle("6. Complex Content with Dynamic Count")
                SectionDescription("ViewFlipper with variable number of items and complex content")

                val initialSteps = persistentListOf(
                    "Place your order" to SushiIconCodes.IconCheck,
                    "Payment processed" to SushiIconCodes.IconCashFilled,
                    "Restaurant preparing" to SushiIconCodes.IconCutlery
                )

                var orderSteps by remember { mutableStateOf(initialSteps) }
                var stepsCount by remember { mutableIntStateOf(initialSteps.size) }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Controls for dynamically changing the count
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "Order steps: $stepsCount",
                                    type = SushiTextType.Regular400
                                ),
                                modifier = Modifier.weight(1f)
                            )
                        }

                        SushiButton(
                            props = SushiButtonProps(text = "Add Step"),
                            onClick = {
                                if (stepsCount < 5) {
                                    // Add a new step
                                    val newStep = when (stepsCount) {
                                        3 -> "Order on the way" to SushiIconCodes.IconScooterSharp
                                        4 -> "Order delivered" to SushiIconCodes.IconCheckCircleFill
                                        else -> "Unknown step" to SushiIconCodes.IconPlusText
                                    }
                                    orderSteps = (orderSteps + newStep).toPersistentList()
                                    stepsCount = orderSteps.size
                                }
                            },
                            modifier = Modifier.padding(end = 8.dp)
                        )
                    }

                    // Flipper with dynamic content
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = SushiTheme.colors.orange.v050.value
                        ),
                        shape = RoundedCornerShape(8.dp),
                        border = androidx.compose.foundation.BorderStroke(
                            1.dp,
                            SushiTheme.colors.orange.v200.value
                        )
                    ) {
                        SushiViewFlipper(
                            props = SushiViewFlipperProps(
                                count = stepsCount,
                                flipInterval = 2000L,
                                animationDirection = SushiViewFlipperProps.FlipAnimationDirection.FlipToTop
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) { index ->
                            val (step, icon) = orderSteps[index]

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Step indicator
                                Box(
                                    modifier = Modifier
                                        .size(36.dp)
                                        .clip(RoundedCornerShape(18.dp))
                                        .background(SushiTheme.colors.orange.v200.value),
                                    contentAlignment = Alignment.Center
                                ) {
                                    SushiText(
                                        props = SushiTextProps(
                                            text = "${index + 1}",
                                            type = SushiTextType.Bold700,
                                            color = SushiTheme.colors.orange.v700
                                        )
                                    )
                                }

                                Spacer(modifier = Modifier.width(16.dp))

                                // Step description
                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    SushiText(
                                        props = SushiTextProps(
                                            text = step,
                                            type = SushiTextType.Medium500,
                                            color = SushiTheme.colors.orange.v800
                                        )
                                    )

                                    SushiText(
                                        props = SushiTextProps(
                                            text = "Order #123456",
                                            type = SushiTextType.Regular400,
                                            color = SushiTheme.colors.orange.v600
                                        )
                                    )
                                }

                                Spacer(modifier = Modifier.width(16.dp))

                                // Step icon
                                SushiIcon(
                                    props = SushiIconProps(
                                        code = icon,
                                        color = SushiTheme.colors.orange.v700
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
            type = SushiTextType.Bold600,
            color = SushiTheme.colors.text.primary
        ),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
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
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
    )
}

@Composable
@SushiPreview
private fun ViewFlipperShowcaseScreenPreview() {
    AppTheme {
        ViewFlipperShowcaseScreen()
    }
}