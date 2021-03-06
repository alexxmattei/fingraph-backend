package com.example.client.nomics

import com.example.api.coingeckoapi.internal.PagingTransformer
import com.example.api.nomicsapi.internal.NomicsErrorTransformer
import com.example.models.nomics.Coin
import com.example.models.nomics.CoinMarketCap
import com.example.models.nomics.CoinMetadata
import com.example.models.nomics.MarketGlobalVolumeHistory
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

private const val IDS = "ids"
private const val INTERVAL = "interval"
private const val CONVERT = "convert"
private const val STATUS = "status"
private const val START = "start"
private const val END = "end"

private const val API_HOST = "api.nomics.com"
private const val API_BASE_PATH = "/v1"
private const val KEY = "b41f7cca5feb852dbdaa3f7eca845d9b8c2c7e42"

class NomicsClientImpl(httpClient: HttpClient) : NomicsClient {

    constructor() : this(HttpClient())

    private val httpClient = httpClient.config {
        defaultRequest {
            url.protocol = URLProtocol.HTTPS
            url.host = API_HOST
            url.encodedPath = API_BASE_PATH + url.encodedPath
            url.parameters["key"] = KEY
        }
        install(NomicsErrorTransformer)
        install(PagingTransformer)

        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                coerceInputValues = true
                useAlternativeNames = false
            })
        }
    }

    override suspend fun getPing() = "Nomics API Client is working properly!"

    override suspend fun getCurrencyById(
        ids: String,
        interval: String,
        convert: String,
        status: String
    ): List<Coin> = httpClient.get("currencies/ticker") {
        parameter(IDS, ids)
        parameter(INTERVAL, interval)
        parameter(CONVERT, convert)
        parameter(STATUS, status)
    }

    override suspend fun getCurrencyMetadataById(key: String, ids: String): List<CoinMetadata> =
        httpClient.get("currencies") {
            parameter(IDS, ids)
        }

    override suspend fun getMarketCapHistoryByIdCurrentDate(ids: String, start: String, end: String?): List<CoinMarketCap> =
        httpClient.get("market-cap/history") {
            parameter(IDS, ids)
            parameter(START, start)
            parameter(END, end ?: "")
        }

    override suspend fun getGlobalVolumeHistory(start: String, end: String?): List<MarketGlobalVolumeHistory> =
        httpClient.get("volume/history") {
            parameter(START, start)
            parameter(END, end ?: "")
        }
}