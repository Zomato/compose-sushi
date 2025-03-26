package com.zomato.sushi.compose.atoms.shimmer

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview

/**
 * A composable that displays a shimmer loading effect over placeholder content.
 * 
 * SushiShimmer creates a shimmering animation effect typically used to indicate
 * loading states in UI. It provides a scope that allows creating shimmer effects
 * over custom shapes and text elements.
 * 
 * Usage example:
 * ```
 * SushiShimmer(SushiShimmerProps()) {
 *   Row(Modifier.fillMaxWidth()) {
 *     // A circular shimmer item
 *     ShimmerItem(Modifier.size(50.dp).clip(CircleShape))
 *     
 *     // A rectangular shimmer item
 *     ShimmerItem(Modifier.fillMaxWidth().height(20.dp))
 *   }
 * }
 * ```
 *
 * @param props The properties to configure the shimmer appearance and behavior
 * @param modifier The modifier to be applied to the component
 * @param shimmerContent The content to display with the shimmer effect, using
 *                      functions provided by the SushiShimmerScope
 */
@Composable
fun SushiShimmer(
    props: SushiShimmerProps,
    modifier: Modifier = Modifier,
    shimmerContent: @Composable SushiShimmerScope.() -> Unit
) {
    SushiComponentBase(
        modifier
            .testTag("SushiShimmer")
            .width(IntrinsicSize.Max)
            .height(IntrinsicSize.Max)
    ) {
        SushiShimmerImpl(
            props,
            modifier,
            shimmerContent
        )
    }
}

@SuppressLint("ComposeModifierReused")
@Composable
private fun SushiShimmerImpl(
    props: SushiShimmerProps,
    modifier: Modifier = Modifier,
    shimmerContent: (@Composable SushiShimmerScope.() -> Unit)
) {
    val bgColor = props.bgColor?.value ?: SushiShimmerDefaults.bgColor.value
    val animationColor = props.animationColor?.value ?: SushiShimmerDefaults.animationColor.value
    val animationWidth = props.animationWidth?.dp?.value ?: SushiShimmerDefaults.WIDTH
    val angleOffset = props.angleOffset?.dp?.value ?: SushiShimmerDefaults.ANGLE_OFFSET
    val animationDuration = props.animationDuration ?: SushiShimmerDefaults.ANIMATION_DURATION
    val animationDelay = props.animationDelay ?: SushiShimmerDefaults.ANIMATION_DELAY

    val shimmerColors = listOf(
        bgColor,
        animationColor,
        bgColor
    )

    val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")

    val shimmerProgress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = (animationDuration + animationWidth),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = animationDuration,
                easing = LinearEasing,
                delayMillis = animationDelay
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "translation"
    )

    val brush by rememberUpdatedState(
        Brush.linearGradient(
            colors = shimmerColors,
            start = Offset(x = shimmerProgress - animationWidth, y = 0f),
            end = Offset(x = shimmerProgress, y = angleOffset)
        )
    )

    val shimmerScope = remember {
        object : SushiShimmerScope {
            @Composable
            override fun ShimmerItem(modifier: Modifier) {
                Box(modifier = modifier.background(brush))
            }

            @Composable
            override fun ShimmerText(sushiTextProps: SushiTextProps, modifier: Modifier) {
                SushiText(
                    props = sushiTextProps.copy(textBrush = brush),
                    modifier = modifier
                )
            }
        }
    }

    Box(modifier) {
        shimmerScope.shimmerContent()
    }
}

@SushiPreview
@Composable
private fun SushiShimmerPreview1() {
    SushiPreview {
        SushiShimmer(
            SushiShimmerProps(),
            Modifier.fillMaxWidth()
        ) {
            Row(
                Modifier.fillMaxWidth().padding(12.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                repeat(4) {
                    ShimmerItem(
                        Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                    )
                }
            }
        }
    }
}

@SushiPreview
@Composable
private fun SushiShimmerPreview2() {
    SushiPreview {
        SushiShimmer(
            SushiShimmerProps(),
            Modifier.fillMaxWidth()
        ) {
            Row {
                ShimmerItem(
                    Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@SushiPreview
@Composable
private fun SushiShimmerPreview3() {
    SushiPreview {
        SushiShimmer(
            SushiShimmerProps(),
            Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(12.dp),
                horizontalArrangement = Arrangement.spacedBy(
                    space = 16.dp,
                    alignment = Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ShimmerItem(
                    Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                )
                Column(
                    modifier = Modifier
                        .weight(0.7f)
                        .height(150.dp),
                    verticalArrangement = Arrangement.spacedBy(
                        space = 16.dp,
                        alignment = Alignment.CenterVertically
                    )
                ) {
                    ShimmerText(
                        sushiTextProps = SushiTextProps(
                            text = "Reduce food wastage",
                            type = SushiTextType.SemiBold400,
                            color = SushiTheme.colors.text.disabled,
                            verticalAlignment = Alignment.CenterVertically
                        ),
                        modifier = Modifier
                            .height(40.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                    )
                    ShimmerItem(
                        Modifier
                            .height(40.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                    )
                }
            }
        }
    }
}
