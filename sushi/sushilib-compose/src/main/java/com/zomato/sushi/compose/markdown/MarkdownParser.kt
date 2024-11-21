package com.zomato.sushi.compose.markdown

import android.content.Context
import androidx.compose.ui.text.AnnotatedString
import androidx.core.util.Pair
import java.util.ArrayDeque
import java.util.Deque

class MarkdownParser {
    companion object {

        const val PARSER_VERSION_1 = 1
        const val PARSER_VERSION_2 = 2
        const val PARSER_VERSION_3 = 3

        /**
         * Util to parse markdown String
         */
        fun parse(
            text: String?,
            isClickable: Boolean = false,
            parserVersion: Int = PARSER_VERSION_1,
            context: Context?
        ): AnnotatedString {
            if (text.isNullOrEmpty()) return AnnotatedString("")
            val builder = AnnotatedString.Builder()
            val markDownProcessors = initMarkdownParser(
                BoldProcessor(parserVersion),
                ItalicsProcessor(parserVersion),
                StrikethroughProcessor(parserVersion)
            )
            getPreProcessedSpannableBuilder(
                text,
                ArrayDeque(),
                builder,
                markDownProcessors
            )

            return parseRegexTransformation(builder, false, context, 1)
        }

        private fun parseRegexTransformation(
            annotatedString: AnnotatedString.Builder,
            isClickable: Boolean,
            context: Context?,
            parserVersion: Int
        ): AnnotatedString {
            val regexProcessors = initRegexProcessor(parserVersion)
            var resultedAnnotatedString = annotatedString.toAnnotatedString()
            for (regexProcessor in regexProcessors) {
                if (regexProcessor is ColorProcessorCompose && context != null) {
                    resultedAnnotatedString = regexProcessor.transformWithColorData(
                        resultedAnnotatedString,
                        context
                    )
                } else if (regexProcessor is FontWeightProcessorCompose && context != null) {
                    resultedAnnotatedString = regexProcessor.transformWithFontData(
                        resultedAnnotatedString,
                        context
                    )
                }
            }
            return resultedAnnotatedString
        }

        private fun initRegexProcessor(parserVersion: Int): List<RegexProcessor<*>> {
            val regexProcessors: MutableList<RegexProcessor<*>> = java.util.ArrayList()
            regexProcessors.add(FontWeightProcessorCompose(parserVersion))
            regexProcessors.add((ColorProcessorCompose(parserVersion)))
            return regexProcessors
        }

        private fun getPreProcessedSpannableBuilder(
            string: String,
            stack: Deque<Pair<Int, String>>,
            builder: AnnotatedString.Builder,
            markdownProcessorHashMap: HashMap<String, MarkdownProcessor>
        ) {
            val keys = ArrayList(markdownProcessorHashMap.keys)
            var i = 0
            val size = string.length
            while (i < size) {
                var flag = false
                var j = 0
                val keysSize = keys.size
                while (j < keysSize) {
                    if (string.startsWith(keys[j], i)) {
                        flag = true
                        i += keys[j].length
                        val peek = stack.peek()
                        if (peek != null && peek.second == keys[j]) {
                            val pair = stack.pop()
                            markdownProcessorHashMap[pair.second]?.apply(
                                builder,
                                pair.first,
                                builder.length
                            )
                        } else {
                            stack.push(
                                Pair(builder.length, keys[j])
                            )
                        }
                        break
                    }
                    j++
                }
                if (!flag) {
                    builder.append(string[i])
                    i++
                }
            }
        }

        private fun initMarkdownParser(vararg markdownProcessors: MarkdownProcessor): HashMap<String, MarkdownProcessor> {
            val markdownProcessorHashMap = HashMap<String, MarkdownProcessor>()
            var i = 0
            val size = markdownProcessors.size
            while (i < size) {
                val markdownProcessor = markdownProcessors[i]
                markdownProcessorHashMap[markdownProcessor.getProcessingString()] = markdownProcessor
                i++
            }
            return markdownProcessorHashMap
        }
    }
}
