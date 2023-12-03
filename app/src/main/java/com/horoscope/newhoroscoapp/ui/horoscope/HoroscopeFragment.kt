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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.horocope.newhoroscoapp.databinding.FragmentHoroscopeBinding
import com.horoscope.newhoroscoapp.domain.model.HoroscopeInfo
import com.horoscope.newhoroscoapp.domain.model.HoroscopeModel
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
        adapterHoroscope = HoroscopeAdapter {
//            show(it)
            val type = when (it) {
                HoroscopeInfo.Aquarius -> HoroscopeModel.Aquarius
                HoroscopeInfo.Aries -> HoroscopeModel.Aries
                HoroscopeInfo.Cancer -> HoroscopeModel.Cancer
                HoroscopeInfo.Capricorn -> HoroscopeModel.Capricorn
                HoroscopeInfo.Gemini -> HoroscopeModel.Gemini
                HoroscopeInfo.Leo -> HoroscopeModel.Leo
                HoroscopeInfo.Libra -> HoroscopeModel.Libra
                HoroscopeInfo.Pisces -> HoroscopeModel.Pisces
                HoroscopeInfo.Sagittarius -> HoroscopeModel.Sagittarius
                HoroscopeInfo.Scorpio -> HoroscopeModel.Scorpio
                HoroscopeInfo.Taurus -> HoroscopeModel.Taurus
                HoroscopeInfo.Virgo -> HoroscopeModel.Virgo
            }

            findNavController().navigate(
                HoroscopeFragmentDirections.actionNavHomeToHoroscopeDetailActivity(type)
            )
        }
        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = adapterHoroscope
        }
    }

    private fun show(horoscopeInfo: HoroscopeInfo) {
//        Toast.makeText(context, horoscopeInfo.toString(), Toast.LENGTH_LONG).show()
//        findNavController().navigate(
//            HoroscopeFragmentDirections.actionNavHomeToHoroscopeDetailActivity()
//        )
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