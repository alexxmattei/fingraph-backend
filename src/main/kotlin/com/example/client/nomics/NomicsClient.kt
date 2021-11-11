package com.example.client.nomics

import com.example.client.coingecko.CoinGeckoClient
import com.example.client.coingecko.CoinGeckoClientImpl
import io.ktor.client.*

interface NomicsClient {
    companion object {
        fun create(): CoinGeckoClient {
            return CoinGeckoClientImpl()
        }

        fun create(httpClient: HttpClient): CoinGeckoClient {
            return CoinGeckoClientImpl(httpClient)
        }
    }
}