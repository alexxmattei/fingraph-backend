package com.example.models.coingecko.coins

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class CoinFullData(
    val id: String,
    val symbol: String,
    val name: String
)