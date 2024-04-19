package com.horoscope.newhoroscoapp.ui.providers

import io.kotlintest.shouldBe
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class RandomCardProviderTest {

    @Test
    fun getRandomCardSRandomCard() {
        val randomCard = RandomCardProvider()

        val card = randomCard.getLucky()

        assertNotNull(card)
    }
}