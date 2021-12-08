package com.example.falonzo.santander_challenge.network.service

import androidx.lifecycle.LiveData
import com.example.falonzo.santander_challenge.model.BaseResponse
import com.example.falonzo.santander_challenge.model.Character
import com.example.falonzo.santander_challenge.model.Comic
import com.example.falonzo.santander_challenge.model.Serie
import com.example.falonzo.santander_challenge.network.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {

    @GET("v1/public/characters")
    fun getCharacterList(): LiveData<ApiResponse<BaseResponse<Character>>>

    @GET("v1/public/characters/{id}")
    fun getDetail(@Path("id") characterId: Int): LiveData<ApiResponse<BaseResponse<Character>>>

    @GET("v1/public/characters/{characterId}/series")
    fun getSeries(@Path("characterId") characterId: Int): LiveData<ApiResponse<BaseResponse<Serie>>>

    @GET("v1/public/characters/{characterId}/comics")
    fun getComics(@Path("characterId") characterId: Int): LiveData<ApiResponse<BaseResponse<Comic>>>
}