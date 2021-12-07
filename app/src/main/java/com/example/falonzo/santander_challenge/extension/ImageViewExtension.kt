package com.example.falonzo.santander_challenge.extension

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.load(url: String) {
    Picasso
        .get()
        .load(url)
        .into(this)
}