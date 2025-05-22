import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "1.9.0"
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
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
//            implementation(compose.preview)
//            implementation(libs.androidx.activity.compose)
//            implementation(libs.kotlinx.coroutines.android)
        }
        commonMain.dependencies {
//            api(compose.runtime)
//            api(compose.foundation)
//            api(compose.material3)
//            api(compose.ui)
//            implementation(compose.components.uiToolingPreview)
//            implementation(libs.androidx.lifecycle.viewmodel)
//            implementation(libs.androidx.lifecycle.runtime.compose)
//            implementation(libs.napier)
//            api(libs.kotlinx.collections.immutable)
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