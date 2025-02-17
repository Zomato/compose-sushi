package com.zomato.sushi.compose.components.ratingbar

import androidx.compose.ui.unit.Dp

/**
 * @author gupta.anirudh@zomato.com
 */
data class SushiRatingBarProps(
    val rating: Float? = null,
    val betweenSpacing: Dp? = null,
    val starCount: Int? = null
)