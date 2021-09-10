package com.bedu.auth.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.bedu.auth.R
import com.google.android.material.snackbar.Snackbar

object Utility {

    //display SnackBar
    fun displaySnackBar(view: View, s: String, context: Context, @ColorRes colorRes: Int) {

        Snackbar.make(view, s, Snackbar.LENGTH_LONG)
            .withColor(ContextCompat.getColor(context, colorRes))
            .setTextColor(ContextCompat.getColor(context, R.color.white))
            .show()

    }

    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }

    private fun Snackbar.withColor(@ColorInt colorInt: Int): Snackbar {
        this.view.setBackgroundColor(colorInt)
        return this
    }
}