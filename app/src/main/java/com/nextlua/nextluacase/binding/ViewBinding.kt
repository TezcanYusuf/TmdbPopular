package com.nextlua.nextluacase.binding


import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.nextlua.nextluacase.constants.Urls

@BindingAdapter("characterImage")
fun setCharacterImage(imageView: AppCompatImageView, url: String?) {
    var imageUrl = url
    imageUrl = if (url == null) {
        Urls.DEFAULT_IMAGE_URL
    } else {
        Urls.BASE_IMAGE_URL + imageUrl
    }
    Glide.with(imageView.context)
        .load(imageUrl)
        .timeout(15000)
        .into(imageView)
}
