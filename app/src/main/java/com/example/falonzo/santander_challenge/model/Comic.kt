package com.example.falonzo.santander_challenge.model

data class Comic(
    val description: String,
    val diamondCode: String,
    val digitalId: Int,
    val ean: String,
    val format: String,
    val id: Int,
    val isbn: String,
    val issn: String,
    val issueNumber: Int,
    val modified: String,
    val pageCount: Int,
    val title: String,
    val upc: String,
    val variantDescription: String,
    val thumbnail: Thumbnail
): Asset {
    override fun getImage() = thumbnail.getUrl()
    override fun getName() = title
}