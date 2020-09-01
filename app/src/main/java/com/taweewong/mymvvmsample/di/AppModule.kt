package com.taweewong.mymvvmsample.di

import com.taweewong.mymvvmsample.domain.GetUserProfileUseCase
import com.taweewong.mymvvmsample.network.core.ApiManager
import com.taweewong.mymvvmsample.network.core.NetworkClient
import com.taweewong.mymvvmsample.repository.UserRepository
import com.taweewong.mymvvmsample.repository.UserRepositoryImpl
import com.taweewong.mymvvmsample.ui.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory { NetworkClient() }
    factory { ApiManager(get()).userService() }
}

val viewModel = module {
    viewModel { ProfileViewModel(get()) }
}

val repositoryModule = module {
    factory<UserRepository> { UserRepositoryImpl(get()) }
}

val useCase = module {
    factory { GetUserProfileUseCase(get()) }
}