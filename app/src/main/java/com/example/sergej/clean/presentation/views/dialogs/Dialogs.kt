package com.example.sergej.clean.presentation.views.dialogs

import android.app.Activity
import android.app.Dialog

fun buildOneButtonDialog(
        activity: Activity,
        title: String = "",
        message: String = "",
        btnText: String = "",
        listener: ((Dialog) -> Unit)? = null
): Dialog {
    val dialog = OneButtonDialog(activity)
    dialog.mTitle = title
    dialog.mMessage = message
    dialog.mListener = listener
    dialog.mBtnText = btnText
    return dialog
}

fun errorDialog(
        activity: Activity,
        message: String
): Dialog {
    val dialog = OneButtonDialog(activity)
    dialog.mTitle = "Ошибка"
    dialog.mMessage = message
    return dialog
}