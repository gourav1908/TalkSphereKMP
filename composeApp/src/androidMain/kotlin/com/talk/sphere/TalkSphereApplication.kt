package com.talk.sphere

import android.app.Application
import com.talk.sphere.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class TalkSphereApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@TalkSphereApplication)
            androidLogger()
        }
    }
}