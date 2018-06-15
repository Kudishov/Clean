package com.example.sergej.clean.presentation.views.activities

import android.os.Build
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.WindowManager
import com.example.sergej.clean.R
import com.example.sergej.clean.presentation.BaseView
import com.example.sergej.clean.presentation.views.dialogs.ProgressDialog
import com.example.sergej.clean.presentation.views.dialogs.errorDialog
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity : AppCompatActivity(), BaseView {
    private val _progress by lazy {
        ProgressDialog(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    protected fun initToolbar(title: String) {
        toolbar?.let {
            setSupportActionBar(toolbar)
            supportActionBar?.title = title

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = ContextCompat.getColor(this, R.color.status_bar_with_toolbar)
            }
        }
    }

    protected fun setBackButton() {
        supportActionBar?.let {
            it.setHomeButtonEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun error(message: String) {
        errorDialog(this, message).show()
    }

    override fun setProgress(progress: Boolean) {
        if (progress) _progress.show()
        else _progress.dismiss()
    }
}