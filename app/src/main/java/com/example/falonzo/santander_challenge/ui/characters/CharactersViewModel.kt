package com.example.falonzo.santander_challenge.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.falonzo.santander_challenge.model.Character
import com.example.falonzo.santander_challenge.model.Resource
import com.example.falonzo.santander_challenge.repository.CharacterRepository

class CharactersViewModel(
    private val characterRepository: CharacterRepository
): ViewModel() {

    fun getCharacterList(): LiveData<Resource<List<Character>>> {
        return characterRepository.getCharacterList()
    }

}