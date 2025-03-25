// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.publish) apply false
    alias(libs.plugins.compose.screenshot) apply false
    alias(libs.plugins.android.library) apply false
}

extra.run {
    set("monoGroupId", "com.zomato.kits")
    set("monoRepo", "android-mono-repo")

    set("getVersionInfo", { projectDirPath: String? ->
        val resolvedProjectDirPath = projectDirPath ?: projectDir.absolutePath
        val packageRoot = File(resolvedProjectDirPath).relativeTo(rootDir).path.split("/").first()
        val props = java.util.Properties()
        file("$packageRoot/version.properties").inputStream().use { props.load(it) }

        val versionCodeResolved = props.getProperty("VERSION_CODE")
        var versionNameResolved = props.getProperty("VERSION_NAME")
        if (project.hasProperty("VersionName")) {
            versionNameResolved = project.property("VersionName").toString()
        }
        listOf(versionCodeResolved, versionNameResolved)
    })
}