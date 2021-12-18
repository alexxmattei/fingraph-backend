package com.example.plugins

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod

fun Application.configureCORS() {
    install(CORS) {
        header(HttpHeaders.Authorization)
        header(HttpHeaders.ContentType)
        header(HttpHeaders.AccessControlAllowCredentials)
        header(HttpHeaders.AccessControlAllowHeaders)
        header(HttpHeaders.AccessControlAllowMethods)
        header(HttpHeaders.AccessControlAllowOrigin)
        method(HttpMethod.Delete)
        method(HttpMethod.Options)
        method(HttpMethod.Patch)
        method(HttpMethod.Put)
        host("localhost:3000")
        host("localhost:8080")
    }
}
