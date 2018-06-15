package com.example.sergej.clean.presentation

interface BaseView {
    fun error(message: String)
    fun setProgress(progress: Boolean) {}
}