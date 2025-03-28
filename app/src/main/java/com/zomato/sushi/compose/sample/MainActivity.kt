package com.zomato.sushi.compose.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.modifiers.CircularReveal
import com.zomato.sushi.compose.sample.screen.TextShowcaseScreen
import com.zomato.sushi.compose.sample.screen.IconShowcaseScreen
import com.zomato.sushi.compose.sample.screen.ButtonShowcaseScreen
import com.zomato.sushi.compose.sample.screen.ImageShowcaseScreen
import com.zomato.sushi.compose.sample.screen.CheckBoxShowcaseScreen
import com.zomato.sushi.compose.sample.screen.RadioButtonShowcaseScreen
import com.zomato.sushi.compose.sample.screen.SwitchShowcaseScreen
import com.zomato.sushi.compose.sample.screen.TagShowcaseScreen
import com.zomato.sushi.compose.sample.screen.TextFieldShowcaseScreen
import com.zomato.sushi.compose.sample.screen.AnimationShowcaseScreen
import com.zomato.sushi.compose.sample.screen.LoaderShowcaseScreen
import com.zomato.sushi.compose.sample.screen.CardShowcaseScreen
import com.zomato.sushi.compose.sample.screen.IndicatorsShowcaseScreen
import com.zomato.sushi.compose.sample.screen.SeparatorShowcaseScreen
import com.zomato.sushi.compose.sample.screen.ShimmerShowcaseScreen
import com.zomato.sushi.compose.sample.screen.SnackbarShowcaseScreen
import com.zomato.sushi.compose.sample.screen.BottomSheetShowcaseScreen
import com.zomato.sushi.compose.sample.screen.DialogShowcaseScreen
import com.zomato.sushi.compose.sample.screen.DropDownShowcaseScreen
import com.zomato.sushi.compose.sample.screen.MediaShowcaseScreen
import com.zomato.sushi.compose.sample.screen.OTPInputShowcaseScreen
import com.zomato.sushi.compose.sample.screen.HorizontalPagerShowcaseScreen
import com.zomato.sushi.compose.sample.screen.MainScreen
import com.zomato.sushi.compose.sample.screen.VerticalPagerShowcaseScreen
import com.zomato.sushi.compose.sample.screen.RatingBarShowcaseScreen
import com.zomato.sushi.compose.sample.screen.TooltipShowcaseScreen
import com.zomato.sushi.compose.sample.screen.ViewFlipperShowcaseScreen
import com.zomato.sushi.compose.sample.ui.theme.AppColorMode
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import com.zomato.sushi.compose.sample.ui.theme.ThemeController

val LocalNavController = compositionLocalOf<NavHostController> {
    error("NavHostController not provided")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainActivityContent()
        }
    }
}

@Composable
private fun MainActivityContent() {
    AppTheme {
        val navController = rememberNavController()
        CompositionLocalProvider(
            LocalNavController provides navController
        ) {
            NavHost(
                navController = navController,
                startDestination = MainScreen
            ) {
                composable<MainScreen>() {
                    MainScreen()
                }
                composable<TextShowcaseScreen>() {
                    TextShowcaseScreen()
                }
                composable<IconShowcaseScreen>() {
                    IconShowcaseScreen()
                }
                composable<ButtonShowcaseScreen>() {
                    ButtonShowcaseScreen()
                }
                composable<ImageShowcaseScreen>() {
                    ImageShowcaseScreen()
                }
                composable<CheckBoxShowcaseScreen>() {
                    CheckBoxShowcaseScreen()
                }
                composable<RadioButtonShowcaseScreen>() {
                    RadioButtonShowcaseScreen()
                }
                composable<SwitchShowcaseScreen>() {
                    SwitchShowcaseScreen()
                }
                composable<TagShowcaseScreen>() {
                    TagShowcaseScreen()
                }
                composable<TextFieldShowcaseScreen>() {
                    TextFieldShowcaseScreen()
                }
                composable<AnimationShowcaseScreen>() {
                    AnimationShowcaseScreen()
                }
                composable<LoaderShowcaseScreen>() {
                    LoaderShowcaseScreen()
                }
                composable<CardShowcaseScreen>() {
                    CardShowcaseScreen()
                }
                composable<IndicatorsShowcaseScreen>() {
                    IndicatorsShowcaseScreen()
                }
                composable<SeparatorShowcaseScreen>() {
                    SeparatorShowcaseScreen()
                }
                composable<ShimmerShowcaseScreen>() {
                    ShimmerShowcaseScreen()
                }
                composable<SnackbarShowcaseScreen>() {
                    SnackbarShowcaseScreen()
                }
                composable<BottomSheetShowcaseScreen>() {
                    BottomSheetShowcaseScreen()
                }
                composable<DialogShowcaseScreen>() {
                    DialogShowcaseScreen()
                }
                composable<DropDownShowcaseScreen>() {
                    DropDownShowcaseScreen()
                }
                composable<MediaShowcaseScreen>() {
                    MediaShowcaseScreen()
                }
                composable<OTPInputShowcaseScreen>() {
                    OTPInputShowcaseScreen()
                }
                composable<HorizontalPagerShowcaseScreen>() {
                    HorizontalPagerShowcaseScreen()
                }
                composable<VerticalPagerShowcaseScreen>() {
                    VerticalPagerShowcaseScreen()
                }
                composable<RatingBarShowcaseScreen>() {
                    RatingBarShowcaseScreen()
                }
                composable<TooltipShowcaseScreen>() {
                    TooltipShowcaseScreen()
                }
                composable<ViewFlipperShowcaseScreen>() {
                    ViewFlipperShowcaseScreen()
                }
            }
        }
    }
}

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val themeController = AppTheme.themeController
    CircularReveal(
        themeController.colorMode.value to themeController.darkMode.value,
        modifier
    ) { theme ->
        AppTheme(
            themeController = remember {
                object : ThemeController(theme.first, theme.second) {
                    override fun updateDarkMode(newDarkMode: Boolean) {
                        themeController.updateDarkMode(newDarkMode)
                    }

                    override fun updateColorMode(newColorMode: AppColorMode) {
                        themeController.updateColorMode(newColorMode)
                    }
                }
            }
        ) {
            content()
        }
    }
}

@Composable
@SushiPreview
private fun MainActivityPreview() {
    MainActivityContent()
}