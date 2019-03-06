package com.yoesuv.multiplerequest.utils.bindings

import android.databinding.BindingAdapter
import android.support.v7.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.yoesuv.multiplerequest.R

object Converters {
    @BindingAdapter("loadImage")
    @JvmStatic fun loadImage(imageView: AppCompatImageView, imageUrl: String) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.placeholder_image)
            .into(imageView)
    }
}