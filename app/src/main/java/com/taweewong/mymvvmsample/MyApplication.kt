package com.taweewong.mymvvmsample

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.taweewong.mymvvmsample.di.appModule
import com.taweewong.mymvvmsample.di.repositoryModule
import com.taweewong.mymvvmsample.di.useCase
import com.taweewong.mymvvmsample.di.viewModel
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            androidLogger()
            modules(appModule)
            modules(viewModel)
            modules(repositoryModule)
            modules(useCase)
        }
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
        AndroidThreeTen.init(this)
    }
}