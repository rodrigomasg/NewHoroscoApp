package com.horoscope.newhoroscoapp.ui.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor() : ViewModel() {

    private var _state = MutableStateFlow<DetailHoroscopeUiState>(DetailHoroscopeUiState.Loading)
    val state: StateFlow<DetailHoroscopeUiState> = _state.asStateFlow()



}