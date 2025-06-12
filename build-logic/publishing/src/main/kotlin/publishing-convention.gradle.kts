import java.util.Properties

plugins {
    id("com.vanniktech.maven.publish")
}

val props = Properties()
file("../version.properties").inputStream().use { props.load(it) }

val versionCode = props.getProperty("VERSION_CODE")
val versionName = props.getProperty("VERSION_NAME")

publishing {
    repositories {
        maven("https://maven.pkg.github.com/Zomato/kmm-core-libs") {
            name = "Zomato"
            credentials {
                username = "Zomato"
                password = System.getenv("READ_ARTIFACTS_TOKEN")
            }
        }
        mavenLocal()
    }
}

mavenPublishing {
    coordinates(
        groupId = "com.zomato.kmm",
        artifactId = project.name,
        version = versionName
    )

    pom {
        name.set(project.findProperty("publishingName") as String? ?: "Sushi Compose")
        description.set(
            project.findProperty("publishingDescription") as String?
                ?: "Sushi Design System for Compose Multiplatform"
        )
        inceptionYear.set("2025")
        url.set("https://github.com/Zomato/compose-sushi")

        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("repo")
            }
        }

        developers {
            developer {
                id.set("zomato")
                name.set("Zomato")
                url.set("https://github.com/Zomato")
            }
        }
    }
}
