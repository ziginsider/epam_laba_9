package io.github.ziginsider.epam_laba_9.utils

import android.app.Activity
import android.app.Fragment
import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.github.ziginsider.epam_laba_9.BuildConfig

/**
 * Extension for LogCat
 */
fun logi(className: String, message: String) {
    if (BuildConfig.DEBUG) Log.i(className, message)
}

/**
 * Extension for ViewGroup. Inflates fab/
 *
 * @return Inflated View
 */
infix fun ViewGroup.inflate(layoutResId: Int): View =
        LayoutInflater.from(context).inflate(layoutResId, this, false)

/**
 * Extension show Toast for Activity.
 */
fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}
