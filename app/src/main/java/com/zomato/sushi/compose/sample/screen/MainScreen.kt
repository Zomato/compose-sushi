package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.BaseScreen
import com.zomato.sushi.compose.sample.LocalNavController
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import kotlinx.serialization.Serializable

@Serializable
object MainScreen

private val listOfComponents = listOf(
    "Text" to TextShowcaseScreen,
    "Icon" to IconShowcaseScreen,
    "Button" to ButtonShowcaseScreen,
    "Image" to ImageShowcaseScreen,
    "CheckBox" to CheckBoxShowcaseScreen,
    "RadioButton" to RadioButtonShowcaseScreen,
    "Switch" to SwitchShowcaseScreen,
    "Tag" to TagShowcaseScreen,
    "TextField" to TextFieldShowcaseScreen,
    "Animation" to AnimationShowcaseScreen,
    "Loader" to LoaderShowcaseScreen,
    "Card" to CardShowcaseScreen,
    "Indicators" to IndicatorsShowcaseScreen,
    "Separator" to SeparatorShowcaseScreen,
    "Shimmer" to ShimmerShowcaseScreen,
    "Snackbar" to SnackbarShowcaseScreen,
    "BottomSheet" to BottomSheetShowcaseScreen,
    "Dialog" to DialogShowcaseScreen,
    "DropDown" to DropDownShowcaseScreen,
    "Media" to MediaShowcaseScreen,
    "OTPInput" to OTPInputShowcaseScreen,
    "HorizontalPager" to HorizontalPagerShowcaseScreen,
    "VerticalPager" to VerticalPagerShowcaseScreen,
    "RatingBar" to RatingBarShowcaseScreen,
    "Tooltip" to TooltipShowcaseScreen,
    "ViewFlipper" to ViewFlipperShowcaseScreen,
)

// Prompt:
// TextShowcaseScreen is a file which showcases all possibilities
// of how we can use SushiText. Please complete it with 40 examples
// of SushiText, each one showcasing different different features
// supported (via SushiTextProps).

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    BaseScreen(modifier) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = SushiTheme.colors.surface.primary.value
        ) { innerPadding ->
            Column(
                Modifier.padding(innerPadding)
            ) {
                AppTopBar(
                    title = "Sushi Components",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        start = SushiTheme.dimens.spacing.base,
                        end = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )
                val navigator = LocalNavController.current
                LazyVerticalGrid(
                    GridCells.Fixed(2),
                    Modifier.padding(
                        start = SushiTheme.dimens.spacing.base,
                        end = SushiTheme.dimens.spacing.base
                    ),
                    horizontalArrangement = Arrangement.spacedBy(SushiTheme.dimens.spacing.base),
                    verticalArrangement = Arrangement.spacedBy(SushiTheme.dimens.spacing.base),
                ) {
                    items(listOfComponents) { component ->
                        ExploreComponentButton(
                            text = component.first,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            onClick = {
                                navigator.navigate(component.second)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ExploreComponentButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    SushiButton(
        props = SushiButtonProps(
            text = text
        ),
        onClick = onClick,
        modifier
    )
}

@Composable
@SushiPreview
private fun MainScreenPreview() {
    AppTheme {
        CompositionLocalProvider(
            LocalNavController provides rememberNavController()
        ) {
            MainScreen()
        }
    }
}
