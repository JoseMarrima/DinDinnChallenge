package com.example.dindinnchallenge.views.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.airbnb.mvrx.*
import com.denzcoskun.imageslider.models.SlideModel
import com.example.dindinnchallenge.R
import com.example.dindinnchallenge.data.TypeOfFood.*
import com.example.dindinnchallenge.databinding.FoodFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class FoodFragment : BaseMvRxFragment() {

    private val viewModel: FoodViewModel by activityViewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FoodFragmentBinding = DataBindingUtil
            .inflate(inflater, R.layout.food_fragment, container, false)
        binding.lifecycleOwner = this

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.promo1))
        imageList.add(SlideModel(R.drawable.promo2))
        binding.imageSlider.setImageList(imageList)

        val pagerAdapterFood = PagerAdapterFood(requireActivity())
        binding.viewPagerFragmentFood.adapter = pagerAdapterFood

        binding.apply {
            TabLayoutMediator(tabFoodFragmentHome, viewPagerFragmentFood) { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = "Sushi"
                    }
                    1 -> {
                        tab.text = "Pizza"
                    }
                    2 -> {
                        tab.text = "Drink"
                    }
                }
            }.attach()
        }

        return binding.root
    }

    override fun invalidate() {
        withState(viewModel) { foodState ->
            when(foodState.foodListAsync) {
                is Loading -> {}
                is Success -> {}
                is Fail -> {}
                else -> {}
            }
        }
    }
}