package com.example.models.nomics

import kotlinx.serialization.Serializable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Serializable
data class Coin(
    var id: String = "",
    var currency: String = "",
    var symbol: String = "",
    var name: String = "",
    var logo_url: String = "",
    var status: String = "",
    var price: Double = 0.0,
    var priceDate: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    var priceTimestamp: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    var circulatingSupply: String = "",
    var maxSupply: String = "",
    var marketCap: String = "",
    var marketCapDominance: String = "",
    var numExchanges: String = "",
    var numPairs: String = "",
    var numPairsUnmapped: String = "",
    var firstCandle: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    var firstTrade: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    var firstOrderBook: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    var rank: String = "",
    var high: Double = 0.0,
    var highTimestamp: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    var oneHour: CandleData = CandleData()
    )