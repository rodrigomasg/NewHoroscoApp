package com.horoscope.newhoroscoapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.horoscope.newhoroscoapp.domain.model.HoroscopeModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@AndroidEntryPoint
class HoroscopeViewModel @Inject constructor() : ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeModel>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeModel>> = _horoscope

    init {
        _horoscope.value = listOf(
            HoroscopeModel.Aries, HoroscopeModel.Taurus
        )
    }

}