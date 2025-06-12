import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "1.9.0"
    id("publishing-convention")
}

ext {
    set("publishingName", "Sushi Core")
    set("publishingDescription", "Core utilities and foundations for Sushi Design System")
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

        androidMain.dependencies {

        }

        val desktopMain by getting {
            dependencies {
            }
        }

        commonMain.dependencies {

        }
        wasmJsMain.dependencies {

        }
        nativeMain.dependencies {

        }
    }
}

android {
    namespace = "com.zomato.sushi.core"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
//    sourceSets["main"].apply {
//        res.srcDirs("src/androidMain/res", "src/commonMain/composeResources")
//        resources.srcDirs("src/androidMain/res", "src/commonMain/composeResources")
//    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
