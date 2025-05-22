package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.components.ratingbar.SushiRatingBar
import com.zomato.sushi.compose.components.ratingbar.SushiRatingBarProps
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import kotlinx.serialization.Serializable

@Serializable
object RatingBarShowcaseScreen

@Composable
fun RatingBarShowcaseScreen(
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
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 24.dp)
            ) {
                AppTopBar(
                    title = "RatingBar Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )

                // 1. Basic Rating Bar
                SectionTitle("1. Basic Rating Bar")
                var rating1 by remember { mutableFloatStateOf(3.5f) }
                SushiRatingBar(
                    props = SushiRatingBarProps(
                        rating = rating1
                    ),
                    onRatingChange = { rating1 = it }
                )
                RatingValueText(rating1)

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Custom Star Count (3 stars)
                SectionTitle("2. Custom Star Count (3 stars)")
                var rating2 by remember { mutableFloatStateOf(2f) }
                SushiRatingBar(
                    props = SushiRatingBarProps(
                        rating = rating2,
                        starCount = 3
                    ),
                    onRatingChange = { rating2 = it }
                )
                RatingValueText(rating2)

                Spacer(modifier = Modifier.height(24.dp))

                // 3. Custom Star Count (10 stars)
                SectionTitle("3. Custom Star Count (10 stars)")
                var rating3 by remember { mutableFloatStateOf(7.5f) }
                SushiRatingBar(
                    props = SushiRatingBarProps(
                        rating = rating3,
                        starCount = 10
                    ),
                    onRatingChange = { rating3 = it }
                )
                RatingValueText(rating3)

                Spacer(modifier = Modifier.height(24.dp))

                // 4. Custom Spacing (No spacing)
                SectionTitle("4. Custom Spacing (No spacing)")
                var rating4 by remember { mutableFloatStateOf(4f) }
                SushiRatingBar(
                    props = SushiRatingBarProps(
                        rating = rating4,
                        betweenSpacing = 0.dp
                    ),
                    onRatingChange = { rating4 = it }
                )
                RatingValueText(rating4)

                Spacer(modifier = Modifier.height(24.dp))

                // 5. Custom Spacing (Wide spacing)
                SectionTitle("5. Custom Spacing (Wide spacing)")
                var rating5 by remember { mutableFloatStateOf(3f) }
                SushiRatingBar(
                    props = SushiRatingBarProps(
                        rating = rating5,
                        betweenSpacing = 16.dp
                    ),
                    onRatingChange = { rating5 = it }
                )
                RatingValueText(rating5)

                Spacer(modifier = Modifier.height(24.dp))

                // 6. Custom Color (Red)
                SectionTitle("6. Custom Color (Red)")
                var rating6 by remember { mutableFloatStateOf(3.5f) }
                SushiRatingBar(
                    props = SushiRatingBarProps(
                        rating = rating6,
                        tintColor = SushiTheme.colors.red.v500
                    ),
                    onRatingChange = { rating6 = it }
                )
                RatingValueText(rating6)

                Spacer(modifier = Modifier.height(24.dp))

                // 7. Custom Color (Gold)
                SectionTitle("7. Custom Color (Gold)")
                var rating7 by remember { mutableFloatStateOf(4f) }
                SushiRatingBar(
                    props = SushiRatingBarProps(
                        rating = rating7,
                        tintColor = SushiColorData(ColorName.Yellow, ColorVariation.Variation600)
                    ),
                    onRatingChange = { rating7 = it }
                )
                RatingValueText(rating7)

                Spacer(modifier = Modifier.height(24.dp))

                // 8. Zero Rating
                SectionTitle("8. Zero Rating")
                var rating8 by remember { mutableFloatStateOf(0f) }
                SushiRatingBar(
                    props = SushiRatingBarProps(
                        rating = rating8
                    ),
                    onRatingChange = { rating8 = it }
                )
                RatingValueText(rating8)

                Spacer(modifier = Modifier.height(24.dp))

                // 9. Full Rating
                SectionTitle("9. Full Rating")
                var rating9 by remember { mutableFloatStateOf(5f) }
                SushiRatingBar(
                    props = SushiRatingBarProps(
                        rating = rating9
                    ),
                    onRatingChange = { rating9 = it }
                )
                RatingValueText(rating9)

                Spacer(modifier = Modifier.height(24.dp))

                // 10. Precise Half Star
                SectionTitle("10. Precise Half Star")
                var rating10 by remember { mutableFloatStateOf(2.5f) }
                SushiRatingBar(
                    props = SushiRatingBarProps(
                        rating = rating10
                    ),
                    onRatingChange = { rating10 = it }
                )
                RatingValueText(rating10)

                Spacer(modifier = Modifier.height(24.dp))

                // 11. Custom Fractional Rating
                SectionTitle("11. Custom Fractional Rating")
                var rating11 by remember { mutableFloatStateOf(3.7f) }
                SushiRatingBar(
                    props = SushiRatingBarProps(
                        rating = rating11
                    ),
                    onRatingChange = { rating11 = it }
                )
                RatingValueText(rating11)

                Spacer(modifier = Modifier.height(24.dp))

                // 12. Large Size Rating Bar
                SectionTitle("12. Large Size Rating Bar")
                var rating12 by remember { mutableFloatStateOf(4.5f) }
                SushiRatingBar(
                    props = SushiRatingBarProps(
                        rating = rating12
                    ),
                    onRatingChange = { rating12 = it },
                    modifier = Modifier.height(48.dp)
                )
                RatingValueText(rating12)

                Spacer(modifier = Modifier.height(24.dp))

                // 13. Small Size Rating Bar
                SectionTitle("13. Small Size Rating Bar")
                var rating13 by remember { mutableFloatStateOf(3f) }
                SushiRatingBar(
                    props = SushiRatingBarProps(
                        rating = rating13
                    ),
                    onRatingChange = { rating13 = it },
                    modifier = Modifier.height(24.dp)
                )
                RatingValueText(rating13)

                Spacer(modifier = Modifier.height(24.dp))

                // 14. Custom Width Rating Bar
                SectionTitle("14. Custom Width Rating Bar")
                var rating14 by remember { mutableFloatStateOf(3f) }
                SushiRatingBar(
                    props = SushiRatingBarProps(
                        rating = rating14
                    ),
                    onRatingChange = { rating14 = it },
                    modifier = Modifier.width(200.dp)
                )
                RatingValueText(rating14)

                Spacer(modifier = Modifier.height(24.dp))

                // 15. Read-Only Rating Bar
                SectionTitle("15. Read-Only Rating Bar")
                val rating15 = 4.2f
                SushiRatingBar(
                    props = SushiRatingBarProps(
                        rating = rating15
                    ),
                    onRatingChange = { /* Do nothing - read only */ }
                )
                RatingValueText(rating15, true)

                Spacer(modifier = Modifier.height(24.dp))

                // 16. Rating Bar in Card
                SectionTitle("16. Rating Bar in Card")
                var rating16 by remember { mutableFloatStateOf(4.5f) }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = SushiTheme.colors.surface.secondary.value
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        SushiText(
                            props = SushiTextProps(
                                text = "Restaurant Rating",
                                type = SushiTextType.Medium500
                            )
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        SushiRatingBar(
                            props = SushiRatingBarProps(
                                rating = rating16,
                                tintColor = SushiColorData(ColorName.Yellow, ColorVariation.Variation500)
                            ),
                            onRatingChange = { rating16 = it }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        SushiText(
                            props = SushiTextProps(
                                text = rating16.toString(),
                                type = SushiTextType.Bold600
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 17. Rating Bar with Label
                SectionTitle("17. Rating Bar with Label")
                var rating17 by remember { mutableFloatStateOf(2.5f) }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SushiText(
                        props = SushiTextProps(
                            text = "Your Rating: ",
                            type = SushiTextType.Medium500
                        )
                    )

                    SushiRatingBar(
                        props = SushiRatingBarProps(
                            rating = rating17
                        ),
                        onRatingChange = { rating17 = it }
                    )
                }
                RatingValueText(rating17)

                Spacer(modifier = Modifier.height(24.dp))

                // 18. Dark Background Rating Bar
                SectionTitle("18. Dark Background Rating Bar")
                var rating18 by remember { mutableFloatStateOf(3.5f) }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(SushiTheme.colors.text.primary.value)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    SushiRatingBar(
                        props = SushiRatingBarProps(
                            rating = rating18,
                            tintColor = SushiColorData.fromColorName(colorName = ColorName.Blue)
                        ),
                        onRatingChange = { rating18 = it }
                    )
                }
                RatingValueText(rating18)

                Spacer(modifier = Modifier.height(24.dp))

                // 19. Rating Bar with Different Star Counts and Spacing
                SectionTitle("19. Different Star Counts and Spacing")
                var rating19 by remember { mutableFloatStateOf(2.5f) }

                // 3 Stars, wide spacing
                SushiRatingBar(
                    props = SushiRatingBarProps(
                        rating = rating19 * (3f/5f), // Scale the rating to match star count
                        starCount = 3,
                        betweenSpacing = 12.dp
                    ),
                    onRatingChange = { rating19 = it * (5f/3f) }, // Scale back to 5-star scale
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // 5 Stars, medium spacing
                SushiRatingBar(
                    props = SushiRatingBarProps(
                        rating = rating19,
                        starCount = 5,
                        betweenSpacing = 8.dp
                    ),
                    onRatingChange = { rating19 = it },
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // 7 Stars, narrow spacing
                SushiRatingBar(
                    props = SushiRatingBarProps(
                        rating = rating19 * (7f/5f), // Scale the rating to match star count
                        starCount = 7,
                        betweenSpacing = 4.dp
                    ),
                    onRatingChange = { rating19 = it * (5f/7f) } // Scale back to 5-star scale
                )

                RatingValueText(rating19, isReadOnly = true, suffix = " (on 5-star scale)")

                Spacer(modifier = Modifier.height(24.dp))

                // 20. Rating Bar with Comparison
                SectionTitle("20. Rating Comparison")
                val userRating = 4f
                val averageRating = 3.2f

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .border(1.dp, SushiTheme.colors.border.moderate.value, RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SushiText(
                            props = SushiTextProps(
                                text = "Your Rating: ",
                                type = SushiTextType.Medium500
                            ),
                            modifier = Modifier.width(100.dp)
                        )

                        SushiRatingBar(
                            props = SushiRatingBarProps(
                                rating = userRating,
                                tintColor = SushiTheme.colors.green.v500
                            ),
                            onRatingChange = { /* Read only */ }
                        )

                        SushiText(
                            props = SushiTextProps(
                                text = " $userRating",
                                type = SushiTextType.Regular400
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SushiText(
                            props = SushiTextProps(
                                text = "Avg. Rating: ",
                                type = SushiTextType.Medium500
                            ),
                            modifier = Modifier.width(100.dp)
                        )

                        SushiRatingBar(
                            props = SushiRatingBarProps(
                                rating = averageRating,
                                tintColor = SushiTheme.colors.yellow.v500
                            ),
                            onRatingChange = { /* Read only */ }
                        )

                        SushiText(
                            props = SushiTextProps(
                                text = " $averageRating",
                                type = SushiTextType.Regular400
                            )
                        )
                    }
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
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
private fun RatingValueText(
    rating: Float,
    isReadOnly: Boolean = false,
    suffix: String = ""
) {
    SushiText(
        props = SushiTextProps(
            text = "Rating: $rating$suffix${if (isReadOnly) " (Read-Only)" else ""}",
            type = SushiTextType.Regular400,
            color = SushiTheme.colors.text.secondary,
            textAlign = TextAlign.Center
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    )
}

@Composable
@SushiPreview
private fun RatingBarShowcaseScreenPreview() {
    AppTheme {
        RatingBarShowcaseScreen()
    }
}