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

internal fun String.sanitizeForDisplay(): String = this.sanitize()

internal fun generateKtOutput(
    config: Config,
    objectName: String = "SushiIconCodes",
    packageName: String = "com.zomato.sushi.compose.atoms.icon"
): String {
    val stringResArr = config.glyphs.map { icon ->
        """val Icon${icon.css.sanitize()} = SushiIconCode("${icon.code.toString(16)}")"""
    }
    val previewList = config.glyphs.map { icon ->
        "\"${icon.css.sanitize()}\" to $objectName.Icon${icon.css.sanitize()},"
    }

    val output = buildString {
        appendLine(
            """
                package $packageName

                import androidx.compose.runtime.Composable
                import org.jetbrains.compose.ui.tooling.preview.Preview

                // Generated file. DO NOT EDIT.
                object $objectName {
${stringResArr.joinToString("\n") { "                    $it" }}
                }

                @Preview(widthDp = 560)
                @Composable
                private fun ${objectName}Preview() {
                    val icons = listOf(
${previewList.joinToString("\n") { "                        $it" }}
                    )
                    SushiIconCodesPreview(icons)
                }
            """.trimIndent()
        )
    }

    return output
}