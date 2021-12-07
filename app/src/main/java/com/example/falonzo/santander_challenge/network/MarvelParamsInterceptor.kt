package com.example.falonzo.santander_challenge.network

import com.example.falonzo.santander_challenge.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest

class MarvelParamsInterceptor: Interceptor {
    private val TIME_STAMP_VALUE = "1"

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("apikey", BuildConfig.MARVEL_PUBLIC_KEY)
            .addQueryParameter("ts", TIME_STAMP_VALUE)
            .addQueryParameter("hash", md5Hash(TIME_STAMP_VALUE+BuildConfig.MARVEL_PRIVATE_KEY+BuildConfig.MARVEL_PUBLIC_KEY))
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }

    private fun md5Hash(value: String): String {
        val md = MessageDigest.getInstance("MD5")
        val bigInt = BigInteger(1, md.digest(value.toByteArray(Charsets.UTF_8)))
        return String.format("%032x", bigInt)
    }
}