import com.zomato.plugins.publish.ArtifactInfo
import com.zomato.plugins.publish.BuildType

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.publish)
    alias(libs.plugins.compose.screenshot)
    alias(libs.plugins.kotlin.compose)
}

// Maven Publishing Details
@Suppress("UNCHECKED_CAST")
val getVersionInfoFunc = rootProject.extra["getVersionInfo"] as (String?) -> List<String>
val versionInfo = getVersionInfoFunc(projectDir.absolutePath)
val versionCode = versionInfo[0].toInt()
val versionName = versionInfo[1].toString()

val monoGroupId = rootProject.extra["monoGroupId"] as String
val monoRepo = rootProject.extra["monoRepo"] as String

val artifactData = ArtifactInfo(monoGroupId, project.name, versionName, monoRepo, false)
val releaseBuildData = BuildType("release", null, false)
val debugBuildData = BuildType("debug", null, false)

mavenPublishing {
    artifactInfo = artifactData
    buildTypes = listOf(releaseBuildData, debugBuildData)
}

android {
    namespace = "com.zomato.sushi.compose"

    compileSdk = 35

    experimentalProperties["android.experimental.enableScreenshotTest"] = true

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    api(project(":sushilib-core"))

    api(libs.lottie.compose)
    api(libs.kotlinx.collections.immutable)

    lintChecks(libs.slack.compose.lint)

    // Compose dependencies
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.material3)

    // Android Studio Preview support
    api(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling)
}