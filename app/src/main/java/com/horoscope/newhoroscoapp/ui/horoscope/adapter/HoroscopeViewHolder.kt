package com.horoscope.newhoroscoapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.horocope.newhoroscoapp.databinding.ItemHoroscopeBinding
import com.horoscope.newhoroscoapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemHoroscopeBinding.bind(view)
    fun bind(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val context = binding.tvHoroscope.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscope.text = context.getString(horoscopeInfo.name)

        binding.ivHoroscope.setOnClickListener {
            startRotationAnim(binding.ivHoroscope, newLamda = { onItemSelected(horoscopeInfo) })
//            onItemSelected(horoscopeInfo)
        }
    }

    private fun startRotationAnim(view: View, newLamda: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { newLamda() }
            start()
        }

    }
}