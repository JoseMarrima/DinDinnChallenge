package com.example.dindinnchallenge.views.food

import androidx.recyclerview.widget.DiffUtil
import com.example.dindinnchallenge.data.Food

class DataDiffCallback : DiffUtil.ItemCallback<Food>() {
    override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem == newItem
    }
}
