package com.example.android3_2.ui

import com.example.android3_2.data.models.Character

data class UiSate<T>(
    val isLoading:Boolean = true,
    val error:String? = null,
    val success:T? = null
)