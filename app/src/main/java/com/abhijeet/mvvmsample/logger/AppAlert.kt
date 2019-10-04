/*
 * Copyright (C) 2017. Avalon information System : Project ASMAN
 */

package com.abhijeet.samplemvp.logger

import android.app.AlertDialog
import android.content.Context
import android.view.View
import com.google.android.material.snackbar.Snackbar


/**
 * Show Alert Message in Snackbar.
 *
 * @param view
 * @param message
 */
fun showAlert(view: View, message: String) {
    // if (view == null)
    //Fabric.getLogger().e("AppAlert", "Asman alert is null for " + message);
    val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
    snackbar.show()

}

/**
 * Show Alert Message in Dialog.
 *
 * @param context
 * @param message
 */
fun showAlertDialog(context: Context?, message: String): AlertDialog? {
    return if (context != null) {
        AlertDialog.Builder(context).setMessage(message)
            .setPositiveButton("OK") { dialog, which -> dialog.dismiss() }.show()
    } else null
}

/**
 * Show Alert Message in Dialog.
 *
 * @param context
 * @param message
 */
fun showAlertDialog(
    context: Context?,
    message: String,
    dialogListionars: DialogListionars
): AlertDialog? {
    return if (context != null) {
        AlertDialog.Builder(context).setMessage(message)
            .setPositiveButton("OK") { dialog, which ->
                dialog.dismiss()
                //dialogListionars.onClickOK();
            }.show()
    } else null
}

interface DialogListionars {
    fun onClickOK()
}

