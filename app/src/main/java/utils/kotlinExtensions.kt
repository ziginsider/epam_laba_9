package io.github.ziginsider.epam_laba_9.utils

import android.util.Log
import io.github.ziginsider.epam_laba_9.BuildConfig

/**
 * Extension for LogCat
 */
fun logi(className: String, message: String) {
    if (BuildConfig.DEBUG) Log.i(className, message)
}