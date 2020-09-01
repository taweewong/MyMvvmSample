package com.taweewong.mymvvmsample.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.taweewong.mymvvmsample.domain.GetUserProfileUseCase
import com.taweewong.mymvvmsample.network.core.ErrorResponse
import com.taweewong.mymvvmsample.network.model.UserInfoResponse
import com.taweewong.mymvvmsample.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val getUserProfileUseCase: GetUserProfileUseCase
) : BaseViewModel() {
    private val _getUserProfileSuccess = MutableLiveData<UserInfoResponse>()
    val getUserProfileSuccess: LiveData<UserInfoResponse>
        get() = _getUserProfileSuccess
    private val _getUserProfileError = MutableLiveData<ErrorResponse>()
    val getUserProfileError: LiveData<ErrorResponse>
        get() = _getUserProfileError
    private val _getUserProfileLoading = MutableLiveData<Unit>()
    val getUserProfileLoading: LiveData<Unit>
        get() = _getUserProfileLoading

    private var userId = ""

    fun getUserProfile() = viewModelScope.launch {
        getUserProfileUseCase(coroutineContext, Unit).handleResponse(
            success = {
                userId = it.id ?: ""
                _getUserProfileSuccess.postValue(it)
            },
            error = { _getUserProfileError.postValue(it) },
            loading = { _getUserProfileLoading.postValue(Unit) }
        )
    }
}