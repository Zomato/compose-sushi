package com.zomato.sushi.compose.components.otptextfield

/**
 * Defines the visual style variants for SushiOTPTextField components.
 * 
 * - Outlined: Displays each digit field with a complete border outline
 * - Filled: Displays each digit field with a filled background
 * - Underlined: Displays each digit field with only a bottom border line
 *
 * These styles affect the visual appearance of the OTP input fields while
 * maintaining consistent behavior.
 *
 * @author gupta.anirudh@zomato.com
 */
enum class SushiOTPTextFieldType {
    Outlined,
    Filled,
    Underlined,
}