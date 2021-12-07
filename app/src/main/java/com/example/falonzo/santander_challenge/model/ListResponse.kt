package com.example.falonzo.santander_challenge.model

data class ListResponse<T>(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<T>,
    val total: Int
)