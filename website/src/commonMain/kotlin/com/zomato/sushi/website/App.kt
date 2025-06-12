package com.zomato.sushi.website

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.zomato.sushi.compose.foundation.SushiTheme

@Composable
fun App() {
    val navController = rememberNavController()
    CompositionLocalProvider(
        LocalNavController provides navController
    ) {
        NavHost(
            navController = navController,
            startDestination = StartScreenProps
        ) {
            composable<StartScreenProps> {
                SushiTheme {
                    StartScreen(it.toRoute())
                }
            }
            composable<DetailScreenProps> {
                SushiTheme {
                    val props = it.toRoute<DetailScreenProps>()
                    DetailScreen(
                        props = props,
                    )
                }
            }
        }
    }

    PlatformSpecificNavigation(navController)
}