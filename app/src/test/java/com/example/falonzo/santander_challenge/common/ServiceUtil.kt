package com.example.falonzo.santander_challenge.common

import com.example.falonzo.santander_challenge.network.LiveDataCallAdapterFactory
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceUtil {

    fun retrofitMock(mockWebServer: MockWebServer) : Retrofit {
        return  Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
    }

    fun enqueueResponse(mockWebServer: MockWebServer, fileName: String) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        mockWebServer.enqueue(MockResponse().setBody(source.readString(Charsets.UTF_8)))
    }

}