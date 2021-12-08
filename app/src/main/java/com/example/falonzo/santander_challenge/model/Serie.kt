package com.example.falonzo.santander_challenge.model

data class Serie(
    val endYear: Int,
    val id: Int,
    val modified: String,
    val rating: String,
    val startYear: Int,
    val thumbnail: Thumbnail,
    val title: String,
    val type: String
): Asset {
    override fun getImage() = thumbnail.getUrl()
    override fun getName() = title

}