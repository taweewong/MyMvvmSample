package com.taweewong.mymvvmsample.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlin.coroutines.CoroutineContext
import com.taweewong.mymvvmsample.network.core.Result

abstract class BaseUseCase<ReturnType, Param>(
) {
    open operator fun invoke(
        coroutineContext: CoroutineContext,
        param: Param
    ): LiveData<Result<ReturnType>> = liveData {
        emit(Result.Loading)
        emit(run(param))
    }

    abstract suspend fun run(param: Param): Result<ReturnType>
}