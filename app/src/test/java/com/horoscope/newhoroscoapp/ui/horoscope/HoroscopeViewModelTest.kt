package com.horoscope.newhoroscoapp.ui.horoscope

import com.horoscope.newhoroscoapp.data.network.mother.MotherObjHoroscope.horoscopeList
import com.horoscope.newhoroscoapp.data.provider.HoroscopeProvider
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class HoroscopeViewModelTest {

    @MockK/*(relaxed = true)*/
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun viewModelSRHoroscopeLoaded() {
        //sinCoroutines
        every { horoscopeProvider.getHoroscopes() } returns horoscopeList
        //con coroutines
        //coEvery { horoscopeProvider.getHoroscopes() } returns listOf()

        viewModel = HoroscopeViewModel(horoscopeProvider)

        val horoscope = viewModel.horoscope.value

        assertTrue(horoscope.isNotEmpty())
    }
}