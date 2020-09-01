package com.taweewong.mymvvmsample.network.core

import retrofit2.Response

fun <T> Response<T>.toResult(): Result<T> {
    if (isSuccessful) {
        body()?.let {
            return Result.Success(it)
        } ?: run {
            return Result.Error(ErrorResponse("Response not exist"))
        }
    } else {
        //FIXME: Get actual error from response
        return try {
            Result.Error(
                ErrorResponse(errorBody()?.string() ?: "No error message")
            )
        } catch (ex: Exception) {
            Result.Error(
                ErrorResponse("Unknown Error")
            )
        }
    }
}