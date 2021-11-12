package com.example.client.nomics

import com.example.api.nomicsapi.error.NomicsApiException
import io.ktor.client.*
import kotlin.coroutines.cancellation.CancellationException
import kotlin.jvm.Throws
import com.example.models.nomics.Coin

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
    suspend fun getCurrenciesById(
        ids: String,
        interval: String,
        convert: String,
        status: String
    ) : List<Coin>
}