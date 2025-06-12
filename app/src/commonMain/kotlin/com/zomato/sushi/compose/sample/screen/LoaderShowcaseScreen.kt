package com.zomato.sushi.compose.sample.screen

import com.zomato.sushi.compose.sample.snippets.AppTopBar
import kotlinx.serialization.Serializable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.loader.SushiLoader
import com.zomato.sushi.compose.atoms.loader.SushiLoaderProps
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme

@Serializable
object LoaderShowcaseScreen

@Composable
fun LoaderShowcaseScreen(
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
                    title = "Loader Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        start = SushiTheme.dimens.spacing.base,
                        end = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )

                // Column with all examples
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(SushiTheme.dimens.spacing.base)
                ) {
                    // 1. Default Loader
                    SectionTitle("Basic Loaders")
                    LoaderExample(
                        title = "1. Default Loader",
                        description = "Default size, colors and animation speed"
                    ) {
                        SushiLoader(
                            props = SushiLoaderProps()
                        )
                    }

                    // 2. Custom Size
                    LoaderExample(
                        title = "2. Custom Size",
                        description = "Loader with custom size"
                    ) {
                        SushiLoader(
                            props = SushiLoaderProps(),
                            modifier = Modifier.size(48.dp)
                        )
                    }

                    Spacer(Modifier.height(16.dp))

                    // 3-6. Custom Colors
                    SectionTitle("Custom Colors")

                    // 3. Custom outer color
                    LoaderExample(
                        title = "3. Custom Outer Color",
                        description = "Only the outer arc is customized"
                    ) {
                        SushiLoader(
                            props = SushiLoaderProps(
                                outerColor = SushiTheme.colors.blue.v500
                            )
                        )
                    }

                    // 4. Custom inner color
                    LoaderExample(
                        title = "4. Custom Inner Color",
                        description = "Only the inner arc is customized"
                    ) {
                        SushiLoader(
                            props = SushiLoaderProps(
                                innerColor = SushiTheme.colors.green.v500
                            )
                        )
                    }

                    // 5. Different colors for inner and outer arcs
                    LoaderExample(
                        title = "5. Different Colors",
                        description = "Different colors for inner and outer arcs"
                    ) {
                        SushiLoader(
                            props = SushiLoaderProps(
                                outerColor = SushiTheme.colors.blue.v500,
                                innerColor = SushiTheme.colors.green.v500
                            )
                        )
                    }

                    // 6. Using ColorData
                    LoaderExample(
                        title = "6. Using ColorData",
                        description = "Colors defined using ColorData"
                    ) {
                        SushiLoader(
                            props = SushiLoaderProps(
                                outerColor = SushiColorData(ColorName.Purple, ColorVariation.Variation500),
                                innerColor = SushiColorData(ColorName.Orange, ColorVariation.Variation500)
                            )
                        )
                    }

                    Spacer(Modifier.height(16.dp))

                    // 7-10. Animation Speed
                    SectionTitle("Animation Speed")

                    // 7. Slow animation
                    LoaderExample(
                        title = "7. Slow Animation",
                        description = "Animation speed multiplier: 0.5x"
                    ) {
                        SushiLoader(
                            props = SushiLoaderProps(
                                animationSpeedMultiplier = 0.5f
                            )
                        )
                    }

                    // 8. Default animation speed
                    LoaderExample(
                        title = "8. Default Animation Speed",
                        description = "Animation speed multiplier: 1.0x (default)"
                    ) {
                        SushiLoader(
                            props = SushiLoaderProps(
                                animationSpeedMultiplier = 1.0f
                            )
                        )
                    }

                    // 9. Fast animation
                    LoaderExample(
                        title = "9. Fast Animation",
                        description = "Animation speed multiplier: 2.0x"
                    ) {
                        SushiLoader(
                            props = SushiLoaderProps(
                                animationSpeedMultiplier = 2.0f
                            )
                        )
                    }

                    // 10. Extra fast animation
                    LoaderExample(
                        title = "10. Extra Fast Animation",
                        description = "Animation speed multiplier: 3.0x"
                    ) {
                        SushiLoader(
                            props = SushiLoaderProps(
                                animationSpeedMultiplier = 3.0f
                            )
                        )
                    }

                    Spacer(Modifier.height(16.dp))

                    // 11-14. Inner Angle Offset
                    SectionTitle("Inner Angle Offset")

                    // 11. Small inner angle offset
                    LoaderExample(
                        title = "11. Small Inner Angle Offset",
                        description = "Inner angle offset: 45 degrees"
                    ) {
                        SushiLoader(
                            props = SushiLoaderProps(
                                innerAngleOffset = 45f
                            )
                        )
                    }

                    // 12. Default inner angle offset
                    LoaderExample(
                        title = "12. Default Inner Angle Offset",
                        description = "Inner angle offset: 180 degrees (default)"
                    ) {
                        SushiLoader(
                            props = SushiLoaderProps(
                                innerAngleOffset = 180f
                            )
                        )
                    }

                    // 13. Large inner angle offset
                    LoaderExample(
                        title = "13. Large Inner Angle Offset",
                        description = "Inner angle offset: 270 degrees"
                    ) {
                        SushiLoader(
                            props = SushiLoaderProps(
                                innerAngleOffset = 270f
                            )
                        )
                    }

                    // 14. No inner angle offset
                    LoaderExample(
                        title = "14. No Inner Angle Offset",
                        description = "Inner angle offset: 0 degrees"
                    ) {
                        SushiLoader(
                            props = SushiLoaderProps(
                                innerAngleOffset = 0f
                            )
                        )
                    }

                    Spacer(Modifier.height(16.dp))

                    // 15-20. Combinations and Use Cases
                    SectionTitle("Combinations & Use Cases")

                    // 15. Brand colors with custom angle
                    LoaderExample(
                        title = "15. Brand Loading",
                        description = "Zomato red colors with custom angle"
                    ) {
                        SushiLoader(
                            props = SushiLoaderProps(
                                innerAngleOffset = 90f,
                                outerColor = SushiColorData(ColorName.Red, ColorVariation.Variation600),
                                innerColor = SushiColorData(ColorName.Red, ColorVariation.Variation400)
                            )
                        )
                    }

                    // 16. Contrasting colors with fast animation
                    LoaderExample(
                        title = "16. High Contrast & Fast",
                        description = "Contrasting colors with fast animation"
                    ) {
                        SushiLoader(
                            props = SushiLoaderProps(
                                outerColor = SushiTheme.colors.black,
                                innerColor = SushiTheme.colors.white,
                                animationSpeedMultiplier = 2.0f
                            )
                        )
                    }

                    // 17. Tiny loader for inline use
                    LoaderExample(
                        title = "17. Tiny Inline Loader",
                        description = "Small size for inline usage"
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "Loading",
                                    type = SushiTextType.Regular400
                                )
                            )
                            Spacer(Modifier.width(8.dp))
                            SushiLoader(
                                props = SushiLoaderProps(),
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }

                    // 18. Button with loader
                    LoaderExample(
                        title = "18. Button With Loader",
                        description = "Loader integrated in a button"
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                                .background(SushiTheme.colors.blue.v500.value, RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                SushiText(
                                    props = SushiTextProps(
                                        text = "Submitting",
                                        type = SushiTextType.Medium500,
                                        color = SushiTheme.colors.white
                                    )
                                )
                                Spacer(Modifier.width(8.dp))
                                SushiLoader(
                                    props = SushiLoaderProps(
                                        outerColor = SushiTheme.colors.white,
                                        innerColor = SushiTheme.colors.white,
                                        animationSpeedMultiplier = 1.5f
                                    ),
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    }

                    // 19. Center aligned large loader
                    LoaderExample(
                        title = "19. Full Screen Loader",
                        description = "Large centered loader for page loading"
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            SushiLoader(
                                props = SushiLoaderProps(
                                    animationSpeedMultiplier = 1.2f
                                ),
                                modifier = Modifier.size(64.dp)
                            )
                        }
                    }

                    // 20. Success state transition
                    LoaderExample(
                        title = "20. Success State Colors",
                        description = "Green colors to indicate success state"
                    ) {
                        SushiLoader(
                            props = SushiLoaderProps(
                                outerColor = SushiTheme.colors.green.v600,
                                innerColor = SushiTheme.colors.green.v300,
                                animationSpeedMultiplier = 1.5f,
                                innerAngleOffset = 135f
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun LoaderExample(
    title: String,
    description: String,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        SushiText(
            props = SushiTextProps(
                text = title,
                type = SushiTextType.SemiBold600,
                color = SushiTheme.colors.text.primary
            )
        )
        SushiText(
            props = SushiTextProps(
                text = description,
                type = SushiTextType.Regular400,
                color = SushiTheme.colors.text.secondary
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .background(
                    color = SushiTheme.colors.surface.secondary.value,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            content()
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
@SushiPreview
private fun LoaderShowcaseScreenPreview() {
    AppTheme {
        LoaderShowcaseScreen()
    }
}
