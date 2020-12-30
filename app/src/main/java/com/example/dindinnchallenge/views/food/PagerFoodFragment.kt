package com.example.dindinnchallenge.views.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.airbnb.mvrx.*
import com.example.dindinnchallenge.R
import com.example.dindinnchallenge.data.TypeOfFood
import com.example.dindinnchallenge.databinding.FragmentPagerFoodBinding


class PagerFoodFragment(private val position: Int) : BaseMvRxFragment() {

    private val viewModel: FoodViewModel by activityViewModel()

    private val adapter: FoodAdapter by lazy {
        FoodAdapter()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: FragmentPagerFoodBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_pager_food, container, false)
        binding.lifecycleOwner = this

        binding.fragmentPagerFoodRecyclerView.adapter = adapter

        return binding.root
    }

    override fun invalidate() {
        withState(viewModel) { foodState ->
            when(foodState.foodListAsync) {
                is Loading -> {}
                is Success -> {
                    val sushiList =
                        foodState.foodListAsync.invoke().filter { it.type == TypeOfFood.SUSHI }
                    val pizzaList =
                        foodState.foodListAsync.invoke().filter { it.type == TypeOfFood.PIZZA }
                    val drinkList =
                        foodState.foodListAsync.invoke().filter { it.type == TypeOfFood.DRINK }

                    when (position) {
                        0 -> {
                            adapter.submitList(sushiList)
                            adapter.notifyDataSetChanged()
                        }
                        1 -> {
                            adapter.submitList(pizzaList)
                            adapter.notifyDataSetChanged()
                        }
                        2 -> {
                            adapter.submitList(drinkList)
                            adapter.notifyDataSetChanged()
                        }
                    }
                }
                is Fail -> {}
                else -> {}
            }
        }
    }

}