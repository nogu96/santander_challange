package com.example.falonzo.santander_challenge.di

import com.example.falonzo.santander_challenge.AppExecutors
import com.example.falonzo.santander_challenge.repository.CharacterRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { AppExecutors() }

    single { CharacterRepository(get(), get()) }

}