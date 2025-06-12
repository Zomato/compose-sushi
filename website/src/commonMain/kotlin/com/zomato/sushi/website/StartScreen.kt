package com.zomato.sushi.website

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.button.SushiButtonSize
import com.zomato.sushi.compose.atoms.button.SushiButtonType
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.atoms.text.transform
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.website.components.HeaderLogo
import com.zomato.sushi.website.components.HeaderOption
import composesushi.website.generated.resources.Res
import composesushi.website.generated.resources.apps
import composesushi.website.generated.resources.background
import composesushi.website.generated.resources.background_effect
import composesushi.website.generated.resources.eternal_logo
import composesushi.website.generated.resources.github_icon
import composesushi.website.generated.resources.modular_design_icon
import composesushi.website.generated.resources.performance_icon
import composesushi.website.generated.resources.themeable_icon
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Serializable
@SerialName("start")
data object StartScreenProps

@Composable
fun StartScreen(
    props: StartScreenProps,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .safeContentPadding()
            .fillMaxSize(),
    ) {
        Image(
            painterResource(Res.drawable.background),
            null,
            Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillHeight
        )
        Image(
            painterResource(Res.drawable.background_effect),
            null,
            Modifier
                .fillMaxWidth(0.4f)
                .alpha(0.4f)
                .align(Alignment.TopEnd),
            contentScale = ContentScale.FillWidth
        )
        Column(
            Modifier
                .align(Alignment.Center)
        ) {
            StartScreenContent(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 12.dp)
                    .widthIn(max = 1200.dp)
                    .fillMaxWidth()
                    .weight(1f)
            )
            Footer(
                maxWidth = 1200.dp,
                Modifier
                    .fillMaxWidth()
            )
        }
    }
}

private data class Highlight(
    val title: String,
    val description: String,
    val icon: DrawableResource
)

private val listOfHighlights = listOf(
    Highlight(title = "Modular design", description = "Build with flexible, reusable components.", icon = Res.drawable.modular_design_icon),
    Highlight(title = "Themeable", description = "Easily adapt to any brand or style.", icon = Res.drawable.themeable_icon),
    Highlight(title = "High performance", description = "Designed for speed and smooth experiences.", icon = Res.drawable.performance_icon),
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun StartScreenContent(
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        WebHeader(
            Modifier
                .padding(vertical = 28.dp)
                .fillMaxWidth()
        )
        Column(
            Modifier
                .verticalScroll(
                    rememberScrollState()
                )
                .fillMaxSize()
        ) {
            IntroBanner()
            Header(
                "Core Features",
                Modifier
                    .padding(
                        top = 120.dp,
                        bottom = 32.dp
                    )
            )
            val maxItemWidth = 280.dp
            Grid(
                itemCount = listOfHighlights.size,
                maxItemWidth = maxItemWidth,
                betweenSpace = 48.dp,
                maxItemsInEachRow = 3,
                content = { idx ->
                    val highlight = listOfHighlights[idx]
                    HightlightCard(
                        painterResource(highlight.icon),
                        title = highlight.title,
                        description = highlight.description,
                        Modifier
                            .fillMaxRowHeight(1f)
                            .weight(1f)
                            .widthIn(max = maxItemWidth)
                    )
                }
            )
            Header(
                "Components",
                Modifier
                    .padding(
                        top = 120.dp,
                        bottom = 32.dp
                    )
            )
            Grid(
                itemCount = listOfComponents.size,
                maxItemWidth = maxItemWidth,
                betweenSpace = 48.dp,
                maxItemsInEachRow = 3,
                content = { idx ->
                    val navController = LocalNavController.current
                    val component = listOfComponents[idx]
                    ComponentCard(
                        image = painterResource(component.banner),
                        title = component.title,
                        description = component.shortDescription,
                        onClick = {
                            navController.navigate(
                                DetailScreenProps(
                                    componentId = component.id
                                )
                            )
                        },
                        Modifier
                            .fillMaxRowHeight(1f)
                            .weight(1f)
                            .widthIn(max = maxItemWidth)
                    )
                }
            )
            Spacer(
                Modifier
                    .fillMaxWidth()
                    .height(160.dp)
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun Grid(
    itemCount: Int,
    maxItemWidth: Dp,
    betweenSpace: Dp,
    maxItemsInEachRow: Int,
    content: @Composable FlowRowScope.(idx: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier
    ) {
        val noOfItemsInRow = remember(this.maxWidth) {
            ((this.maxWidth + betweenSpace) / (maxItemWidth + betweenSpace)).toInt().coerceIn(1, maxItemsInEachRow)
        }
        FlowRow(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(betweenSpace),
            verticalArrangement = Arrangement.spacedBy(betweenSpace),
            maxItemsInEachRow = maxItemsInEachRow
        ) {
            repeat(itemCount) { index ->
                content(index)
            }
            val noOfPlaceholders = (noOfItemsInRow - (listOfComponents.size % noOfItemsInRow)) % noOfItemsInRow
            repeat(noOfPlaceholders) {
                Box(
                    Modifier
                        .fillMaxRowHeight(1f)
                        .weight(1f)
                        .widthIn(max = maxItemWidth)
                )
            }
        }
    }
}

@Composable
private fun Footer(
    maxWidth: Dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .background(SushiTheme.colors.grey.v100.value)
    ) {
        Column(
            Modifier
                .align(Alignment.Center)
                .padding(vertical = 16.dp, horizontal = 12.dp)
                .widthIn(max = maxWidth)
                .fillMaxWidth()
        ) {
            Image(
                painterResource(Res.drawable.eternal_logo),
                contentDescription = null,
                Modifier.height(20.dp)
            )
            WebText(
                SushiTextProps(text = "© 2025 Eternal Ltd."),
                Modifier.padding(top = 12.dp)
            )
        }
    }
}

@Composable
private fun ComponentCard(
    image: Painter,
    title: String,
    description: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                onClick()
            }
            .pointerHoverIcon(PointerIcon.Hand)
            .border(1.dp, SushiTheme.colors.grey.v300.value, RoundedCornerShape(8.dp))
            .background(SushiTheme.colors.white.value, RoundedCornerShape(8.dp))
    ) {
        Box(
            Modifier
                .background(SushiTheme.colors.grey.v100.value)
                .fillMaxWidth()
                .height(183.dp)
        ) {
            Image(
                painter = image,
                contentDescription = null,
                Modifier
                    .padding(SushiTheme.dimens.spacing.loose)
                    .align(Alignment.Center)
            )
        }
        Spacer(
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(SushiTheme.colors.grey.v300.value)
        )
        WebText(
            SushiTextProps(
                text = title,
                type = SushiTextType.Bold700
            ),
            Modifier.padding(
                top = SushiTheme.dimens.spacing.loose,
                start = SushiTheme.dimens.spacing.loose,
                end = SushiTheme.dimens.spacing.loose
            )
        )
        WebText(
            SushiTextProps(
                text = description,
                type = SushiTextType.Regular600,
                color = SushiTheme.colors.grey.v800
            ),
            Modifier.padding(
                top = SushiTheme.dimens.spacing.extra,
                start = SushiTheme.dimens.spacing.loose,
                end = SushiTheme.dimens.spacing.loose,
                bottom = SushiTheme.dimens.spacing.loose
            )
        )
    }
}

@Composable
private fun HightlightCard(
    icon: Painter,
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .widthIn(max = 360.dp)
            .border(1.dp, SushiTheme.colors.grey.v300.value, RoundedCornerShape(8.dp))
            .background(SushiTheme.colors.white.value, RoundedCornerShape(8.dp))
            .padding(SushiTheme.dimens.spacing.loose)
    ) {
        Image(
            painter = icon, contentDescription = null,
            Modifier.height(48.dp)
        )
        WebText(
            SushiTextProps(
                text = title,
                type = SushiTextType.Bold700
            ),
            Modifier.padding(top = SushiTheme.dimens.spacing.loose)
        )
        WebText(
            SushiTextProps(
                text = description,
                type = SushiTextType.Regular600,
                color = SushiTheme.colors.grey.v800
            ),
            Modifier.padding(top = SushiTheme.dimens.spacing.extra)
        )
    }
}

