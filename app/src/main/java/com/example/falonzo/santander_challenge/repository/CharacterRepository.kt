package com.example.falonzo.santander_challenge.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.falonzo.santander_challenge.AppExecutors
import com.example.falonzo.santander_challenge.model.BaseResponse
import com.example.falonzo.santander_challenge.model.Character
import com.example.falonzo.santander_challenge.model.Resource
import com.example.falonzo.santander_challenge.network.ApiResponse
import com.example.falonzo.santander_challenge.network.service.CharacterService

class CharacterRepository(
    private val appExecutors: AppExecutors,
    private val characterService: CharacterService
) {

    fun getCharacterList(): LiveData<Resource<List<Character>>> {
        var characterList: List<Character>? = null
        return object: NetworkBoundResource<List<Character>, BaseResponse<Character>>(appExecutors) {
            override fun saveCallResult(item: BaseResponse<Character>) {
                characterList = item.data.results
            }

            override fun shouldFetch(data: List<Character>?) = data == null

            override fun loadFromDb(): LiveData<List<Character>> {
                return MutableLiveData(characterList)
            }

            override fun createCall(): LiveData<ApiResponse<BaseResponse<Character>>> {
                return characterService.getCharacterList()
            }
        }.asLiveData()
    }
}