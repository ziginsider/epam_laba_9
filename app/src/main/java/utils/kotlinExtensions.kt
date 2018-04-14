package io.github.ziginsider.epam_laba_9.utils

import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.ziginsider.epam_laba_9.BuildConfig

/**
 * Extension for LogCat
 */
fun logi(className: String, message: String) {
    if (BuildConfig.DEBUG) Log.i(className, message)
}

/**
 * Extension for ViewGroup. Inflates view/
 *
 * @return Inflated View
 */
infix fun ViewGroup.inflate(layoutResId: Int): View =
        LayoutInflater.from(context).inflate(layoutResId, this, false)

/**
 * Extension for Int. Converts <tt>Int</tt> to <tt>dp</dp>
 */
val Int.asDp: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()