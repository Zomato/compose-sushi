package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.modifiers.ifNonNull

/**
 * @author gupta.anirudh@zomato.com
 *
 * Similar implementation as Material's Button composable, but with a few differences:
 * - Removed minimum interaction
 * - Removed min width, height
 */
@Composable
internal fun ButtonImpl(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.shape,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    containerBrush: Brush? = null,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    CompositionLocalProvider(LocalMinimumInteractiveComponentSize provides 0.dp) {
        val containerBrushColor = when {
            enabled && containerBrush != null -> containerBrush
            else -> null
        }
        val containerColor = when {
            containerBrushColor != null -> Color.Transparent
            enabled -> colors.containerColor
            else -> colors.disabledContainerColor
        }
        val contentColor = when {
            enabled -> colors.contentColor
            else -> colors.disabledContentColor
        }

        val localTextStyle = LocalTextStyle.current
        val materialLabelLarge = MaterialTheme.typography.labelLarge
        val mergedStyle = remember(localTextStyle, materialLabelLarge) {
            localTextStyle.merge(materialLabelLarge)
        }

        Surface(
            modifier = modifier
                .ifNonNull(containerBrush) { this.background(it) }
                .semantics { role = Role.Button },
            shape = shape,
            color = containerColor,
            contentColor = contentColor,
            border = border
        ) {
            CompositionLocalProvider(
                LocalContentColor provides contentColor,
                LocalTextStyle provides mergedStyle
            ) {
                Row(
                    Modifier.padding(contentPadding),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    content = content
                )
            }
        }
    }
}