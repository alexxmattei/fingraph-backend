package com.example.models.coingecko

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ping(
    @SerialName("gecko_says")
    val geckoSays: String
)