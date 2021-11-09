package com.example.client

import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.logging.*
import io.ktor.network.tls.*
import org.apache.http.HttpHost

val httpClient = HttpClient(CIO) {
    engine {
        maxConnectionsCount = 1000
        endpoint {
            maxConnectionsPerRoute = 100
            pipelineMaxSize = 20
            keepAliveTime = 5000
            connectTimeout = 5000
            connectAttempts = 5
        }
        https {
            serverName = "api.ktor.io"
            cipherSuites = CIOCipherSuites.SupportedSuites
        }
    }
}