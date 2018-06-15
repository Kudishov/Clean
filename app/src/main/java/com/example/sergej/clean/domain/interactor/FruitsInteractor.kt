package com.example.sergej.clean.domain.interactor

import com.example.sergej.clean.domain.Fruit
import com.example.sergej.clean.domain.ISchedulersProvider
import com.example.sergej.clean.domain.repository.IFruitRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class FruitsInteractor(
        private val repository: IFruitRepository,
        private val schedulersProvider: ISchedulersProvider
) {
    fun getFruits(): Observable<List<Fruit>> {
        return repository.getFruits()
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
    }

    fun getFruitById(id: Int): Observable<Fruit> {
        return repository.getFruitById(id)
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
    }

    fun createFruit(fruit: Fruit): Completable {
        return repository.createFruit(fruit)
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
    }
}