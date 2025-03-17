package com.zomato.sushi.compose.components.ratingbar

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.dp

/**
 * Provides default values for SushiRatingBar components.
 * These defaults are used when specific properties are not provided in SushiRatingBarProps.
 *
 * @author gupta.anirudh@zomato.com
 */
@Immutable
object SushiRatingBarDefaults {
    /**
     * Default number of stars to display in the rating bar.
     * The standard 5-star rating scale is used by default.
     */
    public const val starCount = 5
    
    /**
     * Default spacing between each star in the rating bar.
     */
    public val betweenSpacing = 10.dp
    
    /**
     * Default size (height) of each star.
     */
    public val startSize = 20.dp
}