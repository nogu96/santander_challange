package com.example.falonzo.santander_challenge.model

data class BaseResponse<T>(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val data: ListResponse<T>,
    val etag: String,
    val status: String
)