package com.example.falonzo.santander_challenge.di

import com.example.falonzo.santander_challenge.model.Character
import com.example.falonzo.santander_challenge.ui.characterDetail.CharacterDetailViewModel
import com.example.falonzo.santander_challenge.ui.characters.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { CharactersViewModel(get()) }
    viewModel { (character: Character) -> CharacterDetailViewModel(character, get()) }
}