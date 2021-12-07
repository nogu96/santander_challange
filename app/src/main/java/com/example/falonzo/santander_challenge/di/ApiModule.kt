package com.example.falonzo.santander_challenge.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.example.falonzo.santander_challenge.BuildConfig
import com.example.falonzo.santander_challenge.network.LiveDataCallAdapterFactory
import com.example.falonzo.santander_challenge.network.MarvelParamsInterceptor
import com.example.falonzo.santander_challenge.network.service.CharacterService
import com.google.gson.GsonBuilder

val apiModule = module {

    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        okHttpClientBuilder
            .addNetworkInterceptor(interceptor)
            .addInterceptor(MarvelParamsInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.MARVEL_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .client(client)
            .build()
    }

    fun provideCharacterService(retrofit: Retrofit): CharacterService {
        return retrofit.create(CharacterService::class.java)
    }

    single { provideHttpClient() }
    single { provideRetrofit(get()) }

    single { provideCharacterService(get()) }
}