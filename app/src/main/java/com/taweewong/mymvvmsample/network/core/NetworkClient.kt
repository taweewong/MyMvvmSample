package com.taweewong.mymvvmsample.network.core

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class NetworkClient {
    fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(createLoggerInterceptor())
            .build()
    }

    private fun createLoggerInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}