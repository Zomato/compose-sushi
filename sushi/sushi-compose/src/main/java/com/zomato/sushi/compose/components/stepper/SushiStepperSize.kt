package com.zomato.sushi.compose.components.stepper

/**
 * Defines the size variants available for SushiStepper components.
 * 
 * These size variations affect the dimensions, text size, and icon size of the stepper component,
 * allowing it to adapt to different UI contexts.
 *
 * - Small: Compact size for tight spaces (72dp × 26dp)
 * - SmallV2: Alternative compact size with slightly larger dimensions (82dp × 30dp)
 * - Medium: Moderate size for general usage (90dp × 32dp)
 * - Normal: Standard size for most use cases (120dp × 40dp)
 * - Large: Bigger size for emphasis or touch-focused interfaces (104dp × 48dp)
 */
enum class SushiStepperSize {
    Small, SmallV2, Medium, Normal, Large
}