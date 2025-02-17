package com.zomato.sushi.compose.components.ratingbar

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.R
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.modifiers.clip.clipStart
import com.zomato.sushi.compose.modifiers.scaleonpress.rememberScaleOnPressState
import com.zomato.sushi.compose.modifiers.scaleonpress.scaleOnPress
import com.zomato.sushi.compose.modifiers.scaleonpress.scaleOnPressAnchor

/**
 * @author gupta.anirudh@zomato.com
 */
@Composable
fun SushiRatingBar(
    props: SushiRatingBarProps,
    onRatingChange: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    SushiComponentBase(
        modifier
            .testTag("SushiRatingBar")
            .height(IntrinsicSize.Max)
            .width(IntrinsicSize.Max)
            .height(SushiRatingBarDefaults.startSize)
    ) {
        SushiRatingBarImpl(
            props,
            onRatingChange,
            modifier.fillMaxSize(),
        )
    }
}

@Composable
private fun SushiRatingBarImpl(
    props: SushiRatingBarProps,
    onRatingChange: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        val rating = props.rating ?: 0f
        val starCount = props.starCount ?: SushiRatingBarDefaults.starCount
        for (i in 0 until starCount) {
            val spacing = props.betweenSpacing?.let { it / 2 } ?: (SushiRatingBarDefaults.betweenSpacing / 2)
            val scaleOnPressState by rememberScaleOnPressState()

            val filledPercentage = when {
                i < rating.toInt() -> 1f
                i == rating.toInt() -> rating - rating.toInt()
                else -> 0f
            }

            Spacer(
                Modifier
                    .width(if (i == 0) 0.dp else spacing)
                    .clickable {
                        onRatingChange(i + 1f)
                    }
                    .scaleOnPressAnchor(scaleOnPressState)
            )
            Star(
                filledPercentage,
                Modifier
                    .scaleOnPressAnchor(scaleOnPressState)
                    .scaleOnPress(scaleOnPressState)
                    .clickable {
                        onRatingChange(i + 1f)
                    }
                    .fillMaxHeight()
                    .weight(1f)
            )
            Spacer(
                Modifier
                    .width(if (i == starCount - 1) 0.dp else spacing)
                    .clickable {
                        onRatingChange(i + 1f)
                    }
                    .scaleOnPressAnchor(scaleOnPressState)
            )
        }
    }
}

@Composable
private fun Star(
    filledPercentage: Float,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Image(
            painterResource(R.drawable.sushi_rating_star_outline),
            contentDescription = null,
            Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .align(Alignment.Center)
        )
        Image(
            painterResource(R.drawable.sushi_rating_star),
            contentDescription = null,
            Modifier
                .clipStart(filledPercentage)
                .fillMaxHeight()
                .aspectRatio(1f)
                .align(Alignment.Center)
        )
    }
}

@SuppressLint("ComposeModifierMissing")
@SushiPreview
@Composable
private fun SushiRatingBarPreview1() {
    SushiPreview {
        var rating by remember { mutableFloatStateOf(3f) }
        SushiRatingBar(
            SushiRatingBarProps(
                rating = rating,
                betweenSpacing = 6.dp
            ),
            onRatingChange = {
                rating = it
            }
        )
    }
}

@SuppressLint("ComposeModifierMissing")
@SushiPreview
@Composable
private fun SushiRatingBarPreview2() {
    SushiPreview {
        var rating by remember { mutableFloatStateOf(2.5f) }
        SushiRatingBar(
            SushiRatingBarProps(
                rating
            ),
            onRatingChange = {
                rating = it
            },
            Modifier.height(50.dp)
        )
    }
}

@SuppressLint("ComposeModifierMissing")
@SushiPreview
@Composable
private fun SushiRatingBarPreview3() {
    SushiPreview {
        var rating by remember { mutableFloatStateOf(3f) }
        SushiRatingBar(
            props = SushiRatingBarProps(
                rating = rating,
                betweenSpacing = 15.dp,
                starCount = 4
            ),
            onRatingChange = {
                rating = it
            },
            Modifier.height(30.dp).width(120.dp)
        )
    }
}
