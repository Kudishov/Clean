package com.example.sergej.clean.presentation

import com.example.sergej.clean.domain.Fruit

interface IFruitView : BaseView {
    fun setFruit(fruit: Fruit)
}