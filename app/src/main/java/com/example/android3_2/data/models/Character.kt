package com.example.android3_2.data.models

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "implemntation")
data class Character(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @DrawableRes
    val image: Int,
    val name: String
)