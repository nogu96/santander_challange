package com.example.falonzo.santander_challenge

import android.app.Application
import com.example.falonzo.santander_challenge.di.apiModule
import com.example.falonzo.santander_challenge.di.repositoryModule
import com.example.falonzo.santander_challenge.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                apiModule,
                repositoryModule,
                viewModelModule
            )
        }
    }
}