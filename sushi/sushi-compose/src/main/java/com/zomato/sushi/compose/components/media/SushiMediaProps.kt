package com.zomato.sushi.compose.components.media

import com.zomato.sushi.compose.atoms.animation.SushiAnimationProps
import com.zomato.sushi.compose.atoms.image.SushiImageProps

/**
 * Properties for configuring a SushiMedia component.
 *
 * SushiMedia is a unified interface for displaying different types of media content
 * including static images and animations. This sealed class provides a type-safe way
 * to specify which type of media should be rendered and its configuration.
 *
 * @author gupta.anirudh@zomato.com
 */
sealed class SushiMediaProps {
    /**
     * Configuration for displaying a static image.
     * 
     * @property props The properties to configure the image's appearance and behavior
     */
    data class Image(
        val props: SushiImageProps
    ) : SushiMediaProps()

    /**
     * Configuration for displaying an animation.
     * 
     * @property props The properties to configure the animation's appearance and behavior
     */
    data class Animation(
        val props: SushiAnimationProps
    ) : SushiMediaProps()
}