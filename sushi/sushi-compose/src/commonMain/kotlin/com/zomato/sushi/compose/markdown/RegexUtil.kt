package com.zomato.sushi.compose.markdown

import androidx.compose.ui.text.TextRange

internal fun MatchGroup.getTextRange(): TextRange {
    return getGroupRange().let {
        TextRange(it.start, it.endExclusive)
    }
}

internal expect fun MatchGroup.getGroupRange(): IntRange