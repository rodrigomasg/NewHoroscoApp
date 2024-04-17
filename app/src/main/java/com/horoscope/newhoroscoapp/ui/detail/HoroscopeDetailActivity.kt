package com.horoscope.newhoroscoapp.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.horocope.newhoroscoapp.databinding.ActivityHoroscopeDetailBinding
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
        viewModel.getHoroscope(args.type.name)
    }

    private fun initUi() {
        initUiState()
    }

    private fun initUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    when (it) {
                        is DetailHoroscopeUiState.Error -> loadingState()
                        DetailHoroscopeUiState.Loading -> errState()
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
    }

    private fun errState() {
        binding.pgDetail.isVisible = false
    }

    private fun loadingState() {
        binding.pgDetail.isVisible = true
    }
}