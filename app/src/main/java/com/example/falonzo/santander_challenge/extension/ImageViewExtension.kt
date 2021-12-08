package com.example.falonzo.santander_challenge.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(url: String) {
    Glide
        .with(context)
        .load(url)
        .into(this)

}