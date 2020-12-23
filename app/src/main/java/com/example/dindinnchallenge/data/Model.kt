package com.example.dindinnchallenge.data

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import java.util.*

enum class TypeOfFood {SUSHI, PIZZA, DRINK}

data class Food(
    val title: String,
    val type: TypeOfFood,
    val price: Int,
    val description: String,
    val imageUrl: String,
    val id: String = UUID.randomUUID().toString(),
)

data class FoodState(
    val foodListAsync: Async<List<Food>> = Uninitialized,
) : MvRxState