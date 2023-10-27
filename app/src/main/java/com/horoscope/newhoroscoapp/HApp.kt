package com.horoscope.newhoroscoapp

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.e("e", "hello")
    }
}