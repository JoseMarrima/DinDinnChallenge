package com.example.dindinnchallenge.views.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.dindinnchallenge.R
import com.example.dindinnchallenge.databinding.FragmentCartBinding
import com.google.android.material.tabs.TabLayoutMediator

class CartFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: FragmentCartBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)

        val adapterPager = PagerAdapterCart(requireActivity())
        binding.viewPagerFragmentCart.adapter = adapterPager

        binding.apply {
            TabLayoutMediator(tabLayoutCartFragment, viewPagerFragmentCart) { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = "cart"
                    }
                    1 -> {
                        tab.text = "order"
                    }
                    2 -> {
                        tab.text = "information"
                    }
                }
            }.attach()
        }

        return binding.root
    }
}