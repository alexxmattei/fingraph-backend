package com.example.models.coingecko.coins

import com.example.models.coingecko.Page
import com.example.models.coingecko.shared.Ticker
import kotlinx.serialization.Serializable

@Serializable
data class CoinTickerById(
    val name: String,
    val tickers: List<Ticker>,
    override val total: Int,
    override val perPage: Int,
    override val nextPage: Int?,
    override val previousPage: Int?
) : Page