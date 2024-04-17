package com.horoscope.newhoroscoapp.domain

import com.horoscope.newhoroscoapp.domain.model.PredictionModel

interface Repository {

    suspend fun getPrediction(sign: String): PredictionModel?
}