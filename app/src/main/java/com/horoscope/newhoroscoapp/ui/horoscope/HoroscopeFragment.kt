package com.horoscope.newhoroscoapp.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.horocope.newhoroscoapp.databinding.FragmentHoroscopeBinding
import com.horoscope.newhoroscoapp.domain.model.HoroscopeInfo
import com.horoscope.newhoroscoapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {
    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!
    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private lateinit var adapterHoroscope: HoroscopeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initUIState()
        initList()
    }

    private fun initList() {
        adapterHoroscope = HoroscopeAdapter { show(it) }
        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = adapterHoroscope
        }
    }

    private fun show(horoscopeInfo: HoroscopeInfo) {
        Toast.makeText(context, horoscopeInfo.toString(), Toast.LENGTH_LONG).show()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect {
                    adapterHoroscope.updateList(it)
                }
            }
        }
    }

}