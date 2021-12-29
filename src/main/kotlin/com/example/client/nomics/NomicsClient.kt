package com.example.client.nomics

import com.example.api.nomicsapi.error.NomicsApiException
import io.ktor.client.*
import kotlin.coroutines.cancellation.CancellationException
import kotlin.jvm.Throws
import com.example.models.nomics.Coin
import com.example.models.nomics.CoinMarketCap
import com.example.models.nomics.CoinMetadata
import com.example.models.nomics.MarketGlobalVolumeHistory

interface NomicsClient {
    companion object {
        fun create(): NomicsClient {
            return NomicsClientImpl()
        }

        fun create(httpClient: HttpClient): NomicsClient {
            return NomicsClientImpl(httpClient)
        }
    }

    @Throws(NomicsApiException::class, CancellationException::class)
    suspend fun getPing(): String

    @Throws(NomicsApiException::class, CancellationException::class)
    suspend fun getCurrencyById(
        ids: String,
        interval: String,
        convert: String,
        status: String
    ): List<Coin>

    @Throws(NomicsApiException::class, CancellationException::class)
    suspend fun getCurrencyMetadataById(
        key: String,
        ids: String
    ): List<CoinMetadata>

    @Throws(NomicsApiException::class, CancellationException::class)
    suspend fun getMarketCapHistoryByIdCurrentDate(
        ids: String,
        start: String,
        end: String?
    ): List<CoinMarketCap>

    @Throws(NomicsApiException::class, CancellationException::class)
    suspend fun getGlobalVolumeHistory(
        start: String,
        end: String?
    ): List<MarketGlobalVolumeHistory>
}