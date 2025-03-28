package com.zomato.sushi.compose.atoms.tag

/**
 * Provides default values for SushiTag components.
 * These defaults are used when specific properties are not provided in SushiTagProps.
 *
 * Created by Kashish on 03,February,2025
 * Zomato, Gurgaon, India.
 */

object SushiTagDefaults {
    private val size = SushiTagSize.Medium
    private val type = SushiTagType.Rounded

    internal val SushiTagProps.typeOrDefault get() = this.type ?: SushiTagDefaults.type
    internal val SushiTagProps.sizeOrDefault get() = this.size ?: SushiTagDefaults.size
}