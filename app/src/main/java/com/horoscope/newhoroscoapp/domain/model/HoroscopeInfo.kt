package com.horoscope.newhoroscoapp.domain.model

import com.horocope.newhoroscoapp.R

sealed class HoroscopeInfo(
    val img: Int,
    val name: Int,
) {
    object Aries : HoroscopeInfo(R.drawable.haries, R.string.haries)
    object Taurus : HoroscopeInfo(R.drawable.htauro, R.string.htaurus)
    object Gemini : HoroscopeInfo(R.drawable.hgeminis, R.string.hgemini)
    object Cancer : HoroscopeInfo(R.drawable.hcancer, R.string.hcancer)
    object Leo : HoroscopeInfo(R.drawable.hleo, R.string.hleo)
    object Virgo : HoroscopeInfo(R.drawable.hvirgo, R.string.hvirgo)
    object Libra : HoroscopeInfo(R.drawable.hlibra, R.string.hlibra)
    object Scorpio : HoroscopeInfo(R.drawable.hescorpio, R.string.hscorpio)
    object Sagittarius : HoroscopeInfo(R.drawable.hsagitario, R.string.hsagittarius)
    object Capricorn : HoroscopeInfo(R.drawable.hcapricornio, R.string.hcapricorn)
    object Aquarius : HoroscopeInfo(R.drawable.haquario, R.string.haquarius)
    object Pisces : HoroscopeInfo(R.drawable.hpiscis, R.string.hpisces)
}
