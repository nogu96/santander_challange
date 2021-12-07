package com.example.falonzo.santander_challenge.model

data class Container<T>(
    val available: Int,
    val collectionURI: String,
    val items: List<T>,
    val returned: Int
)