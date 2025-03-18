package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.components.pager.SushiVerticalPager
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.BaseScreen
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlin.math.absoluteValue

@Serializable
object VerticalPagerShowcaseScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerticalPagerShowcaseScreen(
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
                    title = "VerticalPager Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        start = SushiTheme.dimens.spacing.base,
                        end = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )

                // Example 1: Social Feed Style Pager with Indicators
                SectionTitle("1. Social Feed Style Pager")
                SectionDescription(
                    "Vertical feed of content with indicators, similar to social media stories"
                )

                val feedItems = List(5) { index ->
                    FeedItem(
                        title = "Story ${index + 1}",
                        content = "This is the content for story ${index + 1}. Swipe vertically to see more stories.",
                        color = getColorForIndex(index)
                    )
                }

                val pagerState1 = rememberPagerState(pageCount = { feedItems.size })
                val scope = rememberCoroutineScope()

                // The vertical pager
                SushiVerticalPager(
                    state = pagerState1,
                    modifier = Modifier.fillMaxWidth()
                        .height(400.dp)
                        .padding(16.dp)
                ) { page ->
                    StoryItem(
                        item = feedItems[page],
                        currentPage = page,
                        totalPages = feedItems.size
                    )
                }

                // Navigation controls
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SushiButton(
                        props = SushiButtonProps(text = "Previous"),
                        onClick = {
                            if (pagerState1.currentPage > 0) {
                                scope.launch {
                                    pagerState1.animateScrollToPage(pagerState1.currentPage - 1)
                                }
                            }
                        },
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    SushiButton(
                        props = SushiButtonProps(text = "Next"),
                        onClick = {
                            if (pagerState1.currentPage < feedItems.size - 1) {
                                scope.launch {
                                    pagerState1.animateScrollToPage(pagerState1.currentPage + 1)
                                }
                            }
                        },
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))

                // Example 2: Card Stack with Custom Transitions
                SectionTitle("2. Card Stack with Custom Transitions")
                SectionDescription(
                    "Overlapping cards with custom transition animations"
                )

                val cardItems = (1..5).map { index ->
                    CardItem(
                        title = "Card ${index}",
                        description = "This is card ${index} in the vertical stack. Each card has a different color and transition effect.",
                        color = getColorForIndex(index + 4)  // Offset to get different colors
                    )
                }

                val pagerState2 = rememberPagerState(pageCount = { cardItems.size })

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .padding(16.dp)
                ) {
                    // Card stack pager with custom transitions
                    SushiVerticalPager(
                        state = pagerState2,
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(vertical = 32.dp),
                        pageSpacing = (-30).dp  // Negative spacing for overlapping effect
                    ) { page ->
                        val pageOffset = (
                                (pagerState2.currentPage - page) + pagerState2
                                    .currentPageOffsetFraction
                                ).absoluteValue

                        // Apply transformation based on page offset
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(400.dp)
                                .padding(16.dp)
                                .graphicsLayer {
                                    // Scale down as items move away from current
                                    val scale = lerp(
                                        start = 0.85f,
                                        stop = 1f,
                                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                    )
                                    scaleX = scale
                                    scaleY = scale

                                    // Slight rotation for a card stack feel
                                    rotationZ = lerp(
                                        start = 0f,
                                        stop = -4f,
                                        fraction = pageOffset.coerceIn(0f, 1f)
                                    )

                                    // Adjust alpha for fading effect
                                    alpha = lerp(
                                        start = 0.5f,
                                        stop = 1f,
                                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                    )
                                },
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 8.dp * (1f - pageOffset.coerceIn(0f, 1f))
                            ),
                            colors = CardDefaults.cardColors(
                                containerColor = cardItems[page].color.value
                            )
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(24.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    SushiText(
                                        props = SushiTextProps(
                                            text = cardItems[page].title,
                                            type = SushiTextType.Bold700,
//                                            color = Color.White,
                                            textAlign = TextAlign.Center
                                        )
                                    )

                                    Spacer(modifier = Modifier.height(16.dp))

                                    SushiText(
                                        props = SushiTextProps(
                                            text = cardItems[page].description,
                                            type = SushiTextType.Regular500,
//                                            color = Color.White,
                                            textAlign = TextAlign.Center
                                        )
                                    )

                                    Spacer(modifier = Modifier.height(32.dp))

                                    Box(
                                        modifier = Modifier
                                            .size(40.dp)
                                            .background(Color.White.copy(alpha = 0.2f), CircleShape),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        SushiText(
                                            props = SushiTextProps(
                                                text = "${page + 1}",
                                                type = SushiTextType.Bold700,
//                                                color = Color.White
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

                // Example 3: Auto-Scroll Product Showcase
                SectionTitle("3. Auto-Scroll Product Showcase")
                SectionDescription(
                    "Auto-scrolling vertical pager with partial height pages"
                )

                val productItems = (1..8).map { index ->
                    ProductItem(
                        name = "Product ${index}",
                        price = "₹${99 * index}",
                        color = getColorForIndex(index + 2).value  // Offset colors
                    )
                }

                val pagerState3 = rememberPagerState(pageCount = { productItems.size })

                // Auto-scroll effect
                var autoScrollEnabled by remember { mutableStateOf(true) }

                LaunchedEffect(autoScrollEnabled) {
                    if (autoScrollEnabled) {
                        while(true) {
                            delay(2500)
                            val nextPage = (pagerState3.currentPage + 1) % productItems.size
                            pagerState3.animateScrollToPage(nextPage)
                        }
                    }
                }

                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    ) {
                        // Partial height pager with multiple visible items
                        SushiVerticalPager(
                            state = pagerState3,
                            modifier = Modifier.fillMaxSize(),
                            pageSize = PageSize.Fixed(150.dp),
                            contentPadding = PaddingValues(vertical = 24.dp),
                            pageSpacing = 16.dp,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) { page ->
                            ProductCard(
                                product = productItems[page],
                                isCurrent = page == pagerState3.currentPage
                            )
                        }

                        // Add gradient overlays at top and bottom for fading effect
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .align(Alignment.TopCenter)
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            SushiTheme.colors.surface.primary.value,
                                            Color.Transparent
                                        )
                                    )
                                )
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .align(Alignment.BottomCenter)
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Transparent,
                                            SushiTheme.colors.surface.primary.value
                                        )
                                    )
                                )
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Current product indicator
                    SushiText(
                        props = SushiTextProps(
                            text = "Product ${pagerState3.currentPage + 1} of ${productItems.size}",
                            type = SushiTextType.Regular400,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Auto-scroll toggle button
                    SushiButton(
                        props = SushiButtonProps(
                            text = if (autoScrollEnabled) "Pause Auto-Scroll" else "Resume Auto-Scroll"
                        ),
                        onClick = { autoScrollEnabled = !autoScrollEnabled },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
private fun StoryItem(
    item: FeedItem,
    currentPage: Int,
    totalPages: Int
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(item.color.value),
        contentAlignment = Alignment.Center
    ) {
        // Progress indicator at the top
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .align(Alignment.TopCenter)
        ) {
            for (i in 0 until totalPages) {
                val alpha = if (i <= currentPage) 1f else 0.3f
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(4.dp)
                        .padding(horizontal = 2.dp)
                        .alpha(alpha)
                        .background(Color.White, RoundedCornerShape(2.dp))
                )
            }
        }

        // Content in the center
        Column(
            modifier = Modifier
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SushiText(
                props = SushiTextProps(
                    text = item.title,
                    type = SushiTextType.Bold700,
//                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            SushiText(
                props = SushiTextProps(
                    text = item.content,
                    type = SushiTextType.Medium500,
//                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            )
        }

        // Swipe indicator at the bottom
        SushiText(
            props = SushiTextProps(
                text = "Swipe Up",
                type = SushiTextType.Regular400,
//                color = Color.White.copy(alpha = 0.7f)
            ),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        )
    }
}

@Composable
private fun ProductCard(
    product: ProductItem,
    isCurrent: Boolean
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isCurrent) 8.dp else 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = product.color.copy(alpha = if (isCurrent) 1f else 0.7f)
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    SushiText(
                        props = SushiTextProps(
                            text = product.name,
                            type = SushiTextType.Bold600,
//                            color = Color.White
                        )
                    )

                    SushiText(
                        props = SushiTextProps(
                            text = "Tap to view details",
                            type = SushiTextType.Regular400,
//                            color = Color.White.copy(alpha = 0.7f)
                        )
                    )
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White.copy(alpha = 0.2f))
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    SushiText(
                        props = SushiTextProps(
                            text = product.price,
                            type = SushiTextType.Bold600,
//                            color = Color.White
                        )
                    )
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

private fun getColorForIndex(index: Int): ColorSpec {
    val colors = listOf(
        SushiColorData(ColorName.Purple, ColorVariation.Variation600),
        SushiColorData(ColorName.Blue, ColorVariation.Variation600),
        SushiColorData(ColorName.Green, ColorVariation.Variation600),
        SushiColorData(ColorName.Orange, ColorVariation.Variation600),
        SushiColorData(ColorName.Red, ColorVariation.Variation600),
        SushiColorData(ColorName.Yellow, ColorVariation.Variation600),
        SushiColorData(ColorName.Blue, ColorVariation.Variation800),
        SushiColorData(ColorName.Green, ColorVariation.Variation800),
        SushiColorData(ColorName.Red, ColorVariation.Variation800),
        SushiColorData(ColorName.Purple, ColorVariation.Variation800),
    )
    return colors[index % colors.size]
}

data class FeedItem(
    val title: String,
    val content: String,
    val color: ColorSpec
)

data class CardItem(
    val title: String,
    val description: String,
    val color: ColorSpec
)

data class ProductItem(
    val name: String,
    val price: String,
    val color: Color
)

@Composable
@SushiPreview
private fun VerticalPagerShowcaseScreenPreview() {
    AppTheme {
        VerticalPagerShowcaseScreen()
    }
}