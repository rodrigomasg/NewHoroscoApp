package com.horoscope.newhoroscoapp.data.network.mother

import com.horoscope.newhoroscoapp.data.network.response.PredictionResponse
import com.horoscope.newhoroscoapp.domain.model.HoroscopeInfo

object MotherObjHoroscope {

    val anyResponse = PredictionResponse("date", "picis d ds ", "img.jpg", 1, "picis")

    val horoscopeList = listOf(
        HoroscopeInfo.Aries,
        HoroscopeInfo.Taurus,
        HoroscopeInfo.Gemini,
        HoroscopeInfo.Cancer,
        HoroscopeInfo.Leo,
        HoroscopeInfo.Virgo,
        HoroscopeInfo.Libra,
        HoroscopeInfo.Scorpio,
        HoroscopeInfo.Sagittarius,
        HoroscopeInfo.Capricorn,
        HoroscopeInfo.Aquarius,
        HoroscopeInfo.Pisces,
    )
}