package com.zomato.sushi.compose.atoms.icon

/**
 * Represents an icon code in the Sushi design system.
 * 
 * SushiIconCode is a type-safe wrapper around a string value that represents
 * a specific icon in the Wasabi icon font. The value is typically a hexadecimal code
 * that maps to a character in the font.
 *
 * @property value The string representation of the icon code, typically a hexadecimal value
 */
@JvmInline
value class SushiIconCode(
    val value: String
)