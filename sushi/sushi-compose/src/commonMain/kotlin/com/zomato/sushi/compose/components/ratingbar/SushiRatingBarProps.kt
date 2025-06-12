package com.zomato.sushi.compose.components.ratingbar

import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec

/**
 * @author gupta.anirudh@zomato.com
 *
 * Properties for configuring a SushiRatingBar component.
 *
 * SushiRatingBar is an interactive component that displays a row of stars for users to
 * provide ratings. These properties control the appearance and behavior of the rating bar.
 *
 * @property rating The current rating value, representing the number of filled stars.
 *                 Can be a fractional value for partial star filling.
 * @property betweenSpacing The spacing between each star in the rating bar
 * @property starCount The total number of stars to display in the rating bar
 * @property tintColor Optional color to apply to the stars
 */
data class SushiRatingBarProps(
    val rating: Float? = null,
    val betweenSpacing: Dp? = null,
    val starCount: Int? = null,
    val tintColor: ColorSpec? = null
)