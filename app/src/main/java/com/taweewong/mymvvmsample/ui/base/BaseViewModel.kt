package com.taweewong.mymvvmsample.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.taweewong.mymvvmsample.network.core.ErrorResponse
import com.taweewong.mymvvmsample.network.core.Result

open class BaseViewModel : ViewModel() {
    val mediatorLiveData = MediatorLiveData<Unit>()

    fun <T> LiveData<Result<T>>.handleResponse(
        success: (T) -> Unit,
        error: (message: ErrorResponse?) -> Unit,
        loading: () -> Unit
    ) {
        mediatorLiveData.addSource(this) { result ->
            when (result) {
                is Result.Success -> success(result.data)
                is Result.Error -> error(result.exception)
                is Result.Loading -> loading()
            }
        }
    }
}