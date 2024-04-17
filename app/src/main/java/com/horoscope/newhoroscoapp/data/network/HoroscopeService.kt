package com.horoscope.newhoroscoapp.data.network

import com.horoscope.newhoroscoapp.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeService {

    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign: String):PredictionResponse
}