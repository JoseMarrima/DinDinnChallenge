package com.example.dindinnchallenge.views.food

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dindinnchallenge.data.Food
import com.example.dindinnchallenge.databinding.FoodItemBinding

class FoodAdapter: ListAdapter<Food, RecyclerView.ViewHolder>(DataDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FoodViewHolder(FoodItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FoodViewHolder).bind(getItem(position))
    }

    class FoodViewHolder(private val binding: FoodItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Food) {
            binding.apply {
                food = item
                executePendingBindings()
            }
        }
    }
}
