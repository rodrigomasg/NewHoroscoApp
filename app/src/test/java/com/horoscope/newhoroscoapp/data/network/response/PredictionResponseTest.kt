package com.horoscope.newhoroscoapp.data.network.response

import com.horoscope.newhoroscoapp.data.network.mother.MotherObjHoroscope.anyResponse
import io.kotlintest.shouldBe
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class PredictionResponseTest {

    @Test
    fun toDomainSRPredictionModel() {
        //Given
        val horoscopeResponse = anyResponse.copy(sing = "libra")
        //When

        val predictionModel = horoscopeResponse.toDomain()

        //Then
        predictionModel.sing shouldBe horoscopeResponse.sing
        predictionModel.horoscope shouldBe horoscopeResponse.horoscope
    }
}