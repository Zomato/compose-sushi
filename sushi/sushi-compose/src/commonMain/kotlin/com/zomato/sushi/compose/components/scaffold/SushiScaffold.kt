package com.zomato.sushi.compose.components.scaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.zomato.sushi.compose.internal.SushiPreview

/**
 * SushiScaffold composable: a Sushi wrapper for Material3 Scaffold using slot-based architecture.
 * All parameters are passed as direct arguments to maximize Compose stability and recomposition performance.
 */
@Composable
fun SushiScaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    containerColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color = contentColorFor(containerColor),
    contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = topBar,
        bottomBar = bottomBar,
        containerColor = containerColor,
        contentColor = contentColor,
        contentWindowInsets = contentWindowInsets,
        content = content
    )
}

/**
 * Preview for SushiScaffold.
 */
@SushiPreview
@Composable
fun SushiScaffoldPreview() {
    SushiPreview {
        SushiScaffold(
            topBar = {
            },
            bottomBar = {
            },
            content = { padding ->
            }
        )
    }
}
