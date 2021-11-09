package com.example.plugins

import io.ktor.features.*
import io.ktor.http.*
import io.ktor.application.*

fun Application.configureHTTP() {
    install(HSTS) {
        includeSubDomains = true
    }
    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        header("MyCustomHeader")
        allowCredentials = true
        anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
    }

}
