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

include(":app")
include(":website")
