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
    //TODO, do room db
    private var characterList: List<Character>? = null

    fun getCharacterList(): LiveData<Resource<List<Character>>> {
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

    fun getCharacterDetail(characterId: Int): LiveData<Resource<Character>> {
        return object: NetworkBoundResource<Character, BaseResponse<Character>>(appExecutors) {
            var character: Character? = null
            override fun saveCallResult(item: BaseResponse<Character>) {
                item.data.results.let { characterList ->
                    if (characterList.isNotEmpty()) {
                        character = characterList.get(0)
                    }
                }
            }

            override fun shouldFetch(data: Character?): Boolean {
                return data == null
            }

            override fun loadFromDb(): LiveData<Character> {
                return MutableLiveData(character)
            }

            override fun createCall(): LiveData<ApiResponse<BaseResponse<Character>>> {
                return characterService.getDetail(characterId)
            }

        }.asLiveData()
    }
}