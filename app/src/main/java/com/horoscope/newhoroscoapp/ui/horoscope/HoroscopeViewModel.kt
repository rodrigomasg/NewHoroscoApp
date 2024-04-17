package com.horoscope.newhoroscoapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.horoscope.newhoroscoapp.data.provider.HoroscopeProvider
import com.horoscope.newhoroscoapp.domain.model.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider) : ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope.asStateFlow()

    init {
        _horoscope.value = horoscopeProvider.getHoroscopes()
    }
}