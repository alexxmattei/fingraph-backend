package com.example.models.coingecko.coins

import kotlinx.serialization.*

@Serializable
data class CoinCategory(
    @SerialName("category_id")
    val categoryId: String,
    val name: String
)

data class CoinCategoryAndData(
    val id: String,
    val name: String,
    @SerialName("market_cap")
    val marketCap: Double,
    @SerialName("market_cap_change_24h")
    val marketCapChange24h: Double,
    @SerialName("updated_at")
    val updatedAt: String
)