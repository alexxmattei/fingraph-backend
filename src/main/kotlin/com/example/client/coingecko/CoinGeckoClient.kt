package com.example.client.coingecko

import com.example.api.coingeckoapi.constants.Order
import com.example.api.coingeckoapi.error.CoinGeckoApiException
import com.example.models.coingecko.AssetPlatform
import com.example.models.coingecko.Ping
import com.example.models.coingecko.coins.*
import com.example.models.coingecko.events.EventCountries
import com.example.models.coingecko.events.EventTypes
import com.example.models.coingecko.events.Events
import com.example.models.coingecko.exchanges.Exchanges
import com.example.models.coingecko.exchanges.ExchangesList
import com.example.models.coingecko.exchanges.ExchangesTickersById
import com.example.models.coingecko.global.Global
import com.example.models.coingecko.rates.ExchangeRates
import com.example.models.coingecko.search.TrendingCoinList
import com.example.models.coingecko.status.StatusUpdates
import io.ktor.client.HttpClient
import kotlin.coroutines.cancellation.*

interface CoinGeckoClient {

    companion object {
        fun create(): CoinGeckoClient {
            return CoinGeckoClientImpl()
        }

        fun create(httpClient: HttpClient): CoinGeckoClient {
            return CoinGeckoClientImpl(httpClient)
        }
    }

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun ping(): Ping

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getPrice(
        ids: String,
        vsCurrencies: String,
        includeMarketCap: Boolean = false,
        include24hrVol: Boolean = false,
        include24hrChange: Boolean = false,
        includeLastUpdatedAt: Boolean = false
    ): Map<String, CoinPrice>

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getTokenPrice(
        id: String,
        contractAddress: String,
        vsCurrencies: String,
        includeMarketCap: Boolean = false,
        include24hrVol: Boolean = false,
        include24hrChange: Boolean = false,
        includeLastUpdatedAt: Boolean = false
    ): Map<String, Map<String, Double>>

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getSupportedVsCurrencies(): List<String>

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getCoinList(includePlatform: Boolean = false): List<CoinList>

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getCoinMarkets(
        vsCurrency: String,
        ids: String? = null,
        order: String? = null,
        perPage: Int? = null,
        page: Int? = null,
        sparkline: Boolean = false,
        priceChangePercentage: String? = null
    ): CoinMarketsList

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getCoinById(
        id: String,
        localization: Boolean = true,
        tickers: Boolean = false,
        marketData: Boolean = false,
        communityData: Boolean = false,
        developerData: Boolean = false,
        sparkline: Boolean = false
    ): CoinFullData

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getCoinTickerById(
        id: String,
        exchangeIds: String? = null,
        page: Int? = null,
        order: String? = null
    ): CoinTickerById

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getCoinHistoryById(
        id: String,
        date: String,
        localization: Boolean = false
    ): CoinHistoryById

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getCoinMarketChartById(
        id: String,
        vsCurrency: String,
        days: Double
    ): MarketChart

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getCoinMarketChartRangeById(
        id: String,
        vsCurrency: String,
        from: String,
        to: String
    ): MarketChart

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getCoinStatusUpdateById(
        id: String,
        perPage: Int? = null,
        page: Int? = null
    ): StatusUpdates

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getCoinInfoByContractAddress(
        id: String,
        contractAddress: String
    ): CoinFullData

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getCoinOhlc(
        id: String,
        vsCurrency: String,
        days: Int,
    ): List<CoinOhlc>

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getAssetPlatforms(): List<AssetPlatform>

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getCoinCategoriesList(): List<CoinCategory>

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getCoinCategories(
        order: String = Order.MARKET_CAP_DESC
    ): List<CoinCategoryAndData>

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getExchanges(): List<Exchanges>

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getExchangesList(): List<ExchangesList>

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getExchangesById(id: String): Exchanges

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getExchangesTickersById(
        id: String,
        coinIds: String? = null,
        page: Int? = null,
        order: String? = null
    ): ExchangesTickersById

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getExchangesStatusUpdatesById(
        id: String,
        perPage: Int? = null,
        page: Int? = null
    ): StatusUpdates

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getExchangesVolumeChart(
        id: String,
        days: Int
    ): List<List<String>>

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getStatusUpdates(
        category: String? = null,
        projectType: String? = null,
        perPage: Int? = null,
        page: Int? = null
    ): StatusUpdates

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getEvents(
        countryCode: String? = null,
        type: String? = null,
        page: Int? = null,
        upcomingEventsOnly: Boolean = false,
        fromDate: String? = null,
        toDate: String? = null
    ): Events

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getEventsCountries(): EventCountries

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getEventsTypes(): EventTypes

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getExchangeRates(): ExchangeRates

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getGlobal(): Global

    @Throws(CoinGeckoApiException::class, CancellationException::class)
    suspend fun getTrending(): TrendingCoinList
}