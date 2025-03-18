package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

@Serializable
object IndicatorsShowcaseScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IndicatorsShowcaseScreen(
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
                    title = "Indicators Showcase",
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
                        .padding(horizontal = SushiTheme.dimens.spacing.base)
                ) {
                    // 1. Basic Balloon Indicator
                    SectionTitle("1. Basic Balloon Indicator")
                    val pagerState1 = rememberPagerState { 5 }
                    AutoScrollingPager(pagerState1)
                    SushiIndicator(
                        dotCount = 5,
                        type = SushiIndicatorType.Balloon(),
                        pagerState = pagerState1,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(24.dp))

                    // 2. Basic Shift Indicator
                    SectionTitle("2. Basic Shift Indicator")
                    val pagerState2 = rememberPagerState { 5 }
                    AutoScrollingPager(pagerState2)
                    SushiIndicator(
                        dotCount = 5,
                        type = SushiIndicatorType.Shift(),
                        pagerState = pagerState2,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(24.dp))

                    // 3. Basic Spring Indicator
                    SectionTitle("3. Basic Spring Indicator")
                    val pagerState3 = rememberPagerState { 5 }
                    AutoScrollingPager(pagerState3)
                    SushiIndicator(
                        dotCount = 5,
                        type = SushiIndicatorType.Spring(),
                        pagerState = pagerState3,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(24.dp))

                    // 4. Balloon Indicator with Custom Color
                    SectionTitle("4. Balloon Indicator with Custom Color")
                    val pagerState4 = rememberPagerState { 5 }
                    AutoScrollingPager(pagerState4)
                    SushiIndicator(
                        dotCount = 5,
                        type = SushiIndicatorType.Balloon(
                            dotsGraphic = DotGraphic(
                                color = SushiTheme.colors.red.v500.value
                            )
                        ),
                        pagerState = pagerState4,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(24.dp))

                    // 5. Shift Indicator with Custom Color
                    SectionTitle("5. Shift Indicator with Custom Color")
                    val pagerState5 = rememberPagerState { 5 }
                    AutoScrollingPager(pagerState5)
                    SushiIndicator(
                        dotCount = 5,
                        type = SushiIndicatorType.Shift(
                            dotsGraphic = DotGraphic(
                                color = SushiTheme.colors.blue.v500.value
                            )
                        ),
                        pagerState = pagerState5,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(24.dp))

                    // 6. Balloon Indicator with Custom Size
                    SectionTitle("6. Balloon Indicator with Custom Size")
                    val pagerState6 = rememberPagerState { 5 }
                    AutoScrollingPager(pagerState6)
                    SushiIndicator(
                        dotCount = 5,
                        type = SushiIndicatorType.Balloon(
                            dotsGraphic = DotGraphic(
                                size = 16.dp,
                                color = SushiTheme.colors.theme.v500.value
                            )
                        ),
                        pagerState = pagerState6,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(24.dp))

                    // 7. Shift Indicator with Custom Size Factor
                    SectionTitle("7. Shift Indicator with Custom Size Factor")
                    val pagerState7 = rememberPagerState { 5 }
                    AutoScrollingPager(pagerState7)
                    SushiIndicator(
                        dotCount = 5,
                        type = SushiIndicatorType.Shift(
                            dotsGraphic = DotGraphic(
                                color = SushiTheme.colors.theme.v500.value
                            ),
                            shiftSizeFactor = 5f // Much wider shift effect
                        ),
                        pagerState = pagerState7,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(24.dp))

                    // 8. Balloon Indicator with Custom Balloon Factor
                    SectionTitle("8. Balloon Indicator with Custom Balloon Factor")
                    val pagerState8 = rememberPagerState { 5 }
                    AutoScrollingPager(pagerState8)
                    SushiIndicator(
                        dotCount = 5,
                        type = SushiIndicatorType.Balloon(
                            dotsGraphic = DotGraphic(
                                color = SushiTheme.colors.theme.v500.value
                            ),
                            balloonSizeFactor = 2.5f // Much larger balloon effect
                        ),
                        pagerState = pagerState8,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(24.dp))

                    // 9. Spring Indicator with Custom Colors
                    SectionTitle("9. Spring Indicator with Custom Colors")
                    val pagerState9 = rememberPagerState { 5 }
                    AutoScrollingPager(pagerState9)
                    SushiIndicator(
                        dotCount = 5,
                        type = SushiIndicatorType.Spring(
                            dotsGraphic = DotGraphic(
                                color = SushiTheme.colors.grey.v300.value
                            ),
                            selectorDotGraphic = DotGraphic(
                                color = SushiTheme.colors.theme.v500.value
                            )
                        ),
                        pagerState = pagerState9,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(24.dp))

                    // 10. Indicator with Custom Dot Spacing
                    SectionTitle("10. Indicator with Custom Dot Spacing")
                    val pagerState10 = rememberPagerState { 5 }
                    AutoScrollingPager(pagerState10)
                    SushiIndicator(
                        dotCount = 5,
                        type = SushiIndicatorType.Balloon(),
                        pagerState = pagerState10,
                        dotSpacing = 24.dp, // Wider spacing between dots
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(24.dp))

                    // 11. Spring Indicator with Custom Shapes
                    SectionTitle("11. Spring Indicator with Custom Shapes")
                    val pagerState11 = rememberPagerState { 5 }
                    AutoScrollingPager(pagerState11)
                    SushiIndicator(
                        dotCount = 5,
                        type = SushiIndicatorType.Spring(
                            dotsGraphic = DotGraphic(
                                color = Color.Transparent,
                                borderColor = SushiTheme.colors.theme.v500.value,
                                borderWidth = 2.dp,
                                size = 12.dp,
                                shape = CircleShape
                            ),
                            selectorDotGraphic = DotGraphic(
                                color = SushiTheme.colors.theme.v500.value,
                                size = 10.dp,
                                shape = CircleShape
                            )
                        ),
                        pagerState = pagerState11,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(24.dp))

                    // 12. Balloon Indicator with Border
                    SectionTitle("12. Balloon Indicator with Border")
                    val pagerState12 = rememberPagerState { 5 }
                    AutoScrollingPager(pagerState12)
                    SushiIndicator(
                        dotCount = 5,
                        type = SushiIndicatorType.Balloon(
                            dotsGraphic = DotGraphic(
                                color = Color.Transparent,
                                borderColor = SushiTheme.colors.theme.v500.value,
                                borderWidth = 2.dp,
                                size = 12.dp
                            )
                        ),
                        pagerState = pagerState12,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(24.dp))

                    // 13. Different Page Counts (3 pages)
                    SectionTitle("13. Different Page Counts (3 pages)")
                    val pagerState13 = rememberPagerState { 3 }
                    AutoScrollingPager(pagerState13, pageCount = 3)
                    SushiIndicator(
                        dotCount = 3,
                        type = SushiIndicatorType.Balloon(),
                        pagerState = pagerState13,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(24.dp))

                    // 14. Different Page Counts (7 pages)
                    SectionTitle("14. Different Page Counts (7 pages)")
                    val pagerState14 = rememberPagerState { 7 }
                    AutoScrollingPager(pagerState14, pageCount = 7)
                    SushiIndicator(
                        dotCount = 7,
                        type = SushiIndicatorType.Balloon(),
                        pagerState = pagerState14,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(24.dp))

                    // 15. Manual Control Example
                    SectionTitle("15. Manual Control Example")
                    val scope = rememberCoroutineScope()
                    val totalPages = 5
                    var currentPage by remember { mutableIntStateOf(0) }
                    var currentOffset by remember { mutableStateOf(0f) }

                    // Simulate a pager without an actual pager
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(16.dp)
                        .background(
                            SushiTheme.colors.surface.secondary.value,
                            RoundedCornerShape(8.dp)
                        )
                    ) {
                        Text(
                            text = "Page ${currentPage + 1}",
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }

                    // Control buttons
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Surface(
                            onClick = {
                                if (currentPage > 0) {
                                    currentPage--
                                    currentOffset = 0f
                                }
                            },
                            shape = RoundedCornerShape(4.dp),
                            color = SushiTheme.colors.theme.v500.value
                        ) {
                            Text(
                                "Prev",
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                            )
                        }

                        Surface(
                            onClick = {
                                if (currentPage < totalPages - 1) {
                                    currentPage++
                                    currentOffset = 0f
                                }
                            },
                            shape = RoundedCornerShape(4.dp),
                            color = SushiTheme.colors.theme.v500.value
                        ) {
                            Text(
                                "Next",
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                            )
                        }
                    }

                    // The indicator with manual control
                    SushiIndicator(
                        dotCount = totalPages,
                        type = SushiIndicatorType.Balloon(),
                        currentPage = currentPage,
                        currentPageOffsetFraction = { currentOffset },
                        onDotClicked = { index ->
                            scope.launch {
                                currentPage = index
                                currentOffset = 0f
                            }
                        },
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(24.dp))

                    // 16. Combined Different Types in One Screen
                    SectionTitle("16. Combined Types")
                    val pagerState16 = rememberPagerState { 5 }
                    AutoScrollingPager(pagerState16)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        // Balloon
                        SushiIndicator(
                            dotCount = 5,
                            type = SushiIndicatorType.Balloon(
                                dotsGraphic = DotGraphic(
                                    color = SushiTheme.colors.red.v500.value,
                                    size = 8.dp
                                )
                            ),
                            pagerState = pagerState16
                        )

                        // Shift
                        SushiIndicator(
                            dotCount = 5,
                            type = SushiIndicatorType.Shift(
                                dotsGraphic = DotGraphic(
                                    color = SushiTheme.colors.green.v500.value,
                                    size = 8.dp
                                )
                            ),
                            pagerState = pagerState16
                        )

                        // Spring
                        SushiIndicator(
                            dotCount = 5,
                            type = SushiIndicatorType.Spring(
                                dotsGraphic = DotGraphic(
                                    color = SushiTheme.colors.blue.v200.value,
                                    size = 8.dp
                                ),
                                selectorDotGraphic = DotGraphic(
                                    color = SushiTheme.colors.blue.v600.value,
                                    size = 8.dp
                                )
                            ),
                            pagerState = pagerState16
                        )
                    }

                    Spacer(Modifier.height(24.dp))

                    // 17. Shift Indicator with RoundedCornerShape
                    SectionTitle("17. Custom Shape Shift Indicator")
                    val pagerState17 = rememberPagerState { 5 }
                    AutoScrollingPager(pagerState17)
                    SushiIndicator(
                        dotCount = 5,
                        type = SushiIndicatorType.Shift(
                            dotsGraphic = DotGraphic(
                                color = SushiTheme.colors.theme.v500.value,
                                shape = RoundedCornerShape(2.dp),
                                size = 8.dp
                            ),
                            shiftSizeFactor = 4f
                        ),
                        pagerState = pagerState17,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(24.dp))

                    // 18. Indicators with Background Container
                    SectionTitle("18. Indicators with Background")
                    val pagerState18 = rememberPagerState { 5 }
                    AutoScrollingPager(pagerState18)
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .background(
                                SushiTheme.colors.surface.secondary.value,
                                RoundedCornerShape(24.dp)
                            )
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        SushiIndicator(
                            dotCount = 5,
                            type = SushiIndicatorType.Balloon(),
                            pagerState = pagerState18
                        )
                    }

                    Spacer(Modifier.height(24.dp))

                    // 19. Two-Color Spring Indicator
                    SectionTitle("19. Two-Color Spring Indicator")
                    val pagerState19 = rememberPagerState { 5 }
                    AutoScrollingPager(pagerState19)
                    SushiIndicator(
                        dotCount = 5,
                        type = SushiIndicatorType.Spring(
                            dotsGraphic = DotGraphic(
                                color = SushiTheme.colors.blue.v100.value,
                                borderColor = SushiTheme.colors.blue.v500.value,
                                borderWidth = 1.dp,
                                size = 12.dp
                            ),
                            selectorDotGraphic = DotGraphic(
                                color = SushiTheme.colors.yellow.v500.value,
                                size = 12.dp
                            )
                        ),
                        pagerState = pagerState19,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.height(24.dp))

                    // 20. Horizontal Arrangement of Indicators
                    SectionTitle("20. Horizontal Arrangement of Indicators")
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Create three separate pager states with different counts
                        val pagerStateA = rememberPagerState { 3 }
                        val pagerStateB = rememberPagerState { 5 }
                        val pagerStateC = rememberPagerState { 7 }

                        // Launch the auto-scrolling effect for each pager
                        LaunchedEffect(true) {
                            while (true) {
                                delay(3000)
                                if (pagerStateA.currentPage < 2) pagerStateA.animateScrollToPage(pagerStateA.currentPage + 1)
                                else pagerStateA.animateScrollToPage(0)

                                delay(1000)
                                if (pagerStateB.currentPage < 4) pagerStateB.animateScrollToPage(pagerStateB.currentPage + 1)
                                else pagerStateB.animateScrollToPage(0)

                                delay(1000)
                                if (pagerStateC.currentPage < 6) pagerStateC.animateScrollToPage(pagerStateC.currentPage + 1)
                                else pagerStateC.animateScrollToPage(0)
                            }
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "3 dots",
                                    type = SushiTextType.Medium400
                                )
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            SushiIndicator(
                                dotCount = 3,
                                type = SushiIndicatorType.Balloon(
                                    dotsGraphic = DotGraphic(
                                        color = SushiTheme.colors.red.v500.value,
                                        size = 8.dp
                                    )
                                ),
                                pagerState = pagerStateA
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "5 dots",
                                    type = SushiTextType.Medium400
                                )
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            SushiIndicator(
                                dotCount = 5,
                                type = SushiIndicatorType.Shift(
                                    dotsGraphic = DotGraphic(
                                        color = SushiTheme.colors.green.v500.value,
                                        size = 8.dp
                                    )
                                ),
                                pagerState = pagerStateB
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "7 dots",
                                    type = SushiTextType.Medium400
                                )
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            SushiIndicator(
                                dotCount = 7,
                                type = SushiIndicatorType.Spring(
                                    dotsGraphic = DotGraphic(
                                        color = Color.Gray,
                                        size = 8.dp
                                    ),
                                    selectorDotGraphic = DotGraphic(
                                        color = SushiTheme.colors.blue.v500.value,
                                        size = 8.dp
                                    )
                                ),
                                pagerState = pagerStateC
                            )
                        }
                    }

                    Spacer(Modifier.height(32.dp))
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun AutoScrollingPager(pagerState: androidx.compose.foundation.pager.PagerState, pageCount: Int = 5) {
    val scope = rememberCoroutineScope()

    // Auto-scroll effect
    LaunchedEffect(pagerState) {
        while (true) {
            delay(3000)
            if (pagerState.currentPage < pageCount - 1) {
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            } else {
                pagerState.animateScrollToPage(0)
            }
        }
    }

    SushiHorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) { page ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .background(
                    color = SushiTheme.colors.surface.secondary.value,
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            SushiText(
                props = SushiTextProps(
                    text = "Page ${page + 1}",
                    type = SushiTextType.Bold700,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Composable
@SushiPreview
private fun IndicatorsShowcaseScreenPreview() {
    AppTheme {
        IndicatorsShowcaseScreen()
    }
}