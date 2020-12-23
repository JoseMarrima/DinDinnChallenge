package com.example.dindinnchallenge.bindingadapters

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("photoUrl")
fun bindImage(imageView: ImageView, photoUrl: String?){

    photoUrl?.let {

        val photoUri = photoUrl.toUri()
        Picasso.with(imageView.context).load(photoUri).into(imageView)
    }
}