plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.publish) apply false
    alias(libs.plugins.compose.screenshot) apply false
    alias(libs.plugins.kotlin.dokka)
}

afterEvaluate {
    subprojects {
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
            compilerOptions {
                freeCompilerArgs.add("-Xexpect-actual-classes")
            }
        }
    }
}


//extra.run {
//    set("monoGroupId", "com.zomato.kits")
//    set("monoRepo", "android-mono-repo")
//
//    set("getVersionInfo", { projectDirPath: String? ->
//        val resolvedProjectDirPath = projectDirPath ?: projectDir.absolutePath
//        val packageRoot = File(resolvedProjectDirPath).relativeTo(rootDir).path.split("/").first()
//        val props = java.util.Properties()
//        file("$packageRoot/version.properties").inputStream().use { props.load(it) }
//
//        val versionCodeResolved = props.getProperty("VERSION_CODE")
//        var versionNameResolved = props.getProperty("VERSION_NAME")
//        if (project.hasProperty("VersionName")) {
//            versionNameResolved = project.property("VersionName").toString()
//        }
//        listOf(versionCodeResolved, versionNameResolved)
//    })
//}
//
//task("generateDocs") {
//    dependsOn("dokkaHtmlMultiModule")
//    doLast {
//        println("Running MkDocs...")
//        exec {
//            commandLine("mkdocs", "build")
//            isIgnoreExitValue = false
//        }
//    }
//}