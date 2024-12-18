package com.javieriq.artinstitvte.utils

import android.util.Log
import com.javieriq.artinstitvte.utils.Constants.TAG

object Logger {
    fun debug(message: String) {
        Log.d(TAG, message)
    }

    fun error(message: String, throwable: Throwable? = null) {
        Log.e(TAG, message, throwable)
    }
}