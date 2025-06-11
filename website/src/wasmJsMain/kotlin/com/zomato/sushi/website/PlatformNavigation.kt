package com.zomato.sushi.website

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.NavController
import androidx.navigation.bindToNavigation
import androidx.navigation.toRoute
import kotlinx.browser.window

@OptIn(ExperimentalBrowserHistoryApi::class)
@Composable
actual fun PlatformSpecificNavigation(navController: NavController) {
    LaunchedEffect(navController) {
        // Handle initial URL navigation
        val initRoute = window.location.pathname.substringAfter('/')
        when {
            initRoute.isEmpty() -> {
                navController.navigate(StartScreenProps)
            }

            initRoute.startsWith("detail/") -> {
                val componentId = initRoute.removePrefix("detail/").substringBefore("/")
                if (componentId.isNotEmpty()) {
                    navController.navigate(DetailScreenProps(componentId)) {
                        popUpTo(StartScreenProps) { inclusive = true }
                    }
                }
            }
        }

        window.bindToNavigation(navController) { entry ->
            val route = entry.destination.route.orEmpty()
            val expectedPath = when {
                route.startsWith(StartScreenProps.serializer().descriptor.serialName) -> ""
                route.startsWith(DetailScreenProps.serializer().descriptor.serialName) -> {
                    val args = entry.toRoute<DetailScreenProps>()
                    "detail/${args.componentId}"
                }

                else -> "error"
            }

            // Only update URL if it's different from current path
            if (window.location.pathname != "/${expectedPath.removeSuffix("/")}") {
                expectedPath
            } else {
                ""
            }
        }
    }
}