package com.example.dindinnchallenge.repository

import com.example.dindinnchallenge.data.Food
import com.example.dindinnchallenge.data.TypeOfFood
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class DefaultRepository: IRepository {

    private val foodList = mutableListOf<Food>()

    override fun getFood(): Observable<MutableList<Food>>? = Observable.fromCallable {

        foodList.addAll(
        listOf(
            Food("MEATZZA", TypeOfFood.PIZZA,
                20,
                "Pizza Sauce, Beef Pepperoni",
                "https://cdn.pixabay.com/photo/2017/08/06/06/43/pizza-2589575_960_720.jpg"),

            Food("CLASSIC PEPPERONI", TypeOfFood.PIZZA,
                20,
                "Crispy pepperoni and creamy mozzarella",
                "https://cdn.pixabay.com/photo/2017/08/06/06/43/pizza-2589575_960_720.jpg"),

            Food("HAWAIIAN PARADISE", TypeOfFood.PIZZA,
                20,
                "succulent roasted sliced chicken topped",
                "https://cdn.pixabay.com/photo/2017/08/06/06/43/pizza-2589575_960_720.jpg"),

            Food("VERY VEGGIE", TypeOfFood.PIZZA,
                20,
                "Vegetarian Pizza",
                "https://cdn.pixabay.com/photo/2017/08/06/06/43/pizza-2589575_960_720.jpg"),

            Food("Nigiri", TypeOfFood.SUSHI,
                15,
                "seafood and vegetables",
                "https://cdn.pixabay.com/photo/2015/04/10/16/00/sushi-716447_960_720.jpg"),

            Food("Makizushi", TypeOfFood.SUSHI,
                15,
                "seaweed and rice filled with fish",
                "https://cdn.pixabay.com/photo/2017/07/03/00/27/oriental-cuisine-2466295_960_720.jpg"),

            Food("Gunkan Maki", TypeOfFood.SUSHI,
                15,
                "cubes of sushi rice",
                "https://cdn.pixabay.com/photo/2017/10/15/11/41/sushi-2853382__340.jpg"),


            Food("Coffee", TypeOfFood.DRINK,
                4,
                "1 Cup",
                "https://cdn.pixabay.com/photo/2015/10/12/14/54/coffee-983955__340.jpg"),

            Food("Tea", TypeOfFood.DRINK,
                3,
                "1 Cup",
                "https://cdn.pixabay.com/photo/2017/05/19/07/34/teacup-2325722__340.jpg"),

            Food("Juice", TypeOfFood.DRINK,
                4,
                "1 Bottle",
                "https://cdn.pixabay.com/photo/2013/02/21/19/06/drink-84533__340.jpg"),

            Food("Wine", TypeOfFood.DRINK,
                35,
                "1 Bottle",
                "https://cdn.pixabay.com/photo/2014/11/22/18/38/wine-541922__340.jpg"),
        ))
        foodList

    }.subscribeOn(Schedulers.io())

    override fun getFoodByType(typeOfFood: TypeOfFood): Observable<List<Food>> {
        return Observable.fromCallable {
            val foods = foodList.filter {
                it.type == typeOfFood
            }
            foods
        }
    }
}