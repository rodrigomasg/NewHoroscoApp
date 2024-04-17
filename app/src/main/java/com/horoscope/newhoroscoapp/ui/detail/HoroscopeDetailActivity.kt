package com.horoscope.newhoroscoapp.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.horocope.newhoroscoapp.R
import com.horocope.newhoroscoapp.databinding.ActivityHoroscopeDetailBinding
import com.horoscope.newhoroscoapp.domain.model.HoroscopeModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {
    private val binding: ActivityHoroscopeDetailBinding by lazy {
        ActivityHoroscopeDetailBinding.inflate(layoutInflater)
    }
    private val viewModel by viewModels<HoroscopeDetailViewModel>()
    private val args: HoroscopeDetailActivityArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initUi()
        initListener()
        viewModel.getHoroscope(args.type)
    }

    private fun initListener() {
        binding.ivDetailBack.setOnClickListener { finish() }
    }

    private fun initUi() {
        initUiState()
    }

    private fun initUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    when (it) {
                        is DetailHoroscopeUiState.Error -> errState()
                        DetailHoroscopeUiState.Loading -> loadingState()
                        is DetailHoroscopeUiState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun successState(state: DetailHoroscopeUiState.Success) {
        binding.pgDetail.isVisible = false
        binding.tvDetail.text = state.predictionModel?.sing
        binding.tvDetailBody.text = state.predictionModel?.horoscope
        val imgHor = when (state.horoscopeModel) {
            HoroscopeModel.Aries -> R.drawable.detail_aries
            HoroscopeModel.Taurus -> R.drawable.detail_taurus
            HoroscopeModel.Gemini -> R.drawable.detail_gemini
            HoroscopeModel.Cancer -> R.drawable.detail_cancer
            HoroscopeModel.Leo -> R.drawable.detail_leo
            HoroscopeModel.Virgo -> R.drawable.detail_virgo
            HoroscopeModel.Libra -> R.drawable.detail_libra
            HoroscopeModel.Scorpio -> R.drawable.detail_scorpio
            HoroscopeModel.Sagittarius -> R.drawable.detail_sagittarius
            HoroscopeModel.Capricorn -> R.drawable.detail_capricorn
            HoroscopeModel.Aquarius -> R.drawable.detail_aquarius
            HoroscopeModel.Pisces -> R.drawable.detail_pisces
        }
        binding.ivDetail.setImageResource(imgHor)
    }

    private fun errState() {
        binding.pgDetail.isVisible = false
    }

    private fun loadingState() {
        binding.pgDetail.isVisible = true
    }
}