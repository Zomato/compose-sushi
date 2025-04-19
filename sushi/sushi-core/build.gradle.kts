plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.vanniktech.publish)
    alias(libs.plugins.kotlin.dokka)
}

@Suppress("UNCHECKED_CAST")
val getVersionInfoFunc = rootProject.extra["getVersionInfo"] as (String?) -> List<String>
val versionInfo = getVersionInfoFunc(projectDir.absolutePath)
val versionCode = versionInfo[0].toInt()
val versionName = versionInfo[1].toString()

mavenPublishing {
    coordinates("com.eternal.kits", project.name, versionName)
    configureBasedOnAppliedPlugins(false, false)

    pom {
        name.set(project.name.capitalize())
        description.set("Eternal library - ${project.name}")
        inceptionYear.set("2025")
        url.set("https://github.com/Zomato")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("tronku")
                name.set("Shubham Pathak")
                url.set("https://github.com/tronku/")
            }
        }
        scm {
            url.set("https://github.com/Zomato")
            connection.set("scm:git:git://github.com/Zomato/Android.git")
            developerConnection.set("scm:git:ssh://git@github.com/uZomato/Android.git")
        }
    }
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

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        create("external") {
            matchingFallbacks += listOf("release")
            isMinifyEnabled = false
            buildConfigField("boolean", "EXTERNAL", "true")
            proguardFiles("proguard-rules.pro")
        }
    }
}

dependencies {
    
}