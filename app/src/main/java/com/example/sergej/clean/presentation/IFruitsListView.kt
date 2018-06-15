package com.example.sergej.clean.presentation

import com.example.sergej.clean.domain.Fruit

interface IFruitsListView : BaseView {
    fun setFruits(list: List<Fruit>)
}