package com.zomato.sushi.compose.components.media

import com.zomato.sushi.compose.atoms.animation.SushiAnimationProps
import com.zomato.sushi.compose.atoms.image.SushiImageProps

/**
 * @author gupta.anirudh@zomato.com
 */
sealed class SushiMediaProps {
    data class Image(
        val props: SushiImageProps
    ) : SushiMediaProps()

    data class Animation(
        val props: SushiAnimationProps
    ) : SushiMediaProps()
}