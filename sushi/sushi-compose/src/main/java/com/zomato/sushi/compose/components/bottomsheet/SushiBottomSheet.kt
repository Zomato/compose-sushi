package com.zomato.sushi.compose.components.bottomsheet

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.takeIfSpecified
import kotlinx.coroutines.launch

/**
 * A customizable bottom sheet component for the Sushi design system.
 *
 * SushiBottomSheet provides a modal bottom sheet that slides up from the bottom of the screen
 * to display additional content.
 * 
 * The component is built on top of Material 3's ModalBottomSheet with Sushi-specific styling
 * and integration with the Sushi design system.
 *
 * @param props The properties to configure the bottom sheet's appearance
 * @param onDismissRequest Callback that will be called when the user tries to dismiss the sheet
 * @param modifier The modifier to be applied to the component
 * @param sheetState The state of the bottom sheet, controlling its visibility and animating its transitions
 * @param sheetMaxWidth The maximum width to be used for the bottom sheet
 * @param dragHandle Optional composable to override the default drag handle at the top of the sheet
 * @param contentWindowInsets Window insets to be applied to the bottom sheet content
 * @param content The content to be displayed inside the bottom sheet
 *
 * @author gupta.anirudh@zomato.com
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SushiBottomSheet(
    props: SushiBottomSheetProps,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    sheetState: SheetState = rememberModalBottomSheetState(),
    sheetMaxWidth: Dp = BottomSheetDefaults.SheetMaxWidth,
    dragHandle: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
    contentWindowInsets: @Composable () -> WindowInsets = { BottomSheetDefaults.windowInsets },
    content: @Composable ColumnScope.() -> Unit
) {
    SushiComponentBase(
        modifier
            .testTag("SushiBottomSheet")
    ) {
        SushiBottomSheetImpl(
            props = props,
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            sheetMaxWidth = sheetMaxWidth,
            dragHandle = dragHandle,
            contentWindowInsets = contentWindowInsets,
            content = content,
            modifier = Modifier
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SushiBottomSheetImpl(
    props: SushiBottomSheetProps,
    onDismissRequest: () -> Unit,
    sheetState: SheetState,
    sheetMaxWidth: Dp,
    dragHandle: @Composable (() -> Unit)?,
    contentWindowInsets: @Composable () -> WindowInsets,
    content: @Composable ColumnScope.() -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = props.shape ?: RoundedCornerShape(topStart = 28.0.dp, topEnd = 28.dp)
    val containerColor = props.containerColor.takeIfSpecified() ?: SushiTheme.colors.surface.primary
    val contentColor = props.contentColor.takeIfSpecified() ?: SushiTheme.colors.text.primary
    val tonalElevation = props.tonalElevation ?: 0.0.dp
    val properties = props.properties ?: ModalBottomSheetDefaults.properties

    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        sheetState = sheetState,
        sheetMaxWidth = sheetMaxWidth,
        shape = shape,
        containerColor = containerColor.value,
        contentColor = contentColor.value,
        tonalElevation = tonalElevation,
        dragHandle = dragHandle,
        contentWindowInsets = contentWindowInsets,
        properties = properties,
        content = content,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@SushiPreview
private fun SushiBottomSheetPreview1() {
    SushiPreview {
        val sheetState = rememberModalBottomSheetState()
        val scope = rememberCoroutineScope()
        var showBottomSheet by remember { mutableStateOf(false) }
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { SushiText(SushiTextProps("Show bottom sheet")) },
                    icon = { SushiIcon(SushiIconProps(SushiIconCodes.IconPlus)) },
                    onClick = {
                        showBottomSheet = true
                    }
                )
            }
        ) { contentPadding ->
            // Screen content

            if (showBottomSheet) {
                SushiBottomSheet(
                    SushiBottomSheetProps(),
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState
                ) {
                    // Sheet content
                    SushiButton(
                        props = SushiButtonProps(
                            text = "Hide bottom sheet"
                        ),
                        onClick = {
                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    showBottomSheet = false
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}
