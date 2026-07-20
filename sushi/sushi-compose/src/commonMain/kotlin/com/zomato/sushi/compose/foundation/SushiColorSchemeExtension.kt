package com.zomato.sushi.compose.foundation

import androidx.compose.runtime.Immutable

/**
 * Marker for app-defined color-scheme extensions carried by [SushiColorScheme.extension].
 *
 * Lets a consuming app attach its own strongly-typed color tokens to the
 * [SushiColorScheme] provided through [SushiTheme], without maintaining a separate
 * CompositionLocal. The app defines an implementation of this interface, passes an
 * instance via [SushiColorScheme.extension], and reads it back (with a typed accessor)
 * from `SushiTheme.colors.extension`.
 *
 * Implementations must be immutable.
 */
@Immutable
interface SushiColorSchemeExtension
