package com.horoscope.newhoroscoapp.domain.usecase

import com.horoscope.newhoroscoapp.domain.Repository
import javax.inject.Inject

class GetPredictionUserCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)
}