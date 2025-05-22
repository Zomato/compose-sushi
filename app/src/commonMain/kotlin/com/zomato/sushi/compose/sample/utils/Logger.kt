package com.zomato.sushi.compose.sample.utils

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

object Logger {
    const val DEFAULT_TAG = "SAMPLE_APP"
    const val DEBUG_TAG = "${DEFAULT_TAG}_DEBUG"
    const val INFO_TAG = "${DEFAULT_TAG}_INFO"
    const val WARNING_TAG = "${DEFAULT_TAG}_WARNING"
    const val ERROR_TAG = "${DEFAULT_TAG}_ERROR"
    const val VERBOSE_TAG = "${DEFAULT_TAG}_VERBOSE"

    /**
     * Initialize the logger. Call this once at app startup.
     * @param isDebug whether the app is in debug mode
     */
    fun init(isDebug: Boolean) {
        if (isDebug) {
            Napier.base(DebugAntilog())
            debug(message = "Napier is initialized")
        }
    }

    fun debug(tag: String? = DEBUG_TAG, message: String, throwable: Throwable? = null) {
        Napier.d(message, tag = tag, throwable = throwable)
    }

    fun info(tag: String? = INFO_TAG, message: String, throwable: Throwable? = null) {
        Napier.i(message, tag = tag, throwable = throwable)
    }

    fun warning(tag: String? = WARNING_TAG, message: String, throwable: Throwable? = null) {
        Napier.w(message, tag = tag, throwable = throwable)
    }

    fun error(tag: String? = ERROR_TAG, message: String, throwable: Throwable? = null) {
        Napier.e(message, tag = tag, throwable = throwable)
    }

    fun verbose(tag: String? = VERBOSE_TAG, message: String, throwable: Throwable? = null) {
        Napier.v(message, tag = tag, throwable = throwable)
    }
}