package com.example.sergej.clean.presentation.views.dialogs

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatDialog
import android.view.Window
import com.example.sergej.clean.R

class ProgressDialog(context: Activity) : AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_progress)
        setCanceledOnTouchOutside(false)
    }
}