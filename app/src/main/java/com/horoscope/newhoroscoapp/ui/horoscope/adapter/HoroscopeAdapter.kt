package com.horoscope.newhoroscoapp.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.horocope.newhoroscoapp.R
import com.horoscope.newhoroscoapp.domain.model.HoroscopeInfo

class HoroscopeAdapter(
    private var listHoroscope: List<HoroscopeInfo> = emptyList(),
    private val onItemSelected: (HoroscopeInfo) -> Unit
) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {

    fun updateList(list: List<HoroscopeInfo>) {
        listHoroscope = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        )
    }

    override fun getItemCount(): Int = listHoroscope.size

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.bind(listHoroscope[position], onItemSelected)
    }
}