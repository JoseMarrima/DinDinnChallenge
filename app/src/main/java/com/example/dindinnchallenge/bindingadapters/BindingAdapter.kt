package com.example.dindinnchallenge.bindingadapters

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.dindinnchallenge.R

@BindingAdapter("photoUrl")
fun bindImage(imageView: ImageView, photoUrl: String?){

    photoUrl?.let {

        val photoUri = it.toUri()
        Glide.with(imageView.context)
            .load(photoUri)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .into(imageView)
    }
}