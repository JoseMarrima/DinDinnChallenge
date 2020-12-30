package com.example.dindinnchallenge.views.cart

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapterCart(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int) = when (position) {
        0 -> CartPagerFragment()
        1 -> CartPagerFragment()
        2 -> CartPagerFragment()
        else -> throw Exception()
    }
}