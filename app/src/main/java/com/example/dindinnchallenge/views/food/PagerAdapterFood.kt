package com.example.dindinnchallenge.views.food

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapterFood(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int) = when (position) {
        0 -> PagerFoodFragment(0)
        1 -> PagerFoodFragment(1)
        2 -> PagerFoodFragment(2)
        else -> throw Exception()
    }
}