package com.example.sergej.clean.presentation

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration



class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder().name("cleanRealm").build()
        Realm.setDefaultConfiguration(config)
    }
}