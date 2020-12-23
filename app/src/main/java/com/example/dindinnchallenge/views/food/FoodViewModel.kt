package com.example.dindinnchallenge.views.food

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.example.dindinnchallenge.FoodApplication
import com.example.dindinnchallenge.data.FoodState
import com.example.dindinnchallenge.repository.DefaultRepository

class FoodViewModel(initialState: FoodState,
                    repository: DefaultRepository) :
    BaseMvRxViewModel<FoodState>(initialState, debugMode = true) {

    init {
        setState {
            copy(foodListAsync = Loading())
        }

        repository.getFood()?.execute {
            copy(foodListAsync = it)
        }
    }

    companion object : MvRxViewModelFactory<FoodViewModel, FoodState> {
        override fun create(viewModelContext: ViewModelContext,
                            state: FoodState): FoodViewModel {
            val foodRepository = viewModelContext.app<FoodApplication>().foodRepository
            return FoodViewModel(state, foodRepository)
        }
    }
}