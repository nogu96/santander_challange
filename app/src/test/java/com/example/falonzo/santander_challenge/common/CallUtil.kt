package com.example.falonzo.santander_challenge.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.falonzo.santander_challenge.network.ApiResponse
import retrofit2.Response

object CallUtil {

    fun <T> createCall(response: Response<T>): LiveData<ApiResponse<T>> {
        return MutableLiveData<ApiResponse<T>>().apply {
            value = ApiResponse.create(response)
        }
    }

    fun <T> success(data: T) = createCall(Response.success(data))

}