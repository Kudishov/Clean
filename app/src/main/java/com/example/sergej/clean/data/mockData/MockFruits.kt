package com.example.sergej.clean.data.mockData

import com.example.sergej.clean.domain.Fruit

object MockFruits {

    var mockFruits = mutableListOf(
            Fruit(0, "Fruit0", "red", "10", "1", "20.01.2018", "20.05.2018"),
            Fruit(1, "Fruit1", "yellow", "20", "0", "18.02.2005", "20.05.2018"),
            Fruit(2, "Fruit2", "green", "30", "1", "20.04.2017", "20.05.2018"),
            Fruit(3, "Fruit3", "blue", "14", "1", "20.01.1990", "20.05.2018"),
            Fruit(4, "Fruit4", "black", "22", "0", "20.06.2001", "20.05.2018"),
            Fruit(5, "Fruit5", "white", "55", "1", "20.12.2015", "20.05.2018"),
            Fruit(6, "Fruit6", "purple", "222", "1", "20.09.2014", "20.05.2018")
    )

    fun getFruits(): List<Fruit> {
        return mockFruits
    }

    fun getFruitsById(id: Int): Fruit {
        for (mockFruit in mockFruits) {
            if (mockFruit.id == id) {
                return mockFruit
            }
        }
        throw Throwable("Фрукт не найден")
    }

    fun addFruit(fruit: Fruit){
        mockFruits.add(fruit)
    }
}