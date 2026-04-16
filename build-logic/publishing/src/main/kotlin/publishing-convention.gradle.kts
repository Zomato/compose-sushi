import java.util.Properties
import org.gradle.api.publish.maven.tasks.PublishToMavenRepository
import org.gradle.kotlin.dsl.*

plugins {
    id("com.vanniktech.maven.publish")
}

val versionProps = Properties().apply {
    file("../version.properties").inputStream().use { load(it) }
}

val localProps = Properties().apply {
    file("../../local.properties").inputStream().use { load(it) }
}

val secretsProps = Properties().apply {
    val secretsFile = file("../../secrets.properties")
    if (secretsFile.exists()) {
        secretsFile.inputStream().use { load(it) }
    }
}

val versionName: String = versionProps.getProperty("VERSION_NAME")

publishing {
    repositories {
        mavenLocal()
        maven {
            name = "zomato"
            url = uri("https://maven.pkg.github.com/Zomato/compose-sushi")
            credentials {
                username = secretsProps.getProperty("publishing.repo.username", "")
                password = secretsProps.getProperty("publishing.repo.password", "")
            }
        }
    }
}

mavenPublishing {
    coordinates(
        groupId = "com.zomato.kits",
        artifactId = project.name,
        version = versionName
    )

//    publishToMavenCentral(automaticRelease = true)
//    signAllPublications()

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
