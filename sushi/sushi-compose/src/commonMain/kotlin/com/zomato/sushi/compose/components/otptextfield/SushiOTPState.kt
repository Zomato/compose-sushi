package com.zomato.sushi.compose.components.otptextfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.SoftwareKeyboardController

/**
 * Manages the state of an OTP (One-Time Password) input field.
 * 
 * SushiOTPState handles the OTP input value, focus management between digit fields,
 * and keyboard interactions, providing a cohesive experience for entering verification codes.
 *
 * @property length The number of digits in the OTP
 * @property focusManager Used to manage focus across the digit fields
 * @property keyboardController Used to control the keyboard (show/hide)
 * @property code The current OTP value (padded with spaces to fill length)
 * @property interactionSources List of interaction sources for each digit field
 *
 * @param initialOtp Optional initial value for the OTP
 *
 * @author gupta.anirudh@zomato.com
 */
class SushiOTPState(
    val length: Int,
    val focusManager: FocusManager,
    private val keyboardController: SoftwareKeyboardController?,
    initialOtp: String = "",
) {
    /**
     * The current OTP value entered by the user.
     * Empty positions are filled with spaces.
     */
    var code by mutableStateOf(initialOtp.padEnd(length, ' '))
        private set
        
    /**
     * Interaction sources for each digit field, used for focus management.
     */
    val interactionSources = List(length) { MutableInteractionSource() }

    /**
     * Handles when a digit is entered in a specific field.
     * 
     * Updates the code at the specified index and manages focus by moving
     * to the next field (or hiding keyboard if on the last field).
     *
     * @param index The position of the digit field being modified
     * @param value The character that was entered
     */
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

    /**
     * Handles when a digit is deleted from a specific field.
     * 
     * Clears the code at the specified index and manages focus if needed.
     *
     * @param index The position of the digit field being cleared
     */
    fun onDigitDeleted(index: Int) {
        if (index in code.indices) {
            val chars = code.toCharArray()
            chars[index] = ' '
            code = chars.concatToString()
        }
    }

    /**
     * Handles backspace key press in a specific field.
     * 
     * If the current field is empty, moves focus to the previous field
     * and deletes its content.
     *
     * @param index The position of the digit field where backspace was pressed
     */
    fun onBackspacePressed(index: Int) {
        if (isFieldEmpty(index)) {
            if (index > 0) {
                focusManager.moveFocus(FocusDirection.Companion.Previous)
                onDigitDeleted(index - 1)
            }
        } else {
            onDigitDeleted(index)
        }
    }

    /**
     * Checks whether a specific digit field is empty.
     *
     * @param index The position to check
     * @return True if the field is empty or contains only whitespace
     */
    fun isFieldEmpty(index: Int): Boolean {
        return code.getOrNull(index)?.isWhitespace() ?: true
    }

    /**
     * Checks whether all OTP fields have been filled.
     *
     * @return True if all fields have been filled (code is complete)
     */
    fun isComplete(): Boolean {
        return code.trim().length == length
    }
}