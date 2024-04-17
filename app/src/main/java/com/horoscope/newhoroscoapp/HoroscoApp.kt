package com.horoscope.newhoroscoapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HoroscoApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}