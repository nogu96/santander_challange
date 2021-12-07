package com.example.falonzo.santander_challenge.network.service

import com.example.falonzo.santander_challenge.model.BaseResponse
import com.example.falonzo.santander_challenge.model.Character
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {

    @GET("v1/public/characters")
    fun getCharacterList(@Path("apikey") apikey: String,
                         @Path("ts") ts: String,
                         @Path("hash") hash: String
    ): BaseResponse<Character>

}