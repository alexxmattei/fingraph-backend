package com.example.api.coingeckoapi.error

data class CoinGeckoApiError(
    val code: Int = 0,
    val message: String? = null
)