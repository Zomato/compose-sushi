package com.zomato.sushi.compose.atoms.icon

/**
 * Semantic icon slots used internally by Sushi components.
 *
 * Override this to remap internal icons when using a custom icon font
 * whose codepoints differ from Wasabi.
 */
data class SushiDefaultIconSet(
    val clearField: SushiIconCode = SushiIconCodes.IconCrossCircleFill
)
