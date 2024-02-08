package com.example.android3_2.data.models

import androidx.annotation.DrawableRes

data class Character(
    @DrawableRes
    val image: Int,
    val name: String
)