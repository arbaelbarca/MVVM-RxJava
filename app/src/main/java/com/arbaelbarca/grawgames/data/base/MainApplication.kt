package com.arbaelbarca.grawgames.data.base

import android.app.Application
import com.arbaelbarca.grawgames.data.di.myAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidLogger(Level.INFO)
            androidLogger(Level.ERROR)
            androidContext(this@MainApplication)
            modules(myAppModule)
        }
    }
}