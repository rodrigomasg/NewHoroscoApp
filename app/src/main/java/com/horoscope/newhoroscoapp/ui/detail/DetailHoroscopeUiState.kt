package com.horoscope.newhoroscoapp.ui.detail

sealed class DetailHoroscopeUiState {
    data object Loading : DetailHoroscopeUiState()
    data class Error(val err: String) : DetailHoroscopeUiState()
    data class Success(val prediction: String) : DetailHoroscopeUiState()
}