package com.example.falonzo.santander_challenge.model

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<AssetResource>,
    val returned: Int
)