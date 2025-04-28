package com.zomato.sushi.compose.modifiers.shake

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import kotlin.math.roundToInt

/**
 * Create and remember a [ShakeController] instance that survives recompositions.
 *
 * @return A new [ShakeController] instance that is remembered across recompositions.
 */
@Composable
fun rememberShakeController(): ShakeController {
    return remember { ShakeController() }
}

/**
 * Controller for managing shake animations in a Composable.
 * Used to trigger shake animations with various configurations.
 */
class ShakeController {
    var shakeConfig: ShakeConfig? by mutableStateOf(null)
        private set

    fun shake(shakeConfig: ShakeConfig) {
        this.shakeConfig = shakeConfig
    }
}

/**
 * Configuration data class for shake animations.
 *
 * @property iterations The number of shake iterations to perform.
 * @property intensity The stiffness of the spring animation. Higher values result in faster, more aggressive shakes.
 * @property rotate Rotation angle for 2D rotation around the Z-axis.
 * @property rotateX Rotation angle for 3D rotation around the X-axis.
 * @property rotateY Rotation angle for 3D rotation around the Y-axis.
 * @property scaleX Scale factor for the X-axis during the shake animation.
 * @property scaleY Scale factor for the Y-axis during the shake animation.
 * @property translateX Translation distance along the X-axis.
 * @property translateY Translation distance along the Y-axis.
 */
data class ShakeConfig(
    val iterations: Int,
    val intensity: Float = 100_000f,
    val rotate: Float = 0f,
    val rotateX: Float = 0f,
    val rotateY: Float = 0f,
    val scaleX: Float = 0f,
    val scaleY: Float = 0f,
    val translateX: Float = 0f,
    val translateY: Float = 0f,
)

/**
 * Modifier extension that applies a shake animation to a Composable.
 * The animation is controlled by the provided [ShakeController].
 *
 * @param shakeController The controller that manages the shake animation state.
 * @return A modified [Modifier] with shake animation properties applied.
 */
@SuppressLint("ComposeModifierComposed")
fun Modifier.shake(shakeController: ShakeController) = composed {
    shakeController.shakeConfig?.let { shakeConfig ->
        val shake = remember { Animatable(0f) }
        LaunchedEffect(shakeController.shakeConfig) {
            for (i in 0..shakeConfig.iterations) {
                when (i % 2) {
                    0 -> shake.animateTo(1f, spring(stiffness = shakeConfig.intensity))
                    else -> shake.animateTo(-1f, spring(stiffness = shakeConfig.intensity))
                }
            }
            shake.animateTo(0f)
        }

        this
            .rotate(shake.value * shakeConfig.rotate)
            .graphicsLayer {
                rotationX = shake.value * shakeConfig.rotateX
                rotationY = shake.value * shakeConfig.rotateY
            }
            .scale(
                scaleX = 1f + (shake.value * shakeConfig.scaleX),
                scaleY = 1f + (shake.value * shakeConfig.scaleY),
            )
            .offset {
                IntOffset(
                    (shake.value * shakeConfig.translateX).roundToInt(),
                    (shake.value * shakeConfig.translateY).roundToInt(),
                )
            }
    } ?: this
}

@Composable
@SushiPreview
private fun ShakePreview1() {
    SushiPreview {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            val shakeController = remember { ShakeController() }
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .shake(shakeController = shakeController)
                    .border(2.dp, Color(0xFF79DD5D), RoundedCornerShape(5.dp))
                    .background(
                        color = Color(0xFF79DD5D).copy(alpha = .1f),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .clickable {
                        shakeController.shake(
                            ShakeConfig(
                                iterations = 4,
                                intensity = 1500f,
                                rotateX = -20f,
                                translateY = 20f,
                            )
                        )
                    }
                    .clip(RoundedCornerShape(5.dp))
                    .padding(horizontal = 24.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center,
            ) {
                SushiText(
                    SushiTextProps(
                        text = "Vertical Spring",
                        color = SushiTheme.colors.text.primary,
                        type = SushiTextType.Medium300
                    )
                )
            }
        }
    }
}

@Composable
@SushiPreview
private fun ShakePreview2() {
    SushiPreview {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            val shakeController = remember { ShakeController() }
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .shake(shakeController = shakeController)
                    .border(2.dp, Color(0xFFDD5D5D), RoundedCornerShape(5.dp))
                    .background(
                        color = Color(0xFFDD5D5D).copy(alpha = .1f),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .clickable {
                        shakeController.shake(
                            ShakeConfig(
                                iterations = 4,
                                intensity = 1500f,
                                rotateY = 15f,
                                translateX = 40f,
                            )
                        )
                    }
                    .clip(RoundedCornerShape(5.dp))
                    .padding(horizontal = 24.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center,
            ) {
                SushiText(
                    SushiTextProps(
                        text = "Horizontal Spring",
                        color = SushiTheme.colors.text.primary,
                        type = SushiTextType.Medium300
                    )
                )
            }
        }
    }
}

@Composable
@SushiPreview
private fun ShakePreview3() {
    SushiPreview {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            val shakeController = remember { ShakeController() }
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .shake(shakeController = shakeController)
                    .border(2.dp, Color(0xFF79DD5D), RoundedCornerShape(5.dp))
                    .background(
                        color = Color(0xFF79DD5D).copy(alpha = .1f),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .clickable {
                        shakeController.shake(
                            ShakeConfig(
                                iterations = 4,
                                intensity = 3000f,
                                translateY = 20f,
                            )
                        )
                    }
                    .clip(RoundedCornerShape(5.dp))
                    .padding(horizontal = 24.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center,
            ) {
                SushiText(
                    SushiTextProps(
                        text = "Vertical Normal",
                        color = SushiTheme.colors.text.primary,
                        type = SushiTextType.Medium300
                    )
                )
            }
        }
    }
}

@Composable
@SushiPreview
private fun ShakePreview4() {
    SushiPreview {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            val shakeController = remember { ShakeController() }
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .shake(shakeController = shakeController)
                    .border(2.dp, Color(0xFFDD5D5D), RoundedCornerShape(5.dp))
                    .background(
                        color = Color(0xFFDD5D5D).copy(alpha = .1f),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .clickable {
                        shakeController.shake(
                            ShakeConfig(
                                iterations = 4,
                                intensity = 10000f,
                                translateX = 40f,
                            )
                        )
                    }
                    .clip(RoundedCornerShape(5.dp))
                    .padding(horizontal = 24.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center,
            ) {
                SushiText(
                    SushiTextProps(
                        text = "Horizontal Normal",
                        color = SushiTheme.colors.text.primary,
                        type = SushiTextType.Medium300
                    )
                )
            }
        }
    }
}
