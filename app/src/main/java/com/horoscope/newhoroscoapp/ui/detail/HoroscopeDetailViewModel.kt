package com.horoscope.newhoroscoapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horoscope.newhoroscoapp.domain.usecase.GetPredictionUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUserCase: GetPredictionUserCase) :
    ViewModel() {

    private var _state = MutableStateFlow<DetailHoroscopeUiState>(DetailHoroscopeUiState.Loading)
    val state: StateFlow<DetailHoroscopeUiState> = _state.asStateFlow()

    fun getHoroscope(sign: String) {
        viewModelScope.launch {
            _state.value = DetailHoroscopeUiState.Loading
            val result: Unit = withContext(Dispatchers.IO) { getPredictionUserCase(sign) }
            if (result != null){
                _state.value = DetailHoroscopeUiState.Success(result )
            }
        }
    }

}