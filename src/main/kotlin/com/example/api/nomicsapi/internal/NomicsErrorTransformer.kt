package com.example.api.nomicsapi.internal

import com.example.api.nomicsapi.error.NomicsApiError
import com.example.api.nomicsapi.error.NomicsApiException
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.util.*
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

internal object NomicsErrorTransformer  : HttpClientFeature<NomicsErrorTransformer, NomicsErrorTransformer> {

    override val key: AttributeKey<NomicsErrorTransformer> = AttributeKey("ErrorTransformer")

    override fun prepare(block: NomicsErrorTransformer.() -> Unit): NomicsErrorTransformer = this

    override fun install(feature: NomicsErrorTransformer, scope: HttpClient) {
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
                    throw NomicsApiException(
                        NomicsApiError(
                            code = e.response.status.value,
                            message = body?.jsonObject
                                ?.get("error")
                                ?.jsonPrimitive
                                ?.contentOrNull
                                ?: bodyText
                        )
                    )
                } else {
                    throw NomicsApiException(cause = e)
                }
            }
        }
    }
}