package com.taweewong.mymvvmsample.network.service

import com.taweewong.mymvvmsample.network.model.UserInfoResponse
import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET("user_profile")
    suspend fun getUserProfile(): Response<UserInfoResponse>
}