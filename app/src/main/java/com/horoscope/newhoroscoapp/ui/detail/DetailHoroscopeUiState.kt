package com.horoscope.newhoroscoapp.ui.detail

import com.horoscope.newhoroscoapp.domain.model.HoroscopeModel
import com.horoscope.newhoroscoapp.domain.model.PredictionModel

sealed class DetailHoroscopeUiState {
    data object Loading : DetailHoroscopeUiState()
    data class Error(val err: String) : DetailHoroscopeUiState()
    data class Success(val predictionModel: PredictionModel?, val horoscopeModel: HoroscopeModel) : DetailHoroscopeUiState()
}