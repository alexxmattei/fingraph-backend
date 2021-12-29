package com.example.models.nomics

import kotlinx.serialization.Serializable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Serializable
data class MarketGlobalVolumeHistory(
    var timestamp: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    var volume: String = "",
    var spotVolume: String = "",
    var derivativeVolume: String = "",
    var transparentVolume: String = "",
    var transparentSpotVolume: String = "",
    var transparentDerivativeVolume: String = ""
)