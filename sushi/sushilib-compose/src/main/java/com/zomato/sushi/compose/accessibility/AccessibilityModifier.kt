package com.zomato.sushi.compose.accessibility

import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsModifier
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.semantics.semantics

/**
 * Key for the contentDescription semantics property.
 * If your composable works with E2E or UI tests,
 * you can use this property to set a unique identifier for the composable.
 */

/**
 * Key for the contentDescription semantics property.
 */
val ContentDescription = SemanticsPropertyKey<String>("ContentDescription")

/**
 * Receiver for the contentDescription semantics property.
 */
var SemanticsPropertyReceiver.contentDescription by ContentDescription

/**
 * Sets the contentDescription of a composable.
 *
 * @param contentDescription The contentDescription to set.
 */
fun Modifier.contentDescription(contentDescription: String): Modifier {
    return semantics {
        this.contentDescription = contentDescription
    }
}

/**
 * Gets the contentDescription of a composable.
 *
 * @return The contentDescription, or null if not set.
 */
fun Modifier.getContentDescription(): String? {
    return this.foldIn(null as String?) { _, element ->
        if (element is SemanticsModifier) {
            element.semanticsConfiguration.getOrNull(ContentDescription)?.let {
                return@foldIn it
            }
        }
        null
    }
}