@Composable
private fun Header(
    title: String,
    modifier: Modifier = Modifier
) {
    WebText(
        SushiTextProps(text = title, type = SushiTextType.Bold900),
        modifier
    )
}

@Composable
private fun WebHeader(
    modifier: Modifier = Modifier
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        HeaderLogo()
        Spacer(Modifier.weight(1f))
        HeaderOption(
            text = "Github",
            prefixImageRes = Res.drawable.github_icon,
            Modifier.padding(start = 48.dp)
        )
    }
}

@Composable
private fun IntroBanner(
    modifier: Modifier = Modifier
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            Modifier.weight(1f)
        ) {
            WebText(
                SushiTextProps(
                    text = "Build better with Sushi",
                    type = SushiTextType.Bold900.transform {
                        it.copy(fontSize = 72.sp)
                    },
                )
            )
            WebText(
                SushiTextProps(
                    text = "Sushi brings you a fresh, reusable UI experience - designed to roll beautifully across Android. Support for Web, iOS, and more coming soon.",
                    type = SushiTextType.Regular400
                ),
                Modifier.padding(top = 44.dp)
            )
            FlowRow(
                Modifier.padding(top = 44.dp),
                horizontalArrangement = Arrangement.spacedBy(SushiTheme.dimens.spacing.base),
                verticalArrangement = Arrangement.spacedBy(SushiTheme.dimens.spacing.base)
            ) {
                SushiButton(
                    SushiButtonProps(
                        text = "Get started",
                        type = SushiButtonType.Solid,
                        size = SushiButtonSize.Large
                    ),
                    onClick = {

                    }
                )
                SushiButton(
                    SushiButtonProps(
                        text = "View on GitHub",
                        type = SushiButtonType.Outline,
                        size = SushiButtonSize.Large
                    ),
                    onClick = {

                    }
                )
            }
            WebText(
                SushiTextProps(
                    text = "_Note: Currently Sushi is in alpha stage. APIs are subjected to change._",
                    color = SushiTheme.colors.grey.v600
                ),
                Modifier.padding(top = 48.dp)
            )
        }
        Image(
            painterResource(Res.drawable.apps),
            contentDescription = null,
            Modifier.weight(1f)
        )
    }
}
