package com.nassdk.musand

import android.app.Application
import com.nassdk.musand.di.dataModule
import com.nassdk.musand.di.domainModule
import com.nassdk.musand.di.navigationModule
import com.nassdk.musand.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber
import timber.log.Timber.DebugTree

class AppDelegate : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
        initTimber()
    }

    private fun initKoin() {

        startKoin {
            androidContext(this@AppDelegate)
            modules(
                dataModule,
                navigationModule,
                domainModule,
                viewModelModule
            )
        }
    }


    private fun initTimber() {
        Timber.plant(DebugTree())
    }
}