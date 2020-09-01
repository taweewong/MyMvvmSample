package com.taweewong.mymvvmsample.network.core

import com.google.gson.GsonBuilder
import com.taweewong.mymvvmsample.network.constant.ApiUrl.BASE_URL
import com.taweewong.mymvvmsample.network.service.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager(private val networkClient: NetworkClient) {
    fun userService(): UserService = getRetrofit().create(UserService::class.java)

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(networkClient.createOkHttpClient())
            .build()
    }
}