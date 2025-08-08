package com.zomato

import com.zomato.data.Config
import java.util.*

private val snakeRegex = "_[a-zA-Z0-9]".toRegex()
private val specialCaseRegex = Regex("[^A-Za-z0-9]")

private fun String.snakeToLowerCamelCase(): String {
    return snakeRegex.replace(this) {
        it.value.replace("_","")
            .uppercase(Locale.getDefault())
    }
}

private fun String.snakeToUpperCamelCase(): String {
    return this.snakeToLowerCamelCase().capitalize()
}

private fun String.replaceSpecialCase(): String {
    return this.replace(specialCaseRegex, "_")
}

private fun String.sanitize(): String {
    return this
        .replace('-', '_')
        .snakeToUpperCamelCase()
        .replaceSpecialCase()
}

internal fun generateKtOutput(config: Config): String {
    val stringResArr = config.glyphs.map { icon ->
        """val Icon${icon.css.sanitize()} = SushiIconCode("${icon.code.toString(16)}")"""
    }

    val output = buildString {
        appendLine("package com.zomato.sushi.compose.atoms.icon")
        appendLine()
        appendLine("// Generated file. DO NOT EDIT.")
        appendLine("object SushiIconCodes {")
        stringResArr.map {
            appendLine("    $it")
        }
        appendLine("}")
    }

    return output
}