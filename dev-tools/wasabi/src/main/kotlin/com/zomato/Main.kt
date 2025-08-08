package com.zomato

import com.zomato.data.Config
import kotlinx.serialization.json.Json
import java.io.File

fun main() {
    val config = getConfig()

    val ktContent = generateKtOutput(config)

    val outputDir = generatedOutputDirectory()

    writeFile(File(outputDir, "SushiIconCodes.kt"), ktContent)
}

private fun getConfig(): Config {
    val classLoader = Thread.currentThread().contextClassLoader
    val resource = classLoader.getResource("config.json")
        ?: throw IllegalArgumentException("File not found: config.json")

    return Json.decodeFromString<Config>(resource.readText())
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