package com.example.falonzo.santander_challenge.model

import java.io.Serializable

data class Thumbnail(
    val extension: String,
    val path: String
): Serializable {
    fun getUrl() = path +"."+ extension
}