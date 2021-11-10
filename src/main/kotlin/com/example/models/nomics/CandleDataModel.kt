package com.example.models.nomics

import kotlinx.serialization.Serializable

@Serializable
data class CandleData(
    var volume: String = "",
    var priceChange: Double = 0.0,
    var priceChangePct: Double = 0.0,
    var volumeChange: Double = 0.0,
    var volumeChangePct: Double = 0.0,
    var marketCapChange: Double = 0.0,
    var marketCapChangePct: Double = 0.0
)
