package com.zomato.sushi.compose.atoms.text

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// todox: remove
@Preview
@Composable
fun ExampleUsage() {
    Column(modifier = Modifier.padding(16.dp)) {
        // Using default dimensions
        CustomButton(onClick = { /* Handle click */ }) {
            Text("Default Button")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Providing custom dimensions
        CustomButton(
            onClick = { /* Handle click */ },
            modifier = Modifier.size(150.dp, 60.dp)
        ) {
            Text("Custom Size Button")
        }

        CustomButton(
            onClick = { /* Handle click */ },
            modifier = Modifier.size(300.dp, 300.dp)
        ) {
            Text("Custom Size Button 2")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Smaller than minimum size (respects min constraints)
        CustomButton(
            onClick = { /* Handle click */ },
            modifier = Modifier.size(50.dp, 30.dp) // Smaller than minWidth/minHeight
        ) {
            Text("Constrained Button")
        }
    }
}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    // Define default dimensions
    val defaultWidth = 100.dp
    val defaultHeight = 48.dp
    val minWidth = 80.dp
    val minHeight = 40.dp

    // Compose the button
    Box(
        modifier = modifier
            .defaultMinSize(minWidth = minWidth, minHeight = minHeight) // Minimum constraints
            .size(defaultWidth, defaultHeight), // Defaults if no size is provided
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxSize(), // Fill available space in Box
            content = content
        )
    }
}