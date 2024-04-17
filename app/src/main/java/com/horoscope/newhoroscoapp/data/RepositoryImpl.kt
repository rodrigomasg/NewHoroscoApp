package com.horoscope.newhoroscoapp.data

import android.util.Log
import com.horoscope.newhoroscoapp.data.network.HoroscopeService
import com.horoscope.newhoroscoapp.domain.Repository
import com.horoscope.newhoroscoapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        kotlin.runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.e("de", "error") }
        return null
    }
}