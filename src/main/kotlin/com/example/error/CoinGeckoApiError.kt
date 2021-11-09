package com.example.error

data class CoinGeckoApiError(
    val code: Int = 0,
    val message: String? = null
)