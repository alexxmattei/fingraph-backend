package com.example.models.nomics

import kotlinx.serialization.Serializable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Serializable
data class CoinMarketCap(
    var timestamp: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    var marketCap: String = "",
    var transparentMarketCap: String = ""
)
