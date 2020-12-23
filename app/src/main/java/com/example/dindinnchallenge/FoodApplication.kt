package com.example.dindinnchallenge

import android.app.Application
import com.example.dindinnchallenge.repository.DefaultRepository

class FoodApplication : Application() {
    val foodRepository by lazy {
        DefaultRepository()
    }
}