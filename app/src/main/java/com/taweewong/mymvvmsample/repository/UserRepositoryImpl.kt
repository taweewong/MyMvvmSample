package com.taweewong.mymvvmsample.repository

import com.taweewong.mymvvmsample.network.core.Result
import com.taweewong.mymvvmsample.network.core.toResult
import com.taweewong.mymvvmsample.network.model.UserInfoResponse
import com.taweewong.mymvvmsample.network.service.UserService

class UserRepositoryImpl(
    private val userService: UserService
) : UserRepository {
    override suspend fun getUserProfile(): Result<UserInfoResponse> {
        return userService.getUserProfile().toResult()
    }
}