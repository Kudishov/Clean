package com.example.sergej.clean.domain.repository

import com.example.sergej.clean.domain.Fruit
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface IFruitRepository {
    fun getFruits(): Observable<List<Fruit>>
    fun getFruitById(id: Int): Observable<Fruit>
    fun createFruit(fruit: Fruit): Completable
}