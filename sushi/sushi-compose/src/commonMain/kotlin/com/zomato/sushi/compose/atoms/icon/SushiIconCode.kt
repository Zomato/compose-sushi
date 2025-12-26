package com.zomato.sushi.compose.atoms.icon

import kotlin.jvm.JvmInline

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
) {

    /**
     * The string representation of the icon that can be rendered by icon font or null if parsing fails
     *
     * This converts the hexadecimal code into the corresponding Unicode character
     * that represents the icon in the Wasabi icon font.
     */
    val parsedValue: String?
        get() {
            return value.takeIf { it.isNotEmpty() && !it.startsWith("&#x") }
                ?.runCatching { this.toIntOrNull(16)?.toChar().toString() }
                ?.getOrNull()
        }
}