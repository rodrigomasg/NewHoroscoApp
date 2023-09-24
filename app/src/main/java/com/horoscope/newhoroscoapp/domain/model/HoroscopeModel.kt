package com.horoscope.newhoroscoapp.domain.model

import com.horocope.newhoroscoapp.R

sealed class HoroscopeModel(val img: Int, val name: Int) {
    object Aries : HoroscopeModel(R.drawable.haries, R.string.h_haries)
    object Taurus : HoroscopeModel(R.drawable.htauro, R.string.h_htauro)
    object Gemini : HoroscopeModel(R.drawable.hgeminis, R.string.h_hgeminis)
    object Cancer : HoroscopeModel(R.drawable.hcancer, R.string.h_hcancer)
    object Leo : HoroscopeModel(R.drawable.hleo, R.string.h_hleo)
    object Virgo : HoroscopeModel(R.drawable.hvirgo, R.string.h_hvirgo)
    object Libra : HoroscopeModel(R.drawable.hlibra, R.string.h_hlibra)
    object Scorpio : HoroscopeModel(R.drawable.hescorpio, R.string.h_hescorpio)
    object Sagittarius : HoroscopeModel(R.drawable.hsagitario, R.string.h_hsagitario)
    object Capricorn : HoroscopeModel(R.drawable.hcapricornio, R.string.h_hcapricornio)
    object Aquarius : HoroscopeModel(R.drawable.haquario, R.string.h_haquario)
    object Pisces : HoroscopeModel(R.drawable.hpiscis, R.string.h_hpiscis)
}