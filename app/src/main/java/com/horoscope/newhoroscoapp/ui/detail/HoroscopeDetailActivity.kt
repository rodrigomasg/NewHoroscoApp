package com.horoscope.newhoroscoapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.horocope.newhoroscoapp.R
import com.horocope.newhoroscoapp.databinding.ActivityHoroscopeDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
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

        args.type
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
                        is DetailHoroscopeUiState.Success -> successState()
                    }
                }
            }
        }
    }

    private fun successState() {

    }

    private fun errState() {

    }

    private fun loadingState() {

    }
}