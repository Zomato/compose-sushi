package com.zomato.sushi.compose.foundation

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily

/**
 * Defines the Okra font family used as the primary typeface in the Sushi design system.
 *
 * @author gupta.anirudh@zomato.com
 */
expect val OkraFontFamily: FontFamily

/**
 * Defines the Wasabicons font family used for icons in the Sushi design system.
 * 
 * This custom icon font allows rendering vector icons as text characters,
 * enabling efficient icon display with color and size control through text styling.
 */
expect val WasabiFontFamily: FontFamily

/**
 * Encapsulates the complete typography system for the Sushi design system.
 * 
 * SushiTypography provides a comprehensive collection of text styles for different
 * font weights and sizes, organized following a consistent naming convention of
 * [FontWeight][FontSize] (e.g., regular300, bold500). This structure enables
 * precise typography control throughout the application while maintaining visual
 * consistency.
 * 
 * The class also includes Material Typography definitions to ensure proper styling
 * of standard Material components.
 *
 * @property materialTypography Typography definitions for Material components
 * @property light050 through extraBold900 Text styles for all weight/size combinations
 *
 * @author gupta.anirudh@zomato.com
 */
data class SushiTypography(
    val materialTypography: Typography,
    
    // Light weight text styles
    val light050: TextStyle,
    val light100: TextStyle,
    val light200: TextStyle,
    val light300: TextStyle,
    val light400: TextStyle,
    val light500: TextStyle,
    val light600: TextStyle,
    val light700: TextStyle,
    val light800: TextStyle,
    val light900: TextStyle,
    
    // Regular weight text styles
    val regular050: TextStyle,
    val regular100: TextStyle,
    val regular200: TextStyle,
    val regular300: TextStyle,
    val regular400: TextStyle,
    val regular500: TextStyle,
    val regular600: TextStyle,
    val regular700: TextStyle,
    val regular800: TextStyle,
    val regular900: TextStyle,
    
    // Medium weight text styles
    val medium050: TextStyle,
    val medium100: TextStyle,
    val medium200: TextStyle,
    val medium300: TextStyle,
    val medium400: TextStyle,
    val medium500: TextStyle,
    val medium600: TextStyle,
    val medium700: TextStyle,
    val medium800: TextStyle,
    val medium900: TextStyle,
    
    // Semi-bold weight text styles
    val semiBold050: TextStyle,
    val semiBold100: TextStyle,
    val semiBold200: TextStyle,
    val semiBold300: TextStyle,
    val semiBold400: TextStyle,
    val semiBold500: TextStyle,
    val semiBold600: TextStyle,
    val semiBold700: TextStyle,
    val semiBold800: TextStyle,
    val semiBold900: TextStyle,
    
    // Bold weight text styles
    val bold050: TextStyle,
    val bold100: TextStyle,
    val bold200: TextStyle,
    val bold300: TextStyle,
    val bold400: TextStyle,
    val bold500: TextStyle,
    val bold600: TextStyle,
    val bold700: TextStyle,
    val bold800: TextStyle,
    val bold900: TextStyle,
    
    // Extra-bold weight text styles
    val extraBold050: TextStyle,
    val extraBold100: TextStyle,
    val extraBold200: TextStyle,
    val extraBold300: TextStyle,
    val extraBold400: TextStyle,
    val extraBold500: TextStyle,
    val extraBold600: TextStyle,
    val extraBold700: TextStyle,
    val extraBold800: TextStyle,
    val extraBold900: TextStyle
)

/**
 * Default Material Typography with Okra font family applied to all text styles.
 * 
 * This ensures that standard Material components will use the Sushi design system's
 * primary font family while maintaining Material's typography scale.
 */
internal expect val MaterialTypography: Typography
