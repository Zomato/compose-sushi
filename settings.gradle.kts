import java.util.Properties
import java.io.File

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

includeBuild("build-logic")

fun includeKits(vararg kits: String) {
    for (kit in kits) {
        var kitPath = "$kit/$kit"
        var kitName = kit
        if (kit.contains('/')) {
            kitPath = kit
            val splitData = kit.split('/')
            kitName = splitData[splitData.size - 1]
        }
        include(":$kitName")
        project(":$kitName").projectDir = File(settingsDir, kitPath)
    }
}

rootProject.name = "ComposeSushi"

includeKits(
    "sushi/sushi-core",
    "sushi/sushi-compose",
)

fun shouldIncludeSampleApps(): Boolean {
    if (gradle.parent == null) {
        return true
    }

    return try {
        val parentProjectDir = gradle.parent?.startParameter?.projectDir
        val localPropsFile = File(parentProjectDir, "local.properties")

        val localProps = Properties()
        if (localPropsFile.exists()) {
            localPropsFile.inputStream().use { localProps.load(it) }
        }
        localProps.getProperty("compositeBuild.includeSampleApps") == "true"
    } catch (e: Throwable) {
        false
    }
}

if (shouldIncludeSampleApps()) {
    include(":app")
    include(":website")
}