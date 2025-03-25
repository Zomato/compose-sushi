import com.zomato.plugins.publish.ArtifactInfo
import com.zomato.plugins.publish.BuildType

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.publish)
}

// Maven Publishing Details
@Suppress("UNCHECKED_CAST")
val getVersionInfoFunc = rootProject.extra["getVersionInfo"] as (String?) -> List<String>
val versionInfo = getVersionInfoFunc(projectDir.absolutePath)
val versionCode = versionInfo[0].toInt()
val versionName = versionInfo[1].toString() // Ensure it's a String

// Access the properties from root project
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
    namespace = "com.zomato.sushi.core"

    compileSdk = 35

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    
}