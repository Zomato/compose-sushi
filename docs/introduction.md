---
title: Introduction
description: Sushi UI is a comprehensive design system built for Compose Multiplatform applications with a focus on consistency, customization, and accessibility.
---

# Sushi UI

Sushi UI is a comprehensive design system for Jetpack Compose that provides a rich set of
customizable components for building beautiful, consistent, and accessible user interfaces.

## Overview

Sushi UI offers a collection of ready-to-use components that follow a consistent design language
while providing extensive customization options. The library is built on top of Jetpack Compose and
is designed to make UI development faster, more consistent, and more enjoyable.

## Key Features

### Comprehensive Component Library

Sushi UI includes a wide range of components from basic atoms like buttons, text fields, and cards
to complex components like bottom sheets, dialogs, and navigation components. Each component is
carefully designed to provide a consistent look and feel while offering extensive customization
options.

### Consistent Props-Based API

All components follow a consistent API pattern using Props objects that make customization intuitive
and easy to understand. This approach ensures that components are used consistently throughout your
application and reduces the learning curve for developers.

### Theming System

Sushi UI provides a robust theming system that allows you to customize the look and feel of all
components with minimal effort. The theming system includes:

- Color schemes with light and dark variants
- Typography scales
- Dimension systems
- Shape definitions

### Accessibility Built-In

Accessibility features are built into every component, ensuring that your applications are usable by
everyone, including people with disabilities. Components follow WCAG guidelines and support TalkBack
on Android.

### Markdown Support

Many text components in Sushi UI support markdown formatting, allowing you to easily add rich text
formatting to your UI.

## Getting Started

The best way to get started with Sushi UI is to explore the component documentation and examples.
Check out the [Button](sushibutton.md) component to see how Sushi UI components work.

## Component Categories

Sushi UI components are organized into the following categories:

### Atoms and Components

Building blocks that form the foundation of the design system:

- [SushiText](sushitext.md): Text component with styling options, decorations, prefix/suffix icons, expandable support, etc.
- [SushiIcon](sushiicon.md): Component that displays an icon from the Sushi design system.
- [SushiButton](sushibutton.md): Button component that supports different visual styles, sizes, and content configurations.
- [SushiImage](sushiimage.md): Component that displays images in the Sushi design system.
- [SushiCheckBox](sushicheckbox.md):Checkbox component for the Sushi design system.
- [SushiRadioButton](sushiradiobutton.md): Radio button component for the Sushi design system.
- [SushiSwitch](sushiswitch.md): Toggle switch component for the Sushi design system.
- [SushiTag](sushitag.md): Tag component for the Sushi design system.
- [SushiTextField](sushitextfield.md): Text input field component for the Sushi design system.
- [SushiAnimation](sushianimation.md): Component for displaying animations in the Sushi design system, supports Lottie animations and different playback behaviors.
- [SushiLoader](sushiloader.md): Component that displays an animated loading indicator with two concentric rotating arcs.
- [SushiCard](sushicard.md): Card component for the Sushi design system.
- [SushiIndicator](sushiindicator.md): Component to display page indicators for carousel, pager components, etc.
- [SushiDivider](sushidivider.md): Component that displays a divider with various customizable styles.
- [SushiShimmer](sushishimmer.md): Component that displays a shimmer loading effect over placeholder content.
- [SushiSnackbar](sushisnackbar.md): Component that displays a snackbar message with an optional action.
- [SushiBottomSheet](sushibottomsheet.md): Customizable bottom sheet component for the Sushi design system.
- [SushiDialog](sushidialog.md): Customizable alert dialog component for the Sushi design system.
- [SushiDropDown](sushidropdown.md): Dropdown menu component with support for checkbox and radio based selections.
- [SushiMedia](sushimedia.md): Unified media component for the Sushi design system that can display different types of media.
- [SushiOTPInput](sushiotpinput.md): Customizable OTP (One-Time Password) input field component.
- [SushiHorizontalPager](sushihorizontalpager.md): Component that allow users to swipe between pages of content horizontally.
- [SushiVerticalPager](sushiverticalpager.md): Component that allow users to swipe between pages of content vertically.
- [SushiRatingBar](sushiratingbar.md): Rating bar component for the Sushi design system.
- [SushiTooltip](sushitooltip.md): Customizable tooltip component for the Sushi design system.
- [SushiViewFlipper](sushiviewflipper.md): Component that automatically cycles through multiple content items with animated transitions.

[//]: # (### todox: Utilities)

[//]: # ()
[//]: # ()
[//]: # (Helper components and modifiers that enhance the user experience:)

[//]: # ()
[//]: # ()
[//]: # (- [Scrollbars]&#40;scrollarea.md&#41;: Components for indicating scroll position)

[//]: # ()
[//]: # (- [Progress Indicator]&#40;progressindicator.md&#41;: Components for showing loading or progress)

[//]: # (- [Separator]&#40;separators.md&#41;: Visual dividers between content sections)

## Design Principles

Sushi UI is built with the following principles in mind:

1. **Consistency**: All components follow the same design language and API patterns
2. **Customization**: Every aspect of the components can be customized to fit your needs
3. **Accessibility**: Components are designed to be usable by everyone
4. **Performance**: Components are optimized for performance and minimal recompositions
5. **Developer Experience**: APIs are intuitive and easy to use

## Contributing

Sushi UI is an open-source project, and contributions are welcome. Please check
the [GitHub repository](https://github.com/Zomato/sushi-compose) for more information on how to
contribute.

## Installation

Add Sushi UI to your project by including the dependency in your build.gradle file:
```kotlin title="build.gradle.kts"
repositories {
    mavenCentral()
}

dependencies {
    implementation("com.eternal.kits:sushi-compose:0.0.1")
}
```