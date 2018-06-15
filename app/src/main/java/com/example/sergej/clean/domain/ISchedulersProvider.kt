package com.example.sergej.clean.domain

import io.reactivex.Scheduler

interface ISchedulersProvider {
    fun ui(): Scheduler
    fun io(): Scheduler
}