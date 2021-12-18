package com.example.plugins

import io.ktor.features.*
import io.ktor.http.*
import io.ktor.application.*

fun Application.configureHTTP() {
    install(HSTS) {
        includeSubDomains = true
    }
}
