package com.example.models.coingecko.exchanges

import com.example.models.coingecko.shared.Ticker
import com.example.models.coingecko.status.Update
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class Exchanges(
    val id: String,
    val name: String,
    @SerialName("year_established")
    val yearEstablished: Long = 0,
    val country: String? = null,
    val description: String? = null,
    val url: String? = null,
    val image: String? = null,
    @SerialName("has_trading_incentive")
    val hasTradingIncentive: Boolean = false,
    @SerialName("trade_volume_24h_btc")
    val tradeVolume24hBtc: Double = 0.0,
    @SerialName("tickers")
    val tickers: List<Ticker> = emptyList(),
    @SerialName("status_updates")
    val statusUpdates: List<Update> = emptyList()
)