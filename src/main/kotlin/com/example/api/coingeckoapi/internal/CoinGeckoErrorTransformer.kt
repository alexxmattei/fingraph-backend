package com.example.api.coingeckoapi.internal

import com.example.api.coingeckoapi.error.CoinGeckoApiError
import com.example.api.coingeckoapi.error.CoinGeckoApiException
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.util.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*

internal object CoinGeckoErrorTransformer : HttpClientFeature<CoinGeckoErrorTransformer, CoinGeckoErrorTransformer> {

    override val key: AttributeKey<CoinGeckoErrorTransformer> = AttributeKey("ErrorTransformer")

    override fun prepare(block: CoinGeckoErrorTransformer.() -> Unit): CoinGeckoErrorTransformer = this

    override fun install(feature: CoinGeckoErrorTransformer, scope: HttpClient) {
        scope.requestPipeline.intercept(HttpRequestPipeline.Render) {
            try {
                proceed()
            } catch (e: Throwable) {
                if (e is ResponseException) {
                    val bodyText = e.response.readText()
                    val body = try {
                        Json.parseToJsonElement(bodyText)
                    } catch (e: SerializationException) {
                        null
                    }
                    throw CoinGeckoApiException(
                        CoinGeckoApiError(
                            code = e.response.status.value,
                            message = body?.jsonObject
                                ?.get("error")
                                ?.jsonPrimitive
                                ?.contentOrNull
                                ?: bodyText
                        )
                    )
                } else {
                    throw CoinGeckoApiException(cause = e)
                }
            }
        }
    }
}