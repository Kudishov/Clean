package com.example.sergej.clean.data

import com.example.sergej.clean.data.mockData.MockFruits
import com.example.sergej.clean.domain.Fruit
import com.example.sergej.clean.domain.repository.IFruitRepository
import io.reactivex.Completable
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

object FruitRepositoryImpl : IFruitRepository {

    override fun getFruits(): Observable<List<Fruit>> {
        val api = Observable
                .just(MockFruits.getFruits())
                .delay(1, TimeUnit.SECONDS)
                .doOnNext({
                    CacheManager.cacheFruits(it)
                })

        val local = Observable
                .just(CacheManager.getFruitsCache())
                .delay(1, TimeUnit.SECONDS)
                .filter({ it.isNotEmpty() })

        return Observable
                .merge(local, api)
    }

    override fun getFruitById(id: Int): Observable<Fruit> {
        val api = Observable
                .just(MockFruits.getFruitsById(id))
                .delay(1, TimeUnit.SECONDS)

        val local = Observable
                .just(CacheManager.getFruitCache(id))
                .delay(1, TimeUnit.SECONDS)

        return Observable
                .merge(local, api)
    }

    override fun createFruit(fruit: Fruit): Completable {
        CacheManager.cacheFruit(fruit)
        return Completable
                .complete()
                .doOnComplete({ MockFruits.addFruit(fruit) })
    }
}