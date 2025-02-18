package com.zomato.sushi.compose.components.viewflipper

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.components.viewflipper.SushiViewFlipperDefaults.countOrDefault
import com.zomato.sushi.compose.components.viewflipper.SushiViewFlipperDefaults.flipAnimationDurationMsOrDefault
import com.zomato.sushi.compose.components.viewflipper.SushiViewFlipperDefaults.isPlayingOrDefault
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@Composable
fun SushiViewFlipper(
    props: SushiViewFlipperProps,
    modifier: Modifier = Modifier,
    onFlip: ((currentIdx: Int) -> Unit)? = null,
    item: @Composable (index: Int) -> Unit
) {
    SushiComponentBase(
        modifier
            .testTag("SushiViewFlipper")
            .width(IntrinsicSize.Max)
            .height(IntrinsicSize.Max)
    ) {
        SushiViewFlipperImpl(
            props,
            Modifier.fillMaxSize(),
            onFlip,
            item
        )
    }
}

@Composable
private fun SushiViewFlipperImpl(
    props: SushiViewFlipperProps,
    modifier: Modifier = Modifier,
    onFlip: ((currentIdx: Int) -> Unit)? = null,
    item: @Composable (index: Int) -> Unit
) {
    var currentShowingIdx by rememberSaveable { mutableIntStateOf(-1) }

    AnimatedContent(
        targetState = currentShowingIdx.takeIf { it >=0 } ?: 0,
        modifier = modifier
            .clipToBounds()
            .fillMaxSize(),
        transitionSpec = {
            when (props.animationDirection) {
                SushiViewFlipperProps.FlipAnimationDirection.FlipToBottom -> {
                    slideInVertically(animationSpec = tween((props.flipAnimationDurationMsOrDefault) / 2, (props.flipAnimationDurationMsOrDefault) / 2), initialOffsetY = { height -> -height }) togetherWith
                        slideOutVertically(animationSpec = tween((props.flipAnimationDurationMsOrDefault) / 2), targetOffsetY = { height -> height })
                }
                else -> {
                    slideInVertically(animationSpec = tween((props.flipAnimationDurationMsOrDefault) / 2, (props.flipAnimationDurationMsOrDefault) / 2), initialOffsetY = { height -> height }) togetherWith
                        slideOutVertically(animationSpec = tween((props.flipAnimationDurationMsOrDefault) / 2), targetOffsetY = { height -> -height })
                }
            }.using(SizeTransform(clip = false))
        }, label = "animated content"
    ) { targetCount ->
        Box(Modifier.fillMaxSize()) {
            if (targetCount <= props.countOrDefault) {
                item(targetCount)
            }
        }
    }
    // Update the count every second
    LaunchedEffect(
        props.flipInterval,
        props.isPlaying,
        props.animationDuration,
        props.count
    ) {
        while (props.isPlayingOrDefault) {
            currentShowingIdx = (currentShowingIdx + 1) % props.countOrDefault
            delay(props.flipInterval ?: SushiViewFlipperDefaults.flipIntervalMs)
            onFlip?.invoke(currentShowingIdx)
            yield()
        }
    }
}

@SushiPreview
@Composable
private fun SushiViewFlipperPreviewTest1() {
    SushiPreview {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var count by remember { mutableIntStateOf(10) }
            val sushiViewFlipperProps = SushiViewFlipperProps(
                animationDirection = SushiViewFlipperProps.FlipAnimationDirection.FlipToTop,
                count = count
            )
            SushiButton(
                SushiButtonProps("Change count"),
                onClick = {
                    count = 4
                }
            )
            SushiViewFlipper(
                sushiViewFlipperProps,
                Modifier
                    .background(Color.Red)
                    .padding(vertical = 12.dp, horizontal = 12.dp)
                    .background(Color.Blue),
                onFlip = {

                }
            ) { index ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SushiText(SushiTextProps(text = "We are not the same ${index}", color = SushiTheme.colors.text.default))
                    if (index % 2 == 0) {
                        SushiText(SushiTextProps(text = "Another Text", color = SushiTheme.colors.text.default))
                    }
                }
            }
        }
    }
}

@SushiPreview
@Composable
private fun SushiFlipperPreviewTest2() {
    SushiPreview {
        Box(Modifier.fillMaxSize()) {
            val items = persistentListOf(
                "Search for \"Pizza\"",
                "Search for \"Burger\"",
                "Search for \"Momos\"",
                "Search for \"Ice Cream\"",
                "Search for \"Chicken\""
            )
            val sushiViewFlipperProps = SushiViewFlipperProps(
                animationDirection = SushiViewFlipperProps.FlipAnimationDirection.FlipToTop,
                count = items.size
            )
            Row(
                Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .border(1.dp, SushiTheme.colors.border.success.value, RoundedCornerShape(10.dp))
                    .fillMaxWidth()
            ) {
                SushiViewFlipper(
                    sushiViewFlipperProps,
                    Modifier,
                    onFlip = {

                    }
                ) { index ->
                    SushiText(
                        SushiTextProps(
                            text = items[index],
                            color = SushiTheme.colors.text.default
                        ),
                        Modifier.padding(12.dp)
                    )
                }
            }
        }
    }
}
