package com.example.android3_2.utils

data class UiSate<T>(
    val isLoading:Boolean = true,
    val error:String? = null,
    val success:T? = null
)