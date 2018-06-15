package com.example.sergej.clean.presentation.presenters

import com.example.sergej.clean.data.FruitRepositoryImpl
import com.example.sergej.clean.domain.interactor.FruitsInteractor
import com.example.sergej.clean.presentation.IFruitView
import com.example.sergej.clean.presentation.MainSchedulersProvider
import io.reactivex.disposables.Disposable

class FruitPresenter : BasePresenter<IFruitView>() {

    private val fruitsInteractor: FruitsInteractor = FruitsInteractor(FruitRepositoryImpl, MainSchedulersProvider)
    private var subscribe: Disposable? = null

    fun getFruit(id: Int) {
        subscribe = fruitsInteractor.getFruitById(id)
                .doOnSubscribe({ view?.setProgress(true) })
                .doFinally({ view?.setProgress(false) })
                .subscribe({
                    view?.setFruit(it)
                }, {
                    view?.error(it.message.toString())
                })
    }

    fun onDestroy() {
        subscribe?.dispose()
    }
}