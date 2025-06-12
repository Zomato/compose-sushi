package com.zomato.sushi.website

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
actual fun PlatformSpecificNavigation(navController: NavController) {
    // No platform-specific navigation for desktop
}