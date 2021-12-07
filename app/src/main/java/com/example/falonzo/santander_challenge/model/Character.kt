package com.example.falonzo.santander_challenge.model

data class Character(
    val comics: Container<Comic>,
    val description: String,
    val events: Events,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Container<Serie>,
    val stories: Container<Story>,
    val thumbnail: Thumbnail,
    val urls: List<Url>
)