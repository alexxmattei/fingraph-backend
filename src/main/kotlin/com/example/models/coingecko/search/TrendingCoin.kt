package com.example.models.coingecko.search

import kotlinx.serialization.Serializable

@Serializable
data class TrendingCoin(
    val item: TrendingCoinItem
)