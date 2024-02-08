package com.horoscope.newhoroscoapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.horoscope.newhoroscoapp.domain.model.PredictionModel

data class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("icon") val icon: String,
    @SerializedName("id") val id: Int,
    @SerializedName("sing") val sing: String,
) {
    fun toDomain(): PredictionModel {
        return PredictionModel(horoscope, sing)
    }
}
