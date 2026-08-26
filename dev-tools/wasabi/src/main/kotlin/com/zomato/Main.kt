package com.zomato

import com.zomato.data.Config
import kotlinx.serialization.json.Json
import java.io.File

fun main(args: Array<String>) {
    val parsedArgs = parseArgs(args)
    val config = getConfig(parsedArgs.configPath)
    val filteredConfig = config.copy(glyphs = config.glyphs.filter { it.selected })

    val ktContent = generateKtOutput(
        config = filteredConfig,
        objectName = parsedArgs.objectName,
        packageName = parsedArgs.packageName
    )
    val mkDocsContent = generateMkDocsIconBrowserPage(filteredConfig)

    val outputDir = generatedOutputDirectory()

    writeFile(File(outputDir, "${parsedArgs.objectName}.kt"), ktContent)
    writeFile(File(outputDir, "icon-browser.md"), mkDocsContent)
}

private data class CliArgs(
    val configPath: String?,
    val objectName: String,
    val packageName: String
)

private fun parseArgs(args: Array<String>): CliArgs {
    val map = mutableMapOf<String, String>()
    var i = 0
    while (i < args.size - 1) {
        if (args[i].startsWith("--")) {
            map[args[i].removePrefix("--")] = args[i + 1]
            i += 2
        } else {
            i++
        }
    }
    return CliArgs(
        configPath = map["config"],
        objectName = map["objectName"] ?: "SushiIconCodes",
        packageName = map["package"] ?: "com.zomato.sushi.compose.atoms.icon"
    )
}

private fun getConfig(configPath: String?): Config {
    val text = if (configPath != null) {
        File(configPath).also {
            require(it.exists()) { "Config file not found: $configPath" }
        }.readText()
    } else {
        val classLoader = Thread.currentThread().contextClassLoader
        val resource = classLoader.getResource("config.json")
            ?: throw IllegalArgumentException("File not found: config.json")
        resource.readText()
    }
    return Json.decodeFromString<Config>(text)
}

private fun generatedOutputDirectory(): File {
    val outputDir = File("out")
    if (outputDir.exists()) {
        outputDir.deleteRecursively()
    }
    outputDir.mkdirs()
    return outputDir
}

private fun writeFile(outputFile: File, content: String) {
    outputFile.printWriter().use { writer ->
        writer.print(content)
    }
    println("File created at: ${outputFile.absolutePath}")
}
