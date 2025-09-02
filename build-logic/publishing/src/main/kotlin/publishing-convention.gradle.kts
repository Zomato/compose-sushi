import java.util.Properties

plugins {
    id("com.vanniktech.maven.publish")
}

val versionProps = Properties().apply {
    file("../version.properties").inputStream().use { load(it) }
}

val localProps = Properties().apply {
    file("../../local.properties").inputStream().use { load(it) }
}

val versionName = versionProps.getProperty("VERSION_NAME")

publishing {
    repositories {
        mavenLocal()
    }
}

mavenPublishing {
    coordinates(
        groupId = "com.eternal.kits",
        artifactId = project.name,
        version = versionName
    )

    publishToMavenCentral(automaticRelease = true)
    signAllPublications()

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
                id.set("firefinchdev")
                name.set("Anirudh Gupta")
                url.set("https://github.com/firefinchdev")
            }
        }
        scm {
            url.set("https://github.com/Zomato/compose-sushi")
            connection.set("scm:git:git://github.com/Zomato/compose-sushi.git")
            developerConnection.set("scm:git:ssh://github.com/Zomato/compose-sushi.git")
        }
    }
}
