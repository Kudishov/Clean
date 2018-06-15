package com.example.sergej.clean.presentation.presenters

import com.example.sergej.clean.data.FruitRepositoryImpl
import com.example.sergej.clean.domain.Fruit
import com.example.sergej.clean.domain.interactor.FruitsInteractor
import com.example.sergej.clean.presentation.ICreateFruitView
import com.example.sergej.clean.presentation.IFruitView
import com.example.sergej.clean.presentation.MainSchedulersProvider

class CreateFruitPresenter: BasePresenter<ICreateFruitView>(){

    private val fruitsInteractor: FruitsInteractor = FruitsInteractor(FruitRepositoryImpl, MainSchedulersProvider)

    fun createFruit(fruit: Fruit) {
        fruitsInteractor.createFruit(fruit)
                .doOnSubscribe({view?.setProgress(true)})
                .doFinally({view?.setProgress(false)})
                .subscribe({
                    view?.onFruitCreated()
                }, {
                    view?.error(it.message.toString())})
    }
}