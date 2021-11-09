package com.example.models.coingecko.exchanges

import com.example.models.coingecko.Page
import com.example.models.coingecko.shared.Ticker
import kotlinx.serialization.Serializable

@Serializable
class ExchangesTickersById(
    val name: String,
    val tickers: List<Ticker> = emptyList(),
    override val total: Int,
    override val perPage: Int,
    override val nextPage: Int?,
    override val previousPage: Int?
) : Page