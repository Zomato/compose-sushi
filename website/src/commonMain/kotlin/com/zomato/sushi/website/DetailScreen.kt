package com.zomato.sushi.website

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.ExperimentalComposeUiApi
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.button.SushiButtonSize
import com.zomato.sushi.compose.atoms.button.SushiButtonType
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.atoms.text.transform
import com.zomato.sushi.compose.atoms.textfield.SushiTextField
import com.zomato.sushi.compose.atoms.textfield.SushiTextFieldProps
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.website.components.HeaderLogo
import com.zomato.sushi.website.components.HeaderOption
import composesushi.website.generated.resources.Res
import composesushi.website.generated.resources.github_icon
import kotlinx.coroutines.launch
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.painterResource
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import com.wakaztahir.codeeditor.model.CodeLang
import com.wakaztahir.codeeditor.prettify.PrettifyParser
import com.wakaztahir.codeeditor.theme.DefaultTheme
import com.wakaztahir.codeeditor.utils.parseCodeAsAnnotatedString

@Serializable
@SerialName("detail")
data class DetailScreenProps(
    val componentId: String
)

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DetailScreen(
    props: DetailScreenProps,
    modifier: Modifier = Modifier
) {
    val component = listOfComponents.first { it.id == props.componentId }
    val windowInfo = LocalWindowInfo.current
    val density = LocalDensity.current

    // Calculate screen width in dp
    val screenWidthPx = windowInfo.containerSize.width
    val screenWidth = with(density) { screenWidthPx.toDp() }
    val isCompact = screenWidth < 768.dp

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )
    val scope = rememberCoroutineScope()

    // Close drawer when switching to desktop mode
    LaunchedEffect(isCompact) {
        if (!isCompact && drawerState.isClosed) {
            drawerState.open()
        }
    }

    if (isCompact) {
        // Mobile layout with modal navigation drawer
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet(
                    modifier = Modifier.width(280.dp)
                ) {
                    SidebarContent(
                        component = component,
                        isCompact = true,
                        onItemClick = {
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    )
                }
            },
            modifier = modifier
        ) {
            DetailScreenContent(
                component = component,
                isCompact = true,
                onMenuClick = {
                    scope.launch {
                        if (drawerState.isClosed) {
                            drawerState.open()
                        } else {
                            drawerState.close()
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .background(SushiTheme.colors.white.value)
            )
        }
    } else {
        // Desktop layout with persistent sidebar
        Row(
            modifier
                .fillMaxSize()
                .background(SushiTheme.colors.white.value)
        ) {
            Box(
                Modifier
                    .width(280.dp)
                    .fillMaxSize()
            ) {
                SidebarContent(
                    component = component,
                    isCompact = false
                )
            }

            DetailScreenContent(
                component = component,
                isCompact = false,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            )
        }
    }
}

@Composable
private fun SidebarContent(
    component: Component,
    isCompact: Boolean,
    modifier: Modifier = Modifier,
    onItemClick: (() -> Unit)? = null
) {
    val navController = LocalNavController.current
    var searchText by remember { mutableStateOf("") }
    val filteredComponents = remember(searchText) {
        if (searchText.isEmpty()) {
            listOfComponents
        } else {
            listOfComponents.filter {
                it.title.contains(searchText, ignoreCase = true)
            }
        }
    }

    Column(
        modifier
            .fillMaxSize()
            .background(SushiTheme.colors.grey.v050.value)
    ) {
        Column(
            Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            HeaderLogo()
            Spacer(Modifier.height(24.dp))
            SushiTextField(
                props = SushiTextFieldProps(
                    id = "search",
                    text = searchText,
                    placeholder = SushiTextProps(text = "Search components...")
                ),
                onValueChange = { searchText = it },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
                .weight(1f)
        ) {
            Spacer(Modifier.height(16.dp))

            SidebarSection("Getting Started") {
                SidebarItem(
                    "Introduction",
                    false,
                    onClick = {
                        navController.navigate(StartScreenProps)
                        onItemClick?.invoke()
                    }
                )
                SidebarItem("Setup guide", false)
            }

            Spacer(Modifier.height(24.dp))

            SidebarSection("Components") {
                filteredComponents.forEach { comp ->
                    SidebarItem(
                        text = comp.title,
                        isSelected = comp.id == component.id,
                        onClick = {
                            navController.navigate(
                                DetailScreenProps(
                                    componentId = comp.id
                                )
                            )
                            onItemClick?.invoke()
                        }
                    )
                }
            }

            Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable
private fun SidebarSection(
    title: String,
    content: @Composable () -> Unit
) {
    Column {
        WebText(
            SushiTextProps(
                text = title,
                type = SushiTextType.Medium500,
                color = SushiTheme.colors.grey.v800
            ),
            Modifier.padding(horizontal = 16.dp)
        )
        Spacer(Modifier.height(8.dp))
        content()
    }
}

@Composable
private fun SidebarItem(
    text: String,
    isSelected: Boolean,
    onClick: (() -> Unit)? = null
) {
    val backgroundColor = if (isSelected) {
        SushiTheme.colors.grey.v200
    } else {
        SushiTheme.colors.transparent
    }

    Box(
        Modifier
            .fillMaxWidth()
            .background(backgroundColor.value)
            .let { if (onClick != null) it.clickable { onClick() } else it }
            .let { if (onClick != null) it.pointerHoverIcon(PointerIcon.Hand) else it }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        WebText(
            SushiTextProps(
                text = text,
                type = if (isSelected) SushiTextType.Medium500 else SushiTextType.Regular400,
                color = if (isSelected) SushiTheme.colors.grey.v900 else SushiTheme.colors.grey.v700
            )
        )
    }
}

@Composable
private fun DetailScreenContent(
    component: Component,
    isCompact: Boolean,
    modifier: Modifier = Modifier,
    onMenuClick: (() -> Unit)? = null
) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .padding(if (isCompact) 16.dp else 40.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(bottom = if (isCompact) 24.dp else 40.dp),
            horizontalArrangement = if (isCompact) Arrangement.SpaceBetween else Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isCompact && onMenuClick != null) {
                WebText(
                    SushiTextProps(
                        text = "☰",
                        type = SushiTextType.Medium500.transform {
                            it.copy(fontSize = 24.sp)
                        },
                        color = SushiTheme.colors.grey.v700
                    ),
                    Modifier
                        .clickable { onMenuClick() }
                        .padding(8.dp)
                        .pointerHoverIcon(PointerIcon.Hand)
                )
            }

            HeaderOption(
                text = "Github",
                prefixImageRes = Res.drawable.github_icon,
                Modifier.padding(start = if (isCompact) 0.dp else 24.dp)
            )
        }

        WebText(
            SushiTextProps(
                text = component.name,
                type = SushiTextType.Bold900.transform {
                    it.copy(fontSize = if (isCompact) 32.sp else 48.sp)
                }
            )
        )

        WebText(
            SushiTextProps(
                text = component.longDescription,
                type = SushiTextType.Regular400,
                color = SushiTheme.colors.grey.v700
            ),
            Modifier.padding(top = 16.dp)
        )

        ComponentPreview(
            component,
            isCompact,
            Modifier.padding(vertical = if (isCompact) 24.dp else 40.dp)
        )

        WebText(
            SushiTextProps(
                text = "Example",
                type = SushiTextType.Bold700.transform {
                    it.copy(fontSize = if (isCompact) 20.sp else 24.sp)
                }
            ),
            Modifier.padding(bottom = 16.dp)
        )

        WebText(
            SushiTextProps(
                text = component.sampleCodeDescription,
                type = SushiTextType.Regular400,
                color = SushiTheme.colors.grey.v700
            ),
            Modifier.padding(bottom = 24.dp)
        )

        CodeExample(component, isCompact)

        Spacer(Modifier.height(if (isCompact) 24.dp else 40.dp))

        WebText(
            SushiTextProps(
                text = "Component API",
                type = SushiTextType.Bold700.transform {
                    it.copy(fontSize = if (isCompact) 20.sp else 24.sp)
                }
            ),
            Modifier.padding(bottom = 16.dp)
        )

        ComponentAPITable(component, isCompact)
    }
}

@Composable
private fun ComponentPreview(
    component: Component,
    isCompact: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .background(SushiTheme.colors.grey.v100.value, RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Image(
            painter = painterResource(component.banner),
            contentDescription = null,
            Modifier
                .padding(SushiTheme.dimens.spacing.loose)
                .align(Alignment.Center)
        )
    }
}

@Composable
private fun CodeExample(component: Component, isCompact: Boolean) {
    Box(
        Modifier
            .fillMaxWidth()
            .background(
                SushiTheme.colors.grey.v100.value,
                RoundedCornerShape(8.dp)
            )
    ) {
        WebText(
            SushiTextProps(
                text = "Copy",
                type = SushiTextType.Regular400,
                color = SushiTheme.colors.grey.v400
            ),
            Modifier
                .clickable { }
                .padding(8.dp)
                .align(Alignment.TopEnd)
        )

        SelectionContainer(
            Modifier
                .horizontalScroll(rememberScrollState())
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Text(
                parseCodeAsAnnotatedString(
                    PrettifyParser(),
                    DefaultTheme(),
                    CodeLang.Kotlin,
                    component.sampleCode
                ),
                fontFamily = MonoSpaceFontFamily,
                fontWeight = FontWeight.W600,
                color = SushiTheme.colors.blue.v600.value
            )
        }
    }
}

@Composable
private fun ComponentAPITable(
    component: Component,
    isCompact: Boolean
) {
    component.apiParameters.forEach { parameter ->
        Column(
            Modifier
                .padding(bottom = 12.dp)
                .fillMaxWidth()
                .border(
                    1.dp,
                    SushiTheme.colors.grey.v300.value,
                    RoundedCornerShape(8.dp)
                )
                .background(
                    SushiTheme.colors.white.value,
                    RoundedCornerShape(8.dp)
                )
        ) {
            WebText(
                SushiTextProps(
                    text = parameter.name,
                    type = SushiTextType.SemiBold500
                ),
                Modifier.padding(if (isCompact) 16.dp else 20.dp)
            )

            if (isCompact) {
                // Stack layout for mobile
                parameter.items.forEach { param ->
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .background(SushiTheme.colors.grey.v100.value)
                            .padding(vertical = 12.dp, horizontal = 16.dp)
                    ) {
                        Text(
                            param.first,
                            fontFamily = MonoSpaceFontFamily,
                            fontWeight = FontWeight.W600,
                            color = SushiTheme.colors.blue.v600.value
                        )
                        Spacer(Modifier.height(4.dp))
                        WebText(
                            SushiTextProps(
                                text = param.second,
                                type = SushiTextType.Regular400,
                                color = SushiTheme.colors.grey.v700
                            )
                        )
                    }
                }
            } else {
                // Table layout for desktop
                Row(
                    Modifier
                        .fillMaxWidth()
                        .background(SushiTheme.colors.grey.v100.value)
                        .padding(vertical = 12.dp, horizontal = 20.dp)
                ) {
                    WebText(
                        SushiTextProps(
                            text = "Parameter",
                            type = SushiTextType.Medium500
                        ),
                        Modifier.weight(1f)
                    )
                    WebText(
                        SushiTextProps(
                            text = "Description",
                            type = SushiTextType.Medium500
                        ),
                        Modifier.weight(2f)
                    )
                }

                parameter.items.forEach { param ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp, horizontal = 20.dp)
                    ) {
                        Text(
                            param.first,
                            Modifier.weight(1f),
                            fontFamily = MonoSpaceFontFamily,
                            fontWeight = FontWeight.W600,
                            color = SushiTheme.colors.blue.v600.value,
                        )
                        WebText(
                            SushiTextProps(
                                text = param.second,
                                type = SushiTextType.Regular400,
                                color = SushiTheme.colors.grey.v700
                            ),
                            Modifier.weight(2f)
                        )
                    }
                }
            }
        }
    }
}
