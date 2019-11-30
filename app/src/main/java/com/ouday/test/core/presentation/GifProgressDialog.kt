package com.ouday.test.core.presentation

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View

import com.ouday.test.R

import java.io.IOException

import pl.droidsonroids.gif.GifDrawable


class GifProgressDialog(private val context: Context) {
    private val dialog: Dialog?

    private val view: View
        @SuppressLint("InflateParams")
        get() {
            val view = LayoutInflater.from(context).inflate(R.layout.dialog_gif, null)
            try {
                var gifDrawable: GifDrawable?
                gifDrawable = GifDrawable(context.resources, R.drawable.loading)
                gifDrawable.loopCount = 65535

            } catch (e: IOException) {
                Log.e("ioException", e.localizedMessage!!)
            }

            return view
        }

    val isShowing: Boolean
        get() = dialog!!.isShowing

    init {

        dialog = Dialog(context, R.style.ProgressDialog)
        dialog!!.setCancelable(false)
        dialog.setContentView(view)
    }

    fun showDialog() {
        if (dialog != null && !dialog.isShowing && !(context as Activity).isFinishing)
            dialog.show()
    }

    fun dismissDialog() {

        if (dialog != null && !(context as Activity).isFinishing)
            dialog.dismiss()
    }


    fun setCancelable(cancelable: Boolean) {
        dialog!!.setCancelable(cancelable)
    }

}
