package com.horoscope.newhoroscoapp.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LuckyModel(
    @DrawableRes val img: Int,
    @StringRes val text: Int
)
