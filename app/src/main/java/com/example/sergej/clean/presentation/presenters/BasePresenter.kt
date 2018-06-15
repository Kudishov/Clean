package com.example.sergej.clean.presentation.presenters

import com.example.sergej.clean.presentation.BaseView

abstract class BasePresenter<V : BaseView> {
    protected var view: V? = null

    open fun attachView(view: V) {
        this.view = view
    }

    open fun destroy() {}
}