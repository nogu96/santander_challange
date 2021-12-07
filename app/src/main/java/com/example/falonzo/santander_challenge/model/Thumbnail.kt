package com.example.falonzo.santander_challenge.model

data class Thumbnail(
    val extension: String,
    val path: String
) {
    fun getUrl() = path +"."+ extension
}