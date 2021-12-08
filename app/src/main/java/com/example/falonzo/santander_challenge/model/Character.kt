package com.example.falonzo.santander_challenge.model

import java.io.Serializable

data class Character(
    val comics: Container<AssetResource>,
    val description: String,
    val events: Events,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Container<AssetResource>,
    val stories: Container<AssetResource>,
    val thumbnail: Thumbnail,
    val urls: List<Url>
): Serializable