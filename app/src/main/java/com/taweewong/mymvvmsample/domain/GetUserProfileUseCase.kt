package com.taweewong.mymvvmsample.domain

import com.taweewong.mymvvmsample.network.core.Result
import com.taweewong.mymvvmsample.network.model.UserInfoResponse
import com.taweewong.mymvvmsample.repository.UserRepository

class GetUserProfileUseCase(
    private val userRepository: UserRepository
) : BaseUseCase<UserInfoResponse, Unit>() {
    override suspend fun run(param: Unit): Result<UserInfoResponse> {
        return userRepository.getUserProfile()
    }
}