package com.example.sergej.clean.presentation.presenters

import com.example.sergej.clean.data.FruitRepositoryImpl
import com.example.sergej.clean.domain.interactor.FruitsInteractor
import com.example.sergej.clean.presentation.IFruitsListView
import com.example.sergej.clean.presentation.MainSchedulersProvider
import io.reactivex.disposables.Disposable

class FruitsListPresenter : BasePresenter<IFruitsListView>() {

    private val fruitsInteractor: FruitsInteractor = FruitsInteractor(FruitRepositoryImpl, MainSchedulersProvider)
    private var subscribe: Disposable? = null

    fun getFruits() {
        subscribe = fruitsInteractor.getFruits()
                .doOnSubscribe({ view?.setProgress(true) })
                .doFinally({ view?.setProgress(false) })
                .subscribe({
                    view?.setFruits(it)
                }, {
                    view?.error(it.message.toString())
                })
    }

    fun onDestroy() {
        subscribe?.dispose()
    }
}