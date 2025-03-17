package com.zomato.sushi.compose.atoms.tag

/**
 * Defines the visual style variants for SushiTag components.
 * 
 * SushiTag supports multiple visual styles to accommodate different design needs.
 * The types vary in corner radius (rounded vs capsule) and border style (solid, outline, or dashed).
 *
 * - Rounded: Tag with slightly rounded corners and a solid background
 * - Capsule: Tag with fully rounded ends (pill shape) and a solid background
 * - RoundedOutline: Tag with slightly rounded corners and a solid outline border
 * - CapsuleOutline: Tag with fully rounded ends (pill shape) and a solid outline border
 * - RoundedDashed: Tag with slightly rounded corners and a dashed border
 * - CapsuleDashed: Tag with fully rounded ends (pill shape) and a dashed border
 *
 * Created by Kashish on 10,January,2025
 * Zomato, Gurgaon, India.
 */
enum class SushiTagType {
    Rounded, Capsule, RoundedOutline, CapsuleOutline, RoundedDashed, CapsuleDashed
}