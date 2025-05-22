package com.zomato.sushi.compose.sample.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.animation.LottieAssetSource
import com.zomato.sushi.compose.atoms.animation.LottieCompositionSource
import com.zomato.sushi.compose.atoms.animation.SushiAnimation
import com.zomato.sushi.compose.atoms.animation.SushiAnimationPlayback
import com.zomato.sushi.compose.atoms.animation.rememberSushiAnimationProps
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import kotlinx.serialization.Serializable

@Serializable
object AnimationShowcaseScreen

@Composable
fun AnimationShowcaseScreen(
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
            ) {
                AppTopBar(
                    title = "Animation Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        start = SushiTheme.dimens.spacing.base,
                        end = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )
                Column(
                    Modifier
                        .verticalScroll(rememberScrollState())
                        .fillMaxWidth()
                        .padding(SushiTheme.dimens.spacing.base)
                ) {
                    SectionTitle("1. Auto Play Animation")
                    SushiAnimation(
                        rememberSushiAnimationProps(
                            source = LottieAssetSource("collection_lottie.json"),
                            playback = SushiAnimationPlayback.AutoPlay(
                                isPlaying = true,
                                restartOnPlay = true,
                                reverseOnRepeat = false,
                                speed = 1f,
                                iterations = 10
                            )
                        ).value
                    )

                    SectionTitle("2. Custom Progress Animation (Lottie Composition)")
                    CustomProgressAnimation()

                    SectionTitle("3. Custom Progress Animation (Duration Control)")

                    val durationMs = 1650 / 2
                    var targetValue by remember { mutableFloatStateOf(0f) }

                    val progress by animateFloatAsState(
                        targetValue = targetValue,
                        animationSpec = tween(durationMs),
                        label = "keyframe",
                        finishedListener = {
                            targetValue = 1 - targetValue
                        }
                    )

                    LaunchedEffect(Unit) {
                        targetValue = 1f
                    }

                    val props by rememberSushiAnimationProps(
                        source = LottieAssetSource("collection_lottie.json"),
                        playback = SushiAnimationPlayback.Progress { progress }
                    )

                    SushiAnimation(props)
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
internal expect fun CustomProgressAnimation(modifier: Modifier = Modifier)

@Composable
@SushiPreview
private fun AnimationShowcaseScreenPreview() {
    AppTheme {
        AnimationShowcaseScreen()
    }
}
