package com.example.sergej.clean.data

import com.example.sergej.clean.domain.Fruit
import io.realm.Realm

object CacheManager {

    fun cacheFruits(fruits: List<Fruit>) {
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(fruits)
        realm.commitTransaction()
        realm.close()
    }

    fun cacheFruit(fruit: Fruit) {
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(fruit)
        realm.commitTransaction()
        realm.close()
    }

    fun getFruitCache(id: Int): Fruit? {
        val realm = Realm.getDefaultInstance()
        val query = realm.where(Fruit::class.java)
        val item = query.equalTo("id", id).findFirst()
        return if (item != null) {
            val results = realm.copyFromRealm(item)
            realm.close()
            results
        } else {
            realm.close()
            null
        }
    }

    fun getFruitsCache(): List<Fruit>? {
        val realm = Realm.getDefaultInstance()
        val query = realm.where(Fruit::class.java)
        val item = query.findAll()
        return if (item != null) {
            val results = realm.copyFromRealm(item)
            realm.close()
            results
        } else {
            realm.close()
            null
        }
    }
}