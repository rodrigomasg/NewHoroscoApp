package com.horoscope.newhoroscoapp.domain.model

import com.horocope.newhoroscoapp.R

sealed class HoroscopeInfo(
    val img: Int,
    val name: Int,
) {
    data object Aries : HoroscopeInfo(R.drawable.haries, R.string.haries)
    data object Taurus : HoroscopeInfo(R.drawable.htauro, R.string.htaurus)
    data object Gemini : HoroscopeInfo(R.drawable.hgeminis, R.string.hgemini)
    data object Cancer : HoroscopeInfo(R.drawable.hcancer, R.string.hcancer)
    data object Leo : HoroscopeInfo(R.drawable.hleo, R.string.hleo)
    data object Virgo : HoroscopeInfo(R.drawable.hvirgo, R.string.hvirgo)
    data object Libra : HoroscopeInfo(R.drawable.hlibra, R.string.hlibra)
    data object Scorpio : HoroscopeInfo(R.drawable.hescorpio, R.string.hscorpio)
    data object Sagittarius : HoroscopeInfo(R.drawable.hsagitario, R.string.hsagittarius)
    data object Capricorn : HoroscopeInfo(R.drawable.hcapricornio, R.string.hcapricorn)
    data object Aquarius : HoroscopeInfo(R.drawable.haquario, R.string.haquarius)
    data object Pisces : HoroscopeInfo(R.drawable.hpiscis, R.string.hpisces)
}
