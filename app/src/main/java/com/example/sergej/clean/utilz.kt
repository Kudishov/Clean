package com.example.sergej.clean

import java.util.*

fun generateId(): Int {
    val uuid = UUID.randomUUID()
    return uuid.hashCode()
}