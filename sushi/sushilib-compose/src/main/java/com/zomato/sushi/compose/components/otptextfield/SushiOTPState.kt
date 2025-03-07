package com.zomato.sushi.compose.components.otptextfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.SoftwareKeyboardController

/**
 * @author gupta.anirudh@zomato.com
 */
class SushiOTPState(
    val length: Int,
    val focusManager: FocusManager,
    private val keyboardController: SoftwareKeyboardController?,
    initialOtp: String = "",
) {
    var code by mutableStateOf(initialOtp.padEnd(length, ' '))
        private set
    val interactionSources = List(length) { MutableInteractionSource() }

    fun onDigitEntered(index: Int, value: Char) {
        if (index in code.indices) {
            val chars = code.toCharArray()
            chars[index] = value
            code = chars.concatToString()

            // Handle focus after digit entry
            if (index < length - 1) {
                focusManager.moveFocus(FocusDirection.Companion.Next)
            } else {
                keyboardController?.hide()
            }
        }
    }

    fun onDigitDeleted(index: Int) {
        if (index in code.indices) {
            val chars = code.toCharArray()
            chars[index] = ' '
            code = chars.concatToString()

            if (index > 0 && isFieldEmpty(index)) {
                focusManager.moveFocus(FocusDirection.Companion.Previous)
            }
        }
    }

    fun onBackspacePressed(index: Int) {
        if (index > 0 && isFieldEmpty(index)) {
            focusManager.moveFocus(FocusDirection.Companion.Previous)
            onDigitDeleted(index - 1)
        }
    }

    fun isFieldEmpty(index: Int): Boolean {
        return code.getOrNull(index)?.isWhitespace() ?: true
    }

    fun isComplete(): Boolean {
        return code.trim().length == length
    }
}