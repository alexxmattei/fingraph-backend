package com.example.models.coingecko.coins

import com.example.api.coingeckoapi.internal.CoinOhlcSerializer
import kotlinx.serialization.Serializable

@Serializable(with = CoinOhlcSerializer::class)
data class CoinOhlc(
    val time: Long,
    val open: Double,
    val high: Double,
    val low: Double,
    val close: Double,
)