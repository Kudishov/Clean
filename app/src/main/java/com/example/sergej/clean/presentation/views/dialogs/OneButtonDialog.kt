package com.example.sergej.clean.presentation.views.dialogs

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AppCompatDialog
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.example.sergej.clean.R

class OneButtonDialog(context: Activity) : AppCompatDialog(context) {
    private var btnSubmit: Button? = null
    private var tvTitle: TextView? = null
    private var tvMessage: TextView? = null

    var mTitle = ""
    var mMessage = ""
    var mBtnText = ""
    var mListener: ((dialog: Dialog) -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCanceledOnTouchOutside(false)
        setContentView(R.layout.one_button_dialog)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnSubmit?.text = mBtnText
        btnSubmit?.setOnClickListener {
            mListener?.invoke(this)
            dismiss()
        }

        tvTitle = findViewById(R.id.tvTitle)
        tvTitle?.text = mTitle
        tvMessage = findViewById(R.id.tvMessage)
        tvMessage?.text = mMessage
    }

    override fun show() {
        super.show()
        this.window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}