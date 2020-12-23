package com.example.dindinnchallenge.repository

import com.example.dindinnchallenge.data.Food
import com.example.dindinnchallenge.data.TypeOfFood
import io.reactivex.Observable

interface IRepository {
    fun getFood(): Observable<MutableList<Food>>?
    fun getFoodByType(typeOfFood: TypeOfFood): Observable<List<Food>>
}