import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    kotlin("plugin.serialization") version "1.9.0"
    id("publishing-convention")
}

ext {
    set("publishingName", "Sushi Compose")
    set("publishingDescription", "Sushi Design System for Compose Multiplatform")
}

compose.resources {
    publicResClass = true
    generateResClass = always
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    jvm("desktop")

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    js(IR) {
        browser()
        binaries.executable()
    }

    val xcf = XCFramework()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "sushi"
            xcf.add(this)
            isStatic = true
        }
    }

    sourceSets {

        // Create a source set that includes all targets except Android
        val nonAndroidMain by creating {
            dependsOn(commonMain.get())
        }

        // Create iosMain explicitly
        val iosMain by creating {
            dependsOn(commonMain.get())
            dependsOn(nonAndroidMain)
        }

        val desktopMain by getting {
            dependsOn(nonAndroidMain)
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }

        val jsMain by getting {
            dependsOn(nonAndroidMain)
        }

        val wasmJsMain by getting {
            dependsOn(nonAndroidMain)
        }

        val iosX64Main by getting {
            dependsOn(iosMain)
        }

        val iosArm64Main by getting {
            dependsOn(iosMain)
        }

        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(compose.uiTooling)
            implementation(libs.androidx.activity.compose)
            implementation(libs.lottie.compose)
        }

        commonMain.dependencies {
            api(compose.runtime)
            api(compose.foundation)
            api(compose.material3)
            api(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.kotlinx.collections.immutable)
            implementation(libs.kotlinx.datetime)
            api(project(":sushi-core"))
            implementation(libs.kotlinx.coroutines.core)
        }
        wasmJsMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
        }
        nativeMain.dependencies {

        }
    }
}

android {
    namespace = "com.zomato.sushi.compose"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
    debugImplementation(compose.preview)
    lintChecks(libs.slack.lint.checks)
}
