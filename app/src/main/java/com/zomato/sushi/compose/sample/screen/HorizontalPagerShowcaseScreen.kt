package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerState
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.indicators.SushiIndicator
import com.zomato.sushi.compose.atoms.indicators.model.DotGraphic
import com.zomato.sushi.compose.atoms.indicators.type.SushiIndicatorType
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.components.pager.SushiHorizontalPager
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.BaseScreen
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
object HorizontalPagerShowcaseScreen

@Composable
fun HorizontalPagerShowcaseScreen(
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
                    title = "HorizontalPager Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        start = SushiTheme.dimens.spacing.base,
                        end = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )

                // Example 1: Basic Image Carousel with SushiIndicator
                SectionTitle("1. Basic Image Carousel")
                SectionDescription(
                    "A simple horizontal pager with page indicators, commonly used for banners"
                )

                val bannerImages = List(5) { index ->
                    getRandomColorForIndex(index)
                }

                val pagerState1 = rememberPagerState(pageCount = { bannerImages.size })
                val scope = rememberCoroutineScope()

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    // The pager
                    SushiHorizontalPager(
                        state = pagerState1,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                    ) { page ->
                        ImageBanner(
                            color = bannerImages[page],
                            text = "Banner ${page + 1}"
                        )
                    }

                    // Indicators
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(16.dp)
                    ) {
                        SushiIndicator(
                            dotCount = bannerImages.size,
                            type = SushiIndicatorType.Balloon(
                                dotsGraphic = DotGraphic(
                                    color = Color.White,
                                    size = 8.dp
                                )
                            ),
                            pagerState = pagerState1
                        )
                    }
                }

                // Navigation buttons
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
                            if (pagerState1.currentPage < bannerImages.size - 1) {
                                scope.launch {
                                    pagerState1.animateScrollToPage(pagerState1.currentPage + 1)
                                }
                            }
                        },
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))

                // Example 2: Auto-Scrolling Carousel with Multiple Visible Items
                SectionTitle("2. Auto-Scrolling Carousel with Multiple Items")
                SectionDescription(
                    "Horizontal pager with multiple visible items and auto-scrolling behavior"
                )

                val cardItems = (1..10).map { index ->
                    "Item $index"
                }

                val pagerState2 = rememberPagerState(pageCount = { cardItems.size })

                // Auto-scroll effect
                var autoScrollEnabled by remember { mutableStateOf(true) }

                LaunchedEffect(autoScrollEnabled) {
                    if (autoScrollEnabled) {
                        while(true) {
                            delay(3000)
                            val nextPage = (pagerState2.currentPage + 1) % cardItems.size
                            pagerState2.animateScrollToPage(nextPage)
                        }
                    }
                }

                // The multi-item pager
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    SushiHorizontalPager(
                        state = pagerState2,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        contentPadding = PaddingValues(horizontal = 32.dp),
                        pageSpacing = 16.dp,
                        pageSize = PageSize.Fixed(180.dp)
                    ) { page ->
                        Card(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(4.dp),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 4.dp
                            ),
                            colors = CardDefaults.cardColors(
                                containerColor = SushiTheme.colors.surface.secondary.value
                            )
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                SushiText(
                                    props = SushiTextProps(
                                        text = cardItems[page],
                                        type = SushiTextType.Medium500,
                                        textAlign = TextAlign.Center
                                    )
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Current page indicator
                    SushiText(
                        props = SushiTextProps(
                            text = "Current page: ${pagerState2.currentPage + 1} / ${cardItems.size}",
                            type = SushiTextType.Regular400,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Toggle auto-scroll
                    SushiButton(
                        props = SushiButtonProps(
                            text = if (autoScrollEnabled) "Disable Auto-Scroll" else "Enable Auto-Scroll"
                        ),
                        onClick = { autoScrollEnabled = !autoScrollEnabled },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))

                // Example 3: Onboarding Flow with Custom Transition
                SectionTitle("3. Onboarding Flow with Custom Navigation")
                SectionDescription(
                    "A pager used for onboarding screens with custom navigation controls"
                )

                val onboardingPages = listOf(
                    OnboardingPage(
                        title = "Welcome to Sushi",
                        description = "Discover how Sushi can help you build beautiful, consistent UIs quickly and easily.",
                        color = SushiTheme.colors.blue.v200.value
                    ),
                    OnboardingPage(
                        title = "Customizable Components",
                        description = "Sushi offers a wide range of customizable components that adapt to your brand.",
                        color = SushiTheme.colors.green.v200.value
                    ),
                    OnboardingPage(
                        title = "Get Started",
                        description = "Start building your app with Sushi components today!",
                        color = SushiTheme.colors.purple.v200.value
                    )
                )

                val pagerState3 = rememberPagerState(pageCount = { onboardingPages.size })

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column {
                        // Onboarding pager
                        SushiHorizontalPager(
                            state = pagerState3,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp),
                            userScrollEnabled = false  // Disable scrolling, control via buttons only
                        ) { page ->
                            OnboardingScreen(onboardingPages[page])
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        // Custom navigation controls
                        Box(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            // Back button (visible except on first page)
                            if (pagerState3.currentPage > 0) {
                                SushiButton(
                                    props = SushiButtonProps(text = "Back"),
                                    onClick = {
                                        scope.launch {
                                            pagerState3.animateScrollToPage(pagerState3.currentPage - 1)
                                        }
                                    },
                                    modifier = Modifier.align(Alignment.CenterStart)
                                )
                            }

                            // Dots indicator
                            Row(
                                modifier = Modifier.align(Alignment.Center),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                repeat(onboardingPages.size) { index ->
                                    val selected = pagerState3.currentPage == index
                                    Box(
                                        modifier = Modifier
                                            .padding(horizontal = 4.dp)
                                            .size(if (selected) 10.dp else 8.dp)
                                            .background(
                                                if (selected)
                                                    SushiTheme.colors.base.theme.v500.value
                                                else
                                                    SushiTheme.colors.grey.v400.value,
                                                CircleShape
                                            )
                                            .clickable {
                                                scope.launch {
                                                    pagerState3.animateScrollToPage(index)
                                                }
                                            }
                                    )
                                }
                            }

                            // Next/Finish button
                            SushiButton(
                                props = SushiButtonProps(
                                    text = if (pagerState3.currentPage == onboardingPages.size - 1)
                                        "Get Started"
                                    else
                                        "Next"
                                ),
                                onClick = {
                                    if (pagerState3.currentPage < onboardingPages.size - 1) {
                                        scope.launch {
                                            pagerState3.animateScrollToPage(pagerState3.currentPage + 1)
                                        }
                                    } else {
                                        // Handle completion of onboarding
                                        // In a real app, you might navigate to the home screen
                                    }
                                },
                                modifier = Modifier.align(Alignment.CenterEnd)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ImageBanner(color: ColorSpec, text: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(8.dp))
            .background(color.value),
        contentAlignment = Alignment.Center
    ) {
        SushiText(
            props = SushiTextProps(
                text = text,
                type = SushiTextType.Bold700,
//                color = Color.White
            )
        )
    }
}

@Composable
private fun OnboardingScreen(page: OnboardingPage) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(page.color),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(24.dp)
        ) {
            // Content placeholder (in a real app, you might have illustrations here)
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.2f))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                // Placeholder for illustration
            }

            Spacer(modifier = Modifier.height(24.dp))

            SushiText(
                props = SushiTextProps(
                    text = page.title,
                    type = SushiTextType.Bold700,
//                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            SushiText(
                props = SushiTextProps(
                    text = page.description,
                    type = SushiTextType.Regular400,
//                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            )
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

private fun getRandomColorForIndex(index: Int): ColorSpec {
    val colors = listOf(
        SushiColorData(ColorName.Red, ColorVariation.Variation600),
        SushiColorData(ColorName.Blue, ColorVariation.Variation600),
        SushiColorData(ColorName.Green, ColorVariation.Variation600),
        SushiColorData(ColorName.Purple, ColorVariation.Variation600),
        SushiColorData(ColorName.Orange, ColorVariation.Variation600)
    )
    return colors[index % colors.size]
}

data class OnboardingPage(
    val title: String,
    val description: String,
    val color: Color
)

@Composable
@SushiPreview
private fun HorizontalPagerShowcaseScreenPreview() {
    AppTheme {
        HorizontalPagerShowcaseScreen()
    }
}