pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        // todox: remove?
        maven {
            url = uri("https://maven.pkg.github.com/Zomato/*")
            credentials {
                username = "Zomato"
                password = System.getenv("READ_ARTIFACTS_TOKEN")
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // todox: remove?
        maven {
            url = uri("https://maven.pkg.github.com/Zomato/*")
            credentials {
                username = "Zomato"
                password = System.getenv("READ_ARTIFACTS_TOKEN")
            }
        }
    }
}

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

rootProject.name = "Sushi Compose"
include(":app")

includeKits(
    "sushi/sushi-core",
    "sushi/sushi-compose",
)
