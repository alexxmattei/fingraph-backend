package com.example.client.nomics

import kotlinx.serialization.json.*
import com.example.api.coingeckoapi.internal.ErrorTransformer
import com.example.api.coingeckoapi.internal.PagingTransformer
import io.ktor.client.features.json.*
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

private const val API_HOST = "api.nomics.com"
private const val API_BASE_PATH = "/v1"

class NomicsClientImpl(httpClient: HttpClient) : NomicsClient {
    constructor() : this(HttpClient())

    private val httpClient = httpClient.config {
        defaultRequest {
            url.protocol = URLProtocol.HTTPS
            url.host = API_HOST
            url.encodedPath = API_BASE_PATH + url.encodedPath
        }
        install(ErrorTransformer)
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
}