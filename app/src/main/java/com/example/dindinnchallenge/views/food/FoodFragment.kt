package com.example.dindinnchallenge.views.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.*
import com.example.dindinnchallenge.R
import com.example.dindinnchallenge.data.Food
import com.example.dindinnchallenge.data.TypeOfFood.*

class FoodFragment : BaseMvRxFragment() {

    private val viewModel: FoodViewModel by activityViewModel()
    private val adapter: FoodAdapter by lazy {
        FoodAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.food_fragment, container, false)
    }

    override fun invalidate() {
        withState(viewModel) { foodState ->
            when(foodState.foodListAsync) {
                is Loading -> {}
                is Success -> {
                    val sushiList = foodState.foodListAsync.invoke().filter { it.type == SUSHI }
                    val pizzaList = foodState.foodListAsync.invoke().filter { it.type == PIZZA }
                    val drinkList = foodState.foodListAsync.invoke().filter { it.type == DRINK }
                    showSushiList(sushiList)
                    showPizzaList(pizzaList)
                    showDrinkList(drinkList)
                }
                is Fail -> {}
                else -> {}
            }
        }
    }


    private fun showDrinkList(drinkList: List<Food>) {
        adapter.submitList(drinkList)
    }

    private fun showPizzaList(pizzaList: List<Food>) {
        adapter.submitList(pizzaList)
    }

    private fun showSushiList(sushiList: List<Food>) {
        adapter.submitList(sushiList)
    }

}