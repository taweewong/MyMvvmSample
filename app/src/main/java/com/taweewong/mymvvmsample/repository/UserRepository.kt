package com.taweewong.mymvvmsample.repository

import com.taweewong.mymvvmsample.network.core.Result
import com.taweewong.mymvvmsample.network.model.UserInfoResponse

interface UserRepository {
    suspend fun getUserProfile(): Result<UserInfoResponse>
}