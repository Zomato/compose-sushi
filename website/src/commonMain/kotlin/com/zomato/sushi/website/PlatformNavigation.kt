package com.zomato.sushi.website

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
expect fun PlatformSpecificNavigation(navController: NavController)