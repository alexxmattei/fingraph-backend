package com.example.models.coingecko.exchanges

import kotlinx.serialization.Serializable

@Serializable
data class ExchangesList(
    val id: String,
    val name: String
)