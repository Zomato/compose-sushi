package com.zomato.sushi.compose.atoms.border

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class SushiBorderProps(
    val colors: PersistentList<ColorSpec> = persistentListOf(),
    val shape: Shape? = null,
    val width: Dp? = null
)
