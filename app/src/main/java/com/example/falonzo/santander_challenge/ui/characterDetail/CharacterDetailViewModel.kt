package com.example.falonzo.santander_challenge.ui.characterDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.falonzo.santander_challenge.model.Character
import com.example.falonzo.santander_challenge.model.Comic
import com.example.falonzo.santander_challenge.model.Resource
import com.example.falonzo.santander_challenge.model.Serie
import com.example.falonzo.santander_challenge.repository.CharacterRepository

class CharacterDetailViewModel(
    val character: Character,
    private val characterRepository: CharacterRepository
) : ViewModel() {

    val _detail = characterRepository.getCharacterDetail(character.id)
    val _comics = characterRepository.getCharacterComics(character.id)
    val _series = characterRepository.getCharacterSeries(character.id)

    fun getDetail(): LiveData<Resource<Character>> {
        return _detail
    }

    fun getComics(): LiveData<Resource<List<Comic>>> {
        return _comics
    }

    fun getSeries(): LiveData<Resource<List<Serie>>> {
        return _series
    }
